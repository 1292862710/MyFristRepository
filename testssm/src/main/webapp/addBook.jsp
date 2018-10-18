<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta charset="UTF-8">
<title>添加书籍页面</title>
</head>
<body>
	<form action="<%=basePath%>book/save.action" method="post" enctype="multipart/form-data">
		书籍编号<input type="text" name="bookid" /></br>
		书籍名字<input type="text" name="bookname" /></br>
		书籍价格<input type="text" name="bookprice" /></br>
		书籍图片<input type="file" name="bookiii" /></br>
		<input type="submit" value="上传"/>
	</form>
</body>
</html>