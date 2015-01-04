package by.happytime.audit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import by.happytime.domain.User;
import by.happytime.repository.UserRepo;

@Component("auditorAware")
public class HappyTimeAuditorAware implements AuditorAware<User> {
    
    @Autowired
    private UserRepo userRepo;

    public User getCurrentAuditor() {
       return userRepo.findOne(1L);
    }

}
