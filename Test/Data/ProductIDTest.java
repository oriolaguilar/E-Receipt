package Data;

import Data.TestInterfaces.DataTest;
<<<<<<< HEAD
=======
import Data.ProductID;
>>>>>>> ca5c9072749a8bcedca22812530ec5ab452da3d9
import Data.Exceptions.WrongCodeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductIDTest implements DataTest {

    ProductID productID;

    @BeforeEach
    @Override
    public void setUp() throws WrongCodeException {
        productID = new ProductID("1234567890");
    }

    @Test
    @Override
    public void testGetter() {
        assertEquals("1234567890", productID.getUPC());

    }

    @Test
    @Override
    public void testEquals() throws WrongCodeException {
        ProductID copyProductId = new ProductID("1234567890");
        assertEquals(copyProductId, productID);

    }

    @Test
    @Override
    public void testHash() {
        String code = "1234567890";
        int hashCode = code.hashCode();
        assertEquals(hashCode, productID.hashCode());
    }
}
