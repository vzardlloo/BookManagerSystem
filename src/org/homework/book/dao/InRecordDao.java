package org.homework.book.dao;

import java.util.Collection;

import org.homework.book.vo.InRecord;

/**
 * ����¼DAO�ӿ�
 * 
 *
 */
public interface InRecordDao {

	/**
	 * �������������������¼
	 * @param begin ��ʼ���ڵ��ַ���
	 * @param end �������ڵ��ַ�
	 * @return
	 */
	Collection<InRecord> findByDate(String begin, String end);
	
	/**
	 * ��������¼id�������¼����
	 * @param id
	 * @return
	 */
	InRecord findById(String id);
	
	/**
	 * ����һ������¼
	 * @param r
	 * @return
	 */
	String save(InRecord r);
}
