package Pharmacy.ExceptionsTests;

import Data.Exceptions.ProductIDException;
import Data.Exceptions.WrongCodeException;
import Data.PatientContr;
import Data.ProductID;
import Pharmacy.Exceptions.SaleClosedException;
import Pharmacy.Sale;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class SaleClosedExceptionTest {
    private Sale sale;
    private PatientContr contr;
    private ProductID productID;
    private static BigDecimal IVA = new BigDecimal(1.21);


    @BeforeEach
    void setUp() throws WrongCodeException, ProductIDException {
        productID = new ProductID("5845489555");
        contr = new PatientContr(new BigDecimal(0.3));
        sale = new Sale(500);
    }

    @Test
    void addLineClosed(){
        BigDecimal price = new BigDecimal(10);
        sale.setClosed();
        assertThrows(SaleClosedException.class,
                () -> sale.addLine(productID,price,contr));
    }

    @Test
    void getAmountClosed() throws SaleClosedException {
        BigDecimal price = new BigDecimal(10);
        sale.addLine(productID,price,contr);
        assertEquals(sale.getAmount(),price.multiply(IVA).multiply(contr.getContribution()));
        sale.setClosed();
        assertThrows(SaleClosedException.class,
                () -> sale.getAmount());
    }



}