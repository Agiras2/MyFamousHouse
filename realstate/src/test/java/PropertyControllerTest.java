import control.controller.PropertyController;
import model.entity.Property;

public class PropertyControllerTest {

    public static void main(String[] args) {
        PropertyController propertyController = new PropertyController();

        // Añadir una propiedad
        Property newProperty = new Property(
            2, // balcony
            5000000L, // basePrice
            3, // bathrooms
            4, // bedrooms
            3, // bhk
            1001, // enrollmentId
            5, // floor
            "Furnished", // furnishedStatus
            true, // garden
            true, // gym
            true, // hospital
            1, // idCustomer
            true, // lifts
            "Sale", // offerType
            true, // parkingArea
            true, // playGround
            true, // powerBackUp
            "123 Main St", // propertyAddress
            2, // propertyAge
            "A beautiful house with all amenities.", // propertyDescription
            "Beautiful House", // propertyName
            "Available", // propertyStatus
            "Residential", // propertyType
            true, // school
            true, // securityGuard
            true, // shopingMall
            true // waterSupply
        );

        propertyController.addProperty(newProperty);

        // Mostrar todas las propiedades
        propertyController.displayAllProperties();

        // Mostrar propiedades por ID de cliente
        propertyController.displayPropertiesByIdCustomer(1);

        // Actualizar una propiedad
        newProperty.setPropertyName("Updated Beautiful House");
        propertyController.updateProperty(newProperty);

        // Eliminar una propiedad por ID de cliente
        propertyController.deletePropertyByIdCustomer(1);

        // Eliminar una propiedad por ID de inscripción
        propertyController.deletePropertyByEnrollmentId(1001);
    }
}

