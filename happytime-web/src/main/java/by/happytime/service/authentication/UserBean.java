package by.happytime.service.authentication;

import java.io.Serializable;
import java.util.Collection;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import by.happytime.domain.User;
import by.happytime.repository.UserRepo;

@ManagedBean(name = "userBean")
@SessionScoped
public class UserBean implements Serializable {

    private static final long serialVersionUID = -1944196553397148289L;
    
    @ManagedProperty("#{userRepo}")
    private UserRepo userRepo;
    
    public boolean hasPermission(String role) {
        SecurityContext context = SecurityContextHolder.getContext();
        if (context == null)
            return false;
        Authentication authentication = context.getAuthentication();
        if (authentication == null) {
            return false;
        }
        for (GrantedAuthority auth : authentication.getAuthorities()) {
            if (role.equals(auth.getAuthority()))
                return true;
        }
        return false;
    }
    
    public User getLoggedUser() {
        String login = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepo.findByLogin(login);
        if (user == null) {
            user = userRepo.findByLogin(User.ANONYMOUS_USER);
        }
        return user;
    }

    public UserRepo getUserRepo() {
        return userRepo;
    }

    public void setUserRepo(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

}
