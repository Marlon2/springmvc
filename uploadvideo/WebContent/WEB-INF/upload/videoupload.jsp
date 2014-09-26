<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品添加</title>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
%>
<sb:head/>
</head>
<body>
<div align="center">
		<s:form action="uploadvideo" namespace="/upload" method="post" enctype="multipart/form-data" theme="simple">
			<table>
				<tr>
					<td>视频名：</td>
					<td><s:textfield name="videoname" cssClass="input"></s:textfield>
					</td>
				</tr>
				<tr>
					<td>视频简介：</td>
					<td>
					<s:textarea cols="18" rows="5" name="videodesp"></s:textarea>
					</td>
				</tr>
				<tr>
					<td>视频上传：</td>
					<td><s:file name="video"></s:file>
					</td>
				</tr>
				<tr>
					<td>上传者:</td>
					<td><s:textfield  name="uploaduser"></s:textfield></td>
				</tr>
				<tr id="addBtn">
					<td><s:submit value="上传"></s:submit></td>
					<td><s:reset  value="重置"></s:reset></td>
				</tr>
			</table>
		</s:form>
	</div>
</body>
</html>