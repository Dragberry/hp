package by.happytime.shop;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import by.happytime.domain.Product;

@ManagedBean(name = "shopSession")
@SessionScoped
public class ShopSession {
    
    private List<Product> selectedProductList = new ArrayList<Product>();

    public List<Product> getSelectedProductList() {
        return selectedProductList;
    }

    public void setSelectedProductList(List<Product> selectedProductList) {
        this.selectedProductList = selectedProductList;
    }
    
    

}
