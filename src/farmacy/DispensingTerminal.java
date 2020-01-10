package farmacy;

import Data.Exceptions.ProductIDException;
import Data.HealthCardID;
import Data.PatientContr;
import Data.ProductID;
import farmacy.Exceptions.DispensingNotAvailableException;
import Data.Exceptions.HealthCardException;
import farmacy.Exceptions.SaleClosedException;
import services.HealthCardReader;
import services.NathionalHealthService;

import java.math.BigDecimal;
import java.net.ConnectException;

public class DispensingTerminal {

    private Dispensing actualDispensing;
    private Sale sale;
    private NathionalHealthService SNS;
    private HealthCardReader HCReader;
    private HealthCardID hcID;


    public void getePrescription() throws ConnectException, HealthCardException, ProductIDException {
        hcID = HCReader.getHealthcardID();
        actualDispensing = SNS.getePrescription(hcID);
    }
    public void initNewSale(int saleCode) throws DispensingNotAvailableException {
        sale = new Sale(saleCode);
        actualDispensing.dispensingEnabled();
        actualDispensing = sale.getDispensing();
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
    public void realizePayment(BigDecimal quantity) {}
    public void realizePayment() {}
    public void printNextDispensingSheet() {}
}