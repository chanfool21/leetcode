package tesco.service;

import tesco.model.Product;
import tesco.storage.ProductTokenInMemoryStorage;

import java.util.PriorityQueue;

public class ProductTokenizerService {

    ProductTokenInMemoryStorage productTokenInMemoryStorage;
    public ProductTokenizerService(ProductTokenInMemoryStorage productTokenInMemoryStorage) {
        this.productTokenInMemoryStorage = productTokenInMemoryStorage;
    }

    void tokenizeProduct(Product product) {
        productTokenInMemoryStorage.createTokenAndSave(product);
    }

    PriorityQueue<Product> getSortedProductList(String param) {
        return productTokenInMemoryStorage.getSortedProductListByParam(param);
    }
}
