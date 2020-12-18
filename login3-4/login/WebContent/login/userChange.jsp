<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <html>

 <head>
     <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <title>用户管理页面</title>
 </head>

 <body>

     <div>
         <h1>用户管理页面</h1>
         <p class="back"><a href="${pageContext.request.contextPath}/login/main.jsp">返回首页</a></p>
         <form action="${pageContext.request.contextPath}/UserChangeServlet.do" method="post" style="text-align: center" id="form2">
             <%--1.用户名的模糊查询（string） 2.用户名的模糊查询（string）  3.用户名的模糊查询（string）  4.省份的模糊查询--%>
                 <%--value属性值会回显数据--%>
             <input type="text" id="userName" name="userName" placeholder="输入用户名" value="${requestScope.userName}">
             <input type="text" name="Name" id="Name"  placeholder="输入姓名"  value="${requestScope.Name}">
             <input type="text" name="email" id="email"  placeholder="输入邮箱地址" value="${requestScope.email}">
             <input type="text" name="shengfen" id="shengfen" placeholder="输入省份" value="${requestScope.shengfen}">
             <!-- 当前页码 -->
             <input type="hidden" name="pageNos" value="1">
             <!-- 操作 -->
             <input type="submit" value="查找" onclick="search()">
             <input type="button" value="清空" onclick="clear()">
             <input type="button" value="增加" onclick="add()" >
             <input type="button" value="删除" onclick="delAll()">
             <input type="button" value="修改" onclick="update()">
         </form>

         <%-- 展示区 --%>
         	
       
         <table border="1" align="center" cellpadding="15" cellspacing="0">
             <tr id="firsttr">
                 <td><input type="checkbox" name="checkboxAll" onclick="cilckAll()"><a href="javascript:delAll()">全选</a></td>
                 <td>用户名 </td>
                 <td>中文名 </td>
                 <td>邮箱 </td>
                 <td>省份 </td>
                 <td>城市 </td>
                 <td>操作 </td>
             </tr>
            <!-- 遍历所有用户信息 -->
            <form action="${pageContext.request.contextPath}/DeleteAllServlet.do" method="post" name="from">
            <c:if test="${not empty requestScope.pb.list}">
              <c:forEach var="user" items="${requestScope.pb.list}" varStatus="vs">
               	<!-- 	隔行变色 -->
               <tr >
                   <td><input type="checkbox" name="checkbox" value="${user.id}" onclick="cilcks()"></td>
                 <td>${user.userName}</td>
                 <td>${user.name}</td>
                 <td>${user.email}</td>
                 <td>${user.shengfen}</td>
                 <td>${user.city}</td>
                 <td><a onclick="return confirm('确定删除该信息吗？')" href="${pageContext.request.contextPath}/DelUserServlet.do?id=${user.id}">删除</a>
                     <a href="${pageContext.request.contextPath}/FindUserByIDServlet.do?id=${user.id}">修改</a>
                 </td>
              </tr>
              </c:forEach>
            </c:if>
         	</form>
             <tr align="center">
                 <td colspan="11">
 	<div id="footer">
                <a href="javascript:pageNos(1)">首页</a>
                <c:if test="${requestScope.pb.pageNos > 1}">
                 	<a href="javascript:pageNos(${requestScope.pb.pageNos-1})">上一页</a>
                </c:if>
                
               <!--  显示十页数据 -->
               <c:forEach var="i" begin="${requestScope.pb.start}" end="${requestScope.pb.end}">
               		<c:choose>
               			<c:when test="${i==requestScope.pb.pageNos}">
     						[ ${i} ] 
     					</c:when>
     					<c:otherwise>
               				<a href="javascript:pageNos(${i})">${i}</a>
               			</c:otherwise>
               		</c:choose>
               		
               </c:forEach>
               
               <c:if test="${requestScope.pb.pageNos<requestScope.pb.page}">
               		<a href="javascript:pageNos(${requestScope.pb.pageNos+1})">下一页</a>
                </c:if>
                
                <a href="javascript:pageNos(${requestScope.pb.page})">尾页</a>
                ${requestScope.pb.pageNos}/ ${requestScope.pb.page}页
            </div>
				</td>
             </tr>
         </table>
     </div>
 </body>
 <script src="${pageContext.request.contextPath}/login/js/jquery-3.1.1.min.js"></script>

 <script type="text/javascript">
 	//隔行变色功能
 $ ( function () {
	  //1.把奇数行标签的背景色设置为天蓝色.
	  $('tr:odd').css('backgroundColor','skyblue');
	  //2.把偶数行标签的背景色设置为红色.
	  $('tr:even').css('backgroundColor','red');
	  //3. 鼠标移入事件
	  var bgColor=null;//先声明一个变量把颜色存起来
	  $('tr').mouseover(function ( ) {
	   // 3.1在鼠标移入到这个标签时,没有改变颜色之前,把他之前的颜色给记录下来.
	   bgColor=$(this).css('backgroundColor');
	   $(this).css('backgroundColor','green')
	  })
	  //4. 鼠标移出事件
	  $('tr').mouseout(function ( ) {
	   $(this).css('backgroundColor',bgColor)
	  })
	 } )
 
		 function add(){
	 		location.href="${pageContext.request.contextPath}/login/register.jsp";
	 	}
	 	
 
	    function pageNos(pageNos){
	    	document.getElementsByName("pageNos")[0].value=pageNos;
	    	var f = document.getElementById("form2");
	    	f.submit();
	    }
    
    
		function view(sid){
		    	
		    	//获取单个行的属性值
		        var checkbox =document.getElementsByName("checkbox");
		        var flag=false;
		       
		        for(var i=0;i<checkbox.length;i++){
		            if (checkbox[i].checked && checkbox[i].value == sid){
		            		flag=true;
		 	                location.href="${pageScope.request.contextPath}/JSP/ViewStudentServlet?sid="+sid;	
		            }
		        } 
		        if (!flag){
		            alert("请满足条件后再查看详情！！")
		        }
		
		    }
    
    function  update(sid){
    	
    	//获取单个行的属性值
        var checkbox =document.getElementsByName("checkbox");
        var flag=false;
       
        for(var i=0;i<checkbox.length;i++){
            if (checkbox[i].checked && checkbox[i].value == sid){
            		flag=true;
 	                location.href="${pageScope.request.contextPath}/JSP/FindStudentServlet?sid="+sid;	
            }
        } 
        if (!flag){
            alert("请满足条件后再修改！！")
        }

    }
    
    
	    function  del(sid){
	    	
	    	//获取单个行的属性值
	        var checkbox =document.getElementsByName("checkbox");
	        var flag=false;
	       
	        for(var i=0;i<checkbox.length;i++){
	            if (checkbox[i].checked && checkbox[i].value == sid){
	            	if(confirm("确定删除数据吗？")){
	            		flag=true;
	 	                location.href="${pageScope.request.contextPath}/JSP/DeleteServlet?sid="+sid;
	 	          	}
	            }
	        } 
	        if (!flag){
	            alert("请满足条件后再删除！！")
	        }
	
	    }
    
	    
	    function cilckAll(){
            //获取全选按钮和多选按钮
            var clickAll = document.getElementsByName("checkboxAll")[0];
            var checkbox = document.getElementsByName("checkbox");

            if(clickAll.checked==true){
                for(var i=0;i<checkbox.length;i++){
                    checkbox[i].checked = true;
                }
            }else{
            	 for(var i=0;i<checkbox.length;i++){
                     checkbox[i].checked = false;
                 }
            }
            
        }
        
        
        function cilcks(){
            //获取全选按钮和多选按钮
            var clickAll = document.getElementsByName("checkboxAll")[0];
            var checkbox = document.getElementsByName("checkbox");

            var count =0;
            
            //如果下面有复选框,没有有被勾选 全选按钮不被选中
     	    for(var i=0;i<checkbox.length;i++){
                if (checkbox[i].checked == false){
                	clickAll.checked = false;
                    break;
                }else {
                	//勾选的话就+1
                    count++;
                }

            }
			//如果下面的话全被勾选，总选框被勾选
            if (count == checkbox.length){
                clickAll.checked  = true;
            }
        }
        
        
        function delAll(){
        	var from = document.getElementsByName("from")[0];
        	var checkbox = document.getElementsByName("checkbox");
        	for(var i=0;i<checkbox.length;i++){
	            if (checkbox[i].checked){
	            	from.submit();
	            	break;
	            }else{
	            	alert("请至少选中一项再删除！");
	            	break;
	            }
	            
	        } 
  
        }
    </script>
 </html>