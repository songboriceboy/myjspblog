<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@ page import="utils.option"%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>个人博客配置</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<script src="js/admin/jquery-1.5.2.min.js" type="text/javascript"></script>
	<script src="js/admin/ideshow.js" type="text/javascript"></script>
	<script src="js/admin/jquery.tablesorter.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="js/admin/jquery.equalHeight.js"></script>



<script type="text/javascript">
function reset_form()
{
	document.getElementById('blogname').value ='';
	document.getElementById('weibourl').value ='';
	document.getElementById('tweibourl').value ='';
	document.getElementById('pageSize').value ='';
	//document.getElementById('weixinpicsrc').value ='';
	//document.getElementById('logopicsrc').value ='';
	document.getElementById('ICPLicensing').value ='';
	
	return false;
}
					 
</script>
    
    <script type="text/javascript">
         function check(form) {

        
          if(form.blogname.value.length>100) {
                alert("请输入合适博客名");
                form.blogname.focus();
                return false;
           }
           
           if(form.weibourl.value.length>100) {
                alert("请输入合适微博地址!");
                form.weibourl.focus();
                return false;
           }
           
           if(form.tweibourl.value.length>100) {
                alert("请输入合适腾讯微博地址!");
                form.tweibourl.focus();
                return false;
           }
           
           if(form.pageSize.value.length>10) {
                alert("请输入合适大小!");
                form.pageSize.focus();
                return false;
           }
           
           
             if(form.ICPLicensing.value.length>200) {
                alert("请输入合适大小!");
                form.ICPLicensing.focus();
                return false;
           }
           
     /*      if(form.weixinpicsrc.value==''||form.weixinpicsrc.value.length>100) {
                alert("请输入合适二维码图!");
                form.weixinpicsrc.focus();
                return false;
           }
           
           if(form.logopicsrc.value==''||form.logopicsrc.value.length>100) {
                alert("请输入合适logo!");
                form.logopicsrc.focus();
                return false;
           }
           
           
       */    
           
           
         
         
         return true;
         }
</script>





	<style>

.div{ text-align:center}

</style>

  </head>
  
  <body>
  
  
      <%
String login =(String)session.getAttribute("Login");
if(login==null){
%>
<font  size="4"  color="red">未登录     </font> 2s后自动返回登陆页
<a href="login.jsp">   <font  size="4"  color="green">手动返回登录页</font>              </a>

     
<%       
      response.setHeader("Refresh","2;URL=login.jsp");
}else{

%>
<font  size="4"  color="red">已登录     </font> <a href="LogOut">退出</a>
<% 
}  
 out.print("</hr>");
 out.print("<br>");
%>
     
     
     
     
     
       <div  class="div">
   </br>
   </br>
   </br>
   </br>
  
  <form action="OptionUpdate" method="post">
  
   
   
   微博地址 <input type="text" id="weibourl" name="weibourl">
    </br>
   </br>

腾讯微博地址  <input type="text" id="tweibourl" name="tweibourl">
    </br>
   </br>
 
 每页显示条数（包括类别 心情  博文）  <input type="text" id="pageSize" name="pageSize">
    </br>
   </br>
   
博客名 :<input type="text" id="blogname" name="blogname">
    </br>
   </br>
   
   
备案  <input type="text" id="ICPLicensing" name="ICPLicensing" >
    </br>
   </br>   
   
<!--  
  请选择微信图片<input type='file' id="weixinpicsrc" name="weixinpicsrc" size='50'>
  
  </br>
   </br>
     请选择博客logo图片<input type='file' id="logopicsrc" name="logopicsrc" size='50'>
   </br>
   </br>
 -->  
 
   <input type="submit" value="发送" onclick="return check(this.form)">    
   <input type="button" value="重置"   onclick="reset_form();">    
</form> 
   
   </div>
     
 <%
String msg="";
msg=(String)request.getAttribute("ms");
if(msg==null){
msg="";
}else{
request.removeAttribute("ms");
}

%>

<%=msg %>
  
<script type="text/javascript">
window.onload=function(){
if("<%=msg%>"!="")

{alert("<%=msg%>");
self.location="option.jsp";
}


}
					 
</script>  
     
     
     
     
  </body>
</html>
