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
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
    TreeView <Directory> treeview;
    
    Image pcIcon = new Image( getClass().getResourceAsStream("/img/pc.png"));
    Image diskIcon = new Image( getClass().getResourceAsStream("/img/hard-disk.png"));
    Image directoryIcon = new Image( getClass().getResourceAsStream("/img/directory.png"));
    Image documentsIcon = new Image( getClass().getResourceAsStream("/img/documents.png"));
    Image musicIcon = new Image( getClass().getResourceAsStream("/img/Music.png"));
    Image downloadsIcon = new Image( getClass().getResourceAsStream("/img/Downloads.png"));
    Image videoIcon = new Image( getClass().getResourceAsStream("/img/video.png"));
    
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
        
        // Image Pc
        ImageView pcImage = new ImageView(pcIcon);
        pcImage.setFitHeight(20);
        pcImage.setFitWidth(20);
        
        TreeItem<Directory> pcRoot = new TreeItem<>(new Directory("Mi PC",""),pcImage);
        treeview.setRoot(pcRoot);
        
        // Check if C hard disk exist
        if( mainC.exists()){
            // Image hard disk
            ImageView diskImage = new ImageView(diskIcon);
            diskImage.setFitHeight(20);
            diskImage.setFitWidth(20);
            
            TreeItem<Directory> rootC = new TreeItem<>(new Directory("Disco C", dirPathC), diskImage);
            pcRoot.getChildren().add(rootC);
        }
        
        // Check if D hard disk exist
        if( mainD.exists()){
            // Image hard disk
            ImageView diskImage = new ImageView(diskIcon);
            diskImage.setFitHeight(20);
            diskImage.setFitWidth(20);
            
            TreeItem<Directory> rootD = new TreeItem<>(new Directory("Disco D", dirPathD), diskImage);
            pcRoot.getChildren().add(rootD);
        }
        
        // Check if documents directory exist
        if( mainDocuments.exists()){
            //Image documents
            ImageView docsImage = new ImageView(documentsIcon);
            docsImage.setFitHeight(20);
            docsImage.setFitWidth(20);
        
            TreeItem<Directory> rootDocuments = new TreeItem<>(new Directory("Mis Documentos", dirPathDocuments), docsImage);
            pcRoot.getChildren().add(rootDocuments);
        }
        
        // Check if video directory exist
        if( mainVideo.exists()){
            //image video
            ImageView vidImage = new ImageView(videoIcon);
            vidImage.setFitHeight(20);
            vidImage.setFitWidth(20);
            
            TreeItem<Directory> rootVideo = new TreeItem<>(new Directory("Mis Videos", dirPathVideo), vidImage);
            pcRoot.getChildren().add(rootVideo);
        }
        
        // Check if downloads directory exist
        if( mainDownloads.exists()){
            //image downloads
            ImageView downImage = new ImageView(downloadsIcon);
            downImage.setFitHeight(20);
            downImage.setFitWidth(20);
        
            TreeItem<Directory> rootDownloads = new TreeItem<>(new Directory("Mis Descargas", dirPathDownloads), downImage);
            pcRoot.getChildren().add(rootDownloads);
        }
        
        // Check if music directory exist
        if( mainMusic.exists()){
            //image music
            ImageView musImage = new ImageView(musicIcon);
            musImage.setFitHeight(20);
            musImage.setFitWidth(20);
            
            TreeItem<Directory> rootMusic = new TreeItem<>(new Directory("Mi Música", dirPathMusic), musImage);
            pcRoot.getChildren().add(rootMusic);
        }
        
        treeview.getSelectionModel().selectedItemProperty().addListener( new ChangeListener() {

        @Override
        public void changed(ObservableValue observable, Object oldValue,Object newValue) {

            TreeItem<Directory> selectedItem = (TreeItem<Directory>) newValue;
            
            File rootFile = new File(selectedItem.getValue().getPath());
            getTitleDirectory(selectedItem,rootFile);
        }
      });
    }    
   
    // Get list of directory from root
    void getTitleDirectory(TreeItem root,File maindir)
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
            getDirectory(root,arr);
        }  
    }
     
    // Insert in TreeItem 
    void getDirectory(TreeItem root,File[] arr)  
    { 
        for ( final File fileEntry : arr){
            if( fileEntry.isDirectory()){
                System.out.println(""+fileEntry.getAbsolutePath());
                // Image directory
                ImageView dirImage = new ImageView(directoryIcon);
                dirImage.setFitHeight(20);
                dirImage.setFitWidth(20);
                
                TreeItem<Directory> children = new TreeItem<>(new Directory(fileEntry.getName(), fileEntry.getAbsolutePath()), dirImage);
                root.getChildren().add(children);
                root.setExpanded(true);
            }
        }
    }
}
