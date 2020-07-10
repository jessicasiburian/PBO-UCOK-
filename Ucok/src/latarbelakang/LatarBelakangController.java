/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latarbelakang;

import alert.MakeAlert;
import enitity.Gejalaterinfeksi;
import enitity.Latarbelakang;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.hibernate.Query;
import org.hibernate.Session;
import src.Connection;
import ucok.FXMLDocumentController;

/**
 * FXML Controller class
 *
 * @author jmanu
 */
public class LatarBelakangController implements Initializable {

    @FXML
    TextField judul;
    @FXML
    TextArea isi;
    @FXML
    Button simpan,kemb;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Session sesi = Connection.getSessionFactory().openSession();
       Query q1 = sesi.createQuery("from Latarbelakang");
   
       List<Latarbelakang> lkasus = q1.list();
        sesi.close();
        judul.setText(lkasus.get(0).getJudul());
        isi.setText(lkasus.get(0).getIsi());
         simpan.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                Session sesi = Connection.getSessionFactory().openSession();
                Latarbelakang newdata = lkasus.get(0);
                newdata.setJudul(judul.getText());
                newdata.setIsi(isi.getText());
                sesi.beginTransaction();
                sesi.update(newdata);
                sesi.getTransaction().commit();
                 sesi.close();
                  new MakeAlert(Alert.AlertType.INFORMATION,"Berhasil","Data telah diubah").show();
            }
        });
         kemb.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
              try{
                            Parent root;
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/beranda/Beranda.fxml"));
                            root = loader.load();
                            Stage stage = (Stage) kemb.getScene().getWindow();
                            stage.close();
                            stage.setScene(new Scene(root));
                            stage.setTitle("Beranda");
                            stage.show();
                            } 
                        catch (IOException ex) {
                            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                        }
            }
        });
    }     
    
}
