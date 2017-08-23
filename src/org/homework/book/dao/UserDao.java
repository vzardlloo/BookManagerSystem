package org.homework.book.dao;

import org.homework.book.vo.User;

/**
 * 用户DAO接口
 * 
 * 
 */
public interface UserDao {

	User getUser(String name, String password);
}
