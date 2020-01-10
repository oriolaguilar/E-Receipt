package Pharmacy;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import Data.PatientContr;
import Data.ProductID;
import Pharmacy.Exceptions.SaleClosedException;


public class Sale {
    private int saleCode;

    private Date date;

    private BigDecimal amount= new BigDecimal(0);

    private boolean isClosed;

    private static final BigDecimal IVA = new BigDecimal (1.21);

    private List<BigDecimal> prices = new ArrayList<>();

    private ProductSaleLine psl;

    private Dispensing dispensing; //SET DISPENSINGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGgg

    public Sale(int saleCode){
        this.saleCode = saleCode;
        this.date = new Date();
    }

    public void addLine(ProductID productID, BigDecimal price, PatientContr contr) throws SaleClosedException {
        if (isClosed()){
            throw new SaleClosedException("Sale is closed");
        }
        psl = new ProductSaleLine(getSaleCode(),productID,contr);
        psl.setPrice(price);
        prices.add(price.multiply(contr.getContribution()));
    }
    private void calculateAmount(){
        for (BigDecimal i: prices){
            amount = amount.add(i);
        }
    }

    private void addTaxes() throws SaleClosedException{
        if (isClosed()){
            throw new SaleClosedException("Sale is closed");
        }
        amount = IVA.multiply(amount);
    }

    public BigDecimal getAmount() throws SaleClosedException{
        if (isClosed()){
            throw new SaleClosedException("Sale is closed");
        }
        calculateAmount();
        addTaxes();
        return amount;
    }
    public void setDispensing(Dispensing dispensing){
        this.dispensing = dispensing;
    }
    public Dispensing getDispensing(){
        return dispensing;
    }
    public void setClosed() {
        isClosed = true;
    }
    public boolean isClosed() {
        return isClosed;
    }

    public int getSaleCode(){return this.saleCode;}
    public ProductSaleLine getPsl(){
        return this.psl;
    }
}