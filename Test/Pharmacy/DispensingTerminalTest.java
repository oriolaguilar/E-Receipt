package Pharmacy;

import Data.Exceptions.HealthCardException;
import Data.Exceptions.ProductIDException;
import Data.Exceptions.WrongCodeException;
import Data.HealthCardID;
import Data.PatientContr;
import Data.ProductID;
import Pharmacy.Exceptions.*;
import jdk.nashorn.internal.ir.annotations.Ignore;
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

    private static class SNSImpl implements NationalHealthService{

        @Override
        public Dispensing getePrescription(HealthCardID hcID)
                throws HealthCardException, ConnectException, NotValideePrescriptionException {

            exceptionsThrowing(hcID);
            try {
                byte nOrder = 13;
                List<MedicineDispensingLine> prescrition = new ArrayList<>();
                prescrition.add(new MedicineDispensingLine(new ProductID("1234567890"), "Prendre cada 8 hores"));
                Dispensing dispensing = new Dispensing(nOrder, new Date(115, 1, 1), new Date(125, 1,1), prescrition);
                return dispensing;
            }catch (ProductIDException ignore){}

            return null; //Mai arribara aqui ja que el new ProductID estarà implementat correctament
        }

        private void exceptionsThrowing(HealthCardID hcID) throws HealthCardException, NotValideePrescriptionException {
            if (hcID.getPersonalID().endsWith("00000")){
                throw new HealthCardException("No es una tarjeta sanitària vàlida!");
            }else if (hcID.getPersonalID().equals(new HealthCardID("AAAA1234567890"))){
                throw new NotValideePrescriptionException("Aquesta tarjeta sanitària no té una prescripció vàlida");
            }
        }

        @Override
        public PatientContr getPatientContr(HealthCardID hcID) throws ConnectException {
            try {
                return new PatientContr(new BigDecimal(0.765));
            }catch (WrongCodeException ignored){}

            return null; //Mai arribara aqui ja que el new PatientContr estarà implementat correctament
        }

        @Override
        public ProductSpecification getProductSpecific(ProductID pID) throws ProductIDException, ConnectException {
            if (pID.getUPC().endsWith("0000")){
                throw new ProductIDException("Aquest producte no es troba en catàleg!");
            }
            return new ProductSpecification(pID, "Diazepam/BAYER/100g", new BigDecimal(5.23));
        }

        @Override
        public List<Dispensing> updateePrescription(HealthCardID hcID, Dispensing disp) throws ConnectException {
            try{
                List<Dispensing> list = new ArrayList<>();
                Dispensing oldDisp = getePrescription(hcID);
                list.add(oldDisp);
                list.add(disp);
                return list;

            }catch (HealthCardException | NotValideePrescriptionException ignored){}
            return null; //Mai arribara aqui ja que el hcID que se'ns passa es correcte
        }

    }
    private static class HealthCardReaderImpl implements HealthCardReader{

        @Override
        public HealthCardID getHealthcardID() throws HealthCardException {
            return new HealthCardID("ABCD1234567890");
        }
    }
    private static class WarehouseImpl implements Warehouse {
        private List<ProductSaleLine> list = new ArrayList<>();

        @Override
        public void updateStock(List<ProductSaleLine> listofProducts) {
            for (ProductSaleLine i: listofProducts){
                list.add(i);
            }
        }

    }
    private static class SalesHistoryImpl implements SalesHistory {
        public List<Sale> saleList = new ArrayList<>();


        public void registerSale(Sale sale){
            saleList.add(sale);
        }

    }

    DispensingTerminal dt;

    @BeforeEach
    public void setUp(){
        dt = new DispensingTerminal();
        dt.setHCReader(new HealthCardReaderImpl());
        dt.setSNS(new SNSImpl());
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
    public void finalizeSaleTest() throws NotValideePrescriptionException, HealthCardException, ConnectException, DispensingNotAvailableException, ProductIDException, SaleClosedException {
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
        dt.setSalesHistory(new SalesHistoryImpl());
        dt.setWarehouse(new WarehouseImpl());
        dt.realizePayment(new BigDecimal(123.00));

        BigDecimal change = new BigDecimal(123.00).subtract(dt.getAmount());
        assertEquals(change, dt.getCashPayment().getpChange());
    }
}
