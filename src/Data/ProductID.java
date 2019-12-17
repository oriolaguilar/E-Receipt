package data;

final public class ProductID {

    private final String UPC;

    public ProductID(String code){
        this.UPC = code;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductID prodID = (ProductID) o;
        return this.UPC.equals(prodID.UPC);
    }
    @Override
    public int hashCode() {
        return UPC.hashCode();
    }

    @Override
    public String toString() {
        return "ProductID{" + "Universal Product Code ='" + UPC + '\'' + '}';
    }

}
