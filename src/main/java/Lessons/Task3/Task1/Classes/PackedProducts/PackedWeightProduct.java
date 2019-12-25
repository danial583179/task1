package Lessons.Task3.Task1.Classes.PackedProducts;

import Lessons.Task3.Task1.Classes.NestedVariablesTypes.NotLessZeroInt;
import Lessons.Task3.Task1.Classes.Product.WeightProduct;
import Lessons.Task3.Task1.Interfaces.HasWeight;
import Lessons.Task3.Task1.Interfaces.PackedProduct;

import java.util.Objects;

public class PackedWeightProduct extends WeightProduct implements PackedProduct, HasWeight {
    private Pack pack;
    private NotLessZeroInt weight;

    public PackedWeightProduct(WeightProduct product, Pack pack, int weight) {
        super(product);
        setPack(pack);
        setWeight(weight);
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

    @Override
    public int getNetWeight() {
        return getWeight();
    }

    @Override
    public int getGrossWeight() {
        return getNetWeight() + pack.getWeight();
    }

    public void setWeight(int weight){
        if (this.weight == null) {
            this.weight = new NotLessZeroInt(weight);
        } else {
            this.weight.setValue(weight);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PackedWeightProduct that = (PackedWeightProduct) o;
        return Objects.equals(pack, that.pack) &&
                Objects.equals(weight, that.weight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), pack, weight);
    }

    @Override
    public int getWeight() {
        return weight.getValue();
    }

    @Override
    public String toString() {
        return "PackedWeightProduct{" +
                "pack=" + pack +
                ", weight=" + weight +
                "} " + super.toString();
    }

}
