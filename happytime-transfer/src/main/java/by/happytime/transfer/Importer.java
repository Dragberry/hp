package by.happytime.transfer;

import java.io.InputStream;
import java.io.Serializable;

public interface Importer extends Serializable {
    
    public void doImport(InputStream is) throws Exception;

}
