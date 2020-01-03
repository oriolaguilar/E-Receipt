package Data;

import Data.TestInterfaces.WrongCodeTest;
import Data.HealthCardID;
import Data.Exceptions.WrongCodeException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class HealthCardIdSetUpExceptionsTest implements WrongCodeTest {

    @Test
    @Override
    public void setUpNull() {
        assertThrows(WrongCodeException.class,
                () -> new HealthCardID(null));
    }

    @Test
    @Override
    public void setUpWrong() {
        assertThrows(WrongCodeException.class,
                () -> new HealthCardID("456AFGHDFGHJGFG"));
    }


}
