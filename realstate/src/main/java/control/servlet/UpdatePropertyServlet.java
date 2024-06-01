package control.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.entity.Property;
import control.controller.PropertyController;

@WebServlet("/UpdateProperty")
public class UpdatePropertyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final PropertyController propertyController = new PropertyController();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int enrollmentId = Integer.parseInt(request.getParameter("enrollmentId"));
        int idCustomer = Integer.parseInt(request.getParameter("idCustomer"));
        String propertyName = request.getParameter("property_name");
        long basePrice = Long.parseLong(request.getParameter("base_price"));
        String address = request.getParameter("property_address");
        String offerType = request.getParameter("offer_type");
        String propertyType = request.getParameter("property_type");
        String propertyStatus = request.getParameter("property_status");
        String furnishedStatus = request.getParameter("furnished_status");
        int bhk = Integer.parseInt(request.getParameter("bhk"));
        int bedrooms = Integer.parseInt(request.getParameter("bedrooms"));
        int bathrooms = Integer.parseInt(request.getParameter("bathrooms"));
        int balcony = Integer.parseInt(request.getParameter("balcony"));
        int age = Integer.parseInt(request.getParameter("property_age"));
        int floor = Integer.parseInt(request.getParameter("floor"));
        String description = request.getParameter("property_description");
        boolean lifts = Boolean.parseBoolean(request.getParameter("lifts"));
        boolean securityGuard = Boolean.parseBoolean(request.getParameter("securityGuard"));
        boolean playGround = Boolean.parseBoolean(request.getParameter("playGround"));
        boolean garden = Boolean.parseBoolean(request.getParameter("garden"));
        boolean waterSupply = Boolean.parseBoolean(request.getParameter("waterSupply"));
        boolean powerBackUp = Boolean.parseBoolean(request.getParameter("powerBackUp"));
        boolean parkingArea = Boolean.parseBoolean(request.getParameter("parkingArea"));
        boolean gym = Boolean.parseBoolean(request.getParameter("gym"));
        boolean shopingMall = Boolean.parseBoolean(request.getParameter("shopingMall"));
        boolean hospital = Boolean.parseBoolean(request.getParameter("hospital"));
        boolean school = Boolean.parseBoolean(request.getParameter("school"));

        Property property = new Property(
            balcony, basePrice, bathrooms, bedrooms, bhk, enrollmentId, floor, furnishedStatus, 
            garden, gym, hospital, idCustomer, lifts, offerType, parkingArea, playGround, 
            powerBackUp, address, age, description, propertyName, propertyStatus, propertyType, 
            school, securityGuard, shopingMall, waterSupply
        );

        propertyController.updateProperty(property);

        response.sendRedirect("MyProperties");
    }
}

