package by.happytime.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category extends AbstractEntity {

    private static final long serialVersionUID = 3337446778695702160L;
    
    @Column(name = "title")
    private String title;
    @Column(name = "code")
    private String code;
    @Column(name = "description_title")
    private String descriptionTitle;
    @Column(name = "description")
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescriptionTitle() {
		return descriptionTitle;
	}

	public void setDescriptionTitle(String descriptionTitle) {
		this.descriptionTitle = descriptionTitle;
	}
	
	
}
