package Data.TestInterfaces;

import data.Exceptions.WrongCodeException;

public interface DataTest {

    void setUp() throws WrongCodeException;
    void testGetter();
    void testEquals() throws WrongCodeException;
;


}
