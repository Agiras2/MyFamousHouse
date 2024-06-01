import java.sql.Timestamp;

import control.controller.CustomersController;

public class CustomersControllerTest {

    public static void main(String[] args) {
        CustomersController customersController = new CustomersController();

        // Agregar un cliente
        customersController.addCustomer(
            "123 Main St", // address
            new Timestamp(System.currentTimeMillis()), // birth
            1, // idCustomer
            "Doe", // lastName1
            "Smith", // lastName2
            "John", // name
            1234567890L // phone
        );

        // Mostrar todos los clientes
        customersController.displayAllCustomers();

        // Mostrar cliente por ID
        customersController.displayCustomerById(1);

        // Actualizar un cliente
        customersController.updateCustomer(
            "456 Elm St", // address
            new Timestamp(System.currentTimeMillis()), // birth
            1, // idCustomer
            "Doe", // lastName1
            "Smith", // lastName2
            "John", // name
            3117407232L // phone
        );

        // Eliminar un cliente por ID
        customersController.deleteCustomerById(1);
    }
}