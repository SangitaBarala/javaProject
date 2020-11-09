/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Models.Users;
import javax.servlet.http.Cookie;
/**
 *
 * @author Sangita Barala
 */
public class UserLogin extends HttpServlet {

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
        
            
//        String[] login_info={request.getParameter("email"),request.getParameter("password")};
//        
//        Users user=new Users();
//        String result[]=user.loginUser(login_info);
//        
//        PrintWriter obj=response.getWriter();
//        if(result[0]==null)
//        {
//            request.setAttribute("ERROR","Login Failed");
//        }
//        else
//        {
//            RequestDispatcher dispatcher=request.getRequestDispatcher("index.html");
//            dispatcher.forward(request, response);
//        }
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
        
        String[] login_info={request.getParameter("email"),request.getParameter("password")};
       
        Users user=new Users();
        String result[]=user.loginUser(login_info);
        PrintWriter obj=response.getWriter();
        if(result[0]==null)
        {
            //obj.print("Wrong Email & Password");
            request.setAttribute("Error","Invalid User name or password");
            RequestDispatcher dispatch=request.getRequestDispatcher("login.jsp");
            dispatch.forward(request, response);
        }
//        else if(result[0]!=null)
//        {
//            
//            RequestDispatcher dispatch=request.getRequestDispatcher("display.jsp");
//          dispatch.forward(request, response);
//        }
        else
        {
           // obj.print("Welcome "+result[1]+", your user id is "+result[0]);
            
//          request.setAttribute("user_name", result[1]);
//          request.setAttribute("user_id", result[0]);
            
           Cookie user_id=new Cookie("user_id",result[0]);
           Cookie user_name=new Cookie("user_name",result[1]);
           Cookie user_email=new Cookie("user_email",result[2]);

           response.addCookie(user_id);
           response.addCookie(user_name);
           response.addCookie(user_email);
         
          RequestDispatcher dispatch=request.getRequestDispatcher("display.jsp");
          dispatch.forward(request, response);
        }
        /*if(result[0].equals("Error: Something went wrong!"))
        {
            obj.write(result[1]);
        }
        if(result[0]==null)
        {
            request.setAttribute("ERROR","Login Failed");
            //obj.println("hello");
        }
       else
        {
//            RequestDispatcher dispatcher=request.getRequestDispatcher("index.html");
//            dispatcher.forward(request, response);
        }
        obj.println(result[1]);*/
        
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
