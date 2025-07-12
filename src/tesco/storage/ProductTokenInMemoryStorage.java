package tesco.storage;

import tesco.model.Product;
import tesco.util.MatchingScoreUtil;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;

public class ProductTokenInMemoryStorage {
    ConcurrentHashMap<String, PriorityQueue<Product>> tokenMap;

    public ProductTokenInMemoryStorage() {
        tokenMap = new ConcurrentHashMap<>();
    }


    public void createTokenAndSave(Product product) {
        String name = product.getName();
        String [] tokens = name.split(" ");
        
        // Add each word as a token
        for(String currentToken: tokens) {
            addProductToToken(currentToken, product);
        }
        
        // Also add substrings of each word to handle partial matches
        for(String currentToken: tokens) {
            for(int i = 0; i < currentToken.length(); i++) {
                for(int j = i + 1; j <= currentToken.length(); j++) {
                    String substring = currentToken.substring(i, j);
                    if(substring.length() >= 2) { // Only add substrings of length 2 or more
                        addProductToToken(substring, product);
                    }
                }
            }
        }
    }
    
    private void addProductToToken(String token, Product product) {
        if(!tokenMap.containsKey(token)) {
            PriorityQueue<Product> pq = new PriorityQueue<Product>(new Comparator<Product>() {
                @Override
                public int compare(Product product1, Product product2) {
                    int score1 = MatchingScoreUtil.getMatchingScore(product1.getName(), token);
                    int score2 = MatchingScoreUtil.getMatchingScore(product2.getName(), token);
                    // Higher score should come first (descending order)
                    return Integer.compare(score2, score1);
                }
            });
            tokenMap.put(token, pq);
        }
        PriorityQueue<Product> productPriorityQueue = tokenMap.get(token);
        if (!productPriorityQueue.contains(product)) {
            productPriorityQueue.add(product);
        }
    }


    public PriorityQueue<Product> getSortedProductListByParam(String param) {
        PriorityQueue<Product> result = tokenMap.get(param);
        return result != null ? result : new PriorityQueue<>();
    }
}
