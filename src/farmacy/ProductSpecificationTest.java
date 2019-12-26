package farmacy;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import data.ProductID;

import static org.junit.jupiter.api.Assertions.*;

class ProductSpecificationTest {

    ProductID productID = new ProductID("ABC");
    ProductSpecification ps;
    ProductID productID2 = new ProductID("123");
    ProductSpecification ps2;


    @BeforeEach
    void setup(){
        ps = new ProductSpecification(productID,"Medicament",23);
        ps2 = new ProductSpecification(productID2);

    }
    @Test
    void setDescription() {
        ps2.setDescription("Medicament");
        assertEquals(ps.getDescription(),ps2.getDescription());
    }

    @Test
    void setPrice() {
        ps2.setPrice(23);
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

    @Test
    void getProductSpecific() {
        ProductSpecification ps3 = ps.getProductSpecific(productID);
        assertEquals(ps3.getPrice(),ps.getPrice());
        assertEquals(ps3.getDescription(),ps.getDescription());
    }

}