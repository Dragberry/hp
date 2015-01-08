package by.happytime.repository;

import by.happytime.baserepo.BaseRepo;
import by.happytime.domain.Role;

public interface RoleRepo extends BaseRepo<Role> {
    
    Role findByValue(String value);

}
