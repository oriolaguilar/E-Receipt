package services;

import Data.Interfaces.ProductIDInter;
import farmacy.Dispensing;
import farmacy.ProductSpecification;

import java.util.List;

public interface NationalHealthService {
    Dispensing getePrescription(Data.HealthCardID hcID);
    Data.PatientContr getPatientCont(Data.HealthCardID hcID);
    ProductSpecification getProductSpecific(ProductIDInter pID);
    List<Dispensing> updateePrescription(Data.HealthCardID hcID, Dispensing disp);
}