<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
        div{
            font-size: 16px;
            width: 980px;
            margin: auto;
        }
        input{
            display: inline-block;
            width: 100px;
        }
        .ss{
            width: 45px;
            float: right;
        }
        
        span{
        	color:red;
        	font-size: 25px;
        }
    </style>
<body>
	<%
		 long current_time=System.currentTimeMillis();
		 long end_time=1337875200000l;
		 long time=end_time-current_time;
	 %>
	<h2><span>${text}</span></h2>
	<h3 id="showTimes"><span>10</span>  秒后自动返回到登录页面</h3>
	<h3>不能跳转，请<a href="login/login.jsp" ><span>点击这儿</span></a></h3>
</body>
<script>
	var second = 10; // 剩余秒数
	// 写一个方法，将秒数专为天数
	var toDays = function(){
	 var s = second % 60; // 秒
	
	return "<span>"+s + "</span>秒后自动返回到登录页面";
	}
	//然后写一个定时器
	window.setInterval(function(){
	 second --;

		//alert(second);
	 if(second==1){
		 window.location.href='${pageContext.request.contextPath}/login/login.jsp';
	
	 }
	 document.getElementById("showTimes").innerHTML = toDays ();
	}, 1000);
</script>
</html>