package farmacy;


import java.math.BigDecimal;
import java.util.Date;

public class Sale {
    private int saleCode;

    private Date date;

    private BigDecimal amount;

    private boolean isClosed;

    private int serial(int saleCode){
        return saleCode + 1;
    }
    public Sale(){
        this.saleCode = serial(saleCode);
        this.date = new Date();
    }


}
