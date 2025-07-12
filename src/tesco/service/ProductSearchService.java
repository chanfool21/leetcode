package tesco.service;

import tesco.model.Product;
import tesco.model.ProductSearchResponse;
import tesco.util.MatchingScoreUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class ProductSearchService {
    ProductTokenizerService productTokenizerService;
    public ProductSearchService(ProductTokenizerService productTokenizerService) {
        this.productTokenizerService = productTokenizerService;
    }
    public List<ProductSearchResponse> searchProduct(String param) {
        PriorityQueue<Product> productList = productTokenizerService.getSortedProductList(param);
        List<ProductSearchResponse> resultList = new ArrayList<>();

        // Convert PriorityQueue to List to avoid modification during iteration
        List<Product> products = new ArrayList<>(productList);
        
        for (Product currentProduct : products) {
            ProductSearchResponse currentProductResponse = new ProductSearchResponse();
            int score = MatchingScoreUtil.getMatchingScore(currentProduct.getName(), param);
            currentProductResponse.setId(currentProduct.getId());
            currentProductResponse.setName(currentProduct.getName());
            currentProductResponse.setScore(score);

            resultList.add(currentProductResponse);
        }

        return resultList;

    }
}
