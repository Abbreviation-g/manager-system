package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.my.manager.ManagerApplication;
import com.my.manager.bean.UserBean;
import com.my.manager.service.UserService;

@SpringBootTest(classes = ManagerApplication.class)
@RunWith(SpringRunner.class)
public class UserServiceTest {
	@Autowired
	UserService userService;
	
	@Test
	public void queryUserByUsername(){
		String username = "admin";
		UserBean userBean = userService.queryUserByUsername(username);
		UserMapperTest.sysout(userBean);
	}
	
}
