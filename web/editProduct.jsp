<%-- 
    Document   : editProduct
    Created on : May 17, 2023, 10:18:00 PM
    Author     : Admin
--%>

<%@page import="model.User"%>
<%@page import="model.Product"%>
<%@page import="java.util.List"%>
<%@page import="dao.ProductDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    User auth = (User) request.getSession().getAttribute("auth");
    if (auth != null) {
        request.setAttribute("auth", auth);
    }
    
    String id = request.getParameter("id");
    Product products = ProductDao.getProductById(id);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="includes/header.jsp" %>
        <title>Edit product</title>
    </head>
    <body>
        <%@include file="includes/navbar.jsp" %>
        
        <div class="container">
            <h3>Edit product</h3>
            <h1><%=products %></h1>
                    <form action="add-product" method="post" >
                        <div class="form-group">
                            <label for="id">Id</label>
                            <input type="text" class="form-control" value="<%=products.getId() %>" name="id">
                        </div>
                        <div class="form-group">
                            <label for="name">Name</label>
                            <input type="text" class="form-control" value="<%=products.getName()%>" name="name">
                        </div>
                        <div class="form-group">
                            <label for="price">Price</label>
                            <input type="text" class="form-control" value="<%=products.getPrice()%>" name="price">
                        </div>
                        <div class="form-group">
                            <label for="description">Description</label>
                            <input type="text" class="form-control" value="<%=products.getDescription()%>" name="description">
                        </div>
                        <div class="form-group">
                            <label for="image">Image</label>
                            <input type="text" class="form-control" value="<%=products.getImage()%>" name="image">
                        </div>

                        <button type="submit" class="btn btn-primary">Update Product</button>
                    </form>
        </div>
        
        <%@include file="includes/footer.jsp" %>
    </body>
</html>
