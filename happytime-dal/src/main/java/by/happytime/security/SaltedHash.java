package by.happytime.security;

import java.io.Serializable;

/**
 * Thic class contains salt and hash for password.
 * 
 * @author Maksim
 *
 */
public class SaltedHash implements Serializable {

    private static final long serialVersionUID = -7910325684762183490L;
    
    private String hash;
    
    private String salt;

    public SaltedHash(String hash, String salt) {
        this.hash = hash;
        this.salt = salt;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
    
}
