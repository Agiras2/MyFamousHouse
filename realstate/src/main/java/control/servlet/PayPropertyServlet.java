package control.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Random;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import control.controller.BankAccountsController;
import control.controller.CustomersController;
import control.controller.PropertyController;
import control.controller.TransactionsController;
import control.controller.WebAccountController;
import model.entity.BankAccounts;
import model.entity.Customers;
import model.entity.Property;
import model.entity.Transactions;

@WebServlet("/PayProperty")
public class PayPropertyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final PropertyController propertyController = new PropertyController();
    private final CustomersController customersController = new CustomersController();
    private final BankAccountsController bankAccountsController = new BankAccountsController();
    private final TransactionsController transactionsController = new TransactionsController();
    private static final long STATIC_ACCOUNT_ID = 1234567890;
    private final WebAccountController webAccountController = new WebAccountController();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int enrollmentId = Integer.parseInt(request.getParameter("enrollmentId"));
        HttpSession session = request.getSession();
        String userEmail = (String) session.getAttribute("userEmail");
        System.out.println(userEmail);
        int idCustomer = webAccountController.getCustomerIdByEmail(userEmail);
        System.out.println(idCustomer);

        Property property;
        Customers propertyOwner;
        BankAccounts ownerBankAccount;
        try {
            property = propertyController.getPropertyByEnrollmentId(enrollmentId);
            System.out.println(property);
            propertyOwner = customersController.getCustomerById(property.getIdCustomer());
            System.out.println(propertyOwner.getIdCustomer());
            ownerBankAccount = bankAccountsController.getBankAccountsByCustomerId(propertyOwner.getIdCustomer()).get(0);
            System.out.println(ownerBankAccount);
        } catch (SQLException e) {
            request.setAttribute("errorMessage", "Error al recuperar los datos de la propiedad o del propietario.");
            System.out.println("err1");
            RequestDispatcher dispatcher = request.getRequestDispatcher("resources/error_page.jsp");
            dispatcher.forward(request, response);
            return;
        }

        if (idCustomer == propertyOwner.getIdCustomer()) {
            request.setAttribute("errorMessage", "No se puede continuar porque el cliente y el comprador son el mismo.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("resources/error_page.jsp");
            System.out.println("err2");
            dispatcher.forward(request, response);
            return;
        }

        BankAccounts buyerBankAccount;
        try {
            buyerBankAccount = bankAccountsController.getBankAccountsByCustomerId(idCustomer).get(0);
        } catch (SQLException e) {
            request.setAttribute("errorMessage", "Error al recuperar la cuenta bancaria del comprador.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("resources/error_page.jsp");
            System.out.println("err3");
            dispatcher.forward(request, response);
            return;
        }

        long propertyPrice = property.getBasePrice();
        long commission = propertyPrice * 5 / 100;
        long sellerAmount = propertyPrice - commission;

        if (buyerBankAccount.getMoneyOnAccount() < propertyPrice) {
            response.setContentType("text/html");
            response.getWriter().println("<script>alert('No hay suficiente dinero en la cuenta para realizar la compra.'); window.location.href = 'HomeServlet';</script>");
            return;
        }

        buyerBankAccount.setMoneyOnAccount(buyerBankAccount.getMoneyOnAccount() - propertyPrice);
        BankAccounts staticAccount;
        try {
            staticAccount = bankAccountsController.getBankAccountById(STATIC_ACCOUNT_ID);
            staticAccount.setMoneyOnAccount(staticAccount.getMoneyOnAccount() + commission);
            ownerBankAccount.setMoneyOnAccount(ownerBankAccount.getMoneyOnAccount() + sellerAmount);

            bankAccountsController.updateBankAccount(buyerBankAccount);
            bankAccountsController.updateBankAccount(staticAccount);
            bankAccountsController.updateBankAccount(ownerBankAccount);
        } catch (SQLException e) {
            request.setAttribute("errorMessage", "Error al actualizar las cuentas bancarias.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("resources/error_page.jsp");
            dispatcher.forward(request, response);
            return;
        }

        int transactionalId = new Random().nextInt(90000000) + 10000000; // Genera un número aleatorio de 8 dígitos

        Transactions transaction = new Transactions(propertyPrice, idCustomer, propertyOwner.getIdCustomer(), commission, enrollmentId, "BANK_TRANSFER", new Timestamp(System.currentTimeMillis()), true, transactionalId);
        transactionsController.addTransaction(transaction);

        // Actualizar el ID del cliente de la propiedad con el nuevo ID del comprador
        propertyController.updatePropertyCustomerId(enrollmentId, idCustomer);

        // Recuperar la propiedad actualizada
        Property updatedProperty = propertyController.getPropertyByEnrollmentId(enrollmentId);

        // Establecer la propiedad actualizada en la solicitud
        request.setAttribute("property", updatedProperty);

        // Redirigir a la vista con la propiedad actualizada
        RequestDispatcher dispatcher = request.getRequestDispatcher("MyProperties");
        dispatcher.forward(request, response);
    }
}





