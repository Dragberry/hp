package by.happytime.service.authentication;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import by.happytime.domain.Role;
import by.happytime.domain.User;
import by.happytime.repository.UserRepo;

@Service(value = "happyTimeUserDetailsService")
public class HappyTimeUserDetailsService implements UserDetailsService {
    
    @Autowired
    private UserRepo userRepo;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByLogin(username);
        List<GrantedAuthority> authorities = buildUserAuthority(user.getRoles());
        return buildUserForAuthentication(user, authorities);
    }

    private UserDetails buildUserForAuthentication(User user, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(
                user.getLogin(), 
                user.getPassword(), 
                user.getEnabled(), 
                true, 
                true, 
                true, 
                authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(Set<Role> roles) {
        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
        for (Role userRole : roles) {
            setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
        }
        List<GrantedAuthority> result = new ArrayList<GrantedAuthority>(setAuths);
        return result;
    }

    public UserRepo getUserRepo() {
        return userRepo;
    }

    public void setUserRepo(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

}
