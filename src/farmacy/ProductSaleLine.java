package farmacy;

import Data.Interfaces.PatientContrInter;
import Data.Interfaces.ProductIDInter;
import farmacy.Interfaces.ProductSaleLineInter;

import java.math.BigDecimal;

public class ProductSaleLine extends Sale {

    private ProductIDInter productID;
    private PatientContrInter contr;
    private BigDecimal price;

    public ProductSaleLine(int saleCode,ProductIDInter productID,PatientContrInter contr) {
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

    public PatientContrInter getContr() {
        return contr;
    }

    public void setContr(PatientContrInter contr) {
        this.contr = contr;
    }
}
