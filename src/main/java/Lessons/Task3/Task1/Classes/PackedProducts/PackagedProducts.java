package Lessons.Task3.Task1.Classes.PackedProducts;

import Lessons.Task3.Task1.Interfaces.PackedProduct;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class PackagedProducts implements PackedProduct {
    private Pack pack;
    private List<PackedProduct> products;

    public PackagedProducts(PackedProduct[] packedProducts, Pack pack) {
        products = new LinkedList<>(Arrays.asList(packedProducts));
        setPack(pack);
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

    public void setProducts(List<PackedProduct> products){
        this.products = products;
    }
    public List<PackedProduct> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "PackagedProducts{" +
                "pack=" + pack +
                ", products=" + products +
                '}';
    }

    @Override
    public int getNetWeight() {
        //todo сделать через list.foreach()
        int netWeight = 0;
        for (PackedProduct pp : products) {
            netWeight += pp.getGrossWeight();
        }
        return netWeight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PackagedProducts that = (PackagedProducts) o;
        return Objects.equals(pack, that.pack) &&
                Objects.equals(products, that.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pack, products);
    }

    @Override
    public int getGrossWeight() {
        return getNetWeight() + pack.getWeight();
    }

}
