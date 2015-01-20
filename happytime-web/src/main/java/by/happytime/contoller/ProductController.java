package by.happytime.contoller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import by.happytime.domain.Product;
import by.happytime.domain.Subcategory;
import by.happytime.model.Cart;
import by.happytime.repository.ProductRepo;
import by.happytime.repository.SubcategoryRepo;

@ManagedBean(name = "productController")
@RequestScoped
public class ProductController implements Serializable {

    private static final long serialVersionUID = -3391995776641623083L;
    
    @ManagedProperty("#{productRepo}")
	private ProductRepo productRepo;
    @ManagedProperty("#{subcategoryRepo}")
    private SubcategoryRepo subcategoryRepo;
    @ManagedProperty("#{cart}")
    private Cart cart;
    
    public void addToCart(Product product) {
        cart.addOrderUnit(product);
    }
    

    public List<Product> getProductList() {
        List<Subcategory> sb = new ArrayList<Subcategory>();
        sb.add(subcategoryRepo.findOne(2L));
        Page<Product> productPage = productRepo.findBySubcategories(sb, new PageRequest(0, 6));
    	return productPage.getContent();
    }
    
	public ProductRepo getProductRepo() {
		return productRepo;
	}

	public void setProductRepo(ProductRepo productRepo) {
		this.productRepo = productRepo;
	}

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }


    public SubcategoryRepo getSubcategoryRepo() {
        return subcategoryRepo;
    }


    public void setSubcategoryRepo(SubcategoryRepo subcategoryRepo) {
        this.subcategoryRepo = subcategoryRepo;
    }
    
}
