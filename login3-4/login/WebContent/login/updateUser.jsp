<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>信息修改页面</title>
 <link href="${pageContext.request.contextPath}/login/css/register.css" rel="stylesheet">
  	<script src="${pageContext.request.contextPath}/login/js/jquery-3.1.1.min.js"></script>
</head>
<body>

 <div id="loginForm">
		 <p>
			<span id="zhuce">信息修改</span>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<span><a href="login.jsp">已有账号，去登录</a></span>
		 </p>
 	
        <form action="${pageContext.request.contextPath}/UpdateUserByIDServlet.do" method="post" id="form01">
        <input name="id" value="${requestScope.user.id}" type="hidden"/>
            <p><input id="userName" name="userName" value="${requestScope.user.userName}" type="text" placeholder="用户名""/>
            </p>
            <p>
             <span id="userNamemessage"></span>
            </p>
           
            <p><input id="Name" name="Name" type="text" value="${requestScope.user.name}" placeholder="真实姓名"/>
            </p>
 			<p>
             <span id="Namemessage"></span>
            </p>
                
            <p><input id="email" name="email" type="text" value="${requestScope.user.email}" placeholder="邮箱"/>
            </p>
			<p>
             <span id="emailmessage"></span>
            </p>
             
            <p>
            	<select id="shengfen" name="shengfen" onchange="test1();">
            		<option value=" " id="shengfen1" >请选择省份</option>
            		<option value="" selected="selected">${requestScope.user.shengfen}</option>
            	</select>
             </p>			
            <p>
             	<span id="shengfenmessage"></span>
            </p>
           
            <p>
            	<select id="city" name="city" >
            		<option value=" " id="city1" >请选择城市</option>
            		<option value="" selected="selected">${requestScope.user.city}</option>
            	</select>
             </p>
			<p>
             	<span id="citymessage"></span>
            </p>
            <p><input id="password" name="password" type="password" value="${requestScope.user.password}" placeholder="密码"/>   	
            </p>
            <p>
               <span id="passwordmessage"></span>
            </p>
            
            <p><input id="password2" name="password2" type="password" value="${requestScope.user.password}" placeholder="确认密码"/> 	
            </p>
            <p>
            	<span id="password2message"></span>
            </p>
            
            <p>
                <input id="btLogin" type="button" value="修改" onClick="check()"></p>
        </form>
    </div>
