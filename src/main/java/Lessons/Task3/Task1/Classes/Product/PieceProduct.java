package Lessons.Task3.Task1.Classes.Product;

import Lessons.Task3.Task1.Classes.NestedVariablesTypes.NotLessZeroInt;
import Lessons.Task3.Task1.Interfaces.HasWeight;

import java.util.Objects;

public class PieceProduct extends Product implements HasWeight {
    private NotLessZeroInt weight;

    @Override
    public String toString() {
        return "PieceProduct{" +
                "weight=" + weight +
                "} " + super.toString();
    }

    public PieceProduct(String name, String description, int weight) {
        super(name, description);
        setWeight(weight);
    }

    public PieceProduct(PieceProduct pieceProduct){
        this(pieceProduct.getName(),pieceProduct.getDescription(),pieceProduct.getWeight());
    }
    public void setWeight(int weight){
        if (this.weight == null) {
            this.weight = new NotLessZeroInt(weight);
        } else {
            this.weight.setValue(weight);
        }
    }
    @Override
    public int getWeight() {
        return weight.getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PieceProduct that = (PieceProduct) o;
        return Objects.equals(weight, that.weight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), weight);
    }
}
