package farmacy;

import Data.Interfaces.ProductIDInter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ProductSpecificationTest {

    private ProductIDInter productIDInter;
    private ProductIDInter productIDInter2;
    private ProductSpecification ps;
    private ProductSpecification ps2;
    

    private static class ProductIDDouble implements ProductIDInter{
        private final String UPC;

        public ProductIDDouble(String UPC){
            this.UPC=UPC;
        }

        public String getUPC(){
            return this.UPC;
        }
    }


    @BeforeEach
    void setup(){
        productIDInter = new ProductIDDouble("ABC");
        productIDInter2 = new ProductIDDouble("123");
        
        ps = new ProductSpecification(productIDInter,"Medicament",new BigDecimal(23));
        ps2 = new ProductSpecification(productIDInter2);

    }
    @Test
    void setDescription() {
        ps2.setDescription("Medicament");
        assertEquals(ps.getDescription(),ps2.getDescription());
    }

    @Test
    void setPrice() {
        ps2.setPrice(new BigDecimal(23));
        assertEquals(ps2.getPrice(),ps.getPrice());
    }

    @Test
    void getDescription() {
        String description = "Medicament";
        assertEquals(description, ps.getDescription());
    }

    @Test
    void getPrice() {
        int price = 23;
        assertEquals(price,ps.getPrice());
    }
}