</body>
<script >
	var flag1=/^[a-zA-Z]+[0-9a-zA-Z]{3,14}$/ //只能使用英文字母和数字，以字母开头，长度为4到15个字符
    var flag2=/^[\u4e00-\u9fa5]{2,4}$/;//2-4长度的中文
    var flag3=/^([a-zA-Z0-9_.-]+)@([da-z.-]+).([a-z.]{2,6})$/; //邮箱验证
    var flag4=/^.{4,}$/; //最小长度为4
    
    var sheng =$("#shengfen");
    var shi =$("#city");
  
	var f1,f2,f3,f4,f5,f6,f7;
    var shengJson =[];
    var shiJson =[];
    fn();  //加载页面的时候就直接加载这个初始化省份的信息


  		//省份及城市信息的显示
		//1、加载数据
		function fn(){
		    $.ajax({
		        "url" : "${pageContext.request.contextPath}/login/city.json",
		        "dataType" : "json",
		        "type" : "GET",
		        "success" :function(data){
		        	 //把返回的数据加载到省份对应的下拉框中
		            shengJson = data.city;
		            var op01="";
		
		            //遍历shengJson里的name属性写入到option标签里
		            $(shengJson).each(function(){
		            	//在页面中创建标签
		                op01 +="<option id='shengfen1' value='"+this.name+"'>"+this.name+"</option>"
		            });
		          //把创建的option标签添加到select标签里去
		            sheng.append(op01);
		        }
		    });
		}
		
		//2.选择一个省份后，在第二个下拉框中加载对应这个省份所有的市区信息
		sheng.change(function(){
			 //加载数据前把之前的数据清空
		    shi.children().not(":first").remove();
		    
		
		    //遍历所有的省份信息，判断用户选择的身份信息和后台的储存位置是否对应
		    for(var i =0; i<shengJson.length ; i++){
		        if(this.value == shengJson[i].name){
		        	//加载这个省份所对应的所有市区信息
		            shiJson = shengJson[i].city;
		            var op02="";
		
		            $(shiJson).each(function(){
		                op02 +="<option id='city' value='"+this.name+"'>"+this.name+"</option>"
		            });
		          //把创建的option标签添加到select标签里去
		            shi.append(op02);
		
		        }
		    }
		});
		
		//正则判断
        $(function () {
        	//1.获取input标签,为input标签绑定一个失去焦点事件
            $("input[name='userName']").blur(function () {
            
                //2.获取文本框中的值
                var userNameVal = $(this).val();

                //3.校验名称不能为空
                if(userNameVal=='') {
                    $("#userNamemessage").html("<font color='red'>*用户名不能为空</font>");
                }else if(!flag1.test(userNameVal)){
                    $("#userNamemessage").html("<font color='red'>*只能使用英文字母和数字，以字母开头，长度为4到15个字符</font>");
                }else if(true){
                	$.ajax({
                        type:'post',
                        xhrFields: {
                            withCredentials: true
                        },
                        crossDomain: true,
                        url:'${pageContext.request.contextPath}/UserNameServlet.do',
                        data:{"userName":userNameVal},
                        dataType:"json", //响应回来的数据为json
                        success:function (response) {
                            if (response.code == 1) { //为1则用户名重复了
                           	 $("#userNamemessage").html("<font color='red'>"+response.text+"</font>");   //在此页面显示失败信息
                            } else {
                            	$("#userNamemessage").html(""); 
                            	f1=true;
                            }
                        },
                        error:function () {
                            alert("响应失败");
                        }
                    })
                }
               
            });

            $("input[name='Name']").blur(function () {
                
            	//2.获取文本框中的值
                var Name = $(this).val();

              //3.校验名称不能为空
                if(Name=='') {
                    $("#Namemessage").html("<font color='red'>*真实姓名不能为空</font>");
                    
                }else if(!flag2.test(Name)){
                    $("#Namemessage").html("<font color='red'>*真实姓名只能是2-4长度的中文</font>");
                }else{
                	$("#Namemessage").html("");  
                	f2=true;
                }
               
            });
            
            
            
            $("input[name='email']").blur(function () {
                
            	//2.获取文本框中的值
                var email = $(this).val();

              //3.校验名称不能为空
                if(email=='') {
                    $("#emailmessage").html("<font color='red'>*邮箱不能为空</font>");
                }else if(!flag3.test(email)){
                    $("#emailmessage").html("<font color='red'>*邮箱地址不合法！</font>");
                }else if(true){
                	$.ajax({
                        type:'post',
                        xhrFields: {
                            withCredentials: true
                        },
                        crossDomain: true,
                        url:'${pageContext.request.contextPath}/EmailServlet.do',
                        data:{"email":email},
                        dataType:"json", //响应回来的数据为json
                        success:function (response) {
                            if (response.code == 1) { //为1则邮箱重复
                           	 $("#emailmessage").html("<font color='red'>"+response.text+"</font>");    //提示
                            } else {
                            	$("#emailmessage").html(""); 
                            	f1=true;
                            }
                        },
                        error:function () {
                            alert("回响失败");
                        }
                    })
                }
               
            });
            
			/* $("#shengfen1").blur(function () {
				alert(111111111111);          
                
                var shengfen = $(this).val();

               
                if(shengfen=='') {
                    $("#shengfenmessage").html("<font color='red'>*</font>");
                }else{
                	$("#shengfenmessage").html("");
                	f4=true;
                }
               
            }); */
          
		
			
			
            
			$("input[name='password']").blur(function () {
                
                var password = $(this).val();

               
                if(password=='') {
                    $("#passwordmessage").html("<font color='red'>*密码不能为空</font>");
                }else if(!flag4.test(password)){
                    $("#passwordmessage").html("<font color='red'>*密码最少为4位</font>");
                }else{
                	$("#passwordmessage").html("");  
                	f6=true;
                }
               
            });
			
			$("input[name='password2']").blur(function () {
				 var password = $("input[name='password']").val();
              
                var password2 = $(this).val();

                
                if(password2!=password) {
                	$("#password2message").html("<font color='red'>*两次密码不一致</font>");  
                }else{
                	$("#password2message").html("");  
                	f7=true;
                }
               
            });
            
			
			 /*  进不去 只能用提交点击事件验证
			 	$("input[name='shengfen']").change(function () {
				 var shengfen = $(this).val();
				alert("sssssssffffffff"+shengfen);
	         
	            if(shengfen==' ') {
	                $("#shengfenmessage").html("<font color='red'>*</font>");
	            }else{
	            	$("#shengfenmessage").html("");
	            	f5=true;
	            } 
              
           });  */

        })
       
       
       
        function check(){
			var form01 = document.getElementById("form01");
			var shengfen1 = document.getElementById("shengfen").value;
			var city1 = document.getElementById("city").value;
			if(shengfen1==" "){
				$("#shengfenmessage").html("<font color='red'>*省份不能为空</font>");
			}
			if(city1==" "){
				$("#citymessage").html("<font color='red'>*城市不能为空</font>");
			}
			
			/* if(f1){ */
				//alert("模拟提交");
				form01.submit();	
			/* }else{
				alert("信息未全部填写，请继续填写！");
			} */
		
		}
            
    </script>
</html>