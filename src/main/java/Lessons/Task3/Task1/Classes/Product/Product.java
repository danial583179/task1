package Lessons.Task3.Task1.Classes.Product;

import Lessons.Task3.Task1.Classes.NestedVariablesTypes.NotNullOrEmptyString;
import Lessons.Task3.Task1.Interfaces.HasDescription;
import Lessons.Task3.Task1.Interfaces.HasName;

import java.util.Objects;

public class Product implements HasName, HasDescription {
    private NotNullOrEmptyString name;
    private NotNullOrEmptyString description;

    public  Product(Product product){
        this(product.getName(),product.getDescription());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) &&
                Objects.equals(description, product.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description);
    }

    public Product(String name, String description) {
        setName(name);
        setDescription(description);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name=" + name +
                ", description=" + description +
                '}';
    }

    public void setName(String name) {
        if (this.name == null) {
            this.name = new NotNullOrEmptyString(name);
        } else {
            this.name.setValue(name);
        }
    }

    public void setDescription(String description){
        if (this.description == null) {
            this.description = new NotNullOrEmptyString(description);
        } else {
            this.description.setValue(description);
        }
    }

    @Override
    public String getName() {
        return name.getValue();
    }

    @Override
    public String getDescription() {
        return description.getValue();
    }

}
