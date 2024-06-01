package control.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import control.controller.WebAccountController;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private final WebAccountController webAccountController = new WebAccountController();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("pass");

        // Verificar si el usuario existe en la base de datos usando el correo electrónico
        boolean userExists = webAccountController.verifyUser(email, password);
        if (userExists) {
            // El usuario existe, crear una sesión y redirigir a la página principal
            HttpSession session = request.getSession();
            session.setAttribute("userEmail", email);
            session.setMaxInactiveInterval(1200); // 20 minutos de inactividad
            response.sendRedirect("HomeServlet");
        } else {
            // El usuario no existe o las credenciales son incorrectas, redirigir de vuelta a la página de inicio de sesión
            response.sendRedirect("resources/login.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Aquí se pueden manejar las solicitudes GET, si es necesario
        response.sendRedirect("../listing");
    }
}


