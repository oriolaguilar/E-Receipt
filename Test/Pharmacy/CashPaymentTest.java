package Pharmacy;


import Data.Exceptions.ProductIDException;
import Data.Exceptions.WrongCodeException;
import Data.PatientContr;
import Data.ProductID;
import Pharmacy.DoubleTestClasses.SalesHistoryDouble;
import Pharmacy.DoubleTestClasses.WarehouseDouble;
import Pharmacy.Exceptions.InsuficientExistence;
import Pharmacy.Exceptions.QuantityMinorThanImport;
import Pharmacy.Exceptions.SaleClosedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

public class CashPaymentTest {

    CashPayment cashPayment;
    @BeforeEach
    public void setUp() throws ProductIDException, WrongCodeException, SaleClosedException {
        cashPayment = new CashPayment();
        cashPayment.setSalesHistory(new SalesHistoryDouble());
        cashPayment.setWarehouse(new WarehouseDouble());
        Sale sale = new Sale (4);
        sale.addLine(new ProductID("1234567890"),new BigDecimal(5.33), new PatientContr(new BigDecimal(0.87)));
        cashPayment.setSale(sale);
    }

    @Test
    public void realizePaymentTest() throws InsuficientExistence, QuantityMinorThanImport {
        BigDecimal amount = new BigDecimal(123);
        BigDecimal quantity = new BigDecimal(150);

        cashPayment.realizePayment(amount, quantity);
        assertEquals(quantity.subtract(amount), cashPayment.getChange());
    }
}
