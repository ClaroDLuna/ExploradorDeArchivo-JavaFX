/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication3;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.ImageView;

/**
 *
 * @author user
 */
public class FileInfo {
    //private SimpleIntegerProperty id;
    private ImageView image;
    private SimpleStringProperty name;
    private SimpleStringProperty size;
    private SimpleStringProperty date;

    public FileInfo(ImageView image, String name, String size, String date){
        super();
        this.image = image;
        this.name = new SimpleStringProperty(name);
        this.size = new SimpleStringProperty(size);
        this.date = new SimpleStringProperty(date);
    }

    public FileInfo(String name, String size, String date){
        super();
        //this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.size = new SimpleStringProperty(size);
        this.date = new SimpleStringProperty(date);
    }

    //public Integer getId(){ return id.get(); }
    public String getDate(){ return date.get();}
    public String getSize(){return size.get();}
    public String getName(){return name.get();}
    public void setImage(ImageView value) {image = value;}
    public ImageView getImage() {return image;}
}
