package by.happytime.navigation;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "navigation")
@SessionScoped
public class Navigation implements Serializable {

    private static final long serialVersionUID = -8898815384982822076L;
    
    private String currentPage;
    
    public String isActivePage(String pageId) {
        if (pageId != null) {
            return pageId.equals(currentPage) ? "menu-active" : "";
        }
        return "";
    }
    
    public void setCurrentPage(String currentPage) {
        this.currentPage = currentPage;
    }

    public String getCurrentPage() {
        return currentPage;
    }
    
}
