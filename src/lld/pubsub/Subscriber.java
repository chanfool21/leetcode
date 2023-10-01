package lld.pubsub;

public class Subscriber {
    String id;

    public Subscriber(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    String name;

    void publishMessage(String message) {
        System.out.println("Message published to subscriber");
        System.out.println("TopicName: " + name + " , message: " + message);
    }
}
