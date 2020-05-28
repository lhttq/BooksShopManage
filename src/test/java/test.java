import cn.lht.entity.BsBooks;
import cn.lht.entity.BsUsers;
import cn.lht.service.BsBooksService;
import cn.lht.service.BsUsersService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: BooksShopManage
 * @description: ceshi
 * @author: LHT
 * @create: 2020-04-14 17:23
 **/
public class test {
    @Test
    public void testSpring(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath" +
                ":applicationContext.xml");
        BsBooksService bsBooksService = (BsBooksService)applicationContext.getBean(
                "bsBooksService");
        bsBooksService.queryAllByLimit(0,10);

    }
}
