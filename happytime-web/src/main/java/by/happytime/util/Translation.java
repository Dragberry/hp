package by.happytime.util;

import java.io.Serializable;
import java.util.ResourceBundle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "translation")
@SessionScoped
public class Translation implements Serializable {

    private static final long serialVersionUID = 8412177741271256452L;
    
    private static ResourceBundle getResourceBundle() {
        FacesContext context = FacesContext.getCurrentInstance();
        return ResourceBundle.getBundle("messages", context.getViewRoot().getLocale());
    }

    public String translate(String key) {
        return getResourceBundle().getString(key);
    }

    public String translate(String key, Object... params) {
        return String.format(getResourceBundle().getString(key), params);
    }

}
