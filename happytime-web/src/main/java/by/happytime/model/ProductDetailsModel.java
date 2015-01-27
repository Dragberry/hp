package by.happytime.model;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import by.happytime.domain.Product;

@ManagedBean(name = "productDetailsModel")
@SessionScoped
public class ProductDetailsModel implements Serializable {

    private static final long serialVersionUID = -8268839693564890119L;
    
    private Product product = null;
    
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    
}
