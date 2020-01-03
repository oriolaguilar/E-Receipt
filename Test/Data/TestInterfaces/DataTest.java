package Data.TestInterfaces;

import Data.Exceptions.WrongCodeException;

public interface DataTest {

    void setUp() throws WrongCodeException;
    void testGetter();
    void testEquals() throws WrongCodeException;
    void testHash();
}
