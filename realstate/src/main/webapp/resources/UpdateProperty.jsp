<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.entity.Property" %>
<%@ page import="control.controller.PropertyController" %>
<%@ page import="javax.servlet.http.*, javax.servlet.*" %>
<%
    String enrollmentId = request.getParameter("enrollmentId");
    PropertyController propertyController = new PropertyController();
    Property property = propertyController.getPropertyByEnrollmentId(Integer.parseInt(enrollmentId));
    if (property == null) {
        // Redirigir o mostrar un mensaje de error si la propiedad no se encuentra
        response.sendRedirect("error.jsp");
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
   <meta charset="UTF-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <title>Actualizar Propiedad</title>
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css">
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

<section class="filters">
<form action="/realstate/UpdateProperty" method="post">
    <h3>Detalles de la propiedad</h3>
    <input type="hidden" name="enrollmentId" value="<%= property.getEnrollmentId() %>">
    <input type="hidden" name="idCustomer" value="<%= property.getIdCustomer() %>">
    <div class="flex">
        <div class="box">
            <p>nombre de la propiedad <span>*</span></p>
            <input type="text" name="property_name" required maxlength="50" placeholder="ingrese el nombre de la propiedad" class="input" value="<%= property.getPropertyName() %>">
        </div>
        <div class="box">
            <p>precio de la propiedad <span>*</span></p>
            <input type="number" name="base_price" required min="0" max="9999999999" maxlength="10" placeholder="ingrese el precio de la propiedad (pesos colombianos)" class="input" value="<%= property.getBasePrice() %>">
        </div>
        <div class="box">
            <p>dirección de la propiedad <span>*</span></p>
            <input type="text" name="property_address" required maxlength="100" placeholder="ingrese una dirección adecuada" class="input" value="<%= property.getPropertyAddress() %>">
        </div>
        <div class="box">
            <p>tipo de oferta <span>*</span></p>
            <select name="offer_type" required class="input">
                <option value="Venta" <%= "sale".equals(property.getOfferType()) ? "selected" : "" %>>Venta</option>
                <option value="Subasta" <%= "resale".equals(property.getOfferType()) ? "selected" : "" %>>Subasta</option>
            </select>
        </div>
        <div class="box">
            <p>tipo de propiedad <span>*</span></p>
            <select name="property_type" required class="input">
                <option value="Apartamento" <%= "flat".equals(property.getPropertyType()) ? "selected" : "" %>>Apartamento</option>
                <option value="Casa" <%= "house".equals(property.getPropertyType()) ? "selected" : "" %>>Casa</option>
                <option value="Estudio <%= "shop".equals(property.getPropertyType()) ? "selected" : "" %>>Estudio</option>
                <option value="Terreno" <%= "shop".equals(property.getPropertyType()) ? "selected" : "" %>>Terreno</option>
            </select>
        </div>
        <div class="box">
            <p>estado de la propiedad <span>*</span></p>
            <select name="property_status" required class="input">
                <option value="lista para mudanza" <%= "ready to move".equals(property.getPropertyStatus()) ? "selected" : "" %>>lista para mudanza</option>
                <option value="bajo construccion" <%= "under construction".equals(property.getPropertyStatus()) ? "selected" : "" %>>bajo construccion</option>
            </select>
        </div>
        <div class="box">
            <p>muebleria <span>*</span></p>
            <select name="furnished_status" required class="input">
                <option value="Amoblada" <%= "furnished".equals(property.getFurnishedStatus()) ? "selected" : "" %>>Amoblada</option>
                <option value="Semi-amoblada" <%= "semi-furnished".equals(property.getFurnishedStatus()) ? "selected" : "" %>>Semi-amoblada</option>
                <option value="Sin amoblar" <%= "unfurnished".equals(property.getFurnishedStatus()) ? "selected" : "" %>>Sin amoblar</option>
            </select>
        </div>
        <div class="box">
            <p>BHK <span>*</span></p>
            <select name="bhk" required class="input">
                <option value="0" <%= property.getBhk() == 0 ? "selected" : "" %>>0 BHK</option>
                <option value="1" <%= property.getBhk() == 1 ? "selected" : "" %>>1 BHK</option>
                <option value="2" <%= property.getBhk() == 2 ? "selected" : "" %>>2 BHK</option>
                <option value="3" <%= property.getBhk() == 3 ? "selected" : "" %>>3 BHK</option>
                <option value="4" <%= property.getBhk() == 4 ? "selected" : "" %>>4 BHK</option>
                <option value="5" <%= property.getBhk() == 5 ? "selected" : "" %>>5 BHK</option>
                <option value="6" <%= property.getBhk() == 6 ? "selected" : "" %>>6 BHK</option>
                <option value="7" <%= property.getBhk() == 7 ? "selected" : "" %>>7 BHK</option>
                <option value="8" <%= property.getBhk() == 8 ? "selected" : "" %>>8 BHK</option>
                <option value="9" <%= property.getBhk() == 9 ? "selected" : "" %>>9 BHK</option>
            </select>
        </div>
        <div class="box">
            <p>habitaciones<span>*</span></p>
            <input type="number" name="bedrooms" required min="0" max="99" maxlength="2" placeholder="ingrese el número de habitaciones" class="input" value="<%= property.getBedrooms() %>">
        </div>
        <div class="box">
            <p>baños <span>*</span></p>
            <input type="number" name="bathrooms" required min="0" max="99" maxlength="2" placeholder="ingrese el número de baños" class="input" value="<%= property.getBathrooms() %>">
        </div>
        <div class="box">
            <p>balcones <span>*</span></p>
            <input type="number" name="balcony" required min="0" max="99" maxlength="2" placeholder="ingrese el número de balcones" class="input" value="<%= property.getBalcony() %>">
        </div>
        <div class="box">
            <p>edad de la propiedad <span>*</span></p>
            <input type="number" name="property_age" required min="0" max="99" maxlength="2" placeholder="ingrese la edad de la propiedad" class="input" value="<%= property.getPropertyAge() %>">
        </div>
        <div class="box">
            <p>pisos <span>*</span></p>
            <input type="number" name="floor" required min="0" max="99" maxlength="2" placeholder="ingrese la cantidad de pisos" class="input" value="<%= property.getFloor() %>">
        </div>
        <div class="box">
            <p>descripción de la propiedad <span>*</span></p>
            <textarea name="property_description" required maxlength="1000" class="input" cols="30" rows="10"><%= property.getPropertyDescription() %></textarea>
        </div>
    </div>
    <h3>Comodidades</h3>
    <div class="flex">
        <div class="box">
            <p>Elevador <span>*</span></p>
            <select name="lifts" required class="input">
                <option value="true" <%= property.isLifts() ? "selected" : "" %>>Si</option>
                <option value="false" <%= !property.isLifts() ? "selected" : "" %>>No</option>
            </select>
        </div>
        <div class="box">
            <p>Guardia de seguridad <span>*</span></p>
            <select name="securityGuard" required class="input">
                <option value="true" <%= property.isSecurityGuard() ? "selected" : "" %>>Si</option>
                <option value="false" <%= !property.isSecurityGuard() ? "selected" : "" %>>No</option>
            </select>
        </div>
        <div class="box">
            <p>Patio de juegos <span>*</span></p>
            <select name="playGround" required class="input">
                <option value="true" <%= property.isPlayGround() ? "selected" : "" %>>Si</option>
                <option value="false" <%= !property.isPlayGround() ? "selected" : "" %>>No</option>
            </select>
        </div>
        <div class="box">
            <p>Jardín <span>*</span></p>
            <select name="garden" required class="input">
                <option value="true" <%= property.isGarden() ? "selected" : "" %>>Si</option>
                <option value="false" <%= !property.isGarden() ? "selected" : "" %>>No</option>
            </select>
        </div>
        <div class="box">
            <p>Suministro de agua <span>*</span></p>
            <select name="waterSupply" required class="input">
                <option value="true" <%= property.isWaterSupply() ? "selected" : "" %>>Si</option>
                <option value="false" <%= !property.isWaterSupply() ? "selected" : "" %>>No</option>
            </select>
        </div>
        <div class="box">
            <p>Respaldo de energía <span>*</span></p>
            <select name="powerBackUp" required class="input">
                <option value="true" <%= property.isPowerBackUp() ? "selected" : "" %>>Si</option>
                <option value="false" <%= !property.isPowerBackUp() ? "selected" : "" %>>No</option>
            </select>
        </div>
        <div class="box">
            <p>Parqueadero <span>*</span></p>
            <select name="parkingArea" required class="input">
                <option value="true" <%= property.isParkingArea() ? "selected" : "" %>>Si</option>
                <option value="false" <%= !property.isParkingArea() ? "selected" : "" %>>No</option>
            </select>
        </div>
        <div class="box">
            <p>Gym <span>*</span></p>
            <select name="gym" required class="input">
                <option value="true" <%= property.isGym() ? "selected" : "" %>>Si</option>
                <option value="false" <%= !property.isGym() ? "selected" : "" %>>No</option>
            </select>
        </div>
        <div class="box">
            <p>Mall <span>*</span></p>
            <select name="shopingMall" required class="input">
                <option value="true" <%= property.isShopingMall() ? "selected" : "" %>>Si</option>
                <option value="false" <%= !property.isShopingMall() ? "selected" : "" %>>No</option>
            </select>
        </div>
        <div class="box">
            <p>Hospital <span>*</span></p>
            <select name="hospital" required class="input">
                <option value="true" <%= property.isHospital() ? "selected" : "" %>>Si</option>
                <option value="false" <%= !property.isHospital() ? "selected" : "" %>>No</option>
            </select>
        </div>
        <div class="box">
            <p>Escuela <span>*</span></p>
            <select name="school" required class="input">
                <option value="true" <%= property.isSchool() ? "selected" : "" %>>Si</option>
                <option value="false" <%= !property.isSchool() ? "selected" : "" %>>No</option>
            </select>
        </div>
    </div>
    <input type="submit" value="Actualizar Propiedad" name="submit" class="btn">
    <a href="../MyProperties" class="btn">Cancelar</a>
</form>
</section>
<script src="js/script.js"></script>
</body>
</html>


