package Data;

import data.WrongCodeException;

public interface DataTest {

    void initializeObject() throws WrongCodeException;
    void testGetter();
    void testEquals() throws WrongCodeException;
;


}
