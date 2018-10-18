package com.lanou.testssm.service;

import java.util.Set;

import com.lanou.testssm.domain.Book;

public interface BookService {
	//��ҳ��ʾ
	public Set<Book> pageShow(int pageIndex);
	//��ʾ�ܵ�ҳ��
	public int getToTalPageNum();
	//����鼮
	public void saveBook(Book book);
	//ɾ���鼮
	public void deleteBook(Book book);
	//�޸��鼮
	public void updateBook(Book book);
}
