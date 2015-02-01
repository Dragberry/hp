package by.happytime.baserepo;


import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

import by.happytime.domain.AbstractEntity;

public class ExtendedRepositoryFactoryBean<R extends JpaRepository<T, ID>, T extends AbstractEntity, ID extends Serializable>
        extends JpaRepositoryFactoryBean<R, T, ID> implements Serializable {

    private static final long serialVersionUID = 1043545568090220555L;

    @Override
    protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager) {
        return new ExtendedRepositoryFactory<T>(entityManager);
    }
    
    private static class ExtendedRepositoryFactory<T extends AbstractEntity> extends JpaRepositoryFactory {
        
        private EntityManager entityManager;

        public ExtendedRepositoryFactory(EntityManager entityManager) {
            super(entityManager);
            this.entityManager = entityManager;
        }
        
        @SuppressWarnings("unchecked")
        protected Object getTargetRepository(RepositoryMetadata metadata) {
            return new HappyTimeExtendedRepo<T>((Class<T>) metadata.getDomainType() , entityManager);
        }

        @Override
        protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
            return ExtendedRepo.class;
        }
    }
}

