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
            Enter Massage: <input type="text" name="massage"></br>
            Enter Mobile Number:<input type="text" name="number"></br>
            <input type="submit" value="submit">
        </form>
    </body>
</html>
