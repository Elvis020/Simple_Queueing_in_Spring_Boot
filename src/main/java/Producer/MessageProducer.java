package Producer;

import redis.clients.jedis.JedisPool;

public class MessageProducer {
    public static void main(String[] args) {
        JedisPool jedis = new JedisPool("localhost");
        jedis.getResource().rpush("mq-key","first message");
        jedis.getResource().rpush("mq-key","second message");
        jedis.getResource().rpush("mq-key","third message");
    }
}
