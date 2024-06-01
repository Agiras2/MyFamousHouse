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
   <title>post property</title>

   <!-- font awesome cdn link  -->
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css">

   <!-- custom css file link  -->
   <link rel="stylesheet" href="css/style.css">

</head>
<body>
   

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


<section class="filters">

<form action="/realstate/postProperty" method="post">
    <h3>Detalles del inmueble</h3>
   
    <div class="flex">
        <div class="box">
            <p>nombre de la propiedad <span>*</span></p>
            <input type="text" name="property_name" required maxlength="50" placeholder="ingrese el nombre de la propiedad" class="input">
        </div>
        <div class="box">
            <p>precio de la propiedad <span>*</span></p>
            <input type="number" name="price" required min="0" max="9999999999" maxlength="10" placeholder="ingrese el precio de la propiedad (pesos colombianos)" class="input">
        </div>
        <div class="box">
            <p>dirección de la propiedad <span>*</span></p>
            <input type="text" name="address" required maxlength="100" placeholder="ingrese una dirección adecuada" class="input">
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
            <p>habitaciones <span>*</span></p>
            <select name="bedroom" required class="input">
            <option value="0">0 habitaciones</option>
            <option value="1" selected>1 habitaciones</option>
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
            <p>baños<span>*</span></p>
            <select name="bathroom" required class="input">
            <option value="0">0 baños</option>
            <option value="1">1 baños</option>
            <option value="2">2 baños</option>
            <option value="3">3 baños</option>
            <option value="4">4 baños</option>
            <option value="5">5 baños</option>
            <option value="6">6 baños</option>
            <option value="7">7 baños</option>
            <option value="8">8 baños</option>
            <option value="9">9 baños</option>
            </select>
        </div>
        <div class="box">
            <p>balcones <span>*</span></p>
            <select name="balcony" required class="input">
            <option value="0">0 balcones</option>
            <option value="1">1 balcones</option>
            <option value="2">2 balcones</option>
            <option value="3">3 balcones</option>
            <option value="4">4 balcones</option>
            <option value="5">5 balcones</option>
            <option value="6">6 balcones</option>
            <option value="7">7 balcones</option>
            <option value="8">8 balcones</option>
            <option value="9">9 balcones</option>
            </select>
        </div>
        <div class="box">
            <p>edad de la propiedad <span>*</span></p>
            <input type="number" name="age" required min="0" max="99" maxlength="2" placeholder="ingrese la edad de la propiedad" class="input">
        </div>
        <div class="box">
            <p>pisos <span>*</span></p>
            <input type="number" name="total_floors" required min="0" max="99" maxlength="2" placeholder="ingrese la cantidad de pisos" class="input">
        </div>
        <div class="box">
            <p>descripción de la propiedad <span>*</span></p>
            <input type="text" name="property_description" required maxlength="1500" placeholder="ingrese una descripción de la propiedad (1500 caracteres)" class="input">
        </div>
        <div class="box">
            <div class="checkbox">
                <div class="box">
                    <p><input type="checkbox" name="lift" value="yes" />Elevador</p>
                    <p><input type="checkbox" name="security_guard" value="yes" />Guardia de seguridad</p>
                    <p><input type="checkbox" name="play_ground" value="yes" />Patio de juegos</p>
                    <p><input type="checkbox" name="garden" value="yes" />Jardín</p>
                    <p><input type="checkbox" name="water_supply" value="yes" />Suministro de agua</p>
                    <p><input type="checkbox" name="power_backup" value="yes" />Respaldo de energía</p>
                </div>
                <div class="box">
                    <p><input type="checkbox" name="parking_area" value="yes" />Parqueadero </p>
                    <p><input type="checkbox" name="gym" value="yes" />Gym</p>
                    <p><input type="checkbox" name="shopping_mall" value="yes" />Mall</p>
                    <p><input type="checkbox" name="hospital" value="yes" />Hospital</p>
                    <p><input type="checkbox" name="school" value="yes" />Escuela</p>
                </div>
            </div>
        </div>
    <input type="submit" value="Matricular Propiedad" class="btn" name="post">
    <a href="../HomeServlet" class="btn">Cancelar</a>
</form>

</section>





<script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>



<!-- custom js file link  -->
<script src="js/script.js"></script>

</body>
</html>