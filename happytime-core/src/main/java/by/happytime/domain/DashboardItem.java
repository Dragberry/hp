package by.happytime.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "dashboard_item")
public class DashboardItem extends AbstractEntity {

    private static final long serialVersionUID = 9065535181515300232L;
    
    @Column(name = "position")
    private Integer position;
    @Column(name ="title")
    private String title;
    @Column(name ="text")
    private String text;
    @Column(name ="img_link")
    private String imgLink;
    @Column(name ="alt")
    private String alt;
    @Column(name ="link")
    private String link;
    @Column(name = "enabled")
    private Boolean enabled;
    
    public Integer getPosition() {
        return position;
    }
    public void setPosition(Integer position) {
        this.position = position;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public String getImgLink() {
        return imgLink;
    }
    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }
    public String getLink() {
        return link;
    }
    public void setLink(String link) {
        this.link = link;
    }
    public Boolean getEnabled() {
        return enabled;
    }
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
    public String getAlt() {
        return alt;
    }
    public void setAlt(String alt) {
        this.alt = alt;
    }

}
