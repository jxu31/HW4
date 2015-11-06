<%-- 
    Document   : search
    Created on : Nov 4, 2015, 12:04:38 PM
    Author     : Jiawen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Courses</title>
        <link rel="stylesheet" type="text/css" href="format.css"/>
    </head>
    
    <body>
        <div class="wrap">

            <%@ include file="includes/header.jsp" %>

            <%@ include file="includes/menu.jsp" %>

            <div class="main">
        <h1>Search Courses</h1>
        <form name="searchForm" action="search" method="get">
            <input type="text" name="searchVal" value="">
            <br>
            <input type="submit" name="submit" value="Search">
            
        </form>
          </div>


            <%@ include file="includes/footer.jsp" %>

        </div>
    </body>
</html>
