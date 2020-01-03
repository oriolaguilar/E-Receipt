package services;

import Data.HealthCardID;

public class HealthCardReaderImpl implements HealthCardReader {

    private HealthCardID healthCardID;

    public HealthCardReaderImpl(HealthCardID healthCardID){
        this.healthCardID=healthCardID;
    }

    @Override
    public HealthCardID getHealthcardID() {
        return null;
    }
}
