package Pharmacy.DoubleTestClasses;

import Data.Exceptions.HealthCardException;
import Data.HealthCardID;
import services.HealthCardReader;

public class HealthCardReaderHCExceptionDouble implements HealthCardReader {

    @Override
    public HealthCardID getHealthcardID() throws HealthCardException {
        return new HealthCardID("ABCD0000000000");
    }
}
