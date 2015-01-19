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
    	CURRENT_SUBPAGE.put("menubBalloons", "");
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
    
    public void setCurrentPage(String currentPage) {
        this.currentPage = currentPage;
    }

    public String getCurrentPage() {
        return currentPage;
    }
    
}
