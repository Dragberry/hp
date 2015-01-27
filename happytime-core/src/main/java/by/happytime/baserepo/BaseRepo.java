package by.happytime.baserepo;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import by.happytime.domain.AbstractEntity;

@Repository
public interface BaseRepo<T extends AbstractEntity> extends ExtendedRepo<T>, Serializable{
    
}
