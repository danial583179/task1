package Lessons.Task3.Task3;

import Lessons.Task3.Task1.Classes.PackedProducts.PackagedProducts;
import Lessons.Task3.Task1.Classes.PackedProducts.ProductBach;
import Lessons.Task3.Task1.Classes.Product.Product;
import Lessons.Task3.Task1.Classes.Product.WeightProduct;
import Lessons.Task3.Task1.Interfaces.PackedProduct;
import Lessons.Task3.Task2.Filter.Filter;

public class ProductService {
    public static int countByFilter(ProductBach pb, Filter filter){
        int counter = 0;
        for (PackedProduct product: pb.getProducts()) {
            if(product instanceof Product) {
                Product currentProduct = (Product) product;
                if (filter.apply(currentProduct.getName())) {
                    counter++;
                }
            }
        }
        return counter;
    }

    public static int countByFilterDeep(ProductBach pb,Filter filter){
        int counter = 0;
        for(PackedProduct product: pb.getProducts()){
            if(product instanceof PackagedProducts){
                counter += countByFilterDeep(new ProductBach((PackagedProducts) product,"description"), filter);
            }
            if(product instanceof Product) {
                Product currentProduct = (Product) product;
                if (filter.apply(currentProduct.getName())) {
                    counter++;
                }
            }
        }
        return counter;
    }

    public static boolean checkAllWeighted(ProductBach pb){
        for(PackedProduct product : pb.getProducts()){
            if(!(product instanceof WeightProduct)){
                return false;
            }
        }
        return true;
    }
}
