<%-- 
    Document   : updateForm
    Created on : Nov 3, 2015, 10:19:43 PM
    Author     : Jiawen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Courses" %>
<% Courses course = (Courses) request.getAttribute("course"); %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update A New Course</title>
         <link rel="stylesheet" type="text/css" href="format.css"/>
    </head>
    <body>
         <h1>Update A New Course Record</h1>
        
        <form name="updateForm" action="updateCourse" method="get" >
            
            <table class="update">
                 <tr>
                <td class="right">Course ID:</td>
                <td> <input type="text" name="id" value="<%= course.getCourseid() %>" readonly/></td>
                </tr>
                <tr>
                <td class="right">Course Name:</td>
                <td> <input type="text" name="name" value="<%= course.getCoursename() %>"/></td>
                </tr>
                
                <tr>
                    <td class="right">Semester: </td>
                    <td><input type="text" name="semester" value="<%= course.getSemester() %>"/></td>
                </tr>
                
                <tr>
                    <td class="right">Credit:</td>
                    <td> <input type="text" name="credit" value="<%= course.getCredit() %>"/></td>
                        
                </tr>
             </table>
                    <br>
                    <input type="reset" name="reset" value="Clear" />
                    <input type="submit" name="submit" value="Update"/>
    
        </form>
           
            
           
           
        
        
    </body>
</html>
