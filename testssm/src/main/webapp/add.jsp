<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>测试上传</title>
</head>
<body>
	<form action="book/upload.action" method="post" enctype="multipart/form-data">
          <input type="file" name="bookimg"><br>
          <input type="text" name="bookid"><br>
          <input type="submit" value="上传">
     </form>
</body>
</html>