<%-- 
    Document   : index.jsp
    Created on : Mar 18, 2023, 1:01:44 PM
    Author     : usama
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <form action="submit" method="POST">
            <input type="text" name="Input" value="" />
            <input type="submit" value="submit" />
        </form>
        <h1> <%= "assets/hangman/"+session.getAttribute("Random")+".png" %> </h1>
        <img src="<%="assets/hangman/"+session.getAttribute("PicNum")+".png"%>" width="520" height="520" alt="1"/>
    </body>
</html>
