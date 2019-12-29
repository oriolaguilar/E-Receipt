package farmacy;

import Data.Interfaces.PatientContrInter;
import Data.Interfaces.ProductIDInter;
import Data.ProductID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ProductSaleLineTest{

    private ProductIDInter productIDInter;
    private PatientContrInter contr;
    private BigDecimal price;
    private ProductSaleLine psl;

    private static class ProductIDDouble implements ProductIDInter{
        private final String UPC;

        public ProductIDDouble(String UPC){
            this.UPC=UPC;
        }

        public String getUPC(){
            return this.UPC;
        }
    }
    private static class PatientContrDouble implements PatientContrInter{
        private BigDecimal contribution;
        public PatientContrDouble (BigDecimal contr){
            this.contribution=contr;
        }
        @Override
        public BigDecimal getContribution(){
            return contribution;
        }

    }


    @BeforeEach
    void setup(){
        productIDInter = new ProductIDDouble("ABC");
        contr = new PatientContrDouble(new BigDecimal(80));
        price = (new BigDecimal(30));
        psl= new ProductSaleLine(productIDInter, price, contr);

    }

    @Test
    void setPrice() {
        BigDecimal price = new BigDecimal(21);
        psl.setPrice(price);
        assertEquals(price,psl.getPrice());
    }

    @Test
    void getPrice() {
        assertEquals(psl.getPrice(),new BigDecimal(30));
        assertNotEquals(psl.getPrice(),new BigDecimal(35));
    }

    @Test
    void getContr() {
        assertEquals(psl.getContr(),contr);
    }

    @Test
    void setContr() {
        PatientContrInter contr2 = new PatientContrDouble(new BigDecimal(100));
        psl.setContr(contr2);
        assertEquals(psl.getContr(),new BigDecimal(100));
        assertNotEquals(psl.getContr(), new BigDecimal(80));
    }
}