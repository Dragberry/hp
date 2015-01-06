package by.happytime.contollers;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import by.happytime.domain.Product;
import by.happytime.repository.ProductRepo;

@ManagedBean(name = "productListController")
@RequestScoped
public class ProductListController implements Serializable {

	private static final long serialVersionUID = 616122755096027649L;
	
	@ManagedProperty("#{productRepo}")
	private ProductRepo productRepo;
	
	public List<Product> getProducts() {
		return productRepo.findAll();
	}

	public ProductRepo getProductRepo() {
		return productRepo;
	}

	public void setProductRepo(ProductRepo productRepo) {
		this.productRepo = productRepo;
	}
	
}
