<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>" />
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
	$(function() {
		$.getJSON("js/json/class_1.js", function(data) {
			$(data).each(
					function(i, json) {
						$("#index_ul_1")
								.append(
										"<li onmouseover='index_show_class_2_ul(this.value)' value="
												+ json.id + ">" + json.flmch1
												+ "</li>");
					});
		});
	})

	function index_show_class_2_ul(class_1_id) {
		$.getJSON("js/json/class_2_" + class_1_id + ".js", function(data) {
			$("#index_ul_2").empty();
			$(data).each(
					function(i, json) {
						$("#index_ul_2").append(
								"<li value="+json.id+">" + json.flmch2
										+ "</li>");
					});
		});
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>硅谷商城</title>
</head>
<body>
	<jsp:include page="sale_header.jsp"></jsp:include>
	<ul id="index_ul_1" style="width: 150px">

	</ul>
	<ul id="index_ul_2">

	</ul>
</body>
</html>