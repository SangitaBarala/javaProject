/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Sangita Barala
 */
public class albumModel {
    
     private int albumId;
    private String albumTitle;
    private String mediaType;
    private String genre;
    private String price;
    private String inStock;
    
    public albumModel(){}
    public albumModel(String albumTitle, String mediaType, String genre, String price, String inStock) {
       
        this.albumTitle = albumTitle;
        this.mediaType = mediaType;
        this.genre = genre;
        this.price = price;
        this.inStock = inStock;
    }
    public albumModel(int albumId, String albumTitle, String mediaType, String genre, String price, String inStock) {
        this.albumId = albumId;
        this.albumTitle = albumTitle;
        this.mediaType = mediaType;
        this.genre = genre;
        this.price = price;
        this.inStock = inStock;
    }

    public albumModel(int albumId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getInStock() {
        return inStock;
    }

    public void setInStock(String inStock) {
        this.inStock = inStock;
    }
   
}
