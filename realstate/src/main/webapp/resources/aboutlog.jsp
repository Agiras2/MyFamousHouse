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
   <link rel="stylesheet" href="css/style.css">

</head>
<body>
   
<!-- header section starts  -->

<header class="header">

   <nav class="navbar nav-1">
      <section class="flex">
         <a href="../HomeServlet" class="logo"><i class="fas fa-house"></i>MyHome</a>

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
                     <li><a href="aboutlog.jsp">Acerca de Nosotros</a></li>
                     <li><a href="contactlog.jsp">Contactanos</a></li>
                     <li><a href="contactlog.jsp#faq">FAQ</a></li>
                  </ul>
               </li>
            </ul>
         </div>

         <ul>
           <li><a href="#">Usuario<i class="fas fa-angle-down"></i></a>
               <ul>
                   <li><a href="../LogoutServlet" class="logout-link">logout</a></li>
                   <li><a href="../MyProperties">Mis propiedades</a></li>
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
         <img src="images/about-img.svg" alt="">
      </div>
      <div class="content">
         <h3>Puede confiar en nosotros</h3>
         <p>Somos una empresa certificada, tenemos convenio con uno de los bancos mas seguros del mundo y mantenemos la privacidad de los clientes, y a su vez, el control de quien puede trabajar con nosotros.</p>
         <a href="contact.jsp" class="inline-btn">contactenos</a>
      </div>
   </div>

</section>

<!-- about section ends -->

<!-- steps section starts  -->

<section class="steps">

   <h1 class="heading">3 simples pasos</h1>

   <div class="box-container">

      <div class="box">
         <img src="images/step-1.png" alt="">
         <h3>Buscar Propiedad</h3>
         <p>Deleitese con la gran variedad de propiedades que ponenmos a su alcance.</p>
      </div>

      <div class="box">
         <img src="images/step-2.png" alt="">
         <h3>Nuestros agentes</h3>
         <p>ofrecemos un servicio facil e independiente, pero siempre atentos a sus necesidades.</p>
      </div>

      <div class="box">
         <img src="images/step-3.png" alt="">
         <h3>Disfrute</h3>
         <p>Ahora que ha adquirido una nueva propiedad, disfrutela a su antojo.</p>
      </div>

   </div>

</section>

<!-- steps section ends -->

<!-- review section starts  -->

<section class="reviews">

   <h1 class="heading">Opiniones de nuestros clientes</h1>

   <div class="box-container">

      <div class="box">
         <div class="user">
            <img src="images/pic-1.png" alt="">
            <div>
               <h3>Jack Smith</h3>
               <div class="stars">
                  <i class="fas fa-star"></i>
                  <i class="fas fa-star"></i>
                  <i class="fas fa-star"></i>
                  <i class="fas fa-star"></i>
                  <i class="fas fa-star-half-alt"></i>
               </div>
            </div>
         </div>
         <p>Facil y rapido, no tomo mucho tiempo y pude obtener lo que necesitaba en poco tiempo, el servicio fue rapido y confiable, espero volver a utilizarlo prontamente.</p>
      </div>

      <div class="box">
         <div class="user">
            <img src="images/pic-2.png" alt="">
            <div>
               <h3>Lili Jones</h3>
               <div class="stars">
                  <i class="fas fa-star"></i>
                  <i class="fas fa-star"></i>
                  <i class="fas fa-star"></i>
                  <i class="fas fa-star"></i>
                  <i class="fas fa-star-half-alt"></i>
               </div>
            </div>
         </div>
         <p>La propiedad que consegui junto al lago es simplemene encantadora, y fue extremadamente facil llevar los tramites con la ayuda de sus servicios, recomendado.</p>
      </div>

      <div class="box">
         <div class="user">
            <img src="images/pic-3.png" alt="">
            <div>
               <h3>Michael Stevens</h3>
               <div class="stars">
                  <i class="fas fa-star"></i>
                  <i class="fas fa-star"></i>
                  <i class="fas fa-star"></i>
                  <i class="fas fa-star"></i>
                  <i class="fas fa-star-half-alt"></i>
               </div>
            </div>
         </div>
         <p>Soy una persona que debido al trabajo debo de estar moviendome mucho y cambiando de hogar, con su ayuda siempre es muy facil, no ocupa mucho tiempo y es confiable.</p>
      </div>

      <div class="box">
         <div class="user">
            <img src="images/pic-4.png" alt="">
            <div>
               <h3>Carolina Simons</h3>
               <div class="stars">
                  <i class="fas fa-star"></i>
                  <i class="fas fa-star"></i>
                  <i class="fas fa-star"></i>
                  <i class="fas fa-star"></i>
                  <i class="fas fa-star-half-alt"></i>
               </div>
            </div>
         </div>
         <p>La gran variedad de estudios que he podido conseguir gracias a ustedes es increible, he expandido mi empresa enormemente con su ayuda, muchas gracias!</p>
      </div>

      <div class="box">
         <div class="user">
            <img src="images/pic-5.png" alt="">
            <div>
               <h3>Robert Higgins</h3>
               <div class="stars">
                  <i class="fas fa-star"></i>
                  <i class="fas fa-star"></i>
                  <i class="fas fa-star"></i>
                  <i class="fas fa-star"></i>
                  <i class="fas fa-star-half-alt"></i>
               </div>
            </div>
         </div>
         <p>Me encanta poder manejar los tramites de forma tan agil y pertinente, siempre he tenido problemas a la hora de comprar inmuebles, pero ahora eso se acabo.</p>
      </div>

      <div class="box">
         <div class="user">
            <img src="images/pic-6.png" alt="">
            <div>
               <h3>Kim sung wan</h3>
               <div class="stars">
                  <i class="fas fa-star"></i>
                  <i class="fas fa-star"></i>
                  <i class="fas fa-star"></i>
                  <i class="fas fa-star"></i>
                  <i class="fas fa-star-half-alt"></i>
               </div>
            </div>
         </div>
         <p>La facilidad y la practicidad me cautivaron, he comprado ya mas de dos propiedades, no necesito mas, pero simplemente es dificl detenerse cuando se vuelve tan facil.</p>
      </div>

   </div>

</section>

<!-- review section ends -->





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
         <a href="../HomeServlet"><span>Inicio</span></a>
         <a href="aboutlog.jsp"><span>Acerca de Nosotros</span></a>
         <a href="contactlog.jsp"><span>Contactenos</span></a>
         <a href="../listing"><span>Todas las Propiedades</span></a>
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