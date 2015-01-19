package by.happytime.navigation;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "navigation")
@SessionScoped
public class Navigation implements Serializable {

    private static final long serialVersionUID = -8898815384982822076L;
    
    private static final Map<String, String> CURRENT_SUBPAGE = new HashMap<String, String>();
    {
    	CURRENT_SUBPAGE.put("menuBalloons", "");
    	CURRENT_SUBPAGE.put("menuAccessories", "");
    	CURRENT_SUBPAGE.put("menuOriginalGifts", "");
    }
    
    private String currentPage;
    
    public String isActivePage(String pageId) {
        if (pageId != null) {
            return pageId.equals(currentPage) ? "menu-active" : "";
        }
        return "";
    }
    
    public String isActiveSubPage(String pageId) {
        if (pageId != null && CURRENT_SUBPAGE.get(currentPage) != null) {
            return CURRENT_SUBPAGE.get(currentPage).equals(pageId) ? "menu-active" : "";
        }
        return "";
    }
    
    public void setCurrentSubPage(String currentSubPage) {
    	CURRENT_SUBPAGE.put(this.currentPage, currentSubPage);
    }
    
    public void setCurrentPage(String currentPage) {
        this.currentPage = currentPage;
    }

    public String getCurrentPage() {
        return currentPage;
    }
    
}
