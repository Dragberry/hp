package by.happytime.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import by.happytime.domain.OrderUnit;
import by.happytime.domain.Product;

@ManagedBean(name = "cart")
@SessionScoped
public class Cart implements Serializable {
    
    private static final long serialVersionUID = 3123640144910331577L;
    
    private OrderStage currentStage = OrderStage.FORMATION;
    
    private List<OrderUnit> orderUnitList = new ArrayList<OrderUnit>();
    
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
    
}
