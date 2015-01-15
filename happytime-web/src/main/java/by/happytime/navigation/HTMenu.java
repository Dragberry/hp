package by.happytime.navigation;

import java.io.Serializable;

public class HTMenu implements Serializable {
	
	private static final long serialVersionUID = -8117918705213997363L;
	
	private String title;

	public String getTitle() {
		return title; 
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
}
