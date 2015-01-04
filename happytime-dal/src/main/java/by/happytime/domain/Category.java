package by.happytime.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category extends AbstractEntity {

    private static final long serialVersionUID = 3337446778695702160L;
    
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private List<Subcategory> subgategories = new ArrayList<Subcategory>();
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "categories")
    private List<Product> products = new ArrayList<Product>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Subcategory> getSubgategories() {
        return subgategories;
    }

    public void setSubgategories(List<Subcategory> subgategories) {
        this.subgategories = subgategories;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
    
}
