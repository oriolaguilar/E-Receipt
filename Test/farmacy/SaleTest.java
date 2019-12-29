package farmacy;

import Data.Interfaces.PatientContrInter;
import Data.Interfaces.ProductIDInter;
import farmacy.Interfaces.ProductSaleLineInter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class SaleTest {

    private Sale sale;
    private PatientContrInter contr;
    private ProductIDInter productID;
    private BigDecimal IVA = new BigDecimal(1.21);

    private static class ProductIDDouble implements ProductIDInter {
        private final String UPC;

        public ProductIDDouble(String UPC){
            this.UPC=UPC;
        }

        public String getUPC(){
            return this.UPC;
        }
    }
    private static class PatientContrDouble implements PatientContrInter {
        private BigDecimal contribution;
        public PatientContrDouble (BigDecimal contr){
            this.contribution=contr;
        }
        @Override
        public BigDecimal getContribution(){
            return contribution;
        }

    }
    private static class ProductSaleLineDouble implements ProductSaleLineInter{
        private ProductIDInter productID;

        private BigDecimal price;

        private PatientContrInter contr;

        public ProductSaleLineDouble(ProductIDInter productID, BigDecimal price, PatientContrInter contr){
            this.productID = productID;
            this.price= price;
            this.contr= contr;
        }
        public BigDecimal getPrice(){
            return price;
        }
        public PatientContrInter getContr(){
            return contr;
        }
    }


    @BeforeEach
    void setup(){
        contr = new PatientContrDouble(new BigDecimal(100));
        productID = new ProductIDDouble("ABC");
        sale = new Sale(123);
    }

    @Test
    void addLine() {
        BigDecimal price = new BigDecimal(50);
        sale.addLine(productID,price,contr);
        ProductSaleLineInter psl = sale.getPsl();

        assertEquals(psl.getPrice(),price);
        assertEquals(psl.getContr(),contr);
    }

    @Test
    void getAmountSimple() {
        BigDecimal price = new BigDecimal(50);
        sale.addLine(productID,price,contr);

        assertEquals(sale.getAmount(),price.multiply(IVA));
    }

    @Test
    void getAmountMultiple() {
        BigDecimal price = new BigDecimal(50);
        BigDecimal price1 = new BigDecimal(30);
        BigDecimal price2 = new BigDecimal(40);

        BigDecimal totalprice = price.add(price1).add(price2);

        sale.addLine(productID,price,contr);
        sale.addLine(productID,price1,contr);
        sale.addLine(productID,price2,contr);

        assertEquals(sale.getAmount(),totalprice.multiply(IVA));
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