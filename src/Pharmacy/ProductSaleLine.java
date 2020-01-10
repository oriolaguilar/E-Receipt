package Pharmacy;

import Data.PatientContr;
import Data.ProductID;

import java.math.BigDecimal;

public class ProductSaleLine extends Sale {

    private ProductID productID;
    private PatientContr contr;
    private BigDecimal price;

    public ProductSaleLine(int saleCode,ProductID productID,PatientContr contr) {
        super(saleCode);
        this.productID=productID;
        this.contr=contr;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public PatientContr getContr() {
        return contr;
    }

    public void setContr(PatientContr contr) {
        this.contr = contr;
    }
}