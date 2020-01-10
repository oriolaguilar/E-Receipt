package Data.TestInterfaces;

import Data.Exceptions.HealthCardException;
import Data.Exceptions.ProductIDException;
import Data.Exceptions.WrongCodeException;

public interface DataTest {

    void setUp() throws WrongCodeException, HealthCardException, ProductIDException;
    void testGetter();
    void testEquals() throws WrongCodeException, HealthCardException, ProductIDException;
    void testHash();
}
