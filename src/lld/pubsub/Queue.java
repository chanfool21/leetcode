package lld.pubsub;

import java.util.*;

public class Queue {
    Map<String, Topic> topicMap;

    public Queue() {
        topicMap = new HashMap<>();
    }


    public void createTopic(String name) {
        Topic newTopic = new Topic(UUID.randomUUID().toString(), name);
        topicMap.put(name, newTopic);
    }

    public void subscribe(Subscriber subscriber, String topicName) {
        Topic topic = getTopicByTopicName(topicName);
        topic.addSubscriber(subscriber);
    }
    public void publish(String topicName, String message) {

        Topic topic = getTopicByTopicName(topicName);
        topic.publishMessageToSubsribers(message);

    }

    public void resetOffset(String topicName, Subscriber subscriber, int offset) {
        Topic topic = getTopicByTopicName(topicName);
        topic.resetOffSetOfASubscriber(subscriber, offset);
    }

    private Topic getTopicByTopicName(String topicName) {
        if(!topicMap.containsKey(topicName)) {
            createTopic(topicName);
        }
        return topicMap.get(topicName);
    }
}
