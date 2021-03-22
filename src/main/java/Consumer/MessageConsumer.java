package Consumer;

import redis.clients.jedis.JedisPool;

import java.util.List;

public class MessageConsumer {
    private static final int TIMEOUT = 0;
    public static void main(String[] args) {
        JedisPool jedis = new JedisPool("localhost");
        while(true){
            System.out.println("Waiting for a message in the queue");
            List<String> messages = jedis.getResource().blpop(TIMEOUT, "mq-key");
            System.out.println(" recieved message with key: " + messages.get(0) + " with the value: "+messages.get(1));
        }
    }
}
