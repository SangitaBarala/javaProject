<%-- 
    Document   : display
    Created on : Nov 2, 2020, 11:51:55 PM
    Author     : Sangita Barala
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:choose>
    <c:when test="${cookie['user_name'].getValue()==null}">
            <jsp:forward page="login.jsp"></jsp:forward>
    </c:when>
</c:choose>
<c:choose>
    <c:when test="${cookie['user_id'].getValue()==null}">
            <jsp:forward page="login.jsp"></jsp:forward>
    </c:when>
</c:choose>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>display result</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <style>
      body{
	margin: 10px;
        padding: 0;
          }
      .form-img{
             height:600px;
            width:750px;
            text-align: center;
            background-color:#fec107;
            }
            .row {
                background-color:#fec107;
                
            }
  </style>
    </head>
    <body>
        <div class="alert alert-danger">
            <h2 class="text-lg-center"><strong>Welcome to Music Store</strong></h2>
        </div> 
            <div class="row">
                
                    <div class="col-6">
                        <img src="music.jpg" class="form-img" alt="music" >
                    </div>
                    <div class="col-5" class="buttons" style="margin:10px;">
                        <a href="login.jsp" class="btn btn-success">Login</a>
                        <a href="logout" class="btn btn-danger" >Logout</a>
                        <a href="Registration.jsp"><strong>Register</strong></a>
                                  <div  style="margin-top:50px; background-color:#fec102;">
                                      <h3> Welcome <strong>${cookie["user_name"].getValue()}!</strong><h3>
                                 </div>
                    </div>
               
            </div>
            
            
          
    </body>
</html>
