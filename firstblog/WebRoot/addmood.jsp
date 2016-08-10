<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@ page import="java.io.*"%>   
  
<%@ page import="java.util.*"%>   
  
<%@ page import="java.sql.*"%>  


<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加心情</title>
    
    
    <script type="text/javascript" src="js/jquery.min.js"></script>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<script type="text/javascript" src="js/xheditor-1.2.2.min.js"></script>

 
 
 <style>
 select {

   background: transparent;

   width: 268px;

   padding: 5px;

   font-size: 16px;

   border: 1px solid #ccc;

   height: 34px;

   -webkit-appearance: none; /*for chrome*/

}
 
 
 </style>
 
 
 
    <script type="text/javascript">
function reset_form()
{
	document.getElementById('mood').value ='';
	return false;
}
					 
</script>
    
    <script type="text/javascript">
         function check(form) {

        
          if(form.mood.value.length>5000) {
                alert("请输入合适心情!");
                form.mood.focus();
                return false;
           }
         
         
         return true;
         }
</script>


  </head>
  
  <body>
  
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
  
  
  
   <script type="text/javascript">
  
  function GetFace() {
var faceid = $("#SelFace").val();
if (faceid.length == 1) { faceid = "0" + faceid; }
$("#imgface").attr("src", "images/"+faceid+".jpg");
$("#picsrc").attr("value", "images/"+faceid+".jpg");
}
  
</script>     
   
   
    <div style="text-align:center;">
    
    
		
   <form action="AddMood" method="post">
 选择心情头图片  :&nbsp &nbsp &nbsp &nbsp 
   <select id="SelFace" name="SelFace" onchange="GetFace();">
<option value="1">头像1</option>
<option value="2">头像2</option>
<option value="3">头像3</option>
<option value="4">头像4</option>
<option value="5">头像5</option>
<option value="6">头像6</option>
</select> 
&nbsp &nbsp &nbsp &nbsp
<img id="imgface" name="imgface" src="images/01.jpg" style="width:100px;height:100px;"/>
 &nbsp &nbsp  
   <input id="picsrc" type="hidden" name="picsrc" value="images/01.jpg">
   </br> </br></br></br>
   <textarea class="xheditor" id="mood"  rows="20" name="mood" placeholder="输入心情" style="width:700px;height:400px;"></textarea>
    </br></br> </br>
  
   <input type="submit" value="发送" class="alt_btn" onclick="return check(this.form)">
   &nbsp &nbsp &nbsp &nbsp
   <input type="button" value="重置" onclick="reset_form();">
   
   
   </form>
   
		
		
  </div>
   
   
  </body>
</html>
