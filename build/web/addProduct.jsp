<%-- 
    Document   : addProduct
    Created on : May 17, 2023, 7:58:01 AM
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
        <title>Add product Page</title>
    </head>
    <body>
        <%@include file="includes/navbar.jsp" %>
        
        <div class="container">
            <h3>Create product</h3>

            <form action="add-product" method="post" >
                <div class="form-group">
                    <label for="id">Id</label>
                    <input type="text" class="form-control" name="id">
                </div>
                <div class="form-group">
                    <label for="name">Name</label>
                    <input type="text" class="form-control" name="name">
                </div>
                <div class="form-group">
                    <label for="price">Price</label>
                    <input type="text" class="form-control" name="price">
                </div>
                <div class="form-group">
                    <label for="description">Description</label>
                    <input type="text" class="form-control" name="description">
                </div>
                <div class="form-group">
                    <label for="image">Image</label>
                    <input type="text" class="form-control" name="image">
                </div>

                <button type="submit" class="btn btn-primary">Add Product</button>
            </form>
        </div>
        
        <%@include file="includes/footer.jsp" %>
    </body>
</html>
