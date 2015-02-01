package by.happytime.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Role")
public class Role extends AbstractEntity {

    private static final long serialVersionUID = -4589737618241523833L;
    
    public static String ROLE_ADMIN = "ROLE_ADMIN";
    public static String ROLE_ANONYMOUS = "guest";
    public static String ROLE_USER = "ROLE_USER";
    
    @Column(name = "name")
    private String name;
    @Column(name = "role")
    private String role;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
