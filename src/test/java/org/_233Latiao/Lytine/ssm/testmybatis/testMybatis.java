package org._233Latiao.Lytine.ssm.testmybatis;

import javax.annotation.Resource;

import org._233Latiao.Lytine.ssm.entity.User;
import org._233Latiao.Lytine.ssm.service.IUserService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-mybatis.xml" })
public class testMybatis {
	private static Logger logger = Logger.getLogger(testMybatis.class);

	@Resource
	private IUserService userService = null;

	@Test
	public void test1() {
		User user = userService.getUserById(1);
		System.out.println(user.getUserName());
		logger.info("值：" + user.getUserName());
		logger.info(JSON.toJSONString(user));
	}
	
	
}



