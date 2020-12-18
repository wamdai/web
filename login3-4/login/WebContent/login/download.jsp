<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>下载页面</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/login/css/download.css">
</head>
<body>
<h1>资源下载</h1>
		<div class="container">
		<c:if test="${not empty sessionScope.list}">
			<c:forEach var="list" items="${list}"  varStatus="vs">
				<ul>
					<li>
					<p class="name">${list.name}</p>
						<div class="pic-txt">
							<img class="img-area" src="${pageContext.request.contextPath}/login/images/doc.png">
							<p class="txt-area">
								<span class="">${list.description}</span>
								<span class="tit-sub">
									<i class="space">时间：2020-09-17</i>
									<i class="space">大小：13.80 MB</i>
									<i>星级：</i>
									<i class="stars">
										<span style="width:100.0%"></span>
									</i>
								</span>
							</p>
						</div>
						<a class="dl-btn" href="${pageContext.request.contextPath}/DownloadServlet.do?id=${list.id}" title="点击下载">下载</a>
						
					</li>
				</ul>
				</c:forEach> 
			</c:if>
			
			<p class="back"><a href="${pageContext.request.contextPath}/login/main.jsp">返回首页</a></p>
		</div>
	

	</body>
</html>