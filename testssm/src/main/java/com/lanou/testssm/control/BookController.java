package com.lanou.testssm.control;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.lanou.testssm.domain.Book;
import com.lanou.testssm.service.BookService;
import com.lanou.testssm.util.Util.ChinaeseEncoding;

@Controller
@RequestMapping("/book")
public class BookController {
	@Autowired
	private BookService bookService;

	private Map<String, String> map = null;
	private int pageIndex;

	// 分页显示书籍
	@RequestMapping("/page")
	public String page(ModelMap map, HttpServletRequest request, String pageIndex) {
		this.pageIndex = 1;
		if (pageIndex != null) {
			this.pageIndex = Integer.parseInt(pageIndex);
		}
		map.addAttribute("books", bookService.pageShow(this.pageIndex));
		map.addAttribute("totalPageNum", bookService.getToTalPageNum());
		return "index";
	}

	// 上传文件
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	public void upload(HttpServletRequest req) throws Exception {
		// D:\jee-2018-09\chengxu/testssm/src/main/webapp/
		map = new HashMap<String, String>();
		MultipartHttpServletRequest mreq = (MultipartHttpServletRequest) req;
		MultipartFile file = mreq.getFile("bookiii");
		String fileName = file.getOriginalFilename();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
//	    FileOutputStream fos = new FileOutputStream(req.getSession().getServletContext().getRealPath("/")+
//	            "upload/"+sdf.format(new Date())+fileName.substring(fileName.lastIndexOf('.')));
		FileOutputStream fos = new FileOutputStream("D:/jee-2018-09/chengxu/testssm/src/main/webapp/"
				+ "upload/" + sdf.format(new Date()) + fileName.substring(fileName.lastIndexOf('.')));
		fos.write(file.getBytes());
		map.put("bookimg", "upload/" + sdf.format(new Date()) + fileName.substring(fileName.lastIndexOf('.')));
		fos.flush();
		fos.close();
	}
	
	// 添加书籍
	@RequestMapping("/save")
	public String save(HttpServletRequest req,Book book) throws Exception {
		upload(req); //调用上传方法
		book.setBookname(ChinaeseEncoding.changestr(book.getBookname()));
		book.setBookimg(map.get("bookimg").toString());
		bookService.saveBook(book);
		return "redirect:/book/page.action";
	}

	// 删除
	@RequestMapping("/delete")
	public String deleteBook(ModelMap map, String bookid) {
		Book book = new Book();
		book.setBookid(bookid);
		bookService.deleteBook(book);
		return "redirect:/book/page.action";
	}

	// 修改书籍
	@RequestMapping("/update")
	//根据springmvc会自动装填
	public String updateBook(HttpServletRequest req,Book book) throws Exception {
		upload(req);
		book.setBookname(ChinaeseEncoding.changestr(book.getBookname()));
		book.setBookimg(map.get("bookimg").toString());
		bookService.updateBook(book);
		return "redirect:/book/page.action";
	}
}
