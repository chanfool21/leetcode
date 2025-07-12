package tesco.storage;

import tesco.model.Product;

import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;

public class ProductInMemoryStorage {
    ConcurrentHashMap<Integer, Product> productData;

    public ProductInMemoryStorage() {
        this.productData = new ConcurrentHashMap<>();
    }


    public void saveProduct(Product product) {
        productData.put(product.getId(), product);
    }

    public Product getProductById(Integer id) {
        return productData.get(id);
    }
}
