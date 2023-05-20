<%-- 
    Document   : orders
    Created on : May 13, 2023, 3:53:00 PM
    Author     : Admin
--%>

<%@page import="model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    User auth = (User) request.getSession().getAttribute("auth");
    if (auth != null) {
        request.setAttribute("auth", auth);
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="includes/header.jsp" %>
        <title>Orders Page</title>
    </head>
    <body>
    
        <%@include file="includes/navbar.jsp" %>
        
        <%@include file="includes/footer.jsp" %>
    
    </body>
</html>

