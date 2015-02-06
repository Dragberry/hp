package by.happytime.model;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import by.happytime.domain.Category;
import by.happytime.domain.Product;
import by.happytime.domain.Subcategory;

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
    
    public TreeNode getCategoryTree() {
    	TreeNode root = new DefaultTreeNode("Root", null);
    	for (Category category : product.getCategories()) {
    		TreeNode node = new DefaultTreeNode(category.getTitle(), root);
    		node.setExpanded(true);
    		for (Subcategory subcategory : product.getSubcategories()) {
    			if (subcategory.getCategory().equals(category)) {
    				new DefaultTreeNode(subcategory.getTitle(), node);
    			}
    		}
    	}
    	return root;
    }
    
}
