package Pharmacy;

import Data.Exceptions.HealthCardException;
import Data.Exceptions.ProductIDException;
import Data.Exceptions.WrongCodeException;
import Data.HealthCardID;
import Data.PatientContr;
import Data.ProductID;
import Pharmacy.Exceptions.NotValideePrescriptionException;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import services.NationalHealthService;

import java.math.BigDecimal;
import java.net.ConnectException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DispensingTerminalTest {

    private static class SNS implements NationalHealthService{

        @Override
        public Dispensing getePrescription(HealthCardID hcID)
                throws HealthCardException, ConnectException, NotValideePrescriptionException {

            exceptionsThrowing(hcID);
            try {
                byte nOrder = 13;
                List<MedicineDispensingLine> prescrition = new ArrayList<>();
                prescrition.add(new MedicineDispensingLine(new ProductID("1234567890"), "Prendre cada 8 hores"));
                Dispensing dispensing = new Dispensing(nOrder, new Date(), new Date(12341L), prescrition);
                return dispensing;
            }catch (ProductIDException ignore){}

            return null; //Mai arribara aqui ja que el new ProductID estarà implementat correctament
        }

        private void exceptionsThrowing(HealthCardID hcID) throws HealthCardException, NotValideePrescriptionException {
            if (hcID.getPersonalID().endsWith("00000")){
                throw new HealthCardException("No es una tarjeta sanitària vàlida!");
            }else if (hcID.getPersonalID().equals(new HealthCardID("AAAA1234567890"))){
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
            if (pID.getUPC().endsWith("0000")){
                throw new ProductIDException("Aquest producte no es troba en catàleg!");
            }
            return new ProductSpecification(pID, "Diazepam/BAYER/100g", new BigDecimal(5.23));
        }

        @Override
        public List<Dispensing> updateePrescription(HealthCardID hcID, Dispensing disp) throws ConnectException {
            try{
                List<Dispensing> list = new ArrayList<>();
                Dispensing oldDisp = getePrescription(hcID);
                list.add(oldDisp);
                list.add(disp);
                return list;

            }catch (HealthCardException | NotValideePrescriptionException ignored){}
            return null; //Mai arribara aqui ja que el hcID que se'ns passa es correcte
        }



    }
    DispensingTerminal dt;

    @Order(0)
    @Test
    public void first() throws ProductIDException, HealthCardException, ConnectException {
        System.out.println("Pole");
        assertTrue(true);
    }
    @Order(1)
    @Test
    public void second() throws ProductIDException, HealthCardException, ConnectException {
        System.out.println("SubPole");
        assertTrue(true);
    }

    @Order(2)
    @Test
    public void third() throws ProductIDException, HealthCardException, ConnectException {
        System.out.println("Fail");
        assertTrue(true);
    }


}
