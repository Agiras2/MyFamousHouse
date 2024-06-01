package control.controller;

import java.sql.SQLException;
import java.util.List;

import control.dao.PropertyDao;
import model.entity.Property;

public class PropertyController {

    private final PropertyDao propertyService = new PropertyDao();

    public void addProperty(Property property) {
        try {
            propertyService.addProperty(property);
            System.out.println("Property added successfully.");
        } catch (SQLException e) {
            System.err.println("Error adding property: " + e.getMessage());
        }
    }

    public void displayAllProperties() {
        try {
            List<Property> properties = propertyService.getAllProperties();
            for (Property property : properties) {
                System.out.println(property);
            }
        } catch (SQLException e) {
            System.err.println("Error fetching properties: " + e.getMessage());
        }
    }

    public void displayPropertiesByIdCustomer(int idCustomer) {
        try {
            List<Property> properties = propertyService.getPropertyByIdCustomer(idCustomer);
            for (Property property : properties) {
                System.out.println(property);
            }
        } catch (SQLException e) {
            System.err.println("Error fetching properties for customer ID " + idCustomer + ": " + e.getMessage());
        }
    }

    public void updateProperty(Property property) {
        try {
            propertyService.updateProperty(property);
            System.out.println("Property updated successfully.");
        } catch (SQLException e) {
            System.err.println("Error updating property: " + e.getMessage());
        }
    }

    public void deletePropertyByIdCustomer(int idCustomer) {
        try {
            propertyService.deletePropertyByIdCustomer(idCustomer);
            System.out.println("Property deleted successfully.");
        } catch (SQLException e) {
            System.err.println("Error deleting property: " + e.getMessage());
        }
    }

    public void deletePropertyByEnrollmentId(int enrollmentId) {
        try {
            propertyService.deletePropertyByEnrollmentId(enrollmentId);
            System.out.println("Property deleted successfully.");
        } catch (SQLException e) {
            System.err.println("Error deleting property: " + e.getMessage());
        }
    }

    public List<Property> getAllProperties() {
        try {
            return propertyService.getAllProperties();
        } catch (SQLException e) {
            System.err.println("Error fetching properties: " + e.getMessage());
            return null;
        }
    }

    public Property getPropertyByEnrollmentId(int enrollmentId) {
        try {
            return propertyService.getPropertyByEnrollmentId(enrollmentId);
        } catch (SQLException e) {
            System.err.println("Error fetching property by enrollment ID: " + e.getMessage());
            return null;
        }
    }

    public List<Property> getPropertiesByCustomerId(int idCustomer) {
        try {
            return propertyService.getPropertyByIdCustomer(idCustomer);
        } catch (SQLException e) {
            System.err.println("Error fetching properties for customer ID " + idCustomer + ": " + e.getMessage());
            return null;
        }
    }

    

    public List<Property> searchProperties(String bedroom, String offer, String type, String bhk, String status, String furnished) {
        try {
            return propertyService.findProperties(bedroom, offer, type, bhk, status, furnished);
        } catch (SQLException e) {
            return null;
        }
    }


    public void updatePropertyCustomerId(int enrollmentId, int newCustomerId) {
        try {
            propertyService.updatePropertyCustomerId(enrollmentId, newCustomerId);
            System.out.println("Property customer ID updated successfully.");
        } catch (SQLException e) {
            System.err.println("Error updating property customer ID: " + e.getMessage());
        }
    }

   
}
