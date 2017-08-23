package org.homework.book.dao;

import java.util.Collection;

import org.homework.book.vo.BookInRecord;

/**
 * �鱾����¼DAO�ӿ�
 * 
 * 
 */
public interface BookInRecordDao {

	/**
	 * ��������¼����ȫ�����������¼
	 * @param inRecordId
	 * @return
	 */
	Collection<BookInRecord> findByInRecord(String inRecordId);
	
	/**
	 * ����һ���������¼, �����ظü�¼��id
	 * @param r
	 * @return
	 */
	String save(BookInRecord r);
}
