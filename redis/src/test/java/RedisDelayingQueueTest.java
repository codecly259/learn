import com.codecly.redis.RedisDelayingQueue;
import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * @ClassName RedisDelayingQueueTest
 * @Description RedisDelayingQueueTest
 * @Author maxinchun
 * @Date 2018/10/6 23:28
 */
public class RedisDelayingQueueTest {

    @Test
    public void delayQueueTest() {
        Jedis jedis = new Jedis();
        RedisDelayingQueue<String> queue = new RedisDelayingQueue<String>(jedis, "q-demo");
        Thread producer = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                queue.delay("codehole" + i);
            }
        });
        Thread consumer = new Thread(() -> {
            queue.loop();
        });
        producer.start();
        consumer.start();
        try {
            producer.join();
            Thread.sleep(6000);
            consumer.interrupt();
            consumer.join();
        } catch (InterruptedException e) {
            
        }
    }

}
