import com.codecly.redis.User;
import com.codecly.redis.UserRedis;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @ClassName UserRedisTest
 * @Description UserRedisTest
 * @Author maxinchun
 * @Date 2018/10/6 02:17
 */

public class UserRedisTest {

    private User user;

    @Before
    public void before() {
        // 构造用户信息实体
        user = new User();
        user.setName("maxinchun");
        user.setAge(27);
        user.setSex(1);
        user.setHeight(170);
        user.setWeight(70);
        user.setTelephone("15212359645");
        user.setCompany("飞友科技");
        user.setAddress("安徽省合肥市肥西县");
    }


    @Test
    public void setUserTest() {
        System.out.println(user);
        UserRedis userRedis = new UserRedis();
        userRedis.setUser(user, "maxinchun");
        System.out.println("存放redis完成");
    }

    @Test
    public void getUserTest() {
        UserRedis userRedis = new UserRedis();
        User user = userRedis.getUser("maxinchun");
        System.out.println(user);
        Assert.assertNotNull("获取用户信息为空", user);
        Assert.assertEquals("获取用户实体信息不一致", this.user, user);
    }

}
