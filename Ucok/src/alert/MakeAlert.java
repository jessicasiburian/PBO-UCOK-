package alert;


import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jmanu
 */
public class MakeAlert {
   Alert.AlertType type;
    String title;
    String headerText;
    String message;

    public MakeAlert(Alert.AlertType type, String title,String message) {
        this.type = type;
        this.title = title;
        this.message = message;
    }
    public void show(){
       Alert alert =  new Alert(type);
       alert.setHeaderText(null);
       alert.setTitle(title);
       alert.setContentText(message);
       alert.showAndWait();
    }
    public boolean showConfirmation(){
       Alert alert =  new Alert(type);
       alert.setHeaderText(null);
       alert.setTitle(title);
       alert.setContentText(message);
       Optional<ButtonType> confir = alert.showAndWait();
       if(confir.get() == ButtonType.OK){
           return true;
       }
       else{
           return false;
       }
    }
    
}

