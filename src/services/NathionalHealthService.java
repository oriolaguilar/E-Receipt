
package services;

import Data.Exceptions.HealthCardException;
import Data.Exceptions.ProductIDException;
import Data.Interfaces.ProductIDInter;
import farmacy.Dispensing;
import farmacy.ProductSpecification;
import Data.PatientContr;
import Data.HealthCardID;

import java.net.ConnectException;
import java.util.List;

public interface NathionalHealthService {
    Dispensing getePrescription(HealthCardID hcID) throws HealthCardException, ConnectException, ProductIDException;
    PatientContr getPatientContr (HealthCardID hcID) throws ConnectException;
    ProductSpecification getProductSpecific(ProductIDInter pID) throws ProductIDException, ConnectException;
    List<Dispensing> updateePrescription(HealthCardID hcID, Dispensing disp) throws ConnectException;
}