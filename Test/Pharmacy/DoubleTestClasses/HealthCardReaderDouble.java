package Pharmacy.DoubleTestClasses;

import Data.Exceptions.HealthCardException;
import Data.HealthCardID;
import services.HealthCardReader;

public class HealthCardReaderDouble implements HealthCardReader {

    @Override
    public HealthCardID getHealthcardID() throws HealthCardException {
        return new HealthCardID("ABCD1234567890");
    }
}
