<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <link rel="stylesheet" type="text/css" href="format.css"/>
    </head>
    
    <% String table = (String) request.getAttribute("table"); %>
    
    <body>
        <h1>My Courses</h1>
        
       
        <%= table %>
        
        <br><br>
        
        <a href ="add"> Add a New Course</a>
    </body>
</html>
