package services;

import Data.HealthCardID;
import Data.Interfaces.ProductIDInter;
import Data.PatientContr;
import farmacy.Dispensing;
import farmacy.ProductSpecification;

import java.util.List;

public class NationalHealthServices implements NationalHealthService {
    @Override
    public Dispensing getePrescription(HealthCardID hcID) {
        return null;
    }

    @Override
    public PatientContr getPatientCont(HealthCardID hcID) {
        return null;
    }

    @Override
    public ProductSpecification getProductSpecific(ProductIDInter pID) {
        return null;
    }

    @Override
    public List<Dispensing> updateePrescription(HealthCardID hcID, Dispensing disp) {
        return null;
    }
}
