<%-- 
    Document   : addjsp
    Created on : Oct 28, 2015, 1:15:33 PM
    Author     : Jiawen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add A New Course</title>
         <link rel="stylesheet" type="text/css" href="format.css"/>
    </head>
    <body>
        <h1>Add A New Friend</h1>
        
        <form name="addForm" action="addCourses" method="get" >
            <label> Course Name:</label>
            <input type="text" name="coursename" value=""/>
            <br>
             <label> Semester:</label>
            <input type="text" name="semester" value=""/>
            <br>
             <label> Credit:</label>
            <input type="text" name="credit" value=""/>
            <br>
            <input type="submit" name="submit" value="Submit"/>
        </form>
        
        
    </body>
</html>
