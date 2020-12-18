<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <title>登录页面</title>
    <link href="${pageContext.request.contextPath}/login/css/login.css" rel="stylesheet">
  	<script src="${pageContext.request.contextPath}/login/js/jquery-3.1.1.min.js"></script>

</head>
<body>
    <div id="loginForm">
        <form action="${pageContext.request.contextPath}/LoginServlet.do" method="post" id="saveForm">
        	<input name="id" value="2" type="hidden" id="id"/>
            <p>
            	<input id="userName" name="userName" type="text" placeholder="用户名"/>
            </p>
            <p>
            	<span id="message"></span>
            </p>
            <p>
            	<input id="password" name="password" type="password" placeholder="密码?"/>       	
            </p>
            <p>
            	<span id="message2"></span>
            </p>
            <p>
            	<input id="vcode" name="yanzhengma" type="text" placeholder="验证码?"/>
                <a href="javascript:void(0);" title="看不清，换一个" onclick="changeCode()">
                	<img id="vcodeImg" src="${pageContext.request.contextPath}/CreateImageServlet.do" />
                </a>             
            </p>
             <p>
            	<span id="message3"></span>
            </p>    
           <p>
               	<input type="checkbox" name="rememberMe" id="rememberMe" onclick="Click()" />
             	<input name="dl" id="dl" value="0" type="hidden"/>
             	<span>一周以内免登陆</span>
            </p>
            <p>
                <input id="btLogin" type="button" value="登录" name="button01"></p>
         	<p>
            	<span id="message4"></span>
            </p>
               
        </form>
    </div>


</body>
<script >
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
       
        $(function () {
        	
            var flag;
            //1.获取input标签,为input标签绑定一个失去焦点事件
            $("input[name='userName']").blur(function () {
            
                //2.获取文本框中的值
                var userNameVal = $(this).val();

                //3.校验名称不能为空
                if(userNameVal=='') {
                    $("#message").html("<font color='red'>*用户名不能为空</font>");
                    return;
                }else{
                	$("#message").html("");  
                }
               
            });

            $("input[name='password']").blur(function () {
                //2.获取文本框中的值
                var passwordVal = $(this).val();              
                if(passwordVal=='') {
                    $("#message2").html("<font color='red'>*密码不能为空</font>");
                    return;
                }else{
                	$("#message2").html("");  
                }
                
            });

            $("input[name='yanzhengma']").blur(function () {
                //2.获取文本框中的值
                var yanzhengmaVal = $(this).val();

                
                if(yanzhengmaVal=='') {
                    $("#message3").html("<font color='red'>*验证码不能为空</font>");
                    return;
                }else{
                	$("#message3").html("");  
                }
                
            });
            
           
            
            //提交
            $("#btLogin").click(function () {
            	var userNameVal = $("input[name='userName']").val();
            	var passwordVal = $("input[name='password']").val();
            	var yanzhengmaVal = $("input[name='yanzhengma']").val();
            	var idVal = $("#id").val();
            	var dlVal = $("#dl").val();
            	//只要有一个没填就为真 就不能提交
            	if((userNameVal=='')||(passwordVal=='')||(yanzhengmaVal=='')){
                    alert('请全部填写后再提交');
                }else{
                	$.ajax({
                        type:'post',
                        xhrFields: {
                            withCredentials: true
                        },
                        crossDomain: true,
                        url:'${pageContext.request.contextPath}/AjaxLoginServlet.do',
                        data:{"userName":userNameVal,"password":passwordVal,
                        	"yanzhengma":yanzhengmaVal,"id":idVal,"dl":dlVal},
                        dataType:"json", //响应回来的数据为json
                        success:function (response) {
                            if (response.codes == 1) { //为1则登录失败了
                           	 $("#message4").text(response.text);    //在此页面显示登录失败信息
                            } else {
                               window.location.href="${pageContext.request.contextPath}/login/main.jsp";
                            }
                        },
                        error:function () {
                            alert("响应失败！");
                        }
                    })
                	
                	 
                }
            	
                
            });
            
        }) 
    </script>
</html>