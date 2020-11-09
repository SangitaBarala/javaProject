/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import Models.albumModel;
import java.sql.SQLException;
import java.util.List;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sangita Barala
 */
public class albumServlet extends HttpServlet {
        
     private static final long serialVersionUID = 1L;
     private albumController2 control;
 
    /**
     *
     */
     @Override
    public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
 
        control = new albumController2(jdbcURL, jdbcUsername, jdbcPassword);
    }
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
         String action = request.getServletPath();
 
        try {
            switch (action) {
            case "/new":
                getAlbum(request, response);
                break;
            case "/insert":
                insertAlbum(request, response);
                break;
            case "/delete":
                deleteAlbum(request, response);
                break;
//           case "/edit":
//               EditForm(request, response);
//                break;
            case "/update":
                updateAlbum(request, response);
                break;
            default:
                listAlbum(request, response);
                break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
    private void listAlbum(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<albumModel> listAlbum = albumController2.listAllAlbum();
        request.setAttribute("listAlbum", listAlbum);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listAlbum.jsp");
        dispatcher.forward(request, response);
    }
     private void getAlbum(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("readAlbum.jsp");
        dispatcher.forward(request, response);
    }
//     private void EditForm(HttpServletRequest request, HttpServletResponse response)
//            throws SQLException, ServletException, IOException {
//        int albumId = Integer.parseInt(request.getParameter("albumId"));
//        albumModel model = albumController2.getAlbum(albumId);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("readAlbum.jsp");
//        request.setAttribute("e", model);
//        dispatcher.forward(request, response);
// 
//    }
      private void insertAlbum(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String albumTitle = request.getParameter("albumTitle");
        String mediaType = request.getParameter("mediaType");
        String genre = request.getParameter("genre");
        String price = request.getParameter("price");
        String inStock = request.getParameter("genre");
 
        albumModel model = new albumModel(albumTitle, mediaType, genre,  price,  inStock);
        control.insertAlbum(model);
        response.sendRedirect("list");
    }
       private void updateAlbum(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int albumId = Integer.parseInt(request.getParameter("albumId"));
       String albumTitle = request.getParameter("albumTitle");
        String mediaType = request.getParameter("mediaType");
        String genre = request.getParameter("genre");
        String price = request.getParameter("price");
        String inStock = request.getParameter("genre");
        albumModel model = new albumModel(albumTitle, mediaType, genre,  price,  inStock);
       
        control.updateAlbum(model);
        response.sendRedirect("list");
    }
        private void deleteAlbum(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int albumId = Integer.parseInt(request.getParameter("albumId"));
 
        albumModel model = new albumModel(albumId);
       
        control.deleteAlbum(model);      
        response.sendRedirect("list");
 
    }
 

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
