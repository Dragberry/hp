package by.happytime.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product extends AbstractEntity {

    private static final long serialVersionUID = -5616387522674333182L;

    @Column(name = "title")
    private String title;
    @Column(name = "cost")
    private BigDecimal cost;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "description")
    private String description;
    @Column(name = "full_description")
    private String fullDescription;
    @Column(name = "img_link")
    private String imgLink;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "product_subcategory", 
            joinColumns = {@JoinColumn(name = "product_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "subcategory_id", referencedColumnName = "id")})
    private List<Subcategory> subcategories = new ArrayList<Subcategory>();
    @Column(name = "country")
    private String country;
    @Column(name = "manufacturer")
    private String manufacturer;
    @Column(name = "colors")
    private String colors;
    @Column(name = "keywords")
    private String keywords;
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgLink() {
        return imgLink;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }

    public List<Category> getCategories() {
        Set<Category> categories = new HashSet<Category>();
       for (Subcategory subcategory : subcategories) {
           categories.add(subcategory.getCategory());
       }
        return new ArrayList<Category>(categories);
    }

    public List<Subcategory> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(List<Subcategory> subcategories) {
        this.subcategories = subcategories;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getColors() {
        return colors;
    }

    public void setColors(String colors) {
        this.colors = colors;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

}
