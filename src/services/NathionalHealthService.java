package services;

import farmacy.Dispensing;
import farmacy.ProductSpecification;

import java.util.List;

public interface NathionalHealthService {
    Dispensing getePrescription(data.HealthCardID hcID);
    data.PatientContr getPatientCont(data.HealthCardID hcID);
    ProductSpecification getProductSpecific(data.ProductID pID);
    List<Dispensing> updateePrescription(data.HealthCardID hcID, Dispensing disp);
}
