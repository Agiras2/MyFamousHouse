<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
   <meta charset="UTF-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <title>Login</title>

   <!-- font awesome cdn link  -->
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css">

   <!-- custom css file link  -->
   <link rel="stylesheet" href="css/style.css">

</head>
<body>
   
<!-- header section starts  -->

<header class="header">

   <nav class="navbar nav-1">
      <section class="flex">
         <a href="../index.jsp" class="logo"><i class="fas fa-house"></i>MyHome</a>

         <ul>
            <li><a href="post_property.jsp">Matricular Inmueble<i class="fas fa-paper-plane"></i></a></li>
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
                     <li><a href="post_property.jsp">Matricular Inmueble</a></li>
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
                     <li><a href="about.jsp">Acerca de Nosotros</a></li>
                     <li><a href="contact.jsp">Contactanos</a></li>
                     <li><a href="contact.jsp#faq">FAQ</a></li>
                  </ul>
               </li>
            </ul>
         </div>

         <ul>
            <li><a href="#">Cuenta<i class="fas fa-angle-down"></i></a>
               <ul>
                  <li><a href="login.jsp">Ingresar</a></li>
               </ul>
            </li>
         </ul>
      </section>
   </nav>

</header>

<!-- header section ends -->

<!-- login section starts  -->

<section class="form-container">

   <form action="../login" method="post">
      <h3>¡Bienvenido de vuelta!</h3>
      <input type="email" name="email" required maxlength="50" placeholder="Ingrese su email" class="box">
      <input type="password" name="pass" required maxlength="20" placeholder="Ingrese su contraseña" class="box">
      <p>¿Tiene problemas? <a href="contact.jsp#faq">FAQ</a></p>
      <p>¿Necesita asistencia?<a href="contact.jsp">Contactenos</a></p>
      <input type="submit" value="Ingresar ahora" name="submit" class="btn">
   </form>

</section>

<!-- login section ends -->




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
         <a href="../index.jsp"><span>Inicio</span></a>
         <a href="about.jsp"><span>Acerca de Nosotros</span></a>
         <a href="contact.jsp"><span>Contactenos</span></a>
         <a href="listings.jsp"><span>Todas las Propiedades</span></a>
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