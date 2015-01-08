package by.happytime.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Role")
public class Role extends AbstractEntity {

    private static final long serialVersionUID = -4589737618241523833L;
    
    public static String ROLE_ADMIN = "admin";
    public static String ROLE_GUEST = "guest";
    public static String ROLE_USER = "user";
    
    @Column(name = "name")
    private String name;
    @Column(name = "value")
    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
