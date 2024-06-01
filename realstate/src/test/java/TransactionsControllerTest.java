import java.sql.Timestamp;

import control.controller.TransactionsController;
import model.entity.Transactions;

public class TransactionsControllerTest {

    public static void main(String[] args) {
        TransactionsController transactionsController = new TransactionsController();

        // Agregar una transacción
        Transactions newTransaction = new Transactions(
            1000.0,             // amount
            1,                  // clientIdBuyer
            2,                  // clientIdSeller
            50.0,               // commission
            55,                  // enrollmentId
            "Cash",             // paymentMethod
            new Timestamp(System.currentTimeMillis()),  // transactionDate
            true,               // transactionStatus
            1                   // transactionalId
        );

        transactionsController.addTransaction(newTransaction);

        // Mostrar todas las transacciones
        transactionsController.displayAllTransactions();

        // Mostrar transacción por ID
        transactionsController.displayTransactionById(1);

        // Actualizar una transacción
        newTransaction.setAmount(1500.0);
        transactionsController.updateTransaction(newTransaction);

        // Eliminar una transacción
        transactionsController.deleteTransactionById(1);
    }
}