package Pharmacy;

import Data.Exceptions.ProductIDException;
import Data.Exceptions.WrongCodeException;
import Data.HealthCardID;
import Data.PatientContr;
import Data.ProductID;
import Pharmacy.Exceptions.DispensingNotAvailableException;
import Data.Exceptions.HealthCardException;
import Pharmacy.Exceptions.NotValideePrescriptionException;
import Pharmacy.Exceptions.SaleClosedException;
import services.HealthCardReader;
import services.NationalHealthService;

import java.math.BigDecimal;
import java.net.ConnectException;

public class DispensingTerminal {

    private Dispensing actualDispensing;
    private Sale sale;
    private NationalHealthService SNS;
    private HealthCardReader HCReader;
    private HealthCardID hcID;

    public DispensingTerminal(){}

    public void getePrescription() throws ConnectException, HealthCardException, NotValideePrescriptionException {
        hcID = HCReader.getHealthcardID();
        actualDispensing = SNS.getePrescription(hcID);
    }
    public void initNewSale(int saleCode) throws DispensingNotAvailableException {
        sale = new Sale(saleCode);
        if(actualDispensing.dispensingEnabled())
            sale.setDispensing(actualDispensing);
    }

    public void enterProduct(ProductID pID) throws SaleClosedException, ConnectException {
        ProductSpecification prodSpec = new ProductSpecification(pID);
        PatientContr patContr = SNS.getPatientContr(hcID);
        sale.addLine(pID, prodSpec.getPrice(), patContr);
        actualDispensing.setProductAsDispensed(pID);
    }

    public void finalizeSale() throws SaleClosedException {
        sale.getAmount();
        sale.setClosed();
        actualDispensing.setCompleted();
    }


    public void setSNS(NationalHealthService SNS){
        this.SNS = SNS;
    }
    public void setHCReader(HealthCardReader HCReader){
        this.HCReader = HCReader;
    }

    public Dispensing getActualDispensing(){
        return actualDispensing;
    }
    public Sale getSale(){
        return sale;
    }


    public void realizePayment(BigDecimal quantity) {}
    public void realizePayment() {}
    public void printNextDispensingSheet() {}
}