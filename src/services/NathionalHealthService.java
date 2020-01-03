package services;

import Data.Interfaces.ProductIDInter;
import farmacy.Dispensing;
import farmacy.ProductSpecification;
import Data.PatientContr;
import Data.HealthCardID;

import java.util.List;

public interface NathionalHealthService {
    Dispensing getePrescription(HealthCardID hcID);
    PatientContr getPatientContr (HealthCardID hcID);
    ProductSpecification getProductSpecific(ProductIDInter pID);
    List<Dispensing> updateePrescription(HealthCardID hcID, Dispensing disp);
}
