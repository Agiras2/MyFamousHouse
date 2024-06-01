import control.controller.BankAccountsController;
import model.entity.BankAccounts;

public class BankAccountsControllerTest {

    public static void main(String[] args) {
        BankAccountsController bankAccountsController = new BankAccountsController();

        // Añadir una cuenta bancaria
        BankAccounts newBankAccount = new BankAccounts(
            1, // accountID
            1, // idCustomer
            10000L // moneyOnAccount
        );

        bankAccountsController.addBankAccount(newBankAccount);

        // Mostrar todas las cuentas bancarias
        bankAccountsController.displayBankAccountsByCustomerId(1);

        // Mostrar cuenta bancaria por ID
        bankAccountsController.displayBankAccountById(1);

        // Actualizar una cuenta bancaria
        newBankAccount.setMoneyOnAccount(15000L);
        bankAccountsController.updateBankAccount(newBankAccount);

        // Eliminar una cuenta bancaria
        bankAccountsController.deleteBankAccount(1);
    }
}
