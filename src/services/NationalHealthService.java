package services;

import Data.Interfaces.ProductIDInter;
import farmacy.Dispensing;
import farmacy.ProductSpecification;
import Data.PatientContr;
import Data.HealthCardID;

import java.util.List;

<<<<<<< HEAD:src/services/NationalHealthService.java
public interface NationalHealthService {
    Dispensing getePrescription(Data.HealthCardID hcID);
    Data.PatientContr getPatientCont(Data.HealthCardID hcID);
    ProductSpecification getProductSpecific(ProductIDInter pID);
    List<Dispensing> updateePrescription(Data.HealthCardID hcID, Dispensing disp);
}
=======
public interface NathionalHealthService {
    Dispensing getePrescription(HealthCardID hcID);
    PatientContr getPatientContr (HealthCardID hcID);
    ProductSpecification getProductSpecific(ProductIDInter pID);
    List<Dispensing> updateePrescription(HealthCardID hcID, Dispensing disp);
}
>>>>>>> ca5c9072749a8bcedca22812530ec5ab452da3d9:src/services/NathionalHealthService.java
