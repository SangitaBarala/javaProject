<%-- 
    Document   : login
    Created on : Oct 30, 2020, 12:22:42 AM
    Author     : Sangita Barala
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <style>
   *{
	padding:0;
	box-sizing:border-box;
	
  }
  .form-img{
  height:550px;
  width:450px;
  border-top-left-radius:30px;
  border-bottom-left-radius:30px;
  }
  body{
	background-color:#fec107;
  }
  .row{
	margin-top:75px;
	background-color:white;
	border-radius:30px;
	box-shadow:15px 15px 22px gray;
  }
  .form-email,.form-pwd{
	border-radius:4px;
	width:100%;
  }
  .btn1{
	border:none;
	height:50px;
	width:100%;
	background-color:black;
	color:white;
	border-radius:4px;
	font-weight:bold;
  }
  .btn1:hover
  {
	background-color:#fec107;
	color:black;
	border:1px solid #d5dbd9;
  }
  .logo{
	height:100px;
	width:120px;
	margin-bottom:5px;
  }
 
  </style>
    </head>
    <body>
     
        <section class="form my-4 mx-5">
		<div class="container">
                   
                       <% if(request.getAttribute("Error")!=null){ %>
                       
                           <div class="alert alert-warning">
                               <strong>Invalid User name or Password !</strong>
                           </div>
                        <% } %> 
                       </div>  
                  
                    <div class="row no-gutters">
				<div class="col-lg-5">
					<img src="music.jpg" class="form-img" alt="music">
				</div>
                        
				<div class="col-lg-7 px-5 pt-5">
                                    <form action="Login" method="post">  
					<div><img src="musicLogo.png" class="logo"></div>
					<h2><strong>Login into Music House</strong></h2>
                                             
						<div class="form-row">
							<div class="col-lg-7">
								<input type="text" name="email" placeholder="Email address" class="form-email my-3 p-2">
							</div>
						</div>
						<div class="form-row">
							<div class="col-lg-7">
								<input type="password" name="password" placeholder="******" class="form-pwd my-3 p-2">
							</div>
						</div>
						<div class="form-row">
							<div class="col-lg-7">
								<button type="submit" class="btn1 mt-3 mb-5">Login</button>
							</div>
						</div>
						<a href="#">Forgot password</a>
						<p>Don't have an account? <a href="Registration.jsp">Register here</a></p>
                                           </form>    
                                </div>
		    </div>
                </div>
        </section>
         
</body>
</html>
