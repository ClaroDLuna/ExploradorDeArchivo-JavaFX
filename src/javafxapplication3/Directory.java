/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication3;

/**
 *
 * @author user
 */
public class Directory {
    private String name;
    private String path;
 
    public Directory() {
 
    }
 
    public Directory(String name, String path) {
        this.name = name;
        this.path = path;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getPath() {
        return path;
    }
 
    public void setPath(String path) {
        this.path = path;
    }
    
    @Override
    public String toString()  {
        return this.name;
    }
}
