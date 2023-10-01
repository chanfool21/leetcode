package gameskraft;

import java.util.*;

public class MinimumBidder {

    int MAX_BID_PER_USER = 3;

    Map<Integer, List<Bid>> bidMap = new TreeMap<>();
    Map<String, Integer> userCount = new HashMap<>();


    String findWinner(List<Bid> bids) {

        String bidWinner = "";

        for(Bid bid: bids) {
            if(userCount.containsKey(bid.getUserId())) {
                if(userCount.get(bid.getUserId()) < MAX_BID_PER_USER) {
                    if(bidMap.containsKey(bid.getValue())) {
                        bidMap.get(bid.getValue()).add(bid);
                    } else {
                        List<Bid> temp = new ArrayList<Bid>();
                        temp.add(bid);
                        bidMap.put(bid.getValue(), temp);
                    }
                    userCount.put(bid.getUserId(), userCount.get(bid.getUserId()) + 1);
                } else {
                    System.out.println("User: "+ bid.getUserId() + " has exhausted its tries");
                }
            } else {
                userCount.put(bid.getUserId(), 1);
                if(bidMap.containsKey(bid.getValue())) {
                    bidMap.get(bid.getValue()).add(bid);
                } else {
                    List<Bid> temp = new ArrayList<Bid>();
                    temp.add(bid);
                    bidMap.put(bid.getValue(), temp);
                }
            }
        }

        int minCount = Integer.MAX_VALUE;
        int minValue = Integer.MAX_VALUE;

        for (Map.Entry<Integer, List<Bid>> entry: bidMap.entrySet()) {
            if(bidWinner.length() == 0) {
                bidWinner = entry.getValue().get(0).getUserId();
                minCount = entry.getValue().size();
                minValue = entry.getKey();
            } else {
                if(minCount > entry.getValue().size()) {
                    bidWinner = entry.getValue().get(0).getUserId();
                    minCount = entry.getValue().size();
                    minValue = entry.getKey();
                } else if(minCount == entry.getValue().size()) {
                    if(minValue > entry.getKey()) {
                        bidWinner = entry.getValue().get(0).getUserId();
                        minCount = entry.getValue().size();
                        minValue = entry.getKey();
                    }
                }
            }

        }

        return bidWinner;
    }

//    String returnRandomWinner(List<Bid> bids) {
//
//    }
    public static void main(String[] args) {
        List<Bid> input = new ArrayList<>();
        Bid bid1 = new Bid();
        bid1.setValue(11);
        bid1.setUserId("abc");
        Bid bid2 = new Bid();
        bid2.setValue(10);
        bid2.setUserId("def");
        Bid bid3 = new Bid();
        bid3.setValue(9);
        bid3.setUserId("ghi");
        Bid bid4 = new Bid();
        bid4.setValue(8);
        bid4.setUserId("def");
        Bid bid5 = new Bid();
        bid5.setValue(8);
        bid5.setUserId("def");
        input.add(bid1);
        input.add(bid2);
        input.add(bid3);
        input.add(bid4);
        input.add(bid5);
        System.out.println(new MinimumBidder().findWinner(input));
    }
}
