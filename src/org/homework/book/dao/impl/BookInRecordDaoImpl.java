package org.homework.book.dao.impl;

import java.util.Collection;
import java.util.Vector;

import org.homework.book.dao.BookInRecordDao;
import org.homework.book.vo.BookInRecord;
import org.homework.book.vo.BookSaleRecord;

/**
 * 书本入库DAO实现类
 *
 */
public class BookInRecordDaoImpl extends CommonDaoImpl implements
		BookInRecordDao {

	@Override
	public Collection<BookInRecord> findByInRecord(String inRecordId) {
		String sql = "SELECT * FROM T_BOOK_IN_RECORD r WHERE r.T_IN_RECORD_ID_FK='" + 
		inRecordId + "'";
		return getDatas(sql, new Vector(), BookInRecord.class);
	}

	@Override
	public String save(BookInRecord r) {
		String sql = "INSERT INTO T_BOOK_IN_RECORD VALUES (ID, '" + r.getBook().getID() + 
		"', '" + r.getT_IN_RECORD_ID_FK() + "', '" + r.getIN_SUM() + "')";
		return String.valueOf(getJDBCExecutor().executeUpdate(sql));

	}

}
