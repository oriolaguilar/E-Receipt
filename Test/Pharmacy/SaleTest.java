package Pharmacy;

import Data.Exceptions.ProductIDException;
import Data.Exceptions.WrongCodeException;
import Data.PatientContr;
import Data.ProductID;
import Pharmacy.Exceptions.SaleClosedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SaleTest {

    private Sale sale;
    private PatientContr contr;
    private ProductID productID;
    private static BigDecimal IVA = new BigDecimal(1.21);

    @BeforeEach
    void setup() throws WrongCodeException, ProductIDException {
        contr = new PatientContr(new BigDecimal(0.5));
        productID = new ProductID("2141582567");
        sale = new Sale(123);
    }

    @Test
    void addLine() throws SaleClosedException {
        BigDecimal price = new BigDecimal(50);
        sale.addLine(productID, price, contr);

        List<ProductSaleLine> listPsl = sale.getPsl();
        ProductSaleLine psl = listPsl.get(listPsl.size()-1);

        assertEquals(price, psl.getPrice());
        assertEquals(contr, psl.getContr());
    }
    @Test
    void getAmountSimple() throws SaleClosedException {
        BigDecimal price = new BigDecimal(50);
        sale.addLine(productID,price,contr);

        assertEquals(price.multiply(IVA).multiply(contr.getContribution()), sale.getAmount());
    }

    @Test
    void getAmountMultiple() throws SaleClosedException {
        BigDecimal price = new BigDecimal(50);
        BigDecimal price1 = new BigDecimal(30);
        BigDecimal price2 = new BigDecimal(40);

        BigDecimal totalprice = price.add(price1).add(price2);

        sale.addLine(productID,price,contr);
        sale.addLine(productID,price1,contr);
        sale.addLine(productID,price2,contr);

        assertEquals(totalprice.multiply(IVA).multiply(contr.getContribution()), sale.getAmount());
    }

    @Test
    void setClosed() {
        sale.setClosed();
        assertEquals(sale.isClosed(),true);
    }

    @Test
    void isClosed() {
        sale.setClosed();
        assertTrue(sale.isClosed());
    }
}