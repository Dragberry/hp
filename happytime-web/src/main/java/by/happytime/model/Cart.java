package by.happytime.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import by.happytime.domain.Address;
import by.happytime.domain.OrderUnit;
import by.happytime.domain.Product;

@ManagedBean(name = "cart")
@SessionScoped
public class Cart implements Serializable {
    
    private static final long serialVersionUID = 3123640144910331577L;
    
    private OrderStage currentStage = OrderStage.FORMATION;
    
    private List<OrderUnit> orderUnitList = new ArrayList<OrderUnit>();
    
    private Address address = new Address();
    
    private String phone;
    
    private String firstName;
    
    private String lastName;
    
    private String additionalInfo;
    
    public int getProductCount() {
        return orderUnitList.size();
    }
    
    public void next() {
        currentStage = currentStage.next();
    }
    
    public void previous() {
        currentStage = currentStage.previous();
    }
    
    public void reset() {
        if (currentStage == OrderStage.SUCCESS) {
            orderUnitList = new ArrayList<OrderUnit>();
            currentStage = OrderStage.FORMATION;
        }
    }
    
    public void addOrderUnit(Product product) {
        OrderUnit unit = new OrderUnit();
        unit.setProduct(product);
        unit.setQuantity(1);
        orderUnitList.add(unit);
    }

    public OrderStage getCurrentStage() {
        return currentStage;
    }

    public void setCurrentStage(OrderStage currentStage) {
        this.currentStage = currentStage;
    }

    public List<OrderUnit> getOrderUnitList() {
        return orderUnitList;
    }

    public void setOrderUnitList(List<OrderUnit> orderUnitList) {
        this.orderUnitList = orderUnitList;
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
    
}
