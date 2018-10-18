<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<% 
	//路径方法一
	String path = request.getContextPath();
	String basePath0 = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	System.out.println(basePath0);
	//路径方法二
	StringBuffer basePathold = request.getRequestURL();
	String basePath = basePathold.substring(0,basePathold.lastIndexOf("/")+1);
	System.out.println(basePath);
%>
<html>
<head>
<style>
	table tr,td{
		text-align:center;
	}
	table tr td a{
		text-decoration:none;
		color:blue;
		font-size:14px;
		font-family:"宋体";
	}
</style>
<meta charset="utf-8">
<title>显示页面</title>
</head>
<body>
	<table border="1" width="80%" height="80%" align="center">
		<tr>
			<td>书籍编号</td>
			<td>书籍姓名</td>
			<td>书籍价格</td>
			<td>书籍图片</td>
			<td colspan="3">操作</td>
		</tr>
		<c:forEach var="book" items="${books }">
			<tr>
				<td>${book.bookid }</td>
				<td>${book.bookname }</td>
				<td>${book.bookprice }</td>
				<!-- C:/Users/admin/eclipse-workspace/testssm/src/main/webapp/upload -->
				<td><img src="<%=basePath%>/${book.bookimg }" width="130px" height="150px"/></td>
				<td><a href="<%=basePath%>book/delete.action?bookid=${book.bookid}">删除书籍</a></td>
				<td><a href="<%=basePath%>updateBook.jsp?bookid=${book.bookid}&bookname=${book.bookname}&bookprice=${book.bookprice}&bookimg=${bookimg}">修改书籍</a></td>
				<td><a href="<%=basePath %>addBook.jsp">添加书籍</a></td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="7">
				<script>
					for(var i = 0 ; i < '${totalPageNum}' ; i++){
						document.write("<a href='<%=basePath%>book/page.action?pageIndex="+(i+1)+"'>"+(i+1)+"</a>");
					}
				</script>
			</td>
		</tr>
	</table>
</body>
</html>