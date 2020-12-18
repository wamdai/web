<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
    <title>登录页面</title>
    <link href="${pageContext.request.contextPath}/login/css/login.css" rel="stylesheet">
   
</head>

<body>
    <div id="loginForm">
        <form action="${pageContext.request.contextPath}/LoginServlet.do" method="post">
        <input name="id" value="2" type="hidden"/>
            <p><input id="userName" name="userName" type="text" placeholder="用户名"/></p>
            <p><input id="password" name="password" type="password" placeholder="密码"/></p>
            <p><input id="vcode" name="yanzhengma" type="text" placeholder="验证码"/>
                 <a href="javascript:void(0);" title="看不清，换一个" onclick="changeCode()">
                 	<img id="vcodeImg" src="${pageContext.request.contextPath}/CreateImageServlet.do" />
                 </a>
                
            </p>
               
           <p>
               	<input type="checkbox" name="rememberMe" id="rememberMe" onclick="Click()" />
             	<input name="dl" id="dl" value="0" type="hidden"/>
             	<span>一周以内免登陆</span>
            </p>
            <p>
                <input id="btLogin" type="submit" value="登录"></p>
        </form>
    </div>


</body>
<script>
        function changeCode(){
            var codeImg=document.getElementById("vcodeImg");
            codeImg.src="${pageContext.request.contextPath}/CreateImageServlet.do?t=" + Math.random();
            
        }
        function Click(){
            var click=document.getElementById("rememberMe");
            var dl=document.getElementById("dl");
            if(click.checked==true){
            	dl.value="1";
            } 
        }
    </script>
</html>