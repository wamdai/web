<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link href="${pageContext.request.contextPath}/login/css/main.css" rel="stylesheet" type="text/css">
<body>
<%
	
	if(session.getAttribute("userName")==null){
%>
<script type="text/javascript">
	 window.location.href='${pageContext.request.contextPath}/LoginServlet.do?id='+1;
</script>

<%

return;
}
%> 
 <div id="container">
        <div id="header">
            <div id="rightTop">
                当前用户：${sessionScope.userName}
				<span>
				<c:if test="${sessionScope.role== '1' }">
	    				【管理员】
				</c:if>
				</span> &nbsp;[<a href="javascript:void(0);" onclick="out();">安全退出</a>]
            </div>
            <div id="menu">
                <ul>
                    <li><a href="javascript:void(0);">首页</a></li>
                    <li class="menuDiv"></li>
                    <li><a href="${pageContext.request.contextPath}/GetDownloadListServlet.do">资源下载</a></li>
                    <li class="menuDiv"></li>
                    <li><a href="${pageContext.request.contextPath}/UserChangeServlet.do">用户管理</a></li>
                    <li class="menuDiv"></li>
                    <li><a href="${pageContext.request.contextPath}/ResourceChangeServlet.do">资源管理</a></li>
                    <li class="menuDiv"></li>
                    <li><a href="${pageContext.request.contextPath}/UserHomeServlet.do">个人中心</a></li>
                    <li class="menuDiv"></li>
                  
                </ul>
            </div>
            <div id="banner">
            </div>
        </div>
    </div>

</body>
<script>
	function out(){
		var result = confirm("确定要退出吗？????");
		if(result){
			location.href="${pageContext.request.contextPath}/TologoutServlet.do";
		}
	}
	
</script>
</html>
