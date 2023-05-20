<%-- 
    Document   : orders
    Created on : May 13, 2023, 3:53:00 PM
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
    
    ProductDao pro = new ProductDao();
    List<Product> products = pro.getProducts();
%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="includes/header.jsp" %>
        <title>Product Page</title>
    </head>
    <body>
        <%@include file="includes/navbar.jsp" %>
        <div class="container">
            <h3 class="my-5">
                <a class="" href="add-product">Add Product</a>
            </h3>
            <table class="table table-light">
                <thead>
                    <tr>
                        <th scope="col">Name</th>
                        <th scope="col">Price</th>
                        <th scope="col">Description</th>
                        <th scope="col">Image</th>
                        <th scope="col"></th>
                    </tr>
                </thead>
                <tbody>
                    <% 
                    if(!products.isEmpty()) {
                        for (Product p : products) { %>
                            <tr>
                                <td><%= p.getName() %></td>
                                <td><%= p.getPrice() %></td>
                                <td><%= p.getDescription() %></td>
                                <td><%= p.getImage()%></td>
                                <td>
                                    <a class="btn btn-sm btn-info" href="editProduct.jsp?id=<%= p.getId() %>">
                                        Edit
                                    </a>
                                    <a class="btn btn-sm btn-danger mt-3">Remove</a>
                                </td>
                            </tr>
                        <%}
                        }
                    %>
                </tbody>
            </table>
        </div>
        
        
        <%@include file="includes/footer.jsp" %>
    
    </body>
</html>

