package services;

import Data.Interfaces.ProductIDInter;
import farmacy.Dispensing;
import farmacy.ProductSpecification;

import java.util.List;

public interface NathionalHealthService {
    Dispensing getePrescription(data.HealthCardID hcID);
    Data.PatientContr getPatientCont(data.HealthCardID hcID);
    ProductSpecification getProductSpecific(ProductIDInter pID);
    List<Dispensing> updateePrescription(data.HealthCardID hcID, Dispensing disp);
}
