package by.happytime.baserepo;

import java.util.List;
import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import by.happytime.domain.AbstractEntity;

public interface ExtendedRepo<T extends AbstractEntity> extends JpaRepository<T, Long>, JpaSpecificationExecutor<T> {

    List<T> findAll();
    
    EntityManager getEntityManager();
    
}
