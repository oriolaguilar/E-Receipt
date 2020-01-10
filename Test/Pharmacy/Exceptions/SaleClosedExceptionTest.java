package farmacy.Exceptions;

import farmacy.Sale;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class SaleClosedExceptionTest {
    private Sale sale;
    private PatientContrInter contr;
    private ProductIDInter productID;
    private static BigDecimal IVA = new BigDecimal(1.21);

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
    @BeforeEach
    void setUp() {
        productID = new ProductIDDouble("123");
        contr = new PatientContrDouble(new BigDecimal(23));
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
        assertEquals(sale.getAmount(),price.multiply(IVA));
        sale.setClosed();
        assertThrows(SaleClosedException.class,
                () -> sale.getAmount());
    }



}