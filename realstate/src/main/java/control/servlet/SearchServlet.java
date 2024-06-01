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

@WebServlet("/Search")
public class SearchServlet extends HttpServlet {
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

        // Recupera los parámetros de búsqueda y maneja valores nulos
        String bedroom = request.getParameter("bedroom");
        String offer = request.getParameter("offer");
        String type = request.getParameter("type");
        String bhk = request.getParameter("bhk");
        String status = request.getParameter("status");
        String furnished = request.getParameter("furnished");

        // Realiza la búsqueda de propiedades según los parámetros
        List<Property> properties = propertyController.searchProperties(
            bedroom != null ? bedroom : "0", 
            offer != null ? offer : "", 
            type != null ? type : "", 
            bhk != null ? bhk : "0", 
            status != null ? status : "", 
            furnished != null ? furnished : ""
        );

        // Configura las propiedades como atributo de la solicitud
        request.setAttribute("properties", properties);

        // Reenvía la solicitud a search.jsp
        request.getRequestDispatcher("/resources/search.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

