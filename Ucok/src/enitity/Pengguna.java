package enitity;
// Generated Jul 8, 2020 10:03:16 AM by Hibernate Tools 4.3.1



/**
 * Pengguna generated by hbm2java
 */
public class Pengguna  implements java.io.Serializable {


     private String username;
     private String nama;
     private String password;
     private String role;

    public Pengguna() {
    }

    public Pengguna(String username, String nama, String password, String role) {
       this.username = username;
       this.nama = nama;
       this.password = password;
       this.role = role;
    }
   
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public String getNama() {
        return this.nama;
    }
    
    public void setNama(String nama) {
        this.nama = nama;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public String getRole() {
        return this.role;
    }
    
    public void setRole(String role) {
        this.role = role;
    }




}

