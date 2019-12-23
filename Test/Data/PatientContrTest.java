package Data;

import data.PatientContr;
import data.WrongCodeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

public class PatientContrTest implements DataTest {

    PatientContr contribution;
    BigDecimal number = new BigDecimal(0.22);

    @BeforeEach
    @Override
    public void setUp() throws WrongCodeException {
        contribution = new PatientContr(number);
    }

    @Test
    @Override
    public void testGetter() {
        BigDecimal expected = contribution.getContribution();
        assertEquals(expected, number);
    }

    @Test
    @Override
    public void testEquals() throws WrongCodeException {

    }
}
