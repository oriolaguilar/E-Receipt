package Pharmacy;

import Data.Exceptions.ProductIDException;
import Data.Exceptions.WrongCodeException;
import Data.PatientContr;
import Data.ProductID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ProductSaleLineTest{

    private ProductID productID;
    private PatientContr contr;
    private BigDecimal price;
    private ProductSaleLine psl;
    private Sale sale;


    @BeforeEach
    void setup() throws WrongCodeException, ProductIDException {
        sale = new Sale (100);
        productID = new ProductID("1236563595");
        contr = new PatientContr(new BigDecimal(0.7));
        price = (new BigDecimal(30));
        psl= new ProductSaleLine(sale.getSaleCode(),productID,contr);
    }

    @Test
    void setPrice() {
        BigDecimal price = new BigDecimal(21);
        psl.setPrice(price);
        assertEquals(price,psl.getPrice());
    }

    @Test
    void getPrice() {
        BigDecimal price = new BigDecimal(21);
        psl.setPrice(price);
        assertEquals(psl.getPrice(),new BigDecimal(21));
        assertNotEquals(psl.getPrice(),new BigDecimal(35));
    }

    @Test
    void getContr() {
        assertEquals(psl.getContr(),contr);
    }

    @Test
    void setContr() throws WrongCodeException {
        PatientContr contr2 = new PatientContr(new BigDecimal(0.6));
        psl.setContr(contr2);
        assertEquals(psl.getContr().getContribution(),new BigDecimal(0.6));
        assertNotEquals(psl.getContr(), new BigDecimal(80));
    }
}