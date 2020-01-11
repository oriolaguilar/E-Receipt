package Pharmacy;

import Data.Exceptions.ProductIDException;
import Data.Exceptions.WrongCodeException;
import Data.HealthCardID;
import Data.PatientContr;
import Data.ProductID;
import Pharmacy.Exceptions.*;
import Data.Exceptions.HealthCardException;
import services.HealthCardReader;
import services.NationalHealthService;
import services.SalesHistory;
import services.Warehouse;

import java.math.BigDecimal;
import java.net.ConnectException;
import java.util.Date;

public class DispensingTerminal {

    private Dispensing actualDispensing;
    private Sale sale;
    private NationalHealthService SNS;
    private HealthCardReader HCReader;
    private HealthCardID hcID;
    private BigDecimal amount;
    private CashPayment cashPayment;

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

    public void enterProduct(ProductID pID) throws SaleClosedException, ConnectException, ProductIDException {
        ProductSpecification prodSpec = SNS.getProductSpecific(pID);
        PatientContr patContr = SNS.getPatientContr(hcID);
        sale.addLine(pID, prodSpec.getPrice(), patContr);
        actualDispensing.setProductAsDispensed(pID);
    }

    public void finalizeSale() throws SaleClosedException {
        amount = sale.getAmount();
        sale.setClosed();
        actualDispensing.setCompleted();
    }

    public void realizePayment(BigDecimal quantity) throws InsuficientExistence, QuantityMinorThanImport, SaleNotClosedException, ConnectException {
        if (!sale.isClosed())
            throw new SaleNotClosedException("La venta encara no ha estat tancada!");

        cashPayment.setSale(sale);
        cashPayment.realizePayment(amount, quantity);
        try {
            SNS.updateePrescription(hcID, SNS.getePrescription(hcID));
        } catch (HealthCardException | NotValideePrescriptionException ignored){}
    }

    public void setWarehouse(Warehouse warehouse){
        cashPayment.setWarehouse(warehouse);
    }
    public void setSalesHistory(SalesHistory salesHistory){
        cashPayment.setSalesHistory(salesHistory);
    }
    public void initCashPayment() {
        cashPayment = new CashPayment();

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
    public BigDecimal getAmount(){
        return amount;
    }
    public CashPayment getCashPayment() {
        return cashPayment;
    }
}