package org.homework.book.ui;

import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.KeyStroke;

import org.homework.book.dao.BookDao;
import org.homework.book.dao.BookInRecordDao;
import org.homework.book.dao.BookSaleRecordDao;
import org.homework.book.dao.ConcernDao;
import org.homework.book.dao.InRecordDao;
import org.homework.book.dao.SaleRecordDao;
import org.homework.book.dao.TypeDao;
import org.homework.book.dao.impl.BookDaoImpl;
import org.homework.book.dao.impl.BookInRecordDaoImpl;
import org.homework.book.dao.impl.BookSaleRecordDaoImpl;
import org.homework.book.dao.impl.ConcernDaoImpl;
import org.homework.book.dao.impl.InRecordDaoImpl;
import org.homework.book.dao.impl.SaleRecordDaoImpl;
import org.homework.book.dao.impl.TypeDaoImpl;
import org.homework.book.service.BookService;
import org.homework.book.service.ConcernService;
import org.homework.book.service.InRecordService;
import org.homework.book.service.SaleRecordService;
import org.homework.book.service.TypeService;
import org.homework.book.service.impl.BookServiceImpl;
import org.homework.book.service.impl.ConcernServiceImpl;
import org.homework.book.service.impl.InRecordServiceImpl;
import org.homework.book.service.impl.SaleRecordServiceImpl;
import org.homework.book.service.impl.TypeServiceImpl;

/**
 * �������JFrame
 * 
 * 
 */
public class MainFrame extends JFrame{
	
	SalePanel salePanel;
	
	RepertoryPanel repertoryPanel;
	
	BookPanel bookPanel;
	
	ConcernPanel concernPanel;
	
	TypePanel typePanel;
	
	CommonPanel currentPanel;
	
	//ҵ��ӿ�
	TypeService typeService;
	
	ConcernService concernService;
	
	BookService bookService;
	
	SaleRecordService saleRecordService;
	
	InRecordService inRecordService;
	
	private Action sale = new AbstractAction("���۹���", new ImageIcon("images/sale.gif")) {
		public void actionPerformed(ActionEvent e) {
			changePanel(salePanel);
		}
	};
	
	private Action repertory = new AbstractAction("������", new ImageIcon("images/repertory.gif")) {
		public void actionPerformed(ActionEvent e) {
			changePanel(repertoryPanel);
		}
	};

	private Action book = new AbstractAction("�鱾����", new ImageIcon("images/book.gif")) {
		public void actionPerformed(ActionEvent e) {
			changePanel(bookPanel);
			bookPanel.initImage();
			bookPanel.repaint();
		}
	};
	
	private Action type = new AbstractAction("�������", new ImageIcon("images/type.gif")) {
		public void actionPerformed(ActionEvent e) {
			changePanel(typePanel);
		}
	};
	
	private Action concern = new AbstractAction("���������", new ImageIcon("images/concern.gif")) {
		public void actionPerformed(ActionEvent e) {
			changePanel(concernPanel);
		}
	};
	
	public MainFrame() {
		TypeDao typeDao = new TypeDaoImpl();
		ConcernDao concernDao = new ConcernDaoImpl();
		BookDao bookDao = new BookDaoImpl();
		SaleRecordDao saleRecordDao = new SaleRecordDaoImpl();
		BookSaleRecordDao bookSaleRecordDao = new BookSaleRecordDaoImpl();
		InRecordDao inRecordDao = new InRecordDaoImpl();
		BookInRecordDao bookInRecordDao = new BookInRecordDaoImpl();
		this.typeService = new TypeServiceImpl(typeDao);
		this.concernService = new ConcernServiceImpl(concernDao);
		this.bookService = new BookServiceImpl(bookDao, typeDao, concernDao);
		this.saleRecordService = new SaleRecordServiceImpl(saleRecordDao, 
				bookSaleRecordDao, bookDao);
		this.inRecordService = new InRecordServiceImpl(inRecordDao, bookInRecordDao, bookDao);
		
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("ϵͳ");
		menuBar.add(menu);
		
		menu.add(sale).setAccelerator(KeyStroke.getKeyStroke('S', InputEvent.CTRL_MASK));
		menu.add(repertory).setAccelerator(KeyStroke.getKeyStroke('R', InputEvent.CTRL_MASK));
		menu.add(book).setAccelerator(KeyStroke.getKeyStroke('B', InputEvent.CTRL_MASK));
		menu.add(type).setAccelerator(KeyStroke.getKeyStroke('T', InputEvent.CTRL_MASK));
		menu.add(concern).setAccelerator(KeyStroke.getKeyStroke('T', InputEvent.CTRL_MASK));
		
		//�ý�����Ϊ��һ��ʾ����
		this.salePanel = new SalePanel(this.bookService, this.saleRecordService);
		this.add(salePanel);
		this.currentPanel = salePanel;
		//��ʼ�����۽��������
		this.salePanel.initData();
		
		//��ʼ�����������
		repertoryPanel = new RepertoryPanel(this.inRecordService, this.bookService);
		//��ʼ���鱾�������
		bookPanel = new BookPanel(this.bookService, this.typeService, 
				this.concernService);
		//��ʼ��������������
		concernPanel = new ConcernPanel(this.concernService);
		//��ʼ������������
		typePanel = new TypePanel(this.typeService);
		
		this.setJMenuBar(menuBar);
		this.setTitle("ͼ�����������ϵͳ");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setVisible(true);
	}
	
	//�л���������
	private void changePanel(CommonPanel commonPanel) {
		//�Ƴ���ǰ��ʾ��JPanel
		this.remove(currentPanel);
		//�����Ҫ��ʾ��JPanel
		this.add(commonPanel);
		//���õ�ǰ��JPanel
		this.currentPanel = commonPanel;
		this.repaint();
		this.setVisible(true);
		//���¶�ȡ����
		commonPanel.setViewDatas();
		//ˢ���б�
		commonPanel.clear();
	}
	
	public static void main(String[] args) {
		new MainFrame();
	}
}
