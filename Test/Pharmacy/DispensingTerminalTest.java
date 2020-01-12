package Pharmacy;

import Data.Exceptions.HealthCardException;
import Data.Exceptions.ProductIDException;
import Data.Exceptions.WrongCodeException;
import Data.HealthCardID;
import Data.PatientContr;
import Data.ProductID;
import Pharmacy.DoubleTestClasses.HealthCardReaderDouble;
import Pharmacy.DoubleTestClasses.SNSDouble;
import Pharmacy.DoubleTestClasses.SalesHistoryDouble;
import Pharmacy.DoubleTestClasses.WarehouseDouble;
import Pharmacy.Exceptions.*;
import org.junit.jupiter.api.*;
import services.HealthCardReader;
import services.NationalHealthService;
import services.SalesHistory;
import services.Warehouse;

import java.math.BigDecimal;
import java.net.ConnectException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DispensingTerminalTest {

    DispensingTerminal dt;

    @BeforeEach
    public void setUp(){
        dt = new DispensingTerminal();
        dt.setHCReader(new HealthCardReaderDouble());
        dt.setSNS(new SNSDouble());
    }


    @Test
    public void getePrescriptionTest() throws ProductIDException, HealthCardException, ConnectException, NotValideePrescriptionException {
        Dispensing dispensingExpected = createDispensing();

        dt.getePrescription();

        assertEquals(dispensingExpected, dt.getActualDispensing());
    }

    @Test
    public void initNewSaleTest() throws ProductIDException, HealthCardException, ConnectException, NotValideePrescriptionException, DispensingNotAvailableException {
        Dispensing dispensingExpected = createDispensing();

        dt.getePrescription();
        dt.initNewSale(5);

        assertEquals(dispensingExpected, dt.getSale().getDispensing());
    }

    private Dispensing createDispensing() throws ProductIDException {
        byte nOrder = 13;
        List<MedicineDispensingLine> prescrition = new ArrayList<>();
        prescrition.add(new MedicineDispensingLine(new ProductID("1234567890"), "Prendre cada 8 hores"));
        Dispensing dispensingExpected = new Dispensing(nOrder, new Date(), new Date(12341L), prescrition);
        return dispensingExpected;
    }


    @Test
    public void enterProductTest() throws ProductIDException, HealthCardException, ConnectException, NotValideePrescriptionException, DispensingNotAvailableException, SaleClosedException {
        dt.getePrescription();
        dt.initNewSale(5);
        dt.enterProduct(new ProductID("1234567890"));
        List<ProductSaleLine> productSaleLines = dt.getSale().getPsl();

        assertEquals(new ProductID("1234567890"), productSaleLines.get(productSaleLines.size()-1).getProductID());
        assertTrue(dt.getActualDispensing().getIsAcquired(new ProductID("1234567890")));
    }

    @Test
    public void finalizeSaleTest() throws NotValideePrescriptionException, HealthCardException, ConnectException,
            DispensingNotAvailableException, ProductIDException, SaleClosedException {

        dt.getePrescription();
        dt.initNewSale(5);
        dt.enterProduct(new ProductID("1234567890"));
        dt.finalizeSale();

        assertTrue(dt.getSale().isClosed());
        assertTrue(dt.getActualDispensing().getIsCompleted());
    }

    @Test
    void realizePayment()
            throws NotValideePrescriptionException, HealthCardException, ConnectException, DispensingNotAvailableException,
            ProductIDException, SaleClosedException, InsuficientExistence, QuantityMinorThanImport, SaleNotClosedException {

        dt.getePrescription();
        dt.initNewSale(5);
        dt.enterProduct(new ProductID("1234567890"));
        dt.finalizeSale();
        dt.initCashPayment();
        dt.setSalesHistory(new SalesHistoryDouble());
        dt.setWarehouse(new WarehouseDouble());
        dt.realizePayment(new BigDecimal(123.00));

        BigDecimal change = new BigDecimal(123.00).subtract(dt.getAmount());
        assertEquals(change, dt.getCashPayment().getChange());
        assertNull(dt.getActualDispensing());
    }
}
