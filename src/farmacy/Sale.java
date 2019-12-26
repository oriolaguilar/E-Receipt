package farmacy;


import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import data.ProductID;
import data.PatientContr;


public class Sale {
    private int saleCode;

    private Date date;

    private BigDecimal amount;

    private boolean isClosed;

    private static final BigDecimal IVA = new BigDecimal (0.21);

    private List<BigDecimal> prices;

    public Sale(int saleCode){
        this.saleCode = saleCode;
        this.date = new Date();
    }

    public void addLine(ProductID productID, BigDecimal price, PatientContr contr){
        ProductSaleLine psl = new ProductSaleLine(productID,price,contr);
        prices.add(price);
    }
    private void calculateAmount(){
        for (int i = 0; i<prices.size();i++){
            amount= amount.add(prices.get(i));
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

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setClosed(boolean closed) {
        isClosed = closed;
    }
    public boolean isClosed() {
        return isClosed;
    }



}
