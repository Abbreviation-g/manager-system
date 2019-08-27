package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.my.manager.ManagerApplication;
import com.my.manager.mapper.UserMapper;

@SpringBootTest(classes = ManagerApplication.class)
@RunWith(SpringRunner.class)
public class UserMapperTest {

	@Autowired
	UserMapper userMapper
;	
	@Test
	public void test() {
		System.out.println(userMapper.queryUserById(1));
	}
}
