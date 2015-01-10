package by.happytime.util;

import java.io.Serializable;
import java.util.ResourceBundle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "translation")
@SessionScoped
public class Translation implements Serializable {

    private static final long serialVersionUID = 8412177741271256452L;

    @ManagedProperty("#{messages}")
    private ResourceBundle resourceBundle;

    public String translate(String key) {
        return resourceBundle.getString(key);
    }

    public String translate(String key, Object... params) {
        return String.format(resourceBundle.getString(key), params);
    }

    public ResourceBundle getResourceBundle() {
        return resourceBundle;
    }

    public void setResourceBundle(ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
    }

}
