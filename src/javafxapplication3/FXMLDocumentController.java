/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication3;

import java.io.File;
import java.io.FileFilter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


/**
 *
 * @author user
 */
public class FXMLDocumentController implements Initializable {
    
    // Obtener atributo TreeView del archivo fxml
    @FXML
    TreeView <Directory> treeview;
    
    // Instanciar objetos Image de los iconos
    Image pcIcon = new Image( getClass().getResourceAsStream("/img/pc.png"));
    Image diskIcon = new Image( getClass().getResourceAsStream("/img/hard-disk.png"));
    Image directoryIcon = new Image( getClass().getResourceAsStream("/img/directory.png"));
    Image documentsIcon = new Image( getClass().getResourceAsStream("/img/documents.png"));
    Image musicIcon = new Image( getClass().getResourceAsStream("/img/Music.png"));
    Image downloadsIcon = new Image( getClass().getResourceAsStream("/img/Downloads.png"));
    Image videoIcon = new Image( getClass().getResourceAsStream("/img/video.png"));
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Obtener el nombre del usuario
        String hostname = System.getProperty("user.name");
          
        // Rutas base de los directorios mas conocidos
        String dirPathC = "C:\\"; 
        String dirPathD = "D:\\"; 
        String dirPathDocuments = "C:\\Users\\"+ hostname +"\\Documents";
        String dirPathVideo = "C:\\Users\\"+ hostname +"\\Videos";
        String dirPathDownloads = "C:\\Users\\"+ hostname +"\\Downloads";
        String dirPathMusic = "C:\\Users\\"+ hostname +"\\Music";

        // Obtener el objeto File respecto a las rutas obtenidas
        File mainC = new File(dirPathC);     
        File mainD = new File(dirPathD);
        File mainDocuments = new File(dirPathDocuments);
        File mainVideo = new File(dirPathVideo);
        File mainDownloads = new File(dirPathDownloads);
        File mainMusic = new File(dirPathMusic);
        
        // Configurar icono de Pc
        ImageView pcImage = new ImageView(pcIcon);
        pcImage.setFitHeight(25);
        pcImage.setFitWidth(25);
        
        // Crear raiz del TreeView
        TreeItem<Directory> pcRoot = new TreeItem<>(new Directory("Mi PC",""),pcImage);
        treeview.setRoot(pcRoot);
        
        /**************************************************************************/
        /************** VALIDACIÓN DE EXISTENCIA DE DIRECTORIOS *******************/
        /**************************************************************************/
        
        /****************************** DISCO C ***********************************/
        if( mainC.exists()){
            // Image hard disk
            ImageView diskImage = new ImageView(diskIcon);
            diskImage.setFitHeight(25);
            diskImage.setFitWidth(25);
            
            TreeItem<Directory> rootC = new TreeItem<>(new Directory("Disco C", dirPathC), diskImage);
            pcRoot.getChildren().add(rootC);
        }
        
        /****************************** DISCO D ***********************************/
        if( mainD.exists()){
            // Image hard disk
            ImageView diskImage = new ImageView(diskIcon);
            diskImage.setFitHeight(25);
            diskImage.setFitWidth(25);
            
            TreeItem<Directory> rootD = new TreeItem<>(new Directory("Disco D", dirPathD), diskImage);
            pcRoot.getChildren().add(rootD);
        }
        
        /***************************** DOCUMENTOS *********************************/
        if( mainDocuments.exists()){
            //Image documents
            ImageView docsImage = new ImageView(documentsIcon);
            docsImage.setFitHeight(25);
            docsImage.setFitWidth(25);
        
            TreeItem<Directory> rootDocuments = new TreeItem<>(new Directory("Mis Documentos", dirPathDocuments), docsImage);
            pcRoot.getChildren().add(rootDocuments);
        }
        
        /****************************** VIDEOS ***********************************/
        if( mainVideo.exists()){
            //image video
            ImageView vidImage = new ImageView(videoIcon);
            vidImage.setFitHeight(25);
            vidImage.setFitWidth(25);
            
            TreeItem<Directory> rootVideo = new TreeItem<>(new Directory("Mis Videos", dirPathVideo), vidImage);
            pcRoot.getChildren().add(rootVideo);
        }
        
        /***************************** DESCARGAS *********************************/
        if( mainDownloads.exists()){
            //image downloads
            ImageView downImage = new ImageView(downloadsIcon);
            downImage.setFitHeight(25);
            downImage.setFitWidth(25);
        
            TreeItem<Directory> rootDownloads = new TreeItem<>(new Directory("Mis Descargas", dirPathDownloads), downImage);
            pcRoot.getChildren().add(rootDownloads);
        }
        
        /****************************** MUSICA ***********************************/
        if( mainMusic.exists()){
            //image music
            ImageView musImage = new ImageView(musicIcon);
            musImage.setFitHeight(25);
            musImage.setFitWidth(25);
            
            TreeItem<Directory> rootMusic = new TreeItem<>(new Directory("Mi Música", dirPathMusic), musImage);
            pcRoot.getChildren().add(rootMusic);
        }
        /******************************************************************************/
        /************** FIN VALIDACIÓN DE EXISTENCIA DE DIRECTORIOS *******************/
        /******************************************************************************/
        
        
        // Evento OnClick
        treeview.getSelectionModel().selectedItemProperty().addListener( new ChangeListener() {
        @Override
        public void changed(ObservableValue observable, Object oldValue,Object newValue) {
            // Instancia del TreeItem seleccionado
            TreeItem<Directory> selectedItem = (TreeItem<Directory>) newValue;
            
            // Obtencion del Directorio seleccionado
            File rootFile = new File(selectedItem.getValue().getPath());
            
            getTitleDirectory(selectedItem,rootFile);
        }
      });
    }    
   
    // Funcion que obtiene la lista de Directorios a partir de una ruta
    void getTitleDirectory(TreeItem root,File maindir)
    {
        // Validacion que el archivo exista y sea un directorio
        if(maindir.exists() && maindir.isDirectory()) 
        { 
            // obtencion de lista de archivos que no sean ocultos(Hidden)
            File arr[] = maindir.listFiles(new FileFilter() {
                @Override
                public boolean accept(File file) {
                    return !file.isHidden();
                }
            }); 
            
            System.out.println("**********************************************"); 
            System.out.println("Files from main directory : " + maindir); 
            System.out.println("**********************************************"); 
            
            
            getDirectory(root,arr);
        }  
    }
     
    // Insercion de los archivos File dentro del TreeItem padre
    void getDirectory(TreeItem root,File[] arr)  
    { 
        // For de la lista de archivos obtenidos en la funcion getTitleDirectory
        for ( final File fileEntry : arr){
            // Validacion si es que cada file del array es un directorio
            if( fileEntry.isDirectory() ){
                System.out.println(""+fileEntry.getAbsolutePath());
                // Intancia de un ImageView para los directorios obtenidos dentro del padre
                ImageView dirImage = new ImageView(directoryIcon);
                dirImage.setFitHeight(25);
                dirImage.setFitWidth(25);
                
                // Crear un TreeItem que sera insertado en el TreeItem padre
                TreeItem<Directory> children = new TreeItem<>(new Directory(fileEntry.getName(), fileEntry.getAbsolutePath()), dirImage);
                
                // Insercion de TreeItem hijo dentro del TreeItem padre
                root.getChildren().add(children);
                
                // Obtener el padre con los items expandidos
                root.setExpanded(true);
            }
        }
    }
}
