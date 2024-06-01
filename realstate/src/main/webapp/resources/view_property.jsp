<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="javax.servlet.http.*, javax.servlet.*" %>
<%@ page import="model.entity.Property" %>
<%@ page import="model.entity.Customers" %>
<!DOCTYPE html>
<html lang="en">
<head>
   <meta charset="UTF-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <title>View Property</title>

   <!-- font awesome cdn link  -->
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css">

   <!-- custom css file link  -->
   <link rel="stylesheet" href="resources/css/style.css">
</head>

<body>

<header class="header">

    <nav class="navbar nav-1">
       <section class="flex">
          <a href="HomeServlet" class="logo"><i class="fas fa-house"></i>MyHome</a>
 
          <ul>
             <li><a href="resources/post_property.jsp">Matricular Inmueble<i class="fas fa-paper-plane"></i></a></li>
          </ul>
       </section>
    </nav>
 
    <nav class="navbar nav-2">
       <section class="flex">
          <div id="menu-btn" class="fas fa-bars"></div>
 
          <div class="menu">
             <ul>
                <li><a href="#">Comprar<i class="fas fa-angle-down"></i></a>
                   <ul>
                      <li><a href="#">Casa</a></li>
                      <li><a href="#">Apartamento</a></li>
                      <li><a href="#">Estudio</a></li>
                      <li><a href="#">Terreno</a></li>
                   </ul>
                </li>
                <li><a href="#">Vender<i class="fas fa-angle-down"></i></a>
                   <ul>
                      <li><a href="resources/post_property.jsp">Matricular Inmueble</a></li>
                      <li><a href="#">Venta Directa</a></li>
                   </ul>
                </li>
                <li><a href="#">Subastas<i class="fas fa-angle-down"></i></a>
                   <ul>
                      <li><a href="#">Casa</a></li>
                      <li><a href="#">Apartamento</a></li>
                      <li><a href="#">Estudio</a></li>
                      <li><a href="#">Terreno</a></li>
                      <li><a href="#">Subastar Inmueble</a></li>
                   </ul>
                </li>
                <li><a href="#">Tramites<i class="fas fa-angle-down"></i></a>
                   <ul>
                      <li><a href="#">Asiento de Compra Venta</a></li>
                      <li><a href="#">Registro de Venta y Transferencia de Bienes</a></li>
                      <li><a href="#">Inventario de Inmuebles por Usuario, con Trazabilidad Tributaria</a></li>
                      <li><a href="#">Cobro de Multas por Incumplimiento</a></li>
                   </ul>
                </li>
                <li><a href="#">Ayuda<i class="fas fa-angle-down"></i></a>
                   <ul>
                      <li><a href="resources/aboutlog.jsp">Acerca de Nosotros</a></li>
                      <li><a href="resources/contactlog.jsp">Contactanos</a></li>
                      <li><a href="resources/contactlog.jsp#faq">FAQ</a></li>
                   </ul>
                </li>
             </ul>
          </div>
 
          <ul>
            <li><a href="#">Usuario<i class="fas fa-angle-down"></i></a>
                <ul>
                    <li><a href="/realstate/LogoutServlet" class="logout-link">logout</a></li>
                    <li><a href="MyProperties">Mis propiedades</a></li>
                </ul>
            </li>
          </ul>
       </section>
    </nav>
 
</header>

<!-- header section ends -->

