package org.homework.book.dao;

import java.util.Collection;

import org.homework.book.vo.Type;

/**
 * �鱾����DAO�ӿ�
 * 
 *
 */
public interface TypeDao {

	/**
	 * �������е�����
	 * @return ����ļ���
	 */
	Collection<Type> find();
	
	/**
	 * ��������ģ����������
	 * @param name ��������
	 * @return
	 */
	Collection<Type> findByName(String name);
	
	/**
	 * ����id��������
	 * @param id ����id
	 * @return �����ֵ����
	 */
	Type find(String id);
	
	/**
	 * ���һ������
	 * @param type ��Ҫ��ӵ�����
	 */
	String add(Type type);
	
	/**
	 * �޸�һ������
	 * @param type �޸ĵ�����
	 */
	String update(Type type);
	
}
