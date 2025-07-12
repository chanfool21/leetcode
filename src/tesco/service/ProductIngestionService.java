package tesco.service;

import tesco.model.Product;
import tesco.storage.ProductInMemoryStorage;

public class ProductIngestionService {
    private ProductInMemoryStorage storage;
    public ProductIngestionService(ProductInMemoryStorage storage) {
        this.storage = storage;
    }

    public void addProductToStorage(Product product) {
        storage.saveProduct(product);
    }

}
