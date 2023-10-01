package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

class ItemWithPerUnitValue {
    Double perUnitValue;
    Item item;
    ItemWithPerUnitValue(Item item, Double perUnitValue) {
        this.perUnitValue = perUnitValue;
        this.item = item;
    }
}

public class FractionalKnapsack {
    double fractionalKnapsack(int W, Item arr[], int n)
    {
        // Your code here
        List<ItemWithPerUnitValue> itemList = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            itemList.add(new ItemWithPerUnitValue(arr[i],Double.parseDouble(String.valueOf(arr[i].value)) / Double.parseDouble(String.valueOf(arr[i].weight))));
        }

        itemList.sort((a,b) -> {
            if(a.perUnitValue <= b.perUnitValue) {
                return 1;
            } else {
                return -1;
            }
        });

        double profit = 0.0;
        for(int i = 0; i < n; i++) {
            if(W >= itemList.get(i).item.weight) {
                profit+= itemList.get(i).item.value;
                W -= itemList.get(i).item.weight;
            } else {
                if(W > 0) {
                    profit+= (W)* Double.parseDouble(String.valueOf(itemList.get(i).item.value)) / Double.parseDouble(String.valueOf(itemList.get(i).item.weight));
                    W = 0;
                }
            }
        }

        return profit;
    }

    public static void main(String[] args) {
        int n = 2;
        Item arr[] = new Item[n];
        arr[0] = new Item(60,10);
        arr[1] = new Item(100,10);
        System.out.println(new FractionalKnapsack().fractionalKnapsack(5, arr, n));
    }
}
