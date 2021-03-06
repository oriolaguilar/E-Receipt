package Data.ExceptionsTests;

import Data.TestInterfaces.WrongCodeTest;
import Data.PatientContr;
import Data.Exceptions.WrongCodeException;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class PatientContrSetUpExceptionsTest implements WrongCodeTest {

    @Test
    @Override
    public void setUpNull() {
        assertThrows(WrongCodeException.class,
                () -> new PatientContr(null));
    }

    @Test
    @Override
    public void setUpWrong() {
        assertThrows(WrongCodeException.class,
                () -> new PatientContr(new BigDecimal(1.2)));

    }
}
