package control.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.controller.PropertyController;
import model.entity.Property;

@WebServlet("/portal")
public class ViewPropertyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private final PropertyController propertyController = new PropertyController();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ViewPropertyServlet - Executing..."); // Mensaje para verificar que el servlet se está ejecutando
        List<Property> properties = propertyController.getAllProperties();
        if(properties != null) {
            System.out.println("ViewPropertyServlet - Number of properties retrieved: " + properties.size()); // Mensaje para verificar el número de propiedades recuperadas
        } else {
            System.out.println("ViewPropertyServlet - No properties retrieved."); // Mensaje si no se recuperan propiedades
        }
        request.setAttribute("properties", properties);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}

