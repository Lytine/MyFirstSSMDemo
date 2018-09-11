package org._233Latiao.Lytine.ssm.service.impl;

import javax.annotation.Resource;

import org._233Latiao.Lytine.ssm.dao.UserMapper;
import org._233Latiao.Lytine.ssm.entity.User;
import org._233Latiao.Lytine.ssm.service.IUserService;
import org.springframework.stereotype.Service;


@Service("userService")
public class UserServiceImpl implements IUserService {

	@Resource
	private UserMapper userMapper;

	@Override
	public User getUserById(int userId) {
		
		return this.userMapper.selectByPrimaryKey(userId);
	}

}
