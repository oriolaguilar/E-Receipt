package farmacy.Interfaces;

import Data.Interfaces.PatientContrInter;

import java.math.BigDecimal;

public interface ProductSaleLineInter {
    BigDecimal getPrice();
    PatientContrInter getContr();

}
