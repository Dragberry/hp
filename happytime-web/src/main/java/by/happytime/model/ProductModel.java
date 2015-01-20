package by.happytime.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import by.happytime.domain.Product;

public class ProductModel implements Serializable {

    private static final long serialVersionUID = 5728778564103883640L;
    
    private List<Product> productList = new ArrayList<Product>();

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
    
}
