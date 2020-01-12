package Pharmacy.DoubleTestClasses;

import Data.Exceptions.HealthCardException;
import Data.Exceptions.ProductIDException;
import Data.HealthCardID;
import Data.PatientContr;
import Data.ProductID;
import Pharmacy.Dispensing;
import Pharmacy.Exceptions.NotValideePrescriptionException;
import Pharmacy.ProductSpecification;
import services.NationalHealthService;

import java.net.ConnectException;
import java.util.List;

public class SNSConnectExGetePresDouble implements NationalHealthService {

    @Override
    public Dispensing getePrescription(HealthCardID hcID) throws HealthCardException, ConnectException, NotValideePrescriptionException {
        throw new ConnectException("Impossible to connect");
    }

    @Override
    public PatientContr getPatientContr(HealthCardID hcID) throws ConnectException {
        return null; //No arribarà mai aquí
    }

    @Override
    public ProductSpecification getProductSpecific(ProductID pID) throws ProductIDException, ConnectException {
        return null; //No arribarà mai aquí
    }

    @Override
    public List<Dispensing> updateePrescription(HealthCardID hcID, Dispensing disp) throws ConnectException {
        return null; //No arribarà mai aquí
    }
}
