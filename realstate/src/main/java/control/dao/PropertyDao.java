package control.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.entity.Property;
import model.util.DatabaseUtil;

public class PropertyDao {

    // Método para agregar una nueva propiedad
    public void addProperty(Property property) throws SQLException {
        String sql = "INSERT INTO property (ID_CUSTOMER, ENROLLMENT_ID, PROPERTY_NAME, BASE_PRICE, PROPERTY_ADDRESS, OFFER_TYPE, PROPERTY_TYPE, PROPERTY_STATUS, FURNISHED_STATUS, BHK, BEDROOMS, BATHROOMS, BALCONY, PROPERTY_AGE, FLOOR, PROPERTY_DESCRIPTION, LIFTS, SECURITY_GUARD, PLAY_GROUND, GARDEN, WATER_SUPPLY, POWER_BACKUP, PARKING_AREA, GYM, SHOPING_MALL, HOSPITAL, SCHOOL) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, property.getIdCustomer());
            statement.setInt(2, property.getEnrollmentId());
            statement.setString(3, property.getPropertyName());
            statement.setLong(4, property.getBasePrice());
            statement.setString(5, property.getPropertyAddress());
            statement.setString(6, property.getOfferType());
            statement.setString(7, property.getPropertyType());
            statement.setString(8, property.getPropertyStatus());
            statement.setString(9, property.getFurnishedStatus());
            statement.setInt(10, property.getBhk());
            statement.setInt(11, property.getBedrooms());
            statement.setInt(12, property.getBathrooms());
            statement.setInt(13, property.getBalcony());
            statement.setInt(14, property.getPropertyAge());
            statement.setInt(15, property.getFloor());
            statement.setString(16, property.getPropertyDescription());
            statement.setBoolean(17, property.isLifts());
            statement.setBoolean(18, property.isSecurityGuard());
            statement.setBoolean(19, property.isPlayGround());
            statement.setBoolean(20, property.isGarden());
            statement.setBoolean(21, property.isWaterSupply());
            statement.setBoolean(22, property.isPowerBackUp());
            statement.setBoolean(23, property.isParkingArea());
            statement.setBoolean(24, property.isGym());
            statement.setBoolean(25, property.isShopingMall());
            statement.setBoolean(26, property.isHospital());
            statement.setBoolean(27, property.isSchool());

            statement.executeUpdate();
        }
    }

    public List<Property> getAllProperties() throws SQLException {
        List<Property> propertyList = new ArrayList<>();
        String sql = "SELECT * FROM property";

        try (Connection connection = DatabaseUtil.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                Property property = new Property(
                    resultSet.getInt("BALCONY"),
                    resultSet.getLong("BASE_PRICE"),
                    resultSet.getInt("BATHROOMS"),
                    resultSet.getInt("BEDROOMS"),
                    resultSet.getInt("BHK"),
                    resultSet.getInt("ENROLLMENT_ID"),
                    resultSet.getInt("FLOOR"),
                    resultSet.getString("FURNISHED_STATUS"),
                    resultSet.getBoolean("GARDEN"),
                    resultSet.getBoolean("GYM"),
                    resultSet.getBoolean("HOSPITAL"),
                    resultSet.getInt("ID_CUSTOMER"),
                    resultSet.getBoolean("LIFTS"),
                    resultSet.getString("OFFER_TYPE"),
                    resultSet.getBoolean("PARKING_AREA"),
                    resultSet.getBoolean("PLAY_GROUND"),
                    resultSet.getBoolean("POWER_BACKUP"),
                    resultSet.getString("PROPERTY_ADDRESS"),
                    resultSet.getInt("PROPERTY_AGE"),
                    resultSet.getString("PROPERTY_DESCRIPTION"),
                    resultSet.getString("PROPERTY_NAME"),
                    resultSet.getString("PROPERTY_STATUS"),
                    resultSet.getString("PROPERTY_TYPE"),
                    resultSet.getBoolean("SCHOOL"),
                    resultSet.getBoolean("SECURITY_GUARD"),
                    resultSet.getBoolean("SHOPING_MALL"),
                    resultSet.getBoolean("WATER_SUPPLY")
                );
                propertyList.add(property);
            }
        }

        return propertyList;
    }

    public List<Property> getPropertyByIdCustomer(int idCustomer) throws SQLException {
        List<Property> propertyList = new ArrayList<>();
        String sql = "SELECT * FROM property WHERE ID_CUSTOMER = ?";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, idCustomer);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Property property = new Property(
                    resultSet.getInt("BALCONY"),
                    resultSet.getLong("BASE_PRICE"),
                    resultSet.getInt("BATHROOMS"),
                    resultSet.getInt("BEDROOMS"),
                    resultSet.getInt("BHK"),
                    resultSet.getInt("ENROLLMENT_ID"),
                    resultSet.getInt("FLOOR"),
                    resultSet.getString("FURNISHED_STATUS"),
                    resultSet.getBoolean("GARDEN"),
                    resultSet.getBoolean("GYM"),
                    resultSet.getBoolean("HOSPITAL"),
                    resultSet.getInt("ID_CUSTOMER"),
                    resultSet.getBoolean("LIFTS"),
                    resultSet.getString("OFFER_TYPE"),
                    resultSet.getBoolean("PARKING_AREA"),
                    resultSet.getBoolean("PLAY_GROUND"),
                    resultSet.getBoolean("POWER_BACKUP"),
                    resultSet.getString("PROPERTY_ADDRESS"),
                    resultSet.getInt("PROPERTY_AGE"),
                    resultSet.getString("PROPERTY_DESCRIPTION"),
                    resultSet.getString("PROPERTY_NAME"),
                    resultSet.getString("PROPERTY_STATUS"),
                    resultSet.getString("PROPERTY_TYPE"),
                    resultSet.getBoolean("SCHOOL"),
                    resultSet.getBoolean("SECURITY_GUARD"),
                    resultSet.getBoolean("SHOPING_MALL"),
                    resultSet.getBoolean("WATER_SUPPLY")
                );
                propertyList.add(property);
            }
        }

        return propertyList;
    }

    public void updateProperty(Property property) throws SQLException {
        String sql = "UPDATE property SET PROPERTY_NAME = ?, BASE_PRICE = ?, PROPERTY_ADDRESS = ?, OFFER_TYPE = ?, PROPERTY_TYPE = ?, PROPERTY_STATUS = ?, FURNISHED_STATUS = ?, BHK = ?, BEDROOMS = ?, BATHROOMS = ?, BALCONY = ?, PROPERTY_AGE = ?, FLOOR = ?, PROPERTY_DESCRIPTION = ?, LIFTS = ?, SECURITY_GUARD = ?, PLAY_GROUND = ?, GARDEN = ?, WATER_SUPPLY = ?, POWER_BACKUP = ?, PARKING_AREA = ?, GYM = ?, SHOPING_MALL = ?, HOSPITAL = ?, SCHOOL = ? WHERE ID_CUSTOMER = ? AND ENROLLMENT_ID = ?";
    
        try (Connection connection = DatabaseUtil.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
    
            statement.setString(1, property.getPropertyName());
            statement.setLong(2, property.getBasePrice());
            statement.setString(3, property.getPropertyAddress());
            statement.setString(4, property.getOfferType());
            statement.setString(5, property.getPropertyType());
            statement.setString(6, property.getPropertyStatus());
            statement.setString(7, property.getFurnishedStatus());
            statement.setInt(8, property.getBhk());
            statement.setInt(9, property.getBedrooms());
            statement.setInt(10, property.getBathrooms());
            statement.setInt(11, property.getBalcony());
            statement.setInt(12, property.getPropertyAge());
            statement.setInt(13, property.getFloor());
            statement.setString(14, property.getPropertyDescription());
            statement.setBoolean(15, property.isLifts());
            statement.setBoolean(16, property.isSecurityGuard());
            statement.setBoolean(17, property.isPlayGround());
            statement.setBoolean(18, property.isGarden());
            statement.setBoolean(19, property.isWaterSupply());
            statement.setBoolean(20, property.isPowerBackUp());
            statement.setBoolean(21, property.isParkingArea());
            statement.setBoolean(22, property.isGym());
            statement.setBoolean(23, property.isShopingMall());
            statement.setBoolean(24, property.isHospital());
            statement.setBoolean(25, property.isSchool());
            statement.setInt(26, property.getIdCustomer());
            statement.setInt(27, property.getEnrollmentId());
    
            statement.executeUpdate();
        }
    }


    public void deletePropertyByIdCustomer(int idCustomer) throws SQLException {
        String sql = "DELETE FROM property WHERE ID_CUSTOMER = ?";

        try (Connection connection = DatabaseUtil.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, idCustomer);
            statement.executeUpdate();
        }
    }


    public void deletePropertyByEnrollmentId(int enrollmentId) throws SQLException {
        String sql = "DELETE FROM property WHERE ENROLLMENT_ID = ?";

        try (Connection connection = DatabaseUtil.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, enrollmentId);
            statement.executeUpdate();
        }
    }

    public Property getPropertyByEnrollmentId(int enrollmentId) throws SQLException {
        String sql = "SELECT * FROM property WHERE ENROLLMENT_ID = ?";
        Property property = null;
    
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
    
            statement.setInt(1, enrollmentId);
            ResultSet resultSet = statement.executeQuery();
    
            if (resultSet.next()) {
                property = new Property(
                    resultSet.getInt("BALCONY"),
                    resultSet.getLong("BASE_PRICE"),
                    resultSet.getInt("BATHROOMS"),
                    resultSet.getInt("BEDROOMS"),
                    resultSet.getInt("BHK"),
                    resultSet.getInt("ENROLLMENT_ID"),
                    resultSet.getInt("FLOOR"),
                    resultSet.getString("FURNISHED_STATUS"),
                    resultSet.getBoolean("GARDEN"),
                    resultSet.getBoolean("GYM"),
                    resultSet.getBoolean("HOSPITAL"),
                    resultSet.getInt("ID_CUSTOMER"),
                    resultSet.getBoolean("LIFTS"),
                    resultSet.getString("OFFER_TYPE"),
                    resultSet.getBoolean("PARKING_AREA"),
                    resultSet.getBoolean("PLAY_GROUND"),
                    resultSet.getBoolean("POWER_BACKUP"),
                    resultSet.getString("PROPERTY_ADDRESS"),
                    resultSet.getInt("PROPERTY_AGE"),
                    resultSet.getString("PROPERTY_DESCRIPTION"),
                    resultSet.getString("PROPERTY_NAME"),
                    resultSet.getString("PROPERTY_STATUS"),
                    resultSet.getString("PROPERTY_TYPE"),
                    resultSet.getBoolean("SCHOOL"),
                    resultSet.getBoolean("SECURITY_GUARD"),
                    resultSet.getBoolean("SHOPING_MALL"),
                    resultSet.getBoolean("WATER_SUPPLY")
                );
            }
        }
    
        return property;
    }

    
    public List<Property> findPropertiesByCustomerId(int customerId) {
        List<Property> properties = new ArrayList<>();
        String sql = "SELECT * FROM property WHERE ID_CUSTOMER = ?";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, customerId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Property property = new Property(
                    resultSet.getInt("BALCONY"),
                    resultSet.getLong("BASE_PRICE"),
                    resultSet.getInt("BATHROOMS"),
                    resultSet.getInt("BEDROOMS"),
                    resultSet.getInt("BHK"),
                    resultSet.getInt("ENROLLMENT_ID"),
                    resultSet.getInt("FLOOR"),
                    resultSet.getString("FURNISHED_STATUS"),
                    resultSet.getBoolean("GARDEN"),
                    resultSet.getBoolean("GYM"),
                    resultSet.getBoolean("HOSPITAL"),
                    resultSet.getInt("ID_CUSTOMER"),
                    resultSet.getBoolean("LIFTS"),
                    resultSet.getString("OFFER_TYPE"),
                    resultSet.getBoolean("PARKING_AREA"),
                    resultSet.getBoolean("PLAY_GROUND"),
                    resultSet.getBoolean("POWER_BACKUP"),
                    resultSet.getString("PROPERTY_ADDRESS"),
                    resultSet.getInt("PROPERTY_AGE"),
                    resultSet.getString("PROPERTY_DESCRIPTION"),
                    resultSet.getString("PROPERTY_NAME"),
                    resultSet.getString("PROPERTY_STATUS"),
                    resultSet.getString("PROPERTY_TYPE"),
                    resultSet.getBoolean("SCHOOL"),
                    resultSet.getBoolean("SECURITY_GUARD"),
                    resultSet.getBoolean("SHOPING_MALL"),
                    resultSet.getBoolean("WATER_SUPPLY")
                );
                properties.add(property);
            }
        } catch (Exception e) {
        }

        return properties;
    }

    public List<Property> findProperties(String bedroom, String offer, String type, String bhk, String status, String furnished) throws SQLException {
        List<Property> propertyList = new ArrayList<>();
        String sql = "SELECT * FROM property WHERE BEDROOMS = ? AND OFFER_TYPE = ? AND PROPERTY_TYPE = ? AND BHK = ? AND PROPERTY_STATUS = ? AND FURNISHED_STATUS = ?";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, (bedroom != null && !bedroom.isEmpty()) ? Integer.parseInt(bedroom) : 0);
            statement.setString(2, offer != null ? offer : "");
            statement.setString(3, type != null ? type : "");
            statement.setInt(4, (bhk != null && !bhk.isEmpty()) ? Integer.parseInt(bhk) : 0);
            statement.setString(5, status != null ? status : "");
            statement.setString(6, furnished != null ? furnished : "");

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Property property = new Property(
                        resultSet.getInt("BALCONY"),
                        resultSet.getLong("BASE_PRICE"),
                        resultSet.getInt("BATHROOMS"),
                        resultSet.getInt("BEDROOMS"),
                        resultSet.getInt("BHK"),
                        resultSet.getInt("ENROLLMENT_ID"),
                        resultSet.getInt("FLOOR"),
                        resultSet.getString("FURNISHED_STATUS"),
                        resultSet.getBoolean("GARDEN"),
                        resultSet.getBoolean("GYM"),
                        resultSet.getBoolean("HOSPITAL"),
                        resultSet.getInt("ID_CUSTOMER"),
                        resultSet.getBoolean("LIFTS"),
                        resultSet.getString("OFFER_TYPE"),
                        resultSet.getBoolean("PARKING_AREA"),
                        resultSet.getBoolean("PLAY_GROUND"),
                        resultSet.getBoolean("POWER_BACKUP"),
                        resultSet.getString("PROPERTY_ADDRESS"),
                        resultSet.getInt("PROPERTY_AGE"),
                        resultSet.getString("PROPERTY_DESCRIPTION"),
                        resultSet.getString("PROPERTY_NAME"),
                        resultSet.getString("PROPERTY_STATUS"),
                        resultSet.getString("PROPERTY_TYPE"),
                        resultSet.getBoolean("SCHOOL"),
                        resultSet.getBoolean("SECURITY_GUARD"),
                        resultSet.getBoolean("SHOPING_MALL"),
                        resultSet.getBoolean("WATER_SUPPLY")
                    );
                    propertyList.add(property);
                }
            }
        }

        return propertyList;
    }


    public void updatePropertyCustomerId(int enrollmentId, int newCustomerId) throws SQLException {
        String sql = "UPDATE property SET ID_CUSTOMER = ? WHERE ENROLLMENT_ID = ?";
        
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            
            statement.setInt(1, newCustomerId);
            statement.setInt(2, enrollmentId);
            
            statement.executeUpdate();
        }
    }

    
}

