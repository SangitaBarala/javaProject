<%-- 
    Document   : listAlbum
    Created on : Nov 7, 2020, 3:14:09 PM
    Author     : Sangita Barala
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Music Store</title>
    </head>
    <body>
        <center>
        <h1>Music Store: Album</h1>
        <h2>
            <a href="/new">Add New Album</a>&nbsp;&nbsp;&nbsp;
            <a href="/list">List All Album</a>
        </h2>
        </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Albums</h2></caption>
            <tr>
                <th>Album ID</th>
                <th>Album Title</th>
                <th>Media Type</th>
                <th>Genre</th>
                <th>Price</th>
                <th>In Stock</th>
            </tr>
            <c:forEach var="e" items="${listAlbum}">
                <tr>
                    <td><c:out value="${e.albumId}" /></td>
                    <td><c:out value="${e.albumTitle}" /></td>
                    <td><c:out value="${e.mediaType}" /></td>
                    <td><c:out value="${e.genre}" /></td>
                    <td><c:out value="${e.price}" /></td>
                    <td><c:out value="${e.inStock}" /></td>
                    <td>
                        <a href="/edit?id=<c:out value='${e.albumId}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/delete?id=<c:out value='${e.albumId}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
    </body>
</html>
