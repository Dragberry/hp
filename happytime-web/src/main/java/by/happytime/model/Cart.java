package by.happytime.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import by.happytime.domain.Address;
import by.happytime.domain.Product;

@ManagedBean(name = "cart")
@SessionScoped
public class Cart implements Serializable {
    
    private static final long serialVersionUID = 3123640144910331577L;
    
    private OrderStage currentStage = OrderStage.FORMATION;
    
    private Map<Product, Integer> orderedProductList = new HashMap<Product, Integer>();
    
    private Address address = new Address();
    
    private String phone;
    
    private String firstName;
    
    private String lastName;
    
    private String additionalInfo;
    
    public void resetInfo() {
    	phone = null;
    	firstName = null;
    	lastName = null;
    	additionalInfo = null;
    	address = new Address();
    }
    
    public void resetCart() {
    	orderedProductList = new HashMap<Product, Integer>();
    }
    
    public boolean isEmptyCart() {
    	return getProductCount() <= 0;
    }
    
    public int getProductCount() {
    	int total = 0;
    	for (Map.Entry<Product, Integer> entry : orderedProductList.entrySet()) {
    		total += entry.getValue();
    	}
        return total;
    }
    
    public BigDecimal getTotalSum() {
    	BigDecimal total = BigDecimal.ZERO;
    	for (Map.Entry<Product, Integer> entry : orderedProductList.entrySet()) {
    		total = total.add(entry.getKey().getCost().multiply(new BigDecimal(entry.getValue())));
    	}
    	return total;
    }
    
    public void next() {
        currentStage = currentStage.next();
    }
    
    public void previous() {
        currentStage = currentStage.previous();
    }
    
    public void reset() {
        if (currentStage == OrderStage.SUCCESS) {
        	resetCart();
        	resetInfo();
            currentStage = OrderStage.FORMATION;
        }
    }
    
    public void addProduct(Product product) {
        if (orderedProductList.containsKey(product)) {
        	Integer count = orderedProductList.get(product);
        	count++;
        	orderedProductList.put(product, count);
        } else {
        	orderedProductList.put(product, 1);
        }
    }
    
    public OrderStage getCurrentStage() {
        return currentStage;
    }

    public void setCurrentStage(OrderStage currentStage) {
        this.currentStage = currentStage;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

	public Map<Product, Integer> getOrderedProductList() {
		return orderedProductList;
	}

	public void setOrderedProductList(Map<Product, Integer> orderedProductList) {
		this.orderedProductList = orderedProductList;
	}
    
}
