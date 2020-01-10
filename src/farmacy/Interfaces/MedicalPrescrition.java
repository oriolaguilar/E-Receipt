package farmacy.Interfaces;

import farmacy.MedicineDispensingLine;

import java.util.List;

public interface MedicalPrescrition {

    List<MedicineDispensingLine> getPrescription();
    void addLine(MedicineDispensingLine prescriptionLine);
}
