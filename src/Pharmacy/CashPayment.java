package Pharmacy;

import Pharmacy.Exceptions.InsuficientExistence;
import Pharmacy.Exceptions.QuantityMinorThanImport;
import services.SalesHistory;
import services.Warehouse;

import java.math.BigDecimal;
import java.util.List;

public class CashPayment {

    private Warehouse warehouse;

    private SalesHistory salesHistory;

    private List<ProductSaleLine> listOfProducts;

    private Sale sale;

    public CashPayment(){
    }

    void realizePayment(BigDecimal amount, BigDecimal quantity) throws QuantityMinorThanImport, InsuficientExistence {
        if(amount.compareTo(quantity) < 0){
            throw new QuantityMinorThanImport("Quantity is lower than price");
        }
        warehouse.updateStock(listOfProducts);
        salesHistory.registerSale(sale);
    }
}
