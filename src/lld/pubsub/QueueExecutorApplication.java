package lld.pubsub;

public class QueueExecutorApplication {

    public static void main(String[] args) {
        Queue queue = new Queue();
        String topicName = "topic1";
        queue.createTopic(topicName);

        Subscriber subscriber1 = new Subscriber("sub1");
        Subscriber subscriber2 = new Subscriber("sub2");
        Subscriber subscriber3 = new Subscriber("sub3");
        Subscriber subscriber4 = new Subscriber("sub4");
        queue.subscribe(subscriber1, topicName);
        queue.subscribe(subscriber2, topicName);
        queue.subscribe(subscriber3, topicName);
        queue.subscribe(subscriber4, topicName);

        queue.publish(topicName, "Hello, this my first message");
        queue.publish(topicName, "Hello, this my second message");

        queue.resetOffset(topicName, subscriber1, 0);
    }
}
