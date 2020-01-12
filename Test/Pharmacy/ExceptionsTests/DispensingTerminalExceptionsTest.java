package Pharmacy.ExceptionsTests;

import Data.Exceptions.HealthCardException;
import Data.Exceptions.ProductIDException;
import Data.ProductID;
import Pharmacy.*;
import Pharmacy.DoubleTestClasses.*;
import Pharmacy.Exceptions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.net.ConnectException;


import static org.junit.jupiter.api.Assertions.*;


public class DispensingTerminalExceptionsTest {

    DispensingTerminal dt;

    @BeforeEach
    public void setUp(){
        dt = new DispensingTerminal();
    }

    @Test
    public void getePrescriptionHCExceptionTest(){
        dt.setSNS(new SNSDouble());
        dt.setHCReader(new HealthCardReaderHCExceptionDouble());

        assertThrows(HealthCardException.class,
                () -> dt.getePrescription());
    }
    @Test
    public void getePrescriptionNotValideTest() {
        dt.setSNS(new SNSDouble());
        dt.setHCReader(new HealthCardReaderNotValideePrescExpetionDouble());

        assertThrows(NotValideePrescriptionException.class,
                () -> dt.getePrescription());
    }

    @Test
    public void getePrescriptionConnectionExceptionTest() {
        dt.setSNS(new SNSConnectExGetePresDouble());
        dt.setHCReader(new HealthCardReaderNotValideePrescExpetionDouble());//****

        assertThrows(ConnectException.class,
                () -> dt.getePrescription());
    }


    @Test
    public void initNewSaleNotAvailable() throws NotValideePrescriptionException, HealthCardException, ConnectException {
        dt.setSNS(new SNSNotAvailableDouble());
        dt.setHCReader(new HealthCardReaderDouble());
        dt.getePrescription();

        assertThrows(DispensingNotAvailableException.class,
                () -> dt.initNewSale(8));
    }
    @Test
    public void enterProductPIDException()
            throws NotValideePrescriptionException, HealthCardException, ConnectException, DispensingNotAvailableException {
        dt.setSNS(new SNSDouble());
        dt.setHCReader(new HealthCardReaderDouble());
        dt.getePrescription();
        dt.initNewSale(8);

        assertThrows(ProductIDException.class,
                () -> dt.enterProduct(new ProductID("0000000000")));
    }

    @Test
    public void enterProductConnectExceptionGetPatContr()
            throws NotValideePrescriptionException, HealthCardException, ConnectException, DispensingNotAvailableException {
        dt.setSNS(new SNSConnectExGetPatContrDouble());
        dt.setHCReader(new HealthCardReaderDouble());
        dt.getePrescription();
        dt.initNewSale(8);

        assertThrows(ConnectException.class,
                () -> dt.enterProduct(new ProductID("1234567890")));
    }

    @Test
    public void enterProductConnectExceptionGetProdSpec()
            throws NotValideePrescriptionException, HealthCardException, ConnectException, DispensingNotAvailableException {
        dt.setSNS(new SNSConnectExGetProdSpecDouble());
        dt.setHCReader(new HealthCardReaderDouble());
        dt.getePrescription();
        dt.initNewSale(8);

        assertThrows(ConnectException.class,
                () -> dt.enterProduct(new ProductID("1234567890")));
    }


    @Test
    public void finalizeSaleSaleisClosedExceptions()
            throws NotValideePrescriptionException, HealthCardException, ConnectException, DispensingNotAvailableException, ProductIDException, SaleClosedException {
        dt.setSNS(new SNSDouble());
        dt.setHCReader(new HealthCardReaderDouble());
        dt.getePrescription();
        dt.initNewSale(8);
        dt.enterProduct(new ProductID("1234567890"));
        dt.finalizeSale();

        assertThrows(SaleClosedException.class,
                () -> dt.enterProduct(new ProductID("1234567891")));
        assertThrows(SaleClosedException.class,
                () -> dt.finalizeSale());
    }

    private void dispensingActions() throws NotValideePrescriptionException, HealthCardException, ConnectException, DispensingNotAvailableException, ProductIDException, SaleClosedException {
        dt.setSNS(new SNSDouble());
        dt.setHCReader(new HealthCardReaderDouble());
        dt.getePrescription();
        dt.initNewSale(8);
        dt.enterProduct(new ProductID("1234567890"));
    }

    @Test
    public void realizePaymentSaleNotClosedException() throws NotValideePrescriptionException, HealthCardException, ConnectException, DispensingNotAvailableException, ProductIDException, SaleClosedException {

        dispensingActions();
        dt.initCashPayment();
        dt.setWarehouse(new WarehouseDouble());
        dt.setSalesHistory(new SalesHistoryDouble());

        assertThrows(SaleNotClosedException.class,
                () -> dt.realizePayment(new BigDecimal(123)));
    }

    @Test
    public void realizePaymentQuantityMinor() throws NotValideePrescriptionException, HealthCardException, ConnectException, DispensingNotAvailableException, ProductIDException, SaleClosedException {

        dispensingActions();
        dt.finalizeSale();
        dt.initCashPayment();
        dt.setWarehouse(new WarehouseDouble());
        dt.setSalesHistory(new SalesHistoryDouble());

        assertThrows(QuantityMinorThanImport.class,
                () -> dt.realizePayment(new BigDecimal(0.23)));
    }

    @Test
    public void realizePaymentInsuficientExistences() throws ConnectException, SaleClosedException, HealthCardException, ProductIDException, NotValideePrescriptionException, DispensingNotAvailableException {
        dispensingActions();
        dt.enterProduct(new ProductID("1234567890"));
        dt.enterProduct(new ProductID("1234567890"));
        dt.enterProduct(new ProductID("1234567890"));
        dt.finalizeSale();
        dt.initCashPayment();
        dt.setWarehouse(new WarehouseDouble());
        dt.setSalesHistory(new SalesHistoryDouble());

        assertThrows(InsuficientExistence.class,
                () -> dt.realizePayment(new BigDecimal(50.23)));

    }
    @Test
    public void realizePaymentConnectException()
            throws NotValideePrescriptionException, HealthCardException, ConnectException, DispensingNotAvailableException, ProductIDException, SaleClosedException {

        dispensingActions();
        dt.setSNS(new SNSConnectExUpdatePrecDouble());
        dt.initCashPayment();
        dt.setWarehouse(new WarehouseDouble());
        dt.setSalesHistory(new SalesHistoryDouble());
        dt.finalizeSale();

        assertThrows(ConnectException.class,
                () -> dt.realizePayment(new BigDecimal(1000.00)));
    }
}
