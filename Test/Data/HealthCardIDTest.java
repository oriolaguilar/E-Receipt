package Data;

import Data.Exceptions.HealthCardException;
import Data.TestInterfaces.DataTest;
import Data.HealthCardID;
import Data.Exceptions.WrongCodeException;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HealthCardIDTest implements DataTest {

    HealthCardID healthcard;

    @BeforeEach
    @Override
    public void setUp() throws HealthCardException {
        healthcard = new HealthCardID("ABCD1234567890");
    }

    @Test
    @Override
    public void testGetter() {
        String id = healthcard.getPersonalID();
        assertEquals("ABCD1234567890", id);
    }

    @Test
    @Override
    public void testEquals() throws HealthCardException {
        HealthCardID healthcardCopy = new HealthCardID("ABCD1234567890");
        assertEquals(healthcardCopy, healthcard);

    }

    @Test
    @Override
    public void testHash() {
        String code = "ABCD1234567890";
        int hashCode = code.hashCode();
        assertEquals(hashCode, healthcard.hashCode());
    }
}
