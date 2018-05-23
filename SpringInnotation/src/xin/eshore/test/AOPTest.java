/**
 * @Description:TODO
 * @author:susan
 * @date 2018年5月16日上午10:06:42
 */
package xin.eshore.test;

import org.junit.AfterClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import xin.eshore.entity.TestEntity;
import xin.eshore.service.UserService;
import xin.eshore.entity.User;

/**
 * @ClassName:AOPTest
 * @Description:TODO
 * @author:susan
 * @date 2018年5月16日上午10:06:42
 */
public class AOPTest {

    /**
     * @throws Exception
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Test
    public void test() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
        UserService service = (UserService) ctx.getBean("service");

        User user = (User) ctx.getBean("user");

        service.addNewUser(user);
    }
    @Test
    public void TestEntity() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
        TestEntity testEntity = (TestEntity) ctx.getBean("entity");
        testEntity.showValue();
    }

    @Test
    public void testAnnotation() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
        UserService service = (UserService) ctx.getBean("service");

        User user = (User) ctx.getBean("user");

        service.addNewUser(user);
    }

}
