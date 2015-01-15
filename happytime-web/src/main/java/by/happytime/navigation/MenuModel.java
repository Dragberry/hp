package by.happytime.navigation;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.XmlMappingException;

@ManagedBean(name = "menuModel")
@SessionScoped
public class MenuModel implements Serializable {

	private static final long serialVersionUID = 5994037666243749993L;

	@ManagedProperty("#{castorMarshaller}")
	private Marshaller marshaller;
	@ManagedProperty("#{castorMarshaller}")
	private Unmarshaller unmarshaller;
	
	
	public void testUnmarshall() throws XmlMappingException, IOException {
		ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
		InputStream is = null;
        try {
        	is = servletContext.getResourceAsStream("/WEB-INF/menu.xml");
            HTMenu menu =   (HTMenu) this.unmarshaller.unmarshal(new StreamSource(is));
            System.out.print("");
        } finally {
            if (is != null) {
                is.close();
            }
        }
		
	}

	public void testMarshall() throws XmlMappingException, IOException {
		
        
		HTMenu menu = new HTMenu();
		menu.setTitle("Test");
		FileOutputStream os = null;
		try {
			os = new FileOutputStream("menu.xml");
			this.marshaller.marshal(menu, new StreamResult(os));
		} finally {
			if (os != null) {
				os.close();
			}
		}
	}

	public Marshaller getMarshaller() {
		return marshaller;
	}

	public void setMarshaller(Marshaller marshaller) {
		this.marshaller = marshaller;
	}

	public Unmarshaller getUnmarshaller() {
		return unmarshaller;
	}

	public void setUnmarshaller(Unmarshaller unmarshaller) {
		this.unmarshaller = unmarshaller;
	}

}
