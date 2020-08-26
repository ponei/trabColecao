/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ponei.model;

/**
 *
 * @author Computador
 */
public class Collection {
    private int idCollection;
    private String nameCollection;
    private String brandCollection;
    private String manufacturerCollection;
    private int yearCollection;
    private int volumeCollection;

    public Collection() {
    }

    
    
    public int getIdCollection() {
        return idCollection;
    }

    public void setIdCollection(int idCollection) {
        this.idCollection = idCollection;
    }

    public String getNameCollection() {
        return nameCollection;
    }

    public void setNameCollection(String nameCollection) {
        this.nameCollection = nameCollection;
    }

    public String getBrandCollection() {
        return brandCollection;
    }

    public void setBrandCollection(String brandCollection) {
        this.brandCollection = brandCollection;
    }

    public String getManufacturerCollection() {
        return manufacturerCollection;
    }

    public void setManufacturerCollection(String manufacturerCollection) {
        this.manufacturerCollection = manufacturerCollection;
    }

    public int getYearCollection() {
        return yearCollection;
    }

    public void setYearCollection(int yearCollection) {
        this.yearCollection = yearCollection;
    }

    public int getVolumeCollection() {
        return volumeCollection;
    }

    public void setVolumeCollection(int volumeCollection) {
        this.volumeCollection = volumeCollection;
    }
}
