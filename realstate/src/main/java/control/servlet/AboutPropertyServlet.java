package control.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.controller.CustomersController;
import control.controller.PropertyController;
import model.entity.Customers;
import model.entity.Property;

@WebServlet("/ViewProperty")
public class AboutPropertyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final PropertyController propertyController = new PropertyController();
    private final CustomersController customersController = new CustomersController();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int enrollmentId = Integer.parseInt(request.getParameter("enrollmentId"));

        // Obtener datos de la propiedad y del cliente
        Property property = propertyController.getPropertyByEnrollmentId(enrollmentId);
        Customers customers = customersController.getCustomerById(property.getIdCustomer());

        // Pasar datos a la vista (JSP)
        request.setAttribute("property", property);
        request.setAttribute("customers", customers);

        // Redirigir a la vista (JSP) correspondiente
        RequestDispatcher dispatcher = request.getRequestDispatcher("resources/view_property.jsp");
        dispatcher.forward(request, response);
    }
}