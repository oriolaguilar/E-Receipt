package farmacy;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Data.Interfaces.ProductIDInter;
import Data.Interfaces.PatientContrInter;


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

    public void addLine(ProductIDInter productID, BigDecimal price, PatientContrInter contr){
        psl = new ProductSaleLine(productID,price,contr);
        prices.add(price);
    }
    private void calculateAmount(){
        for (BigDecimal i: prices){
            amount = amount.add(i);
        }
    }
    private void addTaxes(){
        amount = IVA.multiply(amount);
    }

    public BigDecimal getAmount() {
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


    public ProductSaleLine getPsl() {
        return psl;
    }
}
