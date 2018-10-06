import com.codecly.redis.RedisWithReentrantLock;
import org.junit.Assert;
import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * @ClassName RedisWithReentrantLockTest
 * @Description RedisWithReentrantLockTest
 * @Author maxinchun
 * @Date 2018/10/6 22:54
 */
public class RedisWithReentrantLockTest {

    @Test
    public void lockTest() {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        RedisWithReentrantLock redis = new RedisWithReentrantLock(jedis);
        String key = "codehole";
        Assert.assertTrue("加锁失败", redis.lock(key));
        Assert.assertTrue("加锁失败", redis.lock(key));

        Assert.assertTrue("解锁失败", redis.unlock(key));
        Assert.assertTrue("解锁失败", redis.unlock(key));
    }
}
