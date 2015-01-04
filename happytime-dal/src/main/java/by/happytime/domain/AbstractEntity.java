package by.happytime.domain;

import java.io.Serializable;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;

import org.springframework.data.jpa.domain.AbstractAuditable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@AttributeOverrides({
    @AttributeOverride(name = "id", column = @Column(name = "id")),
    @AttributeOverride(name = "lastModifiedDate", column = @Column(name = "last_modified_date")),
    @AttributeOverride(name = "createdDate", column = @Column(name = "created_date"))
})
@AssociationOverrides({
    @AssociationOverride(name = "id", joinColumns = {@JoinColumn(name = "id")}),
    @AssociationOverride(name = "createdBy", joinColumns = {@JoinColumn(name = "created_by")}),
    @AssociationOverride(name = "lastModifiedBy", joinColumns = {@JoinColumn(name = "last_modified_by")})
})
public abstract class AbstractEntity extends AbstractAuditable<User, Long> implements Serializable {

    private static final long serialVersionUID = -2083224002374950854L;
    
    public AbstractEntity() {
    }

    public void setId(Long id) {
        super.setId(id);
    }
    
    public Long getId() {
        return super.getId();
    }

}
