
package services;

import Data.Exceptions.HealthCardException;
import Data.Exceptions.ProductIDException;
import Data.ProductID;
import Pharmacy.Dispensing;
import Pharmacy.ProductSpecification;
import Data.PatientContr;
import Data.HealthCardID;

import java.net.ConnectException;
import java.util.List;

public interface NathionalHealthService {
    Dispensing getePrescription(HealthCardID hcID) throws HealthCardException, ConnectException, ProductIDException;
    PatientContr getPatientContr (HealthCardID hcID) throws ConnectException;
    ProductSpecification getProductSpecific(ProductID pID) throws ProductIDException, ConnectException;
    List<Dispensing> updateePrescription(HealthCardID hcID, Dispensing disp) throws ConnectException;
}