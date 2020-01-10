package farmacy;

import Data.Interfaces.ProductIDInter;

public class MedicineDispensingLine {

    private ProductIDInter medicine;
    private boolean isAcquired;
    private String description;

    public MedicineDispensingLine(ProductIDInter medicine, String descrition){
        this.medicine = medicine;
        this.description = descrition;
        isAcquired = false;
    }

    public ProductIDInter getMedicine() {
        return medicine;
    }
    public boolean getAcquired(){
        return isAcquired;
    }
    public void setAcquired(boolean acquired) {
        isAcquired = acquired;
    }
}
