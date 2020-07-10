/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucok;

import enitity.Pengguna;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.Preferences;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.hibernate.Query;
import org.hibernate.Session;
import src.Connection;

/**
 *
 * @author jmanu
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    TextField username,password;
    @FXML 
    Button button;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
      
       Session sesi = Connection.getSessionFactory().openSession();
       Query q1 = sesi.createQuery("from Pengguna");
       List<Pengguna> ulogin = q1.list();
       sesi.close();
       for(Pengguna x : ulogin){
           if(x.getUsername().equals(username.getText()) && x.getPassword().equals(password.getText())){
 
               try{         
                            Preferences pengguna = Preferences.userRoot();
                            pengguna.put("username", x.getUsername());
                            Parent root;
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/beranda/Beranda.fxml"));
                            root = loader.load();
                            Stage stage = (Stage) button.getScene().getWindow();
                            stage.close();
                            stage.setScene(new Scene(root));
                            stage.setTitle("Beranda");
                            stage.show();
                            } 
                        catch (IOException ex) {
                            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                        }
           }
       }
       
      
       
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
