package Pharmacy;

import Data.Exceptions.ProductIDException;
import Data.Exceptions.WrongCodeException;
import Data.ProductID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class MedicineDispensingLineTest {

    MedicineDispensingLine medicinePresc;

    @BeforeEach
    public void setUp() throws ProductIDException {
        medicinePresc = new MedicineDispensingLine(new ProductID("1234567890"), "Prendre cada 8 hores.");
    }

    @Test
    public void getProductID() throws ProductIDException {
        assertEquals(new ProductID("1234567890"), medicinePresc.getMedicine());
    }

    @Test
    public void acquiredTest(){
        medicinePresc.setAcquired(false);
        assertEquals(false, medicinePresc.getAcquired());
    }

}
