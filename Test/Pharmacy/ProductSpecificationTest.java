package Pharmacy;

import Data.Exceptions.ProductIDException;
import Data.ProductID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

public class ProductSpecificationTest {

    ProductSpecification productSpecification;
    ProductID pId;
    BigDecimal price;

    @BeforeEach
    public void setUp() throws ProductIDException {
        pId = new ProductID("1234567890");
        price = new BigDecimal(23.2);
        productSpecification = new ProductSpecification(pId, "Un producte", price);
    }

    @Test
    public void getPriceTest(){
        assertEquals(price, productSpecification.getPrice());
    }
}
