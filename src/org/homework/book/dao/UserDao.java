package org.homework.book.dao;

import org.homework.book.vo.User;

/**
 * �û�DAO�ӿ�
 * 
 * 
 */
public interface UserDao {

	User getUser(String name, String password);
}
