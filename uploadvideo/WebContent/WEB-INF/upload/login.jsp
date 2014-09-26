<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page import="java.util.Random" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
<sb:head/>
<%
String basePath = request.getScheme() + "://"
		+ request.getServerName() + ":" + request.getServerPort()
		+ request.getContextPath();
String basePath2 = request.getScheme() + "://"
		+ request.getRemoteHost() + ":" + request.getLocalPort()
		+ request.getContextPath();
%>
<style type="text/css">
.container {
	width: 400px;
}

#sub {
	background-color: aqua;
	border: hidden;
	width: 300px;
	height: 30px;
}

a,img {
	cursor: pointer;
}
</style>
</head>
<body>
	<div class="container">
		<div class="page-header well">
			<h3>用户登陆</h3>
			<div id="imageDiv">
			</div>
			<div class="well">
				<s:form action="login" namespace="/admin" id="loginForm" theme="simple">
			   <table>
			     <tr> 
			       <td><b>用户名</b>&nbsp;&nbsp;&nbsp;<s:textfield name="userEntity.name" cssClass="input"></s:textfield></td>
			     </tr>
			     <tr>
			       <td><b>密       码</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:password name="userEntity.password" cssClass="input"></s:password></td>
			     </tr>
                  <tr>
                    <td align="center"><font color="red"><b><s:property value="message"/></b></font></td>
                  </tr>
			     <tr>
			       <td><s:submit value="登陆" id="sub"></s:submit> </td>
			     </tr>					
			   </table>				
				</s:form>
			</div>
		</div>
	</div>
</body>
</html>