package enitity;
// Generated Jul 8, 2020 10:03:16 AM by Hibernate Tools 4.3.1



/**
 * Latarbelakang generated by hbm2java
 */
public class Latarbelakang  implements java.io.Serializable {


     private Integer id;
     private String judul;
     private String isi;

    public Latarbelakang() {
    }

    public Latarbelakang(String judul, String isi) {
       this.judul = judul;
       this.isi = isi;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getJudul() {
        return this.judul;
    }
    
    public void setJudul(String judul) {
        this.judul = judul;
    }
    public String getIsi() {
        return this.isi;
    }
    
    public void setIsi(String isi) {
        this.isi = isi;
    }




}


