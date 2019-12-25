package Lessons.Task3.Task1.Classes.PackedProducts;

import Lessons.Task3.Task1.Classes.NestedVariablesTypes.NotLessZeroInt;
import Lessons.Task3.Task1.Classes.NestedVariablesTypes.NotNullOrEmptyString;
import Lessons.Task3.Task1.Interfaces.HasName;
import Lessons.Task3.Task1.Interfaces.HasWeight;

import java.util.Objects;

public class Pack implements HasWeight, HasName {
    private NotLessZeroInt weight;
    private NotNullOrEmptyString name;

    public Pack(int weight, String name) {
        setName(name);
        setWeight(weight);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pack pack = (Pack) o;
        return Objects.equals(weight, pack.weight) &&
                Objects.equals(name, pack.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight, name);
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
    public String getName() {
        return name.getValue();
    }

    public void setName(String name) {
        if (this.name == null) {
            this.name = new NotNullOrEmptyString(name);
        } else {
            this.name.setValue(name);
        }
    }

    @Override
    public String toString() {
        return "Pack{" +
                "weight=" + weight +
                ", name=" + name +
                '}';
    }

}
