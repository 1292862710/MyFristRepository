package com.lanou.testssm.service;

import java.util.Set;

import com.lanou.testssm.domain.Book;

public interface BookService {
	//分页显示
	public Set<Book> pageShow(int pageIndex);
	//显示总的页码
	public int getToTalPageNum();
	//添加书籍
	public void saveBook(Book book);
	//删除书籍
	public void deleteBook(Book book);
	//修改书籍
	public void updateBook(Book book);
}
