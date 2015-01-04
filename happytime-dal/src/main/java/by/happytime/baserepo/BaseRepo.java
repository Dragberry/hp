package by.happytime.baserepo;

import org.springframework.stereotype.Repository;

import by.happytime.domain.AbstractEntity;

@Repository
public interface BaseRepo<T extends AbstractEntity> extends ExtendedRepo<T> {
    
}
