package by.happytime.model;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import by.happytime.domain.Subcategory;
import by.happytime.model.data.ProductLazyDataModel;
import by.happytime.repository.ProductRepo;

@ManagedBean(name = "productModel")
@SessionScoped
public class ProductModel implements Serializable {

    private static final long serialVersionUID = 5728778564103883640L;
    
    @ManagedProperty("#{productRepo}")
    private ProductRepo productRepo;
    
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
    
}
