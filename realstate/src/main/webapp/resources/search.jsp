<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.entity.Property" %>
<%@ page import="java.util.logging.Logger" %>
<!DOCTYPE html>
<html lang="en">
<head>
   <meta charset="UTF-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <title>Search Page</title>

   <!-- font awesome cdn link  -->
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css">

   <!-- custom css file link  -->
   <link rel="stylesheet" href="resources/css/style.css">

</head>
<body>
   
<!-- header section starts  -->

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

<!-- search filter section starts  -->

<section class="filters" style="padding-bottom: 0;">
   <form action="Search" method="get">
      <div id="close-filter"><i class="fas fa-times"></i></div>
      <h3>Filtro de busqueda</h3>      
         <div class="flex">
            <div class="box">
               <p>habitaciones <span>*</span></p>
               <select name="bedroom" required class="input">
                  <option value="0">0 habitaciones</option>
                  <option value="1">1 habitaciones</option>
                  <option value="2">2 habitaciones</option>
                  <option value="3">3 habitaciones</option>
                  <option value="4">4 habitaciones</option>
                  <option value="5">5 habitaciones</option>
                  <option value="6">6 habitaciones</option>
                  <option value="7">7 habitaciones</option>
                  <option value="8">8 habitaciones</option>
                  <option value="9">9 habitaciones</option>
               </select>
            </div>
            <div class="box">
               <p>tipo de oferta <span>*</span></p>
               <select name="offer" required class="input">
               <option value="Venta">Venta</option>
               <option value="Subasta">Subasta</option>
               </select>
           </div>
            <div class="box">
               <p>tipo de propiedad <span>*</span></p>
               <select name="type" required class="input">
               <option value="Apartamento">Apartamento</option>
               <option value="Casa">Casa</option>
               <option value="Estudio">Estudio</option>
               <option value="Terreno">Terreno</option>
               </select>
            </div>
            <div class="box">
               <p>BHK <span>*</span></p>
               <select name="bhk" required class="input">
               <option value="0">0 BHK</option>
               <option value="1">1 BHK</option>
               <option value="2">2 BHK</option>
               <option value="3">3 BHK</option>
               <option value="4">4 BHK</option>
               <option value="5">5 BHK</option>
               <option value="6">6 BHK</option>
               <option value="7">7 BHK</option>
               <option value="8">8 BHK</option>
               <option value="9">9 BHK</option>
               </select>
            </div>
            <div class="box">
               <p>estado de la propiedad <span>*</span></p>
               <select name="status" required class="input">
               <option value="lista para mudanza">lista para mudanza</option>
               <option value="bajo construccion">bajo construccion</option>
               </select>
            </div>
            <div class="box">
               <p>muebleria <span>*</span></p>
               <select name="furnished" required class="input">
               <option value="Amoblada">Amoblada</option>
               <option value="Semi-amoblada">Semi-amoblada</option>
               <option value="Sin amoblar">Sin amoblar</option>
               </select>
           </div>
         </div>
         <input type="submit" value="Buscar Propiedad" name="search" class="btn">
   </form>

</section>

<!-- search filter section ends -->

<div id="filter-btn" class="fas fa-filter"></div>

<!-- listings section starts  -->
<section class="listings">
   <h1 class="heading">Resultados de Busqueda</h1>
   
   <!-- Mensajes de éxito o error -->
   <% String message = (String) request.getAttribute("message"); %>
   <% if (message != null) { %>
       <div class="alert alert-success"><%= message %></div>
   <% } %>
   <% String error = (String) request.getAttribute("error"); %>
   <% if (error != null) { %>
       <div class="alert alert-danger"><%= error %></div>
   <% } %>
   
   <div class="box-container">
       <% 
       Logger logger = Logger.getLogger("ListingsLogger");
       List<Property> properties = (List<Property>) request.getAttribute("properties");
       logger.info("Número de propiedades obtenidas: " + (properties != null ? properties.size() : 0));
       if (properties != null) {
           for (Property property : properties) {
       %>
       <div class="box">
           <!-- Aquí muestra los detalles de cada propiedad -->
           <div class="admin">
               <h3><%= property.getPropertyName().substring(0, 1).toUpperCase() %></h3>
               <div>
                   <p class="name"><%= property.getPropertyName() %></p>
                   <span><%= property.getPropertyAge() %></span>
               </div>
           </div>
           <div class="thumb">
               <p class="total-images"><i class="far fa-image"></i><span>4</span></p>
               <p class="type"><span><%= property.getPropertyType() %></span><span><%= property.getOfferType() %></span></p>
               <form action="" method="post" class="save">
                   <button type="submit" name="save" class="far fa-heart"></button>
               </form>
               <img src="resources/images/house-img-3.jpg" alt="">
           </div>
           <h3 class="name"><%= property.getPropertyDescription() %></h3>
           <p class="location"><i class="fas fa-map-marker-alt"></i><span><%= property.getPropertyAddress() %></span></p>
           <div class="flex">
               <p><i class="fas fa-bed"></i><span><%= property.getBedrooms() %></span></p>
               <p><i class="fas fa-bath"></i><span><%= property.getBathrooms() %></span></p>
               <p><i class="fas fa-maximize"></i><span><%= property.getBedrooms() %> sqft</span></p>
           </div>
           <a href="ViewProperty?enrollmentId=<%= property.getEnrollmentId() %>" class="btn">Ver Propiedad</a>
       </div>
       <% 
           }
       }
       %>
   </div>
</section>
<!-- listings section ends -->



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

<script>

   document.querySelector('#filter-btn').onclick = () =>{
      document.querySelector('.filters').classList.add('active');
   }

   document.querySelector('#close-filter').onclick = () =>{
      document.querySelector('.filters').classList.remove('active');
   }

</script>

</body>
</html>