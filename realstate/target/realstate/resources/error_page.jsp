<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

<!-- about section starts  -->

<section class="about">

   <div class="row">
      <div class="image">
         <img src="resources/images/404.png" alt="">
      </div>
      <div class="content">
         <h3>Lo Sentimos</h3>
         <p>Parece que hubo algun error, lo nvitamos a acercarse a nuestro soporte o a visitar el FAQ.</p>
         <a href="resources/contact.jsp" class="inline-btn">contactenos</a>
      </div>
   </div>

</section>

<!-- about section ends -->

<!-- steps section starts  -->

<section class="steps">

   <h1 class="heading">3 simples pasos</h1>

   <div class="box-container">

      <div class="box">
         <img src="resources/images/step-1.png" alt="">
         <h3>Buscar Propiedad</h3>
         <p>Deleitese con la gran variedad de propiedades que ponenmos a su alcance.</p>
      </div>

      <div class="box">
         <img src="resources/images/step-2.png" alt="">
         <h3>Nuestros agentes</h3>
         <p>ofrecemos un servicio facil e independiente, pero siempre atentos a sus necesidades.</p>
      </div>

      <div class="box">
         <img src="resources/images/step-3.png" alt="">
         <h3>Disfrute</h3>
         <p>Ahora que ha adquirido una nueva propiedad, disfrutela a su antojo.</p>
      </div>

   </div>

</section>

<!-- steps section ends -->





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