package lld.pubsub;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Topic {
    String id;
    Map<String, Integer> consumerOffset = null;
    List<String> messageList = null;

    List<Subscriber> subscribers = null;
    public Topic(String id, String name) {
        this.id = id;
        this.name = name;
        subscribers = new ArrayList<>();
        consumerOffset = new HashMap<>();
        messageList = new ArrayList<>();
    }

    public void addSubscriber(Subscriber subscriber) {
        consumerOffset.put(subscriber.getName(), 0);
        subscribers.add(subscriber);
    }

    public void publishMessageToSubsribers(String message) {
        messageList.add(message);
        ExecutorService executorService = Executors.newFixedThreadPool(subscribers.size());;
        for(Subscriber subscriber: subscribers) {
            int offset = consumerOffset.get(subscriber.getName());
            executorService.submit(() -> {publishMessageToSubscriber(subscriber, offset);});
        }
        executorService.shutdown();
    }

    public void resetOffSetOfASubscriber(Subscriber subscriber, int offset) {
        publishMessageToSubscriber(subscriber, offset);
    }
    private void publishMessageToSubscriber(Subscriber subscriber, int offset) {
        for(int i = offset; i < messageList.size(); i++) {
            subscriber.publishMessage(messageList.get(i));
        }
        consumerOffset.put(subscriber.getName(), offset+1);
    }

    String name;
}
