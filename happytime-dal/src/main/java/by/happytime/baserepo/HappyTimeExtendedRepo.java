package by.happytime.baserepo;

import javax.persistence.EntityManager;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import by.happytime.domain.AbstractEntity;

public class HappyTimeExtendedRepo <T extends AbstractEntity> extends SimpleJpaRepository<T, Long> implements ExtendedRepo<T> {

    protected EntityManager entityManager;
    protected Class<T> domainClass;
    
    public HappyTimeExtendedRepo(Class<T> domainClass, EntityManager entityManager) {
        super(domainClass, entityManager);
        this.entityManager = entityManager;
        this.domainClass = domainClass;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

}