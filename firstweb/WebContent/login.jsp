<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- page指令标识常用的属性包含Language用来定义要使用的脚本语言；  contentType定义JSP字符的编码和页面响应的MIME类型；   pageEncoding:jsp页面的字符编码； --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- 文档的根元素是 html，DOCTYPE在公共标识符被定义为 "-//W3C//DTD XHTML 1.0 Strict//EN" 的DTD(文档类型定义) 中进行了定义。--%>
<%-- 浏览器将寻找匹配此公共标识符的DTD并根据该DTD来对页面代码解释。如果找不到该定义文档，浏览器将使用公共标识符后面的 URL 来作为寻找 DTD的地址  --%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%--http-equiv ="Content-Type" 表示描述文档类型 charset=utf-8页面字符集， --%>
<title>Insert title here</title>
</head>
<body>
	<form action="login" method="post"> <%-- 表单数据将通过post方法跳转到login上 ，一般有俩种方法：post和get --%>
		<table>
			<tr>
				<th colspan="2">登录界面</th>
			</tr>
			<tr>
				<td>账号</td>
				<td><input type="text" id="username" name="username"
					value="${username}"></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="text" id="password" name="password"
					value="${password}"></td>
			</tr>
			<tr>
				<td><input type="submit" value="提交"></td>
				<td><font color="red">${error}</font></td> <%-- el表达式 ： ${....} --%>
			</tr>
		</table>
	</form>
</body>
</html>