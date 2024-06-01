import control.controller.WebAccountController;
import model.entity.WebAccount;

public class WebAccountControllerTest {

    public static void main(String[] args) {
        WebAccountController webAccountController = new WebAccountController();

        // Añadir una cuenta web
        WebAccount newWebAccount = new WebAccount(
            1, // idCustomer
            "username123", // username
            "password123", // password
            "user@example.com" // email
        );

        webAccountController.addWebAccount(newWebAccount);

        // Mostrar cuenta web por ID de cliente
        webAccountController.displayWebAccountById(1);

        // Actualizar una cuenta web
        newWebAccount.setPassword("newPassword123");
        webAccountController.updateWebAccount(newWebAccount);

        // Eliminar una cuenta web
        webAccountController.deleteWebAccount(1);
    }
}
