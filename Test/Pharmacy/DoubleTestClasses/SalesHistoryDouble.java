package Pharmacy.DoubleTestClasses;

import Pharmacy.Sale;
import services.SalesHistory;

import java.util.ArrayList;
import java.util.List;

public class SalesHistoryDouble implements SalesHistory {
    public List<Sale> saleList = new ArrayList<>();

    public void registerSale(Sale sale){
        saleList.add(sale);
    }
}