<!-- view property section starts  -->
<section class="view-property">
   <div class="details">
      <!-- Código HTML para mostrar imágenes y detalles de la propiedad -->
      <div class="thumb">
         <div class="big-image">
            <img src="resources/images/house-img-1.webp" alt="">
         </div>
         <div class="small-images">
            <img src="resources/images/house-img-1.webp" alt="">
            <img src="resources/images/hall-img-1.webp" alt="">
            <img src="resources/images/kitchen-img-1.webp" alt="">
            <img src="resources/images/bathroom-img-1.webp" alt="">
         </div>
      </div>
      
      <h3 class="name"><%= ((Property) request.getAttribute("property")).getPropertyName() %></h3>
      <p class="location"><i class="fas fa-map-marker-alt"></i><span><%= ((Property) request.getAttribute("property")).getPropertyAddress() %></span></p>
      <div class="info">
         <p><i class="fas fa-tag"></i><span><%= ((Property) request.getAttribute("property")).getBasePrice() %> $</span></p>
         <p><i class="fas fa-user"></i><span><%= ((Customers) request.getAttribute("customers")).getName() %> (<%= ((Customers) request.getAttribute("customers")).getLastName1() %> <%= ((Customers) request.getAttribute("customers")).getLastName2() %>)</span></p>
         <p><i class="fas fa-phone"></i><a href="tel:<%= ((Customers) request.getAttribute("customers")).getPhone() %>"><%= ((Customers) request.getAttribute("customers")).getPhone() %></a></p>
         <p><i class="fas fa-building"></i><span><%= ((Property) request.getAttribute("property")).getPropertyType() %></span></p>
         <p><i class="fas fa-house"></i><span><%= ((Property) request.getAttribute("property")).getOfferType() %></span></p>
         <p><i class="fas fa-calendar"></i><span><%= ((Property) request.getAttribute("property")).getPropertyAge() %> años</span></p>
         <p><i class="fas fa-th-large"></i><span><%= ((Property) request.getAttribute("property")).getPropertyStatus() %></span></p>
         <p><i class="fas fa-couch"></i><span><%= ((Property) request.getAttribute("property")).getFurnishedStatus() %></span></p>
         <p><i class="fas fa-layer-group"></i><span>Pisos: <%= ((Property) request.getAttribute("property")).getFloor() %></span></p>
      </div>
      
      <h3 class="title">Details</h3>
      <div class="flex">
         <div class="box">
            <p><i>BHK :</i><span><%= ((Property) request.getAttribute("property")).getBhk() %> BHK</span></p>
            <p><i>Estado :</i><span><%= ((Property) request.getAttribute("property")).getPropertyStatus() %></span></p>
            <p><i>Habitaciones :</i><span><%= ((Property) request.getAttribute("property")).getBedrooms() %></span></p>
            <p><i>Baños :</i><span><%= ((Property) request.getAttribute("property")).getBathrooms() %></span></p>
            <p><i>Balcones :</i><span><%= ((Property) request.getAttribute("property")).getBalcony() %></span></p>
         </div>
         <div class="box">
            <p><i>Edad :</i><span><%= ((Property) request.getAttribute("property")).getPropertyAge() %> años</span></p>
            <p><i>Descripción :</i><span><%= ((Property) request.getAttribute("property")).getPropertyDescription() %></span></p>
         </div>
      </div>
      
      <h3 class="title">Comodidades</h3>
      <div class="flex">
         <div class="box">
            <% Property property = (Property) request.getAttribute("property"); %>
            <% if (property.isLifts()) { %>
               <p><i class="fas fa-building"></i><span>Elevador</span></p>
            <% } %>
            <% if (property.isSecurityGuard()) { %>
               <p><i class="fas fa-shield-alt"></i><span>Guardia de seguridad</span></p>
            <% } %>
            <% if (property.isPlayGround()) { %>
               <p><i class="fas fa-futbol"></i><span>Patio de juegos</span></p>
            <% } %>
            <% if (property.isGarden()) { %>
               <p><i class="fas fa-seedling"></i><span>Jardín</span></p>
            <% } %>
            <% if (property.isWaterSupply()) { %>
               <p><i class="fas fa-water"></i><span>Suministro de agua</span></p>
            <% } %>
            <% if (property.isPowerBackUp()) { %>
               <p><i class="fas fa-bolt"></i><span>Respaldo de energía</span></p>
            <% } %>
         </div>
         <div class="box">
            <% if (property.isParkingArea()) { %>
               <p><i class="fas fa-parking"></i><span>Parqueadero</span></p>
            <% } %>
            <% if (property.isGym()) { %>
               <p><i class="fas fa-dumbbell"></i><span>Gym</span></p>
            <% } %>
            <% if (property.isShopingMall()) { %>
               <p><i class="fas fa-shopping-cart"></i><span>Mall</span></p>
            <% } %>
            <% if (property.isHospital()) { %>
               <p><i class="fas fa-hospital"></i><span>Hospital</span></p>
            <% } %>
            <% if (property.isSchool()) { %>
               <p><i class="fas fa-school"></i><span>Escuela</span></p>
            <% } %>
         </div>
      </div>
      <a href="PreparePayProperty?enrollmentId=<%= property.getEnrollmentId() %>" class="inline-btn">Comprar</a>
   </div>
</section>

<!-- view property section ends -->

<!-- footer section starts  -->

<footer class="footer">

   <section class="flex">

      <div class="box">
         <a href="tel:1234567890"><i class="fas fa-phone"></i><span>3104895321</span></a>
         <a href="tel:1112223333"><i class="fas fa-phone"></i><span>3117415896</span></a>
         <a href="mailto:shaikhanas@gmail.com"><i class="fas fa-envelope"></i><span>famoushome@gmail.com</span></a>
         <a href="#"><i class="fas fa-map-marker-alt"></i><span>Medellín, Colombia - 500505</span></a>
      </div>

      <div class="box">
         <a href="index.jsp"><span>Inicio</span></a>
         <a href="resources/aboutlog.jsp"><span>Acerca de Nosotros</span></a>
         <a href="resources/contactlog.jsp"><span>Contactenos</span></a>
         <a href="listing"><span>Todas las Propiedades</span></a>
      </div>

      <div class="box">
         <a href="#"><span>facebook</span><i class="fab fa-facebook-f"></i></a>
         <a href="#"><span>twitter</span><i class="fab fa-twitter"></i></a>
         <a href="#"><span>linkedin</span><i class="fab fa-linkedin"></i></a>
         <a href="#"><span>instagram</span><i class="fab fa-instagram"></i></a>

      </div>

   </section>

</footer>

<!-- footer section ends -->


<!-- custom js file link  -->
<script src="js/script.js"></script>

</body>
</html>

