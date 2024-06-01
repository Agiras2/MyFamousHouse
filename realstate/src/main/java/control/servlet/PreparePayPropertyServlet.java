package control.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.entity.Property;
import control.controller.PropertyController;

@WebServlet("/PreparePayProperty")
public class PreparePayPropertyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final PropertyController propertyController = new PropertyController();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int enrollmentId = Integer.parseInt(request.getParameter("enrollmentId"));
        Property property;

        property = propertyController.getPropertyByEnrollmentId(enrollmentId);
        request.setAttribute("property", property);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/resources/bank.jsp");
        dispatcher.forward(request, response);
    }
}
