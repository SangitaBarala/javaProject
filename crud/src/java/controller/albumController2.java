/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.sql.*;
import com.mysql.jdbc.Driver;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Models.albumModel;
/**
 *
 * @author Sangita Barala
 */
public class albumController2 {

    static List<albumModel> listAllAlbum() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
        private final String jdbcURL = "jdbc:mysql://localhost:3306/musichouse";
	private final String jdbcUsername = "root";
	private final String jdbcPassword = "sang12529";
	private Connection conn;
	
	public albumController2()
        {
        super();
        }

    albumController2(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
         public  Connection getConnection(){  
         Connection conn=null;  
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            conn=DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);  
        }catch(Exception e){System.out.println(e);}  
        return conn;  
    }  
	protected void connect() throws SQLException {
        if (conn == null || conn.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            conn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        }
    }
         protected void disconnect() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }
         
         public boolean insertAlbum(albumModel e) throws SQLException {
        String sql = "INSERT INTO album(albumTitle, mediaType, genre,  price,  inStock) VALUES(?, ?, ?,?,?);";
        connect();
         
        PreparedStatement ps =conn.prepareStatement(sql);
        ps.setString(1, e.getAlbumTitle());
        ps.setString(2,e.getMediaType());
        ps.setString(3,e.getGenre());
        ps.setString(4,e.getPrice());
        ps.setString(5,e.getInStock());
         
        boolean rowInserted = ps.executeUpdate() > 0;
        ps.close();
        disconnect();
        return rowInserted;
         }    
	
        public List<albumModel> listAllAlbums() throws SQLException {
        List<albumModel> listAlbum = new ArrayList<>();
         
        String sql = "SELECT * FROM album";
         
        connect();
         
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            int albumId = resultSet.getInt("albumId");
            String albumTitle = resultSet.getString("albumTitle");
            String mediaType = resultSet.getString("mediaType");
             String genre = resultSet.getString("genre");
            String price = resultSet.getString("price");
            String inStock = resultSet.getString("inStock");
             
            albumModel e = new albumModel(albumTitle, mediaType, genre,  price,  inStock);
            listAlbum.add(e);
        }
        resultSet.close();
        statement.close();
         
        disconnect();
         
        return listAlbum;
    }
        public boolean deleteAlbum(albumModel e) throws SQLException {
        String sql = "DELETE FROM album where albumId = ?";
         
        connect();
         
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, e.getAlbumId()); 
        boolean rowDeleted = ps.executeUpdate() > 0;
        ps.close();
        disconnect();
        return rowDeleted;     
    }
        
        public boolean updateAlbum(albumModel e) throws SQLException {
        String sql = "UPDATE album SET albumTitle=?, mediaType=?, genre=?,  price=?,  inStock = ?";
        sql += " WHERE albumId = ?";
        connect();
         
        PreparedStatement ps = conn.prepareStatement(sql);
       ps.setString(1, e.getAlbumTitle());
        ps.setString(2,e.getMediaType());
        ps.setString(3,e.getGenre());
        ps.setString(4,e.getPrice());
      //  ps.setString(5,e.getInStock());
         
        boolean rowUpdated = ps.executeUpdate() > 0;
       ps.close();
        disconnect();
        return rowUpdated;     
    }
	
        public albumModel getAlbum(int albumId) throws SQLException {
        albumModel e = null;
        String sql = "SELECT * FROM album WHERE albumId = ?";
         
        connect();
         
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1,albumId);
         
        ResultSet resultSet = ps.executeQuery();
         
        if (resultSet.next()) {
           //int albumId = resultSet.getInt("albumId");
            String albumTitle = resultSet.getString("albumTitle");
            String mediaType = resultSet.getString("mediaType");
            String genre = resultSet.getString("genre");
            String price = resultSet.getString("price");
            String inStock = resultSet.getString("inStock");
            e=new albumModel(albumTitle, mediaType, genre,  price,  inStock);
           // albumModel e = new albumModel(albumTitle, mediaType, genre,  price,  inStock);
        }
         
        resultSet.close();
        ps.close();
         
        return e;
    }

}
