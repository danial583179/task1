package Lessons.Task3.Task1.Classes.PackedProducts;

import Lessons.Task3.Task1.Classes.NestedVariablesTypes.NotLessZeroInt;
import Lessons.Task3.Task1.Classes.Product.PieceProduct;
import Lessons.Task3.Task1.Interfaces.PackedProduct;

import java.util.Objects;

public class PackedPieceProduct extends PieceProduct implements PackedProduct {
    private Pack pack;
    private NotLessZeroInt quantity;

    public PackedPieceProduct(PieceProduct pieceProduct,Pack pack, int quantity) {
        super(pieceProduct);
        setPack(pack);
        setQuantity(quantity);
    }

    public void setPack(Pack pack){
        if(pack == null){
            throw new IllegalArgumentException("Pack can't be null");
        } else {
            this.pack = pack;
        }
    }

    public Pack getPack(){
        return pack;
    }

    public void setQuantity(int quantity) {
        if (this.quantity == null) {
            this.quantity = new NotLessZeroInt(quantity);
        } else {
            this.quantity.setValue(quantity);
        }
    }

    public int getQuantity() {
        return quantity.getValue();
    }

    @Override
    public int getNetWeight() {
        return quantity.getValue() * super.getWeight();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PackedPieceProduct that = (PackedPieceProduct) o;
        return quantity == that.quantity &&
                Objects.equals(pack, that.pack);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), pack, quantity);
    }

    @Override
    public int getGrossWeight() {
        return quantity.getValue() * super.getWeight() + pack.getWeight();
    }

    @Override
    public String toString() {
        return "PackedPieceProduct{" +
                "pack=" + pack +
                ", quantity=" + quantity +
                "} " + super.toString();
    }

}
