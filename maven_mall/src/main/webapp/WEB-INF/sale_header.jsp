<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath %>" />
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
    var cookie_nch="";
	$(function (){
		//对cookie的json字符串转码
		var cookie_json = decodeURIComponent(cookie_util("user_login_cookie"));
		//转化成json对象
		cookie_nch =  $.parseJSON(cookie_json).yh_nch;
		$("#header_nch").html(cookie_nch);
		
	});
	
	function cookie_util(key){
		var cookie_value = "";
		var cookies = document.cookie;
		cookies =  cookies.replace(/\s/,"");
		var cookie_array = cookies.split(";");
		for(i=0;i<cookie_array.length;i++){
			var cookie_obj = cookie_array[i].split("=");
			if(cookie_obj[0]==key){
				cookie_value = cookie_obj[1]
			}
		}
		return cookie_value;
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>硅谷商城</title>
</head>
<body>
	<c:if test="${user_login==null}">
		<span style="color:red" id = "header_nch"></span><a href="goto_login0210.do">登录</a>  注册
	</c:if>
	<c:if test="${user_login!=null}">
		欢迎,${user_login.yh_nch}  我的订单   <a href="logout.do">登出</a>
	</c:if>
	<hr>
</body>
</html>