package Pharmacy;

import Pharmacy.Exceptions.InsuficientExistence;
import Pharmacy.Exceptions.QuantityMinorThanImport;
import services.SalesHistory;
import services.Warehouse;

import java.math.BigDecimal;

public class CashPayment {

    private Warehouse warehouse;
    private SalesHistory salesHistory;
    private Sale sale;

    private BigDecimal pImport;
    private BigDecimal pChange;

    public CashPayment(){}

    public void realizePayment(BigDecimal amount, BigDecimal quantity) throws QuantityMinorThanImport, InsuficientExistence {
        if(amount.compareTo(quantity) > 0){
            throw new QuantityMinorThanImport("Quantity is lower than price");
        }
        pImport = amount;
        pChange = quantity.subtract(amount);
        warehouse.updateStock(sale.getPsl());
        salesHistory.registerSale(sale);
    }

    public void setWarehouse(Warehouse warehouse){
        this.warehouse = warehouse;
    }
    public void setSalesHistory(SalesHistory salesHistory){
        this.salesHistory = salesHistory;
    }
    public void setSale(Sale sale){
        this.sale = sale;
    }
    public BigDecimal getChange() {
        return pChange;
    }
}
