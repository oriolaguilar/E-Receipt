package Pharmacy.DoubleTestClasses;

import Data.Exceptions.HealthCardException;
import Data.HealthCardID;
import services.HealthCardReader;

public class HealthCardReaderNotValideePrescExpetionDouble implements HealthCardReader {

    @Override
    public HealthCardID getHealthcardID() throws HealthCardException {
        return new HealthCardID("AAAA1234567890");
    }
}
