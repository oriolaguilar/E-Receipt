package Pharmacy.ExceptionsTests;

import Data.Exceptions.ProductIDException;
import Data.Exceptions.WrongCodeException;
import Data.PatientContr;
import Data.ProductID;
import Pharmacy.CashPayment;
import Pharmacy.DoubleTestClasses.SalesHistoryDouble;
import Pharmacy.DoubleTestClasses.WarehouseDouble;
import Pharmacy.Exceptions.InsuficientExistence;
import Pharmacy.Exceptions.QuantityMinorThanImport;
import Pharmacy.Exceptions.SaleClosedException;
import Pharmacy.Sale;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

public class CashPaymentExceptionsTest {

    CashPayment cashPayment;

    @Test
    public void cashPaymentQuantityMinorThanImportException() throws ProductIDException, WrongCodeException, SaleClosedException {
        cashPayment = new CashPayment();
        cashPayment.setSalesHistory(new SalesHistoryDouble());
        cashPayment.setWarehouse(new WarehouseDouble());
        Sale sale = new Sale (4);
        sale.addLine(new ProductID("1234567890"),new BigDecimal(5.33), new PatientContr(new BigDecimal(0.87)));
        cashPayment.setSale(sale);

        assertThrows(QuantityMinorThanImport.class,
                () -> cashPayment.realizePayment(new BigDecimal(3), new BigDecimal(2)));
    }

    @Test
    public void cashPaymentInsuficentExistences() throws ProductIDException, WrongCodeException, SaleClosedException {
        cashPayment = new CashPayment();
        cashPayment.setSalesHistory(new SalesHistoryDouble());
        cashPayment.setWarehouse(new WarehouseDouble());
        Sale sale = new Sale (4);
        sale.addLine(new ProductID("1234567890"),new BigDecimal(5), new PatientContr(new BigDecimal(0.87)));
        sale.addLine(new ProductID("1234567890"),new BigDecimal(5), new PatientContr(new BigDecimal(0.87)));
        sale.addLine(new ProductID("1234567890"),new BigDecimal(5), new PatientContr(new BigDecimal(0.87)));
        sale.addLine(new ProductID("1234567890"),new BigDecimal(5), new PatientContr(new BigDecimal(0.87)));

        cashPayment.setSale(sale);

        assertThrows(InsuficientExistence.class,
                () -> cashPayment.realizePayment(new BigDecimal(20), new BigDecimal(30)));
    }




}
