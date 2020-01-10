package services;

import Data.Exceptions.HealthCardException;
import Data.HealthCardID;

public interface HealthCardReader {
    public HealthCardID getHealthcardID() throws HealthCardException;
}
