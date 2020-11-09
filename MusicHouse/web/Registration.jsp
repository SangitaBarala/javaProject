<%-- 
    Document   : Registration
    Created on : Oct 30, 2020, 12:23:46 AM
    Author     : Sangita Barala
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
      
 <style>  
*{
	margin:20px;
	padding:0;
	box-sizing:border-box;
}
body{
	background-color:#fec107;
	padding:0 10px;
}
.wrapper{
	max-width:500px;
	width:100%;
	background:white;
	margin:20px auto;
	padding:30px;
	box-shadow:1px 1px 2px rgba(0,0,0,0.125);
}
.wrapper .title{
	font-weight:bold;
	margin: 25px;
	color:#fec107;
	text-align:center;
}
.wrapper .form{
	width:100%;
}
.wrapper .form .input-field{
	margin-bottom:15px;
	display:flex;
	align-items:center;
}
.wrapper .form .input-field label{
	width:150px;
	color:#757575;
	margin-right:10px;
	font-size:14px;
}
.wrapper .form .input-field .input,
.wrapper .form .input-field .textarea{
	width:200px;
	outline:none;
	border:1px solid #d5dbd9;
	font-size:15px;
	padding:8px 10px;
	border-radius:3px;
	transition:all 0.3s ease;
}
.wrapper .form .input-field .input .textarea{
	resize:none;
	height:120px;
	border:1px solid #d5dbd9;
}
.wrapper .form .input-field .input:focus,
.wrapper .form .input-field .textarea:focus{
	border:1px solid #fec107;
}
.wrapper .form .input-field .button{
	width:100%;
	background-color:black;
	color:white;
	font-weight:bold;
	padding:8px 10px;
	font-size:15px;
	border-radius:4px;
	margin-top:10px;
}
.wrapper .form .input-field .button:hover{
	background-color:#fec107;
	color:black;
	font-weight:bold;
}

</style>
</head>
<body>
	<div class="wrapper">
            <form action="Registration" method="post">
		<div class="title">
			<h2>Create Account</h2>
		</div>
		<div class="form">
			<div class="input-field">
				<label>Name</label>
                                <input type="text" name="name" class="input" required>
			</div>	
			<div class="input-field">
				<label>Email</label>
				<input type="text" name="email" class="input" required>
			</div>	
			<div class="input-field">
				<label>Password</label>
				<input type="password" name="password" class="input" required>
			</div>	
			<div class="input-field">
				<label>Address</label>
				<textarea name="address" class="textarea" required></textarea>
			</div>	
			<div class="input-field">
				<label>Postal Code</label>
				<input type="text" name="postalCode" class="input" required>
			</div>	
			<div class="input-field">
				<label>Phone Number</label>
				<input type="text" name="phoneNumber" class="input" required>
			</div>	
			<div class="input-field">
				<input type="submit" value="Register" class="button">
			</div>	
                        <p class="input-field">
                        Have already an account ? <a href="login.jsp" class="loginhere-link">Login here</a>
                        </p>
		</div>
            </form>
       </body>
</html>
