package org.homework.book;

import org.homework.book.dao.UserDao;
import org.homework.book.dao.impl.UserDaoImpl;
import org.homework.book.service.UserService;
import org.homework.book.service.impl.UserServiceImpl;
import org.homework.book.ui.LoginFrame;
import org.homework.book.ui.MainFrame;

/**
 * 程序入口类
 * Created by V-zar on 2017/4/20.
 * 
 */
public class Main {


	public static void main(String[] args) {
		UserDao userDao = new UserDaoImpl();
		UserService userService = new UserServiceImpl(userDao);
		LoginFrame loginFrame = new LoginFrame(userService);
		//new MainFrame();
	}

}
