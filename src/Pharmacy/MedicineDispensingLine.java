package Pharmacy;

import Data.ProductID;

public class MedicineDispensingLine {

    private ProductID medicine;
    private boolean isAcquired;
    private String description;

    public MedicineDispensingLine(ProductID medicine, String descrition){
        this.medicine = medicine;
        this.description = descrition;
        isAcquired = false;
    }

    public ProductID getMedicine() {
        return medicine;
    }
    public boolean getAcquired(){
        return isAcquired;
    }
    public void setAcquired(boolean acquired) {
        isAcquired = acquired;
    }
}
