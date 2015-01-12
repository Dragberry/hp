package by.happytime.contoller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import by.happytime.domain.Product;
import by.happytime.repository.ProductRepo;

@ManagedBean(name = "productController")
@RequestScoped
public class ProductController implements Serializable {

    private static final long serialVersionUID = -3391995776641623083L;
    
    @ManagedProperty("#{productRepo}")
	private ProductRepo productRepo;

    public List<Product> getProductList() {
    	return productRepo.findAll();
    }
    
	public ProductRepo getProductRepo() {
		return productRepo;
	}

	public void setProductRepo(ProductRepo productRepo) {
		this.productRepo = productRepo;
	}
    
}
