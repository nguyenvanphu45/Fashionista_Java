<%-- 
    Document   : index
    Created on : May 13, 2023, 3:52:22 PM
    Author     : Admin
--%>

<%@page import="java.util.List"%>
<%@page import="model.Product"%>
<%@page import="dao.ProductDao"%>
<%@page import="model.User"%>
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
        <title>Fashionista</title>
    </head>
        <%@include file="includes/navbar.jsp" %>
        
        <div class="container">
            <div class="card-header my-3">All products</div>
            <div class="row">
                <% 
                    if(!products.isEmpty()) {
                        for (Product p : products) { %>
                            <div class="col-md-3 my-3">
                                <div class="card w-100" style="width: 18rem;">
                                    <img class="card-img-top h-50" src="<%= p.getImage() %>" alt="Card image cap">
                                    <div class="card-body">
                                        <h5 class="card-title"><%= p.getName() %></h5>
                                        <h6 class="price">
                                            Price: <%= p.getPrice() %>
                                        </h6>
                                        <h6 class="category">
                                            Category: <%= p.getDescription()%>
                                        </h6>
                                        <div class="mt-3 d-flex justify-content-between">
                                            <a href="add-to-cart?id=<%= p.getId() %>" class="btn btn-dark">Add to Cart</a>
                                            <a href="#" class="btn btn-primary">Buy Now</a>
                                        </div>
                                    </div>
                                 </div>
                            </div>
                        <%}
                    }
                %>
                
            </div>
        </div>
        
        <%@include file="includes/footer.jsp" %>
    
</html>
