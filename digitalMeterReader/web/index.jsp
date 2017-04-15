<%-- 
    Document   : index
    Created on : Apr 11, 2017, 4:49:49 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World! this is jsp</h1>
        
        <form action="indexServlet" method="post">
            meter no: <input type="text" name="meter"></br>
            units: <input type="text" name="units"></br>
            
            <input type="submit" value="submit">
        </form>
    </body>
</html>
