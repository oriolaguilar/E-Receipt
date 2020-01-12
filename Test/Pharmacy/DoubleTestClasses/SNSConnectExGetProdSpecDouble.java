package Pharmacy.DoubleTestClasses;

import Data.Exceptions.HealthCardException;
import Data.Exceptions.ProductIDException;
import Data.Exceptions.WrongCodeException;
import Data.HealthCardID;
import Data.PatientContr;
import Data.ProductID;
import Pharmacy.Dispensing;
import Pharmacy.Exceptions.NotValideePrescriptionException;
import Pharmacy.MedicineDispensingLine;
import Pharmacy.ProductSpecification;
import services.NationalHealthService;

import java.math.BigDecimal;
import java.net.ConnectException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SNSConnectExGetProdSpecDouble implements NationalHealthService {

    @Override
    public Dispensing getePrescription(HealthCardID hcID)
            throws HealthCardException, ConnectException, NotValideePrescriptionException {

        exceptionsThrowing(hcID);
        try {
            byte nOrder = 13;
            List<MedicineDispensingLine> prescrition = new ArrayList<>();
            prescrition.add(new MedicineDispensingLine(new ProductID("1234567890"), "Prendre cada 8 hores"));
            Dispensing dispensing = new Dispensing(nOrder, new Date(115, 1, 1), new Date(125, 1,1), prescrition);
            return dispensing;
        }catch (ProductIDException ignore){}

        return null; //Mai arribara aqui ja que el new ProductID estarà implementat correctament
    }

    private void exceptionsThrowing(HealthCardID hcID) throws HealthCardException, NotValideePrescriptionException {
        if (hcID.getPersonalID().endsWith("00000")){
            throw new HealthCardException("No es una tarjeta sanitària vàlida!");
        }else if (hcID.equals(new HealthCardID("AAAA1234567890"))){
            throw new NotValideePrescriptionException("Aquesta tarjeta sanitària no té una prescripció vàlida");
        }
    }

    @Override
    public PatientContr getPatientContr(HealthCardID hcID) throws ConnectException {
        try {
            return new PatientContr(new BigDecimal(0.765));
        }catch (WrongCodeException ignored){}

        return null; //Mai arribara aqui ja que el new PatientContr estarà implementat correctament
    }

    @Override
    public ProductSpecification getProductSpecific(ProductID pID) throws ProductIDException, ConnectException {
        throw new ConnectException("Impossible to connect");
    }

    @Override
    public List<Dispensing> updateePrescription(HealthCardID hcID, Dispensing disp) throws ConnectException {
        return null; //Mai arribarà aquí
    }
}
