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
import model.entity.Property;

@WebServlet("/listing")
public class ListingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final PropertyController propertyController = new PropertyController();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        // Verifica si hay una sesión activa
        if (session == null || session.getAttribute("userEmail") == null) {
            // No hay sesión activa, redirige al login
            response.sendRedirect("resources/login.jsp");
            return;
        }

        // Hay sesión activa, recupera las propiedades
        List<Property> properties = propertyController.getAllProperties();

        if (properties != null) {
            System.out.println("ListingServlet - Number of properties retrieved: " + properties.size());
        } else {
            System.out.println("ListingServlet - No properties retrieved.");
        }

        // Configura las propiedades como atributo de la solicitud
        request.setAttribute("properties", properties);

        // Reenvía la solicitud a index.jsp
        request.getRequestDispatcher("/resources/listings.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}