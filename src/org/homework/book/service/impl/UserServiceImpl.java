package org.homework.book.service.impl;

import org.homework.book.commons.BusinessException;
import org.homework.book.dao.UserDao;
import org.homework.book.service.UserService;
import org.homework.book.vo.User;
import org.junit.Test;

/**
 * 用户业务实现类
 * 
 * 
 */
public class UserServiceImpl implements UserService {

	private UserDao userDao;
	
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}
	@Test
	public void login(String name, String password) {
		User user = userDao.getUser(name, password);
		if (user == null) {
			throw new BusinessException("用户名密码错误");
		}
	}

}
