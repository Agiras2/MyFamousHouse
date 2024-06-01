<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.entity.Property" %>
<%
    Property property = (Property) request.getAttribute("property");
    if (property == null) {
        throw new ServletException("Property not found in request");
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
   <meta charset="UTF-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <title>About Us</title>

   <!-- font awesome cdn link  -->
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css">

   <!-- custom css file link  -->
   <link rel="stylesheet" href="resources/css/stylebank.css">

</head>
<body>
   <div class="container">
      <div class="image-section">
         <img src="resources/images/meme.jpg" alt="Descripción de la imagen">
      </div>
      <div class="button-section">
         <a href="PayProperty?enrollmentId=<%= property.getEnrollmentId() %>" class="btn">Comprar</a>
         <a href="HomeServlet" class="btn cancel">Cancelar</a>
      </div>
   </div>
</body>
</html>
