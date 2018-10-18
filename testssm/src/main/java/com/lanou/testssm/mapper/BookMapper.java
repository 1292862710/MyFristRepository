package com.lanou.testssm.mapper;

import java.util.Set;

import com.lanou.testssm.domain.Book;

public interface BookMapper {
	//��ҳ��ʾ
	public Set<Book> pageShow(int pageIndex);
	//��ѯ���е��鼮��Ŀ
	public int getAllBookNum();
	//�ϴ��鼮
	public void saveBook(Book book);
	//ɾ���鼮
	public void deleteBook(Book book);
	//�޸��鼮
	public void updateBook(Book book);
}
