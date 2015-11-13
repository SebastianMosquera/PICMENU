package com.picmenu.jsf.controllers;

import com.picmenu.jpa.entities.Ciudades;
import com.picmenu.jsf.controllers.util.JsfUtil;
import com.picmenu.jsf.controllers.util.PaginationHelper;
import com.picmenu.jpa.sessions.CiudadesFacade;

import java.io.Serializable;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

@Named("ciudadesController")
@SessionScoped
public class CiudadesController implements Serializable {

    private Ciudades current;
    private DataModel items = null;
    @EJB
    private com.picmenu.jpa.sessions.CiudadesFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    public CiudadesController() {
    }

    public Ciudades getSelected() {
        if (current == null) {
            current = new Ciudades();
            current.setCiudadesPK(new com.picmenu.jpa.entities.CiudadesPK());
            selectedItemIndex = -1;
        }
        return current;
    }

    private CiudadesFacade getFacade() {
        return ejbFacade;
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public String prepareView() {
        current = (Ciudades) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new Ciudades();
        current.setCiudadesPK(new com.picmenu.jpa.entities.CiudadesPK());
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            current.getCiudadesPK().setIdDepartamento(current.getDepartamentos().getIdDepartamento());
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("CiudadesCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/properties/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (Ciudades) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            current.getCiudadesPK().setIdDepartamento(current.getDepartamentos().getIdDepartamento());
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("CiudadesUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/properties/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (Ciudades) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "List";
    }

    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "List";
        }
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("CiudadesDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/properties/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }

    private void recreateModel() {
        items = null;
    }

    private void recreatePagination() {
        pagination = null;
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    public Ciudades getCiudades(com.picmenu.jpa.entities.CiudadesPK id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = Ciudades.class)
    public static class CiudadesControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CiudadesController controller = (CiudadesController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "ciudadesController");
            return controller.getCiudades(getKey(value));
        }

        com.picmenu.jpa.entities.CiudadesPK getKey(String value) {
            com.picmenu.jpa.entities.CiudadesPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new com.picmenu.jpa.entities.CiudadesPK();
            key.setIdCiudad(Integer.parseInt(values[0]));
            key.setIdDepartamento(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(com.picmenu.jpa.entities.CiudadesPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdCiudad());
            sb.append(SEPARATOR);
            sb.append(value.getIdDepartamento());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Ciudades) {
                Ciudades o = (Ciudades) object;
                return getStringKey(o.getCiudadesPK());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Ciudades.class.getName());
            }
        }

    }

}
