package by.happytime.repository;

import by.happytime.baserepo.BaseRepo;
import by.happytime.domain.User;

public interface UserRepo extends BaseRepo<User> {
    
    User findByLogin(String login);

}
