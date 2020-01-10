package Pharmacy;

import Data.ProductID;
import Pharmacy.Exceptions.DispensingNotAvailableException;


import java.util.*;


public class Dispensing {

    private byte nOrder;

    private Date initDate, finalDate;

    private boolean isCompleted;

    List<MedicineDispensingLine> prescription;

    public Dispensing(byte nOrder, Date initDate, Date finalDate, List<MedicineDispensingLine> prescription){
        this.nOrder = nOrder;
        this.initDate = initDate;
        this.finalDate = finalDate;
        this.isCompleted = false;
        this.prescription = prescription;
    }

    public boolean dispensingEnabled() throws DispensingNotAvailableException {
        if (initDate.after(new Date())){
            return true;
        }else{
            throw new DispensingNotAvailableException("Encara no es pot ha començat el període de dispensació");
        }
    }

    public void setProductAsDispensed(ProductID productID){
        Iterator<MedicineDispensingLine> it = prescription.iterator();
        while (it.hasNext()){
            MedicineDispensingLine medicineLine = it.next();
            if(medicineLine.getMedicine().equals(productID)){
                medicineLine.setAcquired(true);
                break;
            }
        }
    }

    public void setCompleted(){
        if (dispensingIsCompleted())
            isCompleted = true;
    }

    private boolean dispensingIsCompleted() {
        Iterator<MedicineDispensingLine> it = prescription.iterator();
        while (it.hasNext()){
            MedicineDispensingLine medicineLine = it.next();
            if(!medicineLine.getAcquired()){
                return false;
            }
        }
        return true;
    }

    public byte getnOrder(){
        return nOrder;
    }
    public void setnOrder(byte newNOrder){
        nOrder = newNOrder;
    }
    public Date getInitDate(){
        return initDate;
    }
    public void setInitDate(Date newInitDate){
        initDate = newInitDate;
    }
    public Date getFinalDate(){
        return finalDate;
    }
    public void setFinalDate(Date newFinalDate){
        finalDate = newFinalDate;
    }
    public boolean getIsCompleted(){
        return isCompleted;
    }
    public List<MedicineDispensingLine> getPrescription(){
        return prescription;
    }
    public void setPrescriptionet(List<MedicineDispensingLine> newPrescription){
        prescription = newPrescription;
    }


}