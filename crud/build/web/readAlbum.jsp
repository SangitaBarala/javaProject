<%-- 
    Document   : readAlbum
    Created on : Nov 7, 2020, 3:26:33 PM
    Author     : Sangita Barala
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <center>
        <h1>Music Store</h1>
        <h2>
            <a href="/new">Add New Album</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/list">List All Album</a>
        </h2>
    </center>
    <div align="center">
        <c:if test="${e != null}">
            <form action="update" method="post">
        </c:if>
        <c:if test="${e == null}">
            <form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    <c:if test="${e != null}">
                        Edit Album
                    </c:if>
                    <c:if test="${e == null}">
                        Add New Album
                    </c:if>
                </h2>
            </caption>
                <c:if test="${e != null}">
                    <input type="hidden" name="albumId" value="<c:out value='${e.albumId}' />" />
                </c:if>           
            <tr>
                <th>Album Title: </th>
                <td>
                    <input type="text" name="albumTitle" size="45"
                            value="<c:out value='${e.albumTitle}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>Media Type: </th>
                <td>
                    <input type="text" name="mediaType" size="45"
                            value="<c:out value='${e.mediaType}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Genre: </th>
                <td>
                    <input type="text" name="genre" size="45"
                            value="<c:out value='${e.genre}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Price: </th>
                <td>
                    <input type="text" name="price" size="5"
                            value="<c:out value='${e.price}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" />
                </td>
            </tr>
        </table>
        </form>
    </div>   
    </body>
</html>
