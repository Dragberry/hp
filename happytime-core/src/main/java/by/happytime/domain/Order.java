package by.happytime.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.collections4.CollectionUtils;

@Entity
@Table(name = "`order`")
public class Order extends AbstractEntity {

    private static final long serialVersionUID = 8075684027785421996L;

    @Column(name = "order_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;
    @Enumerated
    @Column(name = "status")
    private OrderStatus status;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "country")
    private String country;
    @Column(name = "city")
    private String city;
    @Column(name = "street")
    private String street;
    @Column(name = "house")
    private Integer house;
    @Column(name = "housing")
    private Integer housing;
    @Column(name = "flat")
    private Integer flat;
    @Column(name = "postal_code")
    private String postalCode;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Column(name = "additional_info")
    private String additionalInfo;
    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "order_id")
    private List<OrderUnit> orderUnits = new ArrayList<OrderUnit>();
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Order id: " + getId() + "\n");
        builder.append(getFirstName() + " " + getLastName() + "\n");
        builder.append("Phone: " + getPhone() + "\n");
        builder.append("Street: " + getStreet() + "\n");
        builder.append("House: " + getHouse() + "\n");
        if (getHousing() != null) {
            builder.append("Housing: " + getHousing() + "\n");
        }
        builder.append("Flat: " + getFlat() + "\n");
        builder.append("Additional Info: " + getAdditionalInfo() + "\n");
        builder.append("\nProducts:\n");
        if (CollectionUtils.isNotEmpty(getOrderUnits())) {
            int index = 1;
            BigDecimal fullCost = BigDecimal.ZERO;
            for (OrderUnit unit : getOrderUnits()) {
                builder.append("\t" + index + ".Product id: " + unit.getProduct().getId() + "\n");
                builder.append("\t  Product title: " + unit.getProduct().getTitle() + "\n");
                builder.append("\t  Product cost: " + unit.getProduct().getCost() + "\n");
                builder.append("\t  Product quantity: " + unit.getQuantity() + "\n");
                builder.append("\t  Product full cost: " + unit.getFullCost() + "\n\n");
                fullCost = fullCost.add(unit.getFullCost());
                index++;
            }
            builder.append("\nOrder cost: " + fullCost);
        }
        return builder.toString();
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<OrderUnit> getOrderUnits() {
        return orderUnits;
    }

    public void setOrderUnits(List<OrderUnit> orderUnits) {
        this.orderUnits = orderUnits;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getHouse() {
        return house;
    }

    public void setHouse(Integer house) {
        this.house = house;
    }

    public Integer getHousing() {
        return housing;
    }

    public void setHousing(Integer housing) {
        this.housing = housing;
    }

    public Integer getFlat() {
        return flat;
    }

    public void setFlat(Integer flat) {
        this.flat = flat;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

}
