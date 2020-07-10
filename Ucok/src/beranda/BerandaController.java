/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beranda;

import enitity.Informasikasuscovid;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
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

/**
 * FXML Controller class
 *
 * @author jmanu
 */
public class BerandaController implements Initializable {

    @FXML
    TableView tabel;
    @FXML
    TableColumn tpositif,tsembuh,tmeninggal,ttanggal;
    @FXML
    TextField fpositif,fsembuh,fmeninggal;
    @FXML
    Button tambah,edit,hapus;
    @FXML
    MenuItem rumahsakit,dampak,gejala,latar,handsanitizer,penanganan;
   
    Date dt = new Date();
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tpositif.setCellValueFactory(new PropertyValueFactory<>("positif"));
        tsembuh.setCellValueFactory(new PropertyValueFactory<>("sembuh"));
        tmeninggal.setCellValueFactory(new PropertyValueFactory<>("meningal"));
        ttanggal.setCellValueFactory(new PropertyValueFactory<>("tanggalBuat"));
        setTabel();
        edit.setDisable(true);
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
                Informasikasuscovid newdata = (Informasikasuscovid) tabel.getItems().get(index);
                fpositif.setText(String.valueOf(newdata.getPositif()));
                fsembuh.setText(String.valueOf(newdata.getSembuh()));
                fmeninggal.setText(String.valueOf(newdata.getMeningal()));
                tambah.setDisable(true);
                edit.setDisable(false);
        }
                else if(event.isPrimaryButtonDown() && event.getClickCount() == 1){
                fpositif.setText("");
                fsembuh.setText("");
                fmeninggal.setText("");
                tambah.setDisable(false);
                edit.setDisable(true);
                }
            }
        });
       
        tambah.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                Session sesi = Connection.getSessionFactory().openSession();
                sesi.beginTransaction();
                Informasikasuscovid newdata = new Informasikasuscovid(Integer.parseInt(fpositif.getText()),Integer.parseInt(fsembuh.getText()),Integer.parseInt(fmeninggal.getText()),dt);
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
                    Informasikasuscovid newdata = (Informasikasuscovid) tabel.getItems().get(index);
                    newdata.setPositif(Integer.parseInt(fpositif.getText()));
                    newdata.setSembuh(Integer.parseInt(fsembuh.getText()));
                    newdata.setMeningal(Integer.parseInt(fmeninggal.getText()));
                    Session sesi = Connection.getSessionFactory().openSession();
                    newdata.setTanggalBuat(dt);
                    sesi.beginTransaction();
                    sesi.update(newdata);
                    fpositif.setText("");
                    fsembuh.setText("");
                    fmeninggal.setText("");
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
                    Informasikasuscovid newdata = (Informasikasuscovid) tabel.getItems().get(index);
                    Session sesi = Connection.getSessionFactory().openSession();
                    sesi.beginTransaction();
                    sesi.delete(newdata);
                    sesi.getTransaction().commit();
                     sesi.close();
                    setTabel();

                } 
                          }
        });
        rumahsakit.setOnAction(actionEvent ->{
           
                        try{
                            Parent root;
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/rs/RumahSakit.fxml"));
                            root = loader.load();
                            Stage stage = (Stage) tambah.getScene().getWindow();
                             stage.close();
                            stage.setScene(new Scene(root));
                            stage.setTitle("Rumah Sakit");
                            stage.show();
                            }
                            catch(Exception e){
                                System.out.println("Erron");
                            }
                        
                    
        });
        dampak.setOnAction(actionEvent ->{
           
                        try{
                            Parent root;
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/dampak/Dampak.fxml"));
                            root = loader.load();
                            Stage stage = (Stage) tambah.getScene().getWindow();
                             stage.close();
                            stage.setScene(new Scene(root));
                            stage.setTitle("Dampak");
                            stage.show();
                            }
                            catch(Exception e){
                                System.out.println("Erron");
                            }
                        
                    
        });
        gejala.setOnAction(actionEvent ->{
           
                        try{
                            Parent root;
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gejala/GejalaInfeksi.fxml"));
                            root = loader.load();
                            Stage stage = (Stage) tambah.getScene().getWindow();
                             stage.close();
                            stage.setScene(new Scene(root));
                            stage.setTitle("Gejala");
                            stage.show();
                            }
                            catch(Exception e){
                                System.out.println("Erron");
                            }
                        
                    
        });
        latar.setOnAction(actionEvent ->{
           
                        try{
                            Parent root;
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/latarbelakang/LatarBelakang.fxml"));
                            root = loader.load();
                            Stage stage = (Stage) tambah.getScene().getWindow();
                             stage.close();
                            stage.setScene(new Scene(root));
                            stage.setTitle("Latar Belakang");
                            stage.show();
                            }
                            catch(Exception e){
                                System.out.println("Erron");
                            }
                        
                    
        });
        handsanitizer.setOnAction(actionEvent ->{
           
                        try{
                            Parent root;
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/handsanitizer/handsanitizer.fxml"));
                            root = loader.load();
                            Stage stage = (Stage) tambah.getScene().getWindow();
                             stage.close();
                            stage.setScene(new Scene(root));
                            stage.setTitle("Handsanitizer");
                            stage.show();
                            }
                            catch(Exception e){
                                System.out.println("Erron");
                            }
                        
                    
        });
        penanganan.setOnAction(actionEvent ->{
           
                        try{
                            Parent root;
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/penangan/Penangan.fxml"));
                            root = loader.load();
                            Stage stage = (Stage) tambah.getScene().getWindow();
                             stage.close();
                            stage.setScene(new Scene(root));
                            stage.setTitle("Penanganan");
                            stage.show();
                            }
                            catch(Exception e){
                                System.out.println("Erron");
                            }
                        
                    
        });
        
    }    
    
    public void setTabel(){
       Session sesi = Connection.getSessionFactory().openSession();
       Query q1 = sesi.createQuery("from Informasikasuscovid");
   
       List<Informasikasuscovid> lkasus = q1.list();
        sesi.close();
       ObservableList<Informasikasuscovid> rlist = FXCollections.observableArrayList();
       for(Informasikasuscovid x : lkasus){
           rlist.add(x);
       }
       tabel.setItems(rlist);
       
    }
    
}
