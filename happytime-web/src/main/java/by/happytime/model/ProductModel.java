package by.happytime.model;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import by.happytime.domain.Subcategory;
import by.happytime.model.data.ProductLazyDataModel;
import by.happytime.repository.ProductRepo;

@ManagedBean(name = "productModel")
@ViewScoped
public class ProductModel implements Serializable {

    private static final long serialVersionUID = 5728778564103883640L;
    
    @ManagedProperty("#{productRepo}")
    private ProductRepo productRepo;
    
    private String title;
    
    private String pageTitle;
    
    private String description;
    
    private Subcategory subcategory;
    
    private ProductLazyDataModel dataModel = null;
    
    public Subcategory getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(Subcategory subcategory) {
        this.subcategory = subcategory;
    }

    public ProductRepo getProductRepo() {
        return productRepo;
    }

    public void setProductRepo(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public ProductLazyDataModel getDataModel() {
        if (dataModel == null) {
            dataModel = new ProductLazyDataModel(productRepo);
        }
        return dataModel;
    }

    public void setDataModel(ProductLazyDataModel dataModel) {
        this.dataModel = dataModel;
    }

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

    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

}
