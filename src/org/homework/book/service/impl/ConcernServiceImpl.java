package org.homework.book.service.impl;

import java.util.Collection;

import org.homework.book.dao.ConcernDao;
import org.homework.book.service.ConcernService;
import org.homework.book.vo.Concern;

/**
 * ������ҵ��ʵ����
 * 
 
 */
public class ConcernServiceImpl implements ConcernService {

	private ConcernDao dao;
	
	public ConcernServiceImpl(ConcernDao dao) {
		this.dao = dao;
	}
	
	@Override
	public Collection<Concern> getAll() {
		return dao.findAll();
	}

	@Override
	public Concern find(String id) {
		return dao.find(id);
	}

	@Override
	public Concern add(Concern c) {
		String id = dao.add(c);
		return find(id);
	}

	@Override
	public Concern update(Concern c) {
		//����DAO�����޸Ķ���
		String id = dao.update(c);
		//���²��Ҹö���
		return find(id);
	}

	@Override
	public Collection<Concern> query(String name) {
		return dao.findByName(name);
	}

}
