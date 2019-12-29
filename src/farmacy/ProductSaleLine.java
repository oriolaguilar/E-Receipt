package farmacy;

import Data.Interfaces.PatientContrInter;
import Data.Interfaces.ProductIDInter;
import farmacy.Interfaces.ProductSaleLineInter;

import java.math.BigDecimal;

public class ProductSaleLine implements ProductSaleLineInter {

    private ProductIDInter productID;

    private BigDecimal price;

    private PatientContrInter contr;


    public ProductSaleLine(ProductIDInter productID, BigDecimal price, PatientContrInter contr){
        this.productID = productID;
        this.price= price;
        this.contr= contr;
    }
    public ProductSaleLine(ProductIDInter productID){
        this.productID=productID;
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
