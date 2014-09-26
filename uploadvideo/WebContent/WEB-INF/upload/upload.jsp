<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="/struts-bootstrap-tags" prefix="sb" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件上传</title>
<sb:head/>
</head>
<body>
<form action="${pageContext.request.contextPath}/upload2/upload2.do" enctype="multipart/form-data" method="post">
            文件:<input type="file" name="image" accept=".avi,.mp4" />
         <input type="submit" value="上传" />
</form>
<br/>
<%-- <s:fielderror /> --%>
</body>
</html>