package control.servlet;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.controller.PropertyController;
import control.controller.WebAccountController;
import model.entity.Property;

@WebServlet("/postProperty")
public class PostPropertyServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final PropertyController propertyController = new PropertyController();
    private final WebAccountController webAccountController = new WebAccountController();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Obtener el correo electrónico del usuario desde la sesión
        String userEmail = (String) request.getSession().getAttribute("userEmail");

        // Obtener el customer_id usando el correo electrónico
        int idCustomer = webAccountController.getCustomerIdByEmail(userEmail);
        if (idCustomer == -1) {
            // Manejar el error adecuadamente
            response.sendRedirect("resources/error_page.jsp");
            return;
        }

        // Obtener parámetros del formulario
        String propertyName = request.getParameter("property_name");
        long basePrice = Long.parseLong(request.getParameter("price"));
        String propertyAddress = request.getParameter("address");
        String offerType = request.getParameter("offer");
        String propertyType = request.getParameter("type");
        String propertyStatus = request.getParameter("status");
        String furnishedStatus = request.getParameter("furnished");
        int bhk = Integer.parseInt(request.getParameter("bhk"));
        int bedrooms = Integer.parseInt(request.getParameter("bedroom"));
        int bathrooms = Integer.parseInt(request.getParameter("bathroom"));
        int balcony = Integer.parseInt(request.getParameter("balcony"));
        int propertyAge = Integer.parseInt(request.getParameter("age"));
        int floor = Integer.parseInt(request.getParameter("total_floors"));
        String propertyDescription = request.getParameter("property_description");

        // Valores de los checkboxes
        boolean lifts = "yes".equals(request.getParameter("lift"));
        boolean securityGuard = "yes".equals(request.getParameter("security_guard"));
        boolean playGround = "yes".equals(request.getParameter("play_ground"));
        boolean garden = "yes".equals(request.getParameter("garden"));
        boolean waterSupply = "yes".equals(request.getParameter("water_supply"));
        boolean powerBackUp = "yes".equals(request.getParameter("power_backup"));
        boolean parkingArea = "yes".equals(request.getParameter("parking_area"));
        boolean gym = "yes".equals(request.getParameter("gym"));
        boolean shoppingMall = "yes".equals(request.getParameter("shopping_mall"));
        boolean hospital = "yes".equals(request.getParameter("hospital"));
        boolean school = "yes".equals(request.getParameter("school"));

        // Generar un número aleatorio de 6 dígitos
        Random random = new Random();
        int enrollmentID = 100000 + random.nextInt(900000); // Genera un número entre 100000 y 999999

        // Crear instancia de Property
        Property property = new Property(balcony, basePrice, bathrooms, bedrooms, bhk, enrollmentID, floor, furnishedStatus,
                garden, gym, hospital, idCustomer, lifts, offerType, parkingArea, playGround, powerBackUp, propertyAddress,
                propertyAge, propertyDescription, propertyName, propertyStatus, propertyType, school, securityGuard, shoppingMall, waterSupply);

        // Agregar propiedad a la base de datos
        propertyController.addProperty(property);

        // Redirigir a una página de confirmación o de nuevo formulario
        response.sendRedirect("MyProperties");
    }
}

