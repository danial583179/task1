package Lessons.Task3.Task1.Classes.PackedProducts;

import Lessons.Task3.Task1.Classes.NestedVariablesTypes.NotNullOrEmptyString;
import Lessons.Task3.Task1.Interfaces.HasDescription;
import Lessons.Task3.Task1.Interfaces.HasWeight;
import Lessons.Task3.Task1.Interfaces.PackedProduct;

import java.util.*;

public class ProductBach implements HasDescription, HasWeight {
    private NotNullOrEmptyString description;
    private List<PackedProduct> products;

    public ProductBach(PackedProduct[] packedProducts, String description) {
        products = new LinkedList<>(Arrays.asList(packedProducts));
        setDescription(description);
    }

    public ProductBach(PackagedProducts packagedProducts,String description){
        products = packagedProducts.getProducts();
        setDescription(description);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ProductBach that = (ProductBach) o;
        return Objects.equals(description, that.description);
    }

    public List<PackedProduct> getProducts() {
        return products;
    }

    public void setProducts(List<PackedProduct> products) {
        this.products = products;
    }

    public void setDescription(String description) {
        if (this.description == null) {
            this.description = new NotNullOrEmptyString(description);
        } else {
            this.description.setValue(description);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), description);
    }

    @Override
    public String toString() {
        return "ProductBach{" +
                "description=" + description.toString() +
                "} " + super.toString();
    }

    @Override
    public String getDescription() {
        return description.getValue();
    }

    @Override
    public int getWeight() {
        return products.stream().mapToInt(PackedProduct::getGrossWeight).sum();
    }
}
