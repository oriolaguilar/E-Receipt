package farmacy;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Data.Interfaces.ProductIDInter;
import Data.Interfaces.PatientContrInter;
import farmacy.Exceptions.SaleClosedException;


public class Sale {
    private int saleCode;

    private Date date;

    private BigDecimal amount= new BigDecimal(0);

    private boolean isClosed;

    private static final BigDecimal IVA = new BigDecimal (1.21);

    private List<BigDecimal> prices = new ArrayList<>();

    private ProductSaleLine psl;

    public Sale(int saleCode){
        this.saleCode = saleCode;
        this.date = new Date();
    }

<<<<<<< HEAD
    public void addLine(ProductIDInter productID, BigDecimal price, PatientContrInter contr){
        psl = new ProductSaleLine(productID,price,contr); //No t'he sentit
=======
    public void addLine(ProductIDInter productID, BigDecimal price, PatientContrInter contr) throws SaleClosedException {
        if (isClosed()){
            throw new SaleClosedException("Sale is closed");
        }
        psl = new ProductSaleLine(getSaleCode(),productID,contr);
        psl.setPrice(price);
>>>>>>> ca5c9072749a8bcedca22812530ec5ab452da3d9
        prices.add(price);
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

    public void setClosed() {
        isClosed = true;
    }
    public boolean isClosed() {
        return isClosed;
    }


    public int getSaleCode(){return this.saleCode;}
}
