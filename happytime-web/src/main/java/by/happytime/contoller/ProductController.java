package by.happytime.contoller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.lang3.StringUtils;
import org.primefaces.event.data.PageEvent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import by.happytime.domain.Category;
import by.happytime.domain.Product;
import by.happytime.domain.Subcategory;
import by.happytime.model.Cart;
import by.happytime.model.ProductDetailsModel;
import by.happytime.model.ProductModel;
import by.happytime.repository.CategoryRepo;
import by.happytime.repository.ProductRepo;
import by.happytime.repository.SubcategoryRepo;
import by.happytime.util.Translation;

@ManagedBean(name = "productController")
@RequestScoped
public class ProductController implements Serializable {

    private static final long serialVersionUID = -3391995776641623083L;
    
    @ManagedProperty("#{productRepo}")
	private ProductRepo productRepo;
    @ManagedProperty("#{categoryRepo}")
    private CategoryRepo categoryRepo;
    @ManagedProperty("#{subcategoryRepo}")
    private SubcategoryRepo subcategoryRepo;
    @ManagedProperty("#{cart}")
    private Cart cart;
    @ManagedProperty("#{productModel}")
    private ProductModel productModel;
    @ManagedProperty("#{productDetailsModel}")
    private ProductDetailsModel productDetailsModel;
    @ManagedProperty("#{translation}")
	private Translation translation;
    
    public void doSearch(String category, String subcategory) {
        productModel.getDataModel().setCategoryList(null);
        productModel.getDataModel().setSubcategoryList(null);
        if (StringUtils.isNotBlank(category) && StringUtils.isBlank(subcategory)) {
            List<Category> categoryList = new ArrayList<Category>();
            Category c = categoryRepo.findByCode(category);
            categoryList.add(c);
            productModel.getDataModel().setCategoryList(categoryList);
        } else if (StringUtils.isNotBlank(subcategory)) {
            List<Subcategory> subcategoryList = new ArrayList<Subcategory>();
            Subcategory sc = subcategoryRepo.findByCode(subcategory);
            subcategoryList.add(sc);
            productModel.getDataModel().setSubcategoryList(subcategoryList);
        } 
    }
    
    public void initializeProductPage(String productId) {
        try {
            Long id = Long.valueOf(productId);
            Product product = productRepo.findOne(id);
            if (product == null) {
                productDetailsModel.setProduct(getStubProduct());
            } else {
                productDetailsModel.setProduct(product);
            }
        } catch (NumberFormatException e) {
            productDetailsModel.setProduct(getStubProduct()); 
        }
    }
    
    public void onPageChange(PageEvent event) {
        
    }
    
    private Product getStubProduct() {
        Product product = new Product();
        product.setTitle("Извините, по данному запросу продукт не найден");
        product.setImgLink("no_photo.jpg");
        product.setDescription("Извините, по данному запросу продукт не найден");
        return product;
    }
    
    public void addToCart(Product product) {
    	cart.addProduct(product);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(translation.translate("HTaddedToCart"), product.getTitle()));
    }
    
    public List<Product> getProductList() {
        List<Subcategory> sb = new ArrayList<Subcategory>();
        sb.add(productModel.getSubcategory());
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

    public ProductModel getProductModel() {
        return productModel;
    }

    public void setProductModel(ProductModel productModel) {
        this.productModel = productModel;
    }

    public ProductDetailsModel getProductDetailsModel() {
        return productDetailsModel;
    }

    public void setProductDetailsModel(ProductDetailsModel productDetailsModel) {
        this.productDetailsModel = productDetailsModel;
    }

    public CategoryRepo getCategoryRepo() {
        return categoryRepo;
    }

    public void setCategoryRepo(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

	public Translation getTranslation() {
		return translation;
	}

	public void setTranslation(Translation translation) {
		this.translation = translation;
	}
    
}
