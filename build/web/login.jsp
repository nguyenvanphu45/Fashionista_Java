<%-- 
    Document   : login
    Created on : May 13, 2023, 3:52:03 PM
    Author     : Admin
--%>

<%@page import="model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    User auth = (User) request.getSession().getAttribute("auth");
    if (auth != null) {
        response.sendRedirect("index.jsp");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="includes/header.jsp" %>
        <title>Fashionista login</title>
    </head>
    <body>
        <%@include file="includes/navbar.jsp" %>
        <div class="container">
            <div class="card w-50 mx-auto my-5">
                <div class="card-header text-center">User Login</div>
                <div class="card-body">
                    <form action="user-login" method="post">
                        <div class="form-group">
                            <label>Email: </label>
                            <input type="email" class="form-control" 
                                   name="login-email" 
                                   placeholder="Enter your email" required
                            >
                        </div>
                        <div class="form-group">
                            <label>Password: </label>
                            <input type="password" class="form-control" 
                                   name="login-password" 
                                   placeholder="Enter your password" required
                            >
                        </div>
                        <div class="text-center">
                            <button type="submit" class="btn btn-primary">Loging</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        
        <%@include file="includes/footer.jsp" %>
    </body>
</html>

