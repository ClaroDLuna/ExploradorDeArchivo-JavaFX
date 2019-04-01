/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication3;

import java.awt.event.MouseEvent;
import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

/**
 *
 * @author user
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private ListView<String> listView;
    
    ObservableList<String> listButtons = FXCollections.observableArrayList();
    
    @FXML
    private void handleMouseClick(MouseEvent event) {
        System.out.println("clicked on " + listView.getSelectionModel().getSelectedItem());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        String hostname = System.getProperty("user.name");

        String dirPathC = "C:\\"; 
        String dirPathD = "D:\\"; 
        String dirPathDocuments = "C:\\Users\\"+ hostname +"\\Documents";
        String dirPathVideo = "C:\\Users\\"+ hostname +"\\Videos";
        String dirPathDownloads = "C:\\Users\\"+ hostname +"\\Downloads";
        String dirPathMusic = "C:\\Users\\"+ hostname +"\\Music";

        // File object 
        File mainC = new File(dirPathC);        
        File mainD = new File(dirPathD);
        File mainDocuments = new File(dirPathDocuments);
        File mainVideo = new File(dirPathVideo);
        File mainDownloads = new File(dirPathDownloads);
        File mainMusic = new File(dirPathMusic);

        
        if( mainC.exists()){
            listButtons.add("Disco C");
        }
        
        if( mainD.exists()){
            listButtons.add("Disco D");
        }
        
        if( mainDocuments.exists()){
            listButtons.add("Mis Documentos");
        }
        
        if( mainVideo.exists()){
            listButtons.add("Mis Videos");
        }
        
        if( mainDownloads.exists()){
            listButtons.add("Mis Descargas");
        }
        
        if( mainMusic.exists()){
            listButtons.add("Mi Música");
        }
        
        listView.setItems(listButtons);
   
    }    
    
    /*@FXML 
    public void handleMouseClick(MouseEvent arg0) {
        System.out.println("clicked on " + listView.getSelectionModel().getSelectedItem());
    }*/
   
    /*void getTitleDirectory(File maindir)
    {
        if(maindir.exists() && maindir.isDirectory()) 
        { 
            // array for files and sub-directories  
            // of directory pointed by maindir 
            File arr[] = maindir.listFiles(); 
            
            System.out.println("**********************************************"); 
            System.out.println("Files from main directory : " + maindir); 
            System.out.println("**********************************************"); 
            // Calling recursive method 
            RecursivePrint(arr); 
        }  
    }
        
    void RecursivePrint(File[] arr)  
    { 
        for ( final File fileEntry : arr){
            if( fileEntry.isDirectory()){
                System.out.println(""+fileEntry.getName());
            }
        }
    } */
}
