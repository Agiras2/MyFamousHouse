package control.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import control.controller.PropertyController;
import control.controller.WebAccountController;
import model.entity.Property;

@WebServlet("/MyProperties")
public class MyPropertiesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final PropertyController propertyController = new PropertyController();
    private final WebAccountController webAccountController = new WebAccountController();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        // Verifica si hay una sesión activa
        if (session == null || session.getAttribute("userEmail") == null) {
            // No hay sesión activa, redirige al login
            response.sendRedirect("resources/login.jsp");
            return;
        }

        // Obtener el correo electrónico del usuario desde la sesión
        String userEmail = (String) session.getAttribute("userEmail");

        // Obtener el customer_id usando el correo electrónico
        int idCustomer = webAccountController.getCustomerIdByEmail(userEmail);
        if (idCustomer == -1) {
            // Manejar el error adecuadamente
            response.sendRedirect("resources/error_page.jsp");
            return;
        }

        // Recupera las propiedades para el ID_CUSTOMER
        List<Property> properties = propertyController.getPropertiesByCustomerId(idCustomer);

        if (properties != null) {
            System.out.println("MyPropertiesServlet - Number of properties retrieved: " + properties.size());
        } else {
            System.out.println("MyPropertiesServlet - No properties retrieved.");
        }

        // Configura las propiedades como atributo de la solicitud
        request.setAttribute("properties", properties);

        // Reenvía la solicitud a my_properties.jsp
        request.getRequestDispatcher("/resources/my_properties.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
