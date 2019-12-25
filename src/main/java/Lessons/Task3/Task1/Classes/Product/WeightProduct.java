package Lessons.Task3.Task1.Classes.Product;

public class WeightProduct extends Product {
    public WeightProduct(WeightProduct weightProduct){ this(weightProduct.getName(),weightProduct.getDescription());}

    public WeightProduct(String name, String description) {
        super(name, description);
    }

    @Override
    public String toString() {
        return "WeightProduct{} " + super.toString();
    }
}
