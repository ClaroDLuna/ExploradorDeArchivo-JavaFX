/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication3;

import javafx.scene.input.MouseEvent;
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
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author user
 */
public class FXMLDocumentController implements Initializable {
    
    ObservableList<String> listButtons = FXCollections.observableArrayList();
    
    @FXML
    TreeView <String> treeview;
    
    Image pcIcon = new Image( getClass().getResourceAsStream("/img/pc.png"));
    Image diskIcon = new Image( getClass().getResourceAsStream("/img/hard-disk.png"));
    Image directoryIcon = new Image( getClass().getResourceAsStream("/img/directory.png"));
    Image documentsIcon = new Image( getClass().getResourceAsStream("/img/documents.png"));
    Image musicIcon = new Image( getClass().getResourceAsStream("/img/Music.png"));
    Image downloadsIcon = new Image( getClass().getResourceAsStream("/img/Downloads.png"));
    Image videoIcon = new Image( getClass().getResourceAsStream("/video/pc.png"));
    
    /*@FXML
    private ListView<String> listView;
    
    @FXML private void handleMouseClick(MouseEvent event) {
        System.out.println("clicked on " + listView.getSelectionModel().getSelectedItem());
    }*/
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        String hostname = System.getProperty("user.name");
        
        // Image Pc
        ImageView pcImage = new ImageView(pcIcon);
        pcImage.setFitHeight(20);
        pcImage.setFitWidth(20);
        
        // Image hard disk
        ImageView diskImage = new ImageView(diskIcon);
        diskImage.setFitHeight(20);
        diskImage.setFitWidth(20);
        
        // Image directory
        ImageView dirImage = new ImageView(directoryIcon);
        dirImage.setFitHeight(20);
        dirImage.setFitWidth(20);
        
        //Image documents
        ImageView docsImage = new ImageView(documentsIcon);
        docsImage.setFitHeight(20);
        docsImage.setFitWidth(20);
        
        //image music
        ImageView musImage = new ImageView(musicIcon);
        musImage.setFitHeight(20);
        musImage.setFitWidth(20);
        
        
        //image downloads
        ImageView downImage = new ImageView(downloadsIcon);
        downImage.setFitHeight(20);
        downImage.setFitWidth(20);
        
        
        //image video
        ImageView vidImage = new ImageView(videoIcon);
        vidImage.setFitHeight(20);
        vidImage.setFitWidth(20);
        
       
        
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
        
        TreeItem<String> pcRoot = new TreeItem<>("Mi PC",pcImage);
        treeview.setRoot(pcRoot);
        
        if( mainC.exists()){
            TreeItem<String> rootC = new TreeItem<>("Disco C", diskImage);
            pcRoot.getChildren().add(rootC);
            //listButtons.add("Disco C");
        }
        
        if( mainD.exists()){
            TreeItem<String> rootD = new TreeItem<>("Disco D", diskImage);
            pcRoot.getChildren().add(rootD);
        }
        
        if( mainDocuments.exists()){
            TreeItem<String> rootDocuments = new TreeItem<>("Documentos", docsImage);
            pcRoot.getChildren().add(rootDocuments);
        }
        
        if( mainVideo.exists()){
             TreeItem<String> rootVideo = new TreeItem<>("Videos", vidImage);
            pcRoot.getChildren().add(rootVideo);
        }
        
        if( mainDownloads.exists()){
            TreeItem<String> rootDownsloads = new TreeItem<>("Descargas", downImage);
            pcRoot.getChildren().add(rootDownsloads);
        }
        
        if( mainMusic.exists()){
            TreeItem<String> rootMusic = new TreeItem<>("Musica", musImage);
            pcRoot.getChildren().add(rootMusic);
        }
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
