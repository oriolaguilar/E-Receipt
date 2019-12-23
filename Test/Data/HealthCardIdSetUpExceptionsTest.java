package Data;

import data.HealthCardID;
import data.WrongCodeException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class HealthCardIdSetUpExceptionsTest {

    @Test
    public void setUpNull() throws WrongCodeException {
        assertThrows(WrongCodeException.class,
                () -> new HealthCardID(null));
    }

    @Test
    public void setUpWrong() throws WrongCodeException {
        assertThrows(WrongCodeException.class,
                () -> new HealthCardID("456AFGHDFGHJGFG"));
    }


}
