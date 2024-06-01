package control.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.controller.PropertyController;

@WebServlet("/DeletePropertyServlet")
public class DeletePropertyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final PropertyController propertyController = new PropertyController();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String enrollmentIdStr = request.getParameter("enrollmentId");
        if (enrollmentIdStr != null) {
            try {
                int enrollmentId = Integer.parseInt(enrollmentIdStr);
                propertyController.deletePropertyByEnrollmentId(enrollmentId);
                
            } catch (NumberFormatException e) {
                request.setAttribute("error", "ID de inscripción inválido.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("resources/error_page.jsp");
                dispatcher.forward(request, response);
            }
        } else {
            request.setAttribute("error", "No se proporcionó ID de inscripción.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("resources/error_page.jsp");
                dispatcher.forward(request, response);
        }

        // Redirigir de nuevo a la lista de propiedades
        request.getRequestDispatcher("/MyProperties").forward(request, response);
    }
}

