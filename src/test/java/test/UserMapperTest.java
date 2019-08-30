package test;

import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSONObject;
import com.my.manager.ManagerApplication;
import com.my.manager.bean.AuthBean;
import com.my.manager.bean.RoleBean;
import com.my.manager.bean.UserBean;
import com.my.manager.mapper.UserMapper;

@SpringBootTest(classes = ManagerApplication.class)
@RunWith(SpringRunner.class)
public class UserMapperTest {

	@Autowired
	UserMapper userMapper;

	@Test
	public void test() {
		System.out.println("UserMapperTest.test()");

		UserBean userBean = userMapper.queryUserById(1L);
		sysout(userBean);
		userBean = userMapper.queryUserByUsername("admin");
		sysout(userBean);

		List<RoleBean> roleBeans = userMapper.queryRoleByUserId(userBean.getId());

		if (!roleBeans.isEmpty()) {
			userBean.setRoleBeans(roleBeans);
			for (RoleBean roleBean : roleBeans) {
				List<AuthBean> authBeans = userMapper.queryAuthByRoleId(roleBean.getId());

				roleBean.setAuthBeans(authBeans);
			}
		}

		sysout(userBean);
	}

	public static void sysout(Object object) {
		System.out.println("----------------<<>>----------------");
		if (object instanceof Collection) {
			@SuppressWarnings("rawtypes")
			Collection collection = (Collection) object;
			for (Object object2 : collection) {
				System.out.println(JSONObject.toJSONString(object2));
			}
		} else {
			System.out.println(JSONObject.toJSONString(object));
		}
	}
}
