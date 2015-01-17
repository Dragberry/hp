package by.happytime.navigation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MenuUnit implements Serializable {
    
    private static final long serialVersionUID = -321421294904069528L;
    
    public static final String LEFT_POSITION_CLASS = "ui-menubar-options";

    private String id;
    
    private String link;
    
    private String title;
    
    private String position;
    
    private List<MenuUnit> nestedMenu = new ArrayList<MenuUnit>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<MenuUnit> getNestedMenu() {
        return nestedMenu;
    }

    public void setNestedMenu(List<MenuUnit> nestedMenu) {
        this.nestedMenu = nestedMenu;
    }
    
    public void add(MenuUnit menuUnit) {
        if (nestedMenu == null) {
            nestedMenu = new ArrayList<MenuUnit>();
        }
        nestedMenu.add(menuUnit);
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

}