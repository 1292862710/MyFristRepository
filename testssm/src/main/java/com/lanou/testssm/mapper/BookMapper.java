package com.lanou.testssm.mapper;

import java.util.Set;

import com.lanou.testssm.domain.Book;

public interface BookMapper {
	//分页显示
	public Set<Book> pageShow(int pageIndex);
	//查询所有的书籍数目
	public int getAllBookNum();
	//上传书籍
	public void saveBook(Book book);
	//删除书籍
	public void deleteBook(Book book);
	//修改书籍
	public void updateBook(Book book);
}
