package by.happytime.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailConstants;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import by.happytime.domain.Address;
import by.happytime.domain.Order;
import by.happytime.domain.OrderStatus;
import by.happytime.domain.OrderUnit;
import by.happytime.domain.Product;
import by.happytime.repository.OrderRepo;
import by.happytime.repository.OrderUnitRepo;

@ManagedBean(name = "cart")
@SessionScoped
public class Cart implements Serializable {
    
    private static final long serialVersionUID = 3123640144910331577L;
    
    @ManagedProperty("#{orderRepo}")
    private OrderRepo orderRepo;
    @ManagedProperty("#{orderUnitRepo}")
    private OrderUnitRepo orderUnitRepo;
    
    private OrderStage currentStage = OrderStage.FORMATION;
    
    private Map<Product, Integer> orderedProductList = new HashMap<Product, Integer>();
    
    private Address address = new Address();
    
    private String phone;
    
    private String firstName;
    
    private String lastName;
    
    private String additionalInfo;
    
    public void onProductQuantityChange(ValueChangeEvent event) {
        Integer q = (Integer) event.getNewValue();
    }
    
    public void removeFromOrderList(Product product) {
        orderedProductList.remove(product);
    }
    
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
    
    public void next() throws EmailException {
        if (currentStage == OrderStage.OVERVIEW) {
            proccesOrder();
        }
        currentStage = currentStage.next();
    }
    
    private void proccesOrder() throws EmailException {
        Order order = new Order();
        order.setFirstName(firstName);
        order.setLastName(lastName);
        order.setCountry(null);
        order.setCity(null);
        order.setStreet(address.getStreet());
        order.setHouse(address.getHouse());
        order.setHousing(address.getHousing());
        order.setFlat(address.getFlat());
        order.setEmail(null);
        order.setPhone(phone);
        order.setAdditionalInfo(additionalInfo);
        order.setStatus(OrderStatus.NEW);
        order = orderRepo.save(order);
        
        for (Map.Entry<Product, Integer> entry : orderedProductList.entrySet()) {
            OrderUnit unit = new OrderUnit();
            unit.setOrder(order);
            unit.setProduct(entry.getKey());
            unit.setQuantity(entry.getValue());
            orderUnitRepo.save(unit);
        }
        order = orderRepo.findOne(order.getId());
        sendMail(order.toString());
        
    }
    
    public void sendMail(String mail) throws EmailException {
        Email email = new SimpleEmail();
        email.setCharset(EmailConstants.UTF_8);
        email.setHostName("smtp.googlemail.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator("makseemkadragun", "NoMoreSorrow123"));
        email.setSSLOnConnect(true);
        email.setFrom("makseemkadragun@gmail.com");
        email.setSubject("Test order");
        email.setMsg(mail);
        email.addTo("max-hellfire@mail.ru");
//        email.addTo("yuria-25@mail.ru");
        email.send();
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

    public OrderRepo getOrderRepo() {
        return orderRepo;
    }

    public void setOrderRepo(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    public OrderUnitRepo getOrderUnitRepo() {
        return orderUnitRepo;
    }

    public void setOrderUnitRepo(OrderUnitRepo orderUnitRepo) {
        this.orderUnitRepo = orderUnitRepo;
    }
    
}
