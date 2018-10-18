package com.lanou.testssm.serviceimpl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lanou.testssm.domain.Book;
import com.lanou.testssm.mapper.BookMapper;
import com.lanou.testssm.service.BookService;

@Service("bookService")
@Transactional
public class BookServiceImpl implements BookService{
	@Autowired
	private BookMapper bookMapper;
	//分页显示
	@Override
	public Set<Book> pageShow(int pageIndex) {
		return bookMapper.pageShow((pageIndex - 1)*3);
	}
	//得到总的页吗
	@Override
	public int getToTalPageNum() {
		int totalPageNum = 0;
		int allBookNum = bookMapper.getAllBookNum();
		if (allBookNum % 3 ==0) {
			totalPageNum = allBookNum /3;
		}else {
			totalPageNum = allBookNum / 3 + 1;
		}
		return totalPageNum;
	}
	//添加书籍
	@Override
	public void saveBook(Book book) {
		bookMapper.saveBook(book);
	}
	//删除书籍
	@Override
	public void deleteBook(Book book) {
		bookMapper.deleteBook(book);
	}
	//修改书籍
	@Override
	public void updateBook(Book book) {
		bookMapper.updateBook(book);
	}
}
