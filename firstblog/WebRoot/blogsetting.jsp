<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<%@ page import="dal.admindal"%>

<%

if(admindal.sumadmin()!=0){
response.sendRedirect("login.jsp");
}

 %>


<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>首次运行配置博客</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	
		<style>

.div{ text-align:center}

</style>
	
	
	
	
	
	<script type="text/javascript">
function reset_form()
{
	document.getElementById('dburl').value ='';
	document.getElementById('dbname').value ='';
	document.getElementById('dbuser').value ='';
	document.getElementById('dbpwd').value ='';
	document.getElementById('sdbpwd').value ='';
	document.getElementById('account').value ='';
	document.getElementById('question').value ='';
	document.getElementById('answer').value ='';
	document.getElementById('password').value ='';
	document.getElementById('spassword').value ='';
	return false;
}
					 
</script>
    
    <script type="text/javascript">
         function check(form) {

        
          if(form.dburl.value==''||form.dburl.value.length>100) {
                alert("请输入合适数据库地址!");
                form.dburl.focus();
                return false;
           }
         
          if(form.dbname.value==''||form.dbname.value.length>100) {
                alert("请输入合适数据库名!");
                form.dbname.focus();
                return false;
           }
           
            if(form.dbuser.value==''||form.dbuser.value.length>100) {
                alert("请输入合适数据库用户名!");
                form.dbuser.focus();
                return false;
           }
           
            if(form.dbpwd.value==''||form.dbpwd.value.length>100) {
                alert("请输入合适数据库密码!");
                form.dbpwd.focus();
                return false;
           }
           
            if(form.sdbpwd.value==''||form.sdbpwd.value.length>100) {
                alert("请输入合适数据库确认密码!");
                form.sdbpwd.focus();
                return false;
           }
         
         
         
            if(form.dbpwd.value!=form.sdbpwd.value) {
                alert("两次数据库确认密码!");
                form.sdbpwd.focus();
                return false;
           }
         
         
         
          if(form.account.value==''||form.account.value.length>100) {
                alert("请输入合适管理员账号!");
                form.account.focus();
                return false;
           }
         
          if(form.question.value==''||form.question.value.length>100) {
                alert("请输入合适问题!");
                form.question.focus();
                return false;
           }
           
            if(form.answer.value==''||form.answer.value.length>100) {
                alert("请输入合适回答!");
                form.answer.focus();
                return false;
           }
           
            if(form.password.value==''||form.password.value.length>100) {
                alert("请输入合适博客管理员密码!");
                form.password.focus();
                return false;
           }
           
            if(form.spassword.value==''||form.spassword.value.length>100) {
                alert("请输入合适博客管理员确认密码!");
                form.spassword.focus();
                return false;
           }
         
          if(form.spassword.value!=form.password.value) {
                alert("博客管理员两次密码不一致");
                form.spassword.focus();
                return false;
           }
         
         
         
         return true;
         }
</script>
	
	
	
	
	
	
	

  </head>
  
  <body>
  
  
   <div  class="div">
   </br>
   </br>
   </br>
   </br>
  
  <form action="BlogSetting" method="post">
  
    设置 数据库地址 <input type="text" id="dburl" name="dburl">
      例如：jdbc:mysql://127.0.0.1:3306/
  </br>
   </br>
       设置 数据库库名 <input type="text" id="dbname" name="dbname">
      例如：blog, myblog
  </br>
   </br>
      设置数据库用户名  ：<input type="text" id="dbuser" name="dbuser">
    </br>
   </br>
    设置数据库密码：<input type="text" id="dbpwd" name="dbpwd">
    </br>
   </br>
    确定数据库密码：<input type="text" id="sdbpwd" name="sdbpwd">
    </br>
   </br>
  
  
  
  
    设置 博客管理员账号： <input type="text" id="account" name="account">
  </br>
   </br>
      设置问题  ：<input type="text" id="question" name="question">
    </br>
   </br>
     设置问题答案  ：<input type="text" id="answer" name="answer">   
    </br>
   </br> 
  设置 博客管理员密码 ：<input type="text" id="password" name="password">      
   
    </br>
   </br> 
   博客管理员  密码确定 ：<input type="text" id="spassword" name="spassword">      
   
    </br>
   </br> 
   
   <input type="submit" value="发送" onclick="return check(this.form)">    
   <input type="button" value="重置"   onclick="reset_form();">    
</form> 
   
   </div>
  
  
    
  </body>
</html>
