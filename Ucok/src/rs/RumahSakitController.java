/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs;

import enitity.Informasikasuscovid;
import enitity.Rumahsakitrujukan;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
public class RumahSakitController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    TableView tabel;
    @FXML
    TableColumn nama,alamat,nomor;
    @FXML
    TextField fnama,falamat,fnomor;  
    @FXML
    Button tambah,edit,hapus,kemb;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         nama.setCellValueFactory(new PropertyValueFactory<>("nama"));
         alamat.setCellValueFactory(new PropertyValueFactory<>("alamat"));
         nomor.setCellValueFactory(new PropertyValueFactory<>("nomorTelepon"));
         setTabel();
         tabel.setOnMousePressed(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
                Node node = ((Node) event.getTarget()).getParent();
                TableRow row;
                if (node instanceof TableRow) {
                    row = (TableRow) node;
                } else {
                    // clicking on text part
                    row = (TableRow) node.getParent();
                }
                int index = tabel.getSelectionModel().getSelectedIndex();
                Rumahsakitrujukan newdata = (Rumahsakitrujukan) tabel.getItems().get(index);
                fnama.setText(String.valueOf(newdata.getNama()));
                falamat.setText(String.valueOf(newdata.getAlamat()));
                fnomor.setText(String.valueOf(newdata.getNomorTelepon()));
                tambah.setDisable(true);
                edit.setDisable(false);
        }
                else if(event.isPrimaryButtonDown() && event.getClickCount() == 1){
                fnama.setText("");
                falamat.setText("");
                fnomor.setText("");
                tambah.setDisable(false);
                edit.setDisable(true);
                }
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
         tambah.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                Session sesi = Connection.getSessionFactory().openSession();
                sesi.beginTransaction();
                Rumahsakitrujukan newdata = new Rumahsakitrujukan(fnama.getText(),falamat.getText(),fnomor.getText());
                sesi.save(newdata);
                sesi.getTransaction().commit();
                 sesi.close();
                setTabel();
            }
        });
         edit.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                if(tabel.getSelectionModel().isEmpty()){
                }
                else{
                    int index = tabel.getSelectionModel().getSelectedIndex();
                    Rumahsakitrujukan newdata = (Rumahsakitrujukan) tabel.getItems().get(index);
                    newdata.setNama(fnama.getText());
                    newdata.setAlamat(falamat.getText());
                    newdata.setNomorTelepon(fnomor.getText());
                    Session sesi = Connection.getSessionFactory().openSession();
                    sesi.beginTransaction();
                    sesi.update(newdata);
                    fnama.setText("");
                    falamat.setText("");
                    fnomor.setText("");
                    tambah.setDisable(false);
                    edit.setDisable(true);
                    sesi.getTransaction().commit();
                     sesi.close();
                    setTabel();

                } 
                          }
        });
         hapus.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                if(tabel.getSelectionModel().isEmpty()){
                }
                else{
                    int index = tabel.getSelectionModel().getSelectedIndex();
                    Rumahsakitrujukan newdata = (Rumahsakitrujukan) tabel.getItems().get(index);
                    Session sesi = Connection.getSessionFactory().openSession();
                    sesi.beginTransaction();
                    sesi.delete(newdata);
                    sesi.getTransaction().commit();
                     sesi.close();
                    setTabel();

                } 
                          }
        });
    }   
    public void setTabel(){
         Session sesi = Connection.getSessionFactory().openSession();
        Query q1 = sesi.createQuery("from Rumahsakitrujukan");

        List<Rumahsakitrujukan> lkasus = q1.list();
         sesi.close();
        ObservableList<Rumahsakitrujukan> rlist = FXCollections.observableArrayList();
        for(Rumahsakitrujukan x : lkasus){
            rlist.add(x);
        }
        tabel.setItems(rlist);
    }
    
}
