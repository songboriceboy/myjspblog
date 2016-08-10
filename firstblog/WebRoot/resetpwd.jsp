<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>重置密码</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<script type="text/javascript" src="js/jquery.min.js"></script>
	
	
	<script type="text/javascript">
function reset_form()
{
	document.getElementById('account').value = '';
	document.getElementById('password').value = '';
	document.getElementById('question').value = '';
	document.getElementById('answer').value = '';
	document.getElementById('spassword').value = '';
	return false;
}
					 
</script>
	

<script type="text/javascript">
         function check(form) {

        
          if(form.account.value==''||form.account.value.length>100) {
                alert("请输入合适账号");
                form.account.focus();
                return false;
           }
           
           if(form.password.value==''||form.password.value.length>100) {
                alert("请输入合适密码!");
                form.password.focus();
                return false;
           }
           
           if(form.question.value==''||form.question.value.length>100) {
                alert("请输入合适问题!");
                form.question.focus();
                return false;
           }
           
           if(form.answer.value==''||form.answer.value.length>10) {
                alert("请输入合适回答!");
                form.answer.focus();
                return false;
           }
          if(form.spassword.value==''||form.spassword.value.length>10) {
                alert("请输入合适确认密码!");
                form.spassword.focus();
                return false;
           }
           
            if(form.password.value!=form.spassword.value) {
                alert("两次输入密码不一致!");
                form.spassword.focus();
                return false;
           }
           
         
         
         return true;
         }
</script>








	
	
	
	<style>

.div{ text-align:center}
/* css注释：为了观察效果设置宽度 边框 高度等样式 */

</style>
	
	

  </head>
  
  <body>
  
  
   <div  class="div">
   </br>
   </br>
   </br>
   </br>
  
  <form action="ResetPwd" method="post">
  
      重置的账号： <input type="text" id="account" name="account">
  </br>
   </br>
      问题  ：<input type="text" id="question" name="question">
    </br>
   </br>
     问题答案  ：<input type="text" id="answer" name="answer">   
    </br>
   </br> 
   新的密码 ：<input type="text" id="password" name="password">      
   
    </br>
   </br> 
   
    确认新的密码 ：<input type="text" id="spassword" name="spassword">      
   
    </br>
   </br>   
   <input type="submit" value="发送" onclick="return check(this.form)">    
   <input type="button" value="重置"   onclick="reset_form();">    
</form> 
   
   </div>
  
  
  
   <%
String msg="";
msg=(String)session.getAttribute("ms");
if(msg==null){
msg="";
}else{
session.removeAttribute("ms");
}


%>

<%=msg %>
  
<script type="text/javascript">
window.onload=function(){
if("<%=msg%>"!="")

{alert("<%=msg%>");}

}				 
</script>  
  
  
  
  
  </body>
</html>
