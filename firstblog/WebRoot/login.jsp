<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="java.io.*"%>   
  
<%@ page import="java.util.*"%>   
  
<%@ page import="java.sql.*"%>   

<%@ page import="utils.MD5"%>   

<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登录</title>
<style type="text/css">
#all {margin-left:auto; margin-right:auto; text-align: center;width: 540px;}
body {text-align:center;}
#main {background:url(images/login_mid.gif); height:240px; text-align:center;}
#title {height:66px;margin-top: 120px;}
#login { margin-top: 32px; width: 420px; margin-left: auto; margin-right:auto;}
#btm_left {background:url(images/login_btm_left.gif) no-repeat; width:21px; float:left;}
#btm_mid {background:url(images/login_btm_mid.gif); width:498px; float:left;}
#btm_right {background:url(images/login_btm_right.gif) no-repeat; width:21px; float:left;}
</style>
<script type="text/javascript">
function reset_form()
{
	document.getElementById('username').value = '';
	document.getElementById('password').value = '';
	return false;
}
					 
</script>



	<script type="text/javascript" src="js/jquery.min.js"></script>

<script>

$(document).ready(function(){
        $("#username").focus(function(){
    
        });
  
  $("#username").blur(function(){
  
  
  var user_name = $("#username").val();
            $.ajax({
                url: "/ValidateName",
                data: {userName:user_name},
                type: "POST",
                datatype: "html",
                success: function(data){
                     alert("success" +data);
                  $("#username").after("用户名存在");   
                }
                 
            });     
            
                          
  });
  
 
 
});




</script>




</head>

<body>




<%@ page import="model.admin"%>   
  
<%@ page import="dal.admindal"%>   

 <%@ page import="java.io.*"%>   
  
<%@ page import="java.util.*"%>   
  
<%@ page import="java.sql.*"%>   

<%@ page import="utils.gettime"%>

<%@ page import="java.util.Date"%>   
  
<%@ page import="java.text.DateFormat"%>   

<%@ page import="java.text.SimpleDateFormat"%>
  
   <% 
 
 
gettime gt=new gettime();

 if (application.getAttribute("count") == null) { 
        application.setAttribute("count", new Integer(0)); 
    } 
    Integer count = (Integer) application.getAttribute("count"); 
    application 
            .setAttribute("count", new Integer(count.intValue() + 1)); 
    count = (Integer) application.getAttribute("count"); 
 
 
 Date current_date = new Date();  
	//设置日期格式化样式为：yyyy-MM-dd  
	SimpleDateFormat  SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");  
	//格式化当前日期  
	String ndate=SimpleDateFormat.format(current_date.getTime()); 
	
 gt.updatetimes(count.intValue(),ndate);
 

   
     %>  





<div id="all">
    <div id="title"><img src="images/login_title.gif" /></div>
    <div id="main">
    	<form action="login.jsp" method="post" id="login_form">
        <table id="login">
        	<tr>
            	<td>用户名  </td>
                <td><input type="text" name="username" id="username"  size="32" style="background:url(images/username_bg.gif) left no-repeat #FFF; border:1px #ccc solid;height: 20px; font-family:Arial, Helvetica, sans-serif; font-size:14px; font-weight: 800; margin:0; padding-left: 24px;" /></td>
            </tr>
            <tr><td></td><td></td></tr>
            <tr><td></td><td></td></tr>
            <tr>
            	<td>密码 </td>
                <td><input type="password" name="password" id="password" size="32" style="background:url(images/password_bg.gif) left no-repeat #FFF; border: 1px #ccc solid; height: 20px; font-family:Arial, Helvetica, sans-serif; font-size:14px; font-weight: 800; margin:0; padding-left: 24px;" /></td>
            </tr>
            <tr>
            	<td></td>
            	<td style="text-align: left; padding-top: 32px;">
                	<input type="image" src="images/login.gif" name="submit" onclick="javascript:document.getElementById('login_form').submit();" />&nbsp;&nbsp;&nbsp;
                    <input type="image" src="images/cancel.gif" name="cancel" onclick="reset_form();" />
                    <a href="resetpwd.jsp">忘记密码</a>
                </td>
            </tr>
        </table>
        </form>
    </div>
    
    <div id="btm">
        <div id="btm_left"></div>
        <div id="btm_mid"></div>
        <div id="btm_right"></div>
    </div>
</div>

  
  <% 
         
      if (request.getParameter("username") != null&& request.getParameter("password") !=null) {
              
                  
          String Name = request.getParameter("username");  
          String Password = request.getParameter("password"); 
          
          Password=MD5.stringMD5(Password);
          
          admindal admdal=new admindal();
          admin adm=new admin(Name,Password);
           ResultSet rs=admdal.adminlogin(adm);
             
           if(rs.next())  
          {  
                 response.sendRedirect("admin.jsp"); 
                 session.setAttribute("Login", "OK");   
            } 
             else  
           {  
           %>         
           登录失败:用户名或密码不正确
           <%              
            }
            
  
  }
%>  


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