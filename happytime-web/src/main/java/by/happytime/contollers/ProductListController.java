package by.happytime.contollers;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import by.happytime.domain.Product;
import by.happytime.repository.ProductRepo;
import by.happytime.shop.ShopSession;

@ManagedBean(name = "productListController")
@RequestScoped
public class ProductListController implements Serializable {

	private static final long serialVersionUID = 616122755096027649L;
	
	@ManagedProperty("#{productRepo}")
	private ProductRepo productRepo;
	@ManagedProperty("#{shopSession}")
	private ShopSession shopSession;
	
	public void addItem(Long id) {
	    Product product = productRepo.findOne(id);
	    if (product != null) {
	        shopSession.getSelectedProductList().add(product);
	    }
	}
	
	public List<Product> getProducts() {
		return productRepo.findAll();
	}

	public ProductRepo getProductRepo() {
		return productRepo;
	}

	public void setProductRepo(ProductRepo productRepo) {
		this.productRepo = productRepo;
	}

    public ShopSession getShopSession() {
        return shopSession;
    }

    public void setShopSession(ShopSession shopSession) {
        this.shopSession = shopSession;
    }
	
}
