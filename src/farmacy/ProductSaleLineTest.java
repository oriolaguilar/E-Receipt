package farmacy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import data.ProductID;
import data.PatientContr;

import static org.junit.jupiter.api.Assertions.*;

class ProductSaleLineTest {

    ProductID productID = new ProductID("ABC");
    PatientContr contr = new PatientContr();
    ProductSaleLine psl;
    @BeforeEach
    void setup(){
        psl= new ProductSaleLine(productID);

    }

    @Test
    void setProductID() {

    }

    @Test
    void getProductID() {
    }

    @Test
    void getPrice() {
    }

    @Test
    void setPrice() {
    }

    @Test
    void getContr() {
    }

    @Test
    void setContr() {
    }
}