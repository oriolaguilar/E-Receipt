package Data;

import Data.Exceptions.HealthCardException;
import Data.TestInterfaces.WrongCodeTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class HealthCardIdSetUpExceptionsTest implements WrongCodeTest {

    @Test
    @Override
    public void setUpNull() {
        assertThrows(HealthCardException.class,
                () -> new HealthCardID(null));
    }

    @Test
    @Override
    public void setUpWrong() {
        assertThrows(HealthCardException.class,
                () -> new HealthCardID("456AFGHDFGHJGFG"));
    }

}
