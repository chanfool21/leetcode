package tesco;

import tesco.model.Product;
import tesco.model.ProductSearchResponse;
import tesco.service.ProductIngestionService;
import tesco.service.ProductSearchService;
import tesco.service.ProductTokenizerService;
import tesco.storage.ProductInMemoryStorage;
import tesco.storage.ProductTokenInMemoryStorage;

import java.util.List;

public class SearchApplication {
    public static void main(String[] args) {
        ProductInMemoryStorage productStorage = new ProductInMemoryStorage();
        Product product1 = new Product(1, "Amul Milk");
        Product product2 = new Product(2, "Nandini Chocolate Milk");
        Product product3 = new Product(3, "Milk Chocolate");
        Product product4 = new Product(4, "Chocolate Milk");
        Product product5 = new Product(5, "Milky Way Chocolate Bar");

        productStorage.saveProduct(product1);
        productStorage.saveProduct(product2);
        productStorage.saveProduct(product3);
        productStorage.saveProduct(product4);
        productStorage.saveProduct(product5);


        ProductIngestionService productIngestionService= new ProductIngestionService(productStorage);
        ProductTokenInMemoryStorage productTokenInMemoryStorage = new ProductTokenInMemoryStorage();
        productTokenInMemoryStorage.createTokenAndSave(product1);
        productTokenInMemoryStorage.createTokenAndSave(product2);
        productTokenInMemoryStorage.createTokenAndSave(product3);
        productTokenInMemoryStorage.createTokenAndSave(product4);
        productTokenInMemoryStorage.createTokenAndSave(product5);
        ProductTokenizerService productTokenizerService = new ProductTokenizerService(productTokenInMemoryStorage);
        ProductSearchService productSearchService = new ProductSearchService(productTokenizerService);
        List<ProductSearchResponse> result = productSearchService.searchProduct("Milk");
        for(ProductSearchResponse response : result) {
            System.out.println(response.getId() + ", " + response.getName() + ", " + response.getScore());
        }
    }
}
