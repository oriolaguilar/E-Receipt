package Data;

import data.ProductID;
import data.WrongCodeException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductIDSetUpExceptions implements WrongCodeTest {

    @Test
    @Override
    public void setUpNull(){
        assertThrows(WrongCodeException.class,
                () -> new ProductID(null));
    }

    @Test
    @Override
    public void setUpWrong(){
        assertThrows(WrongCodeException.class,
                () -> new ProductID("123456A890"));
    }
}
