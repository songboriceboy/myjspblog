<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="dal.blogdal"%> 
<%@ page import="dal.commentdal"%>   
<%@ page import="java.io.*"%>   
  
<%@ page import="java.util.*"%>   
  
<%@ page import="java.sql.*"%>  

<!DOCTYPE HTML>
<html>
  <head>
<style>
textarea{
height:100px;
width:550px;
padding-top: 10px;
}
</style>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/xheditor-1.2.2.min.js"></script>

 <script type="text/javascript">
function reset_form()
{
	document.getElementById('reply').value ='';
	return false;
}
					 
</script>


    
    <script type="text/javascript">
         function check(form) {

        
          if(form.reply.value==''||form.reply.value.length>500) {
                alert("请输入合适回复!");
                form.title.focus();
                return false;
           }
         
         
         return true;
         }
</script>

    
    
    
  
    
	
	<link rel="stylesheet" type="text/css" href="styles.css">
	<meta charset="utf-8"/>
	<title>评论回复</title>
	
	<link rel="stylesheet" href="css/layout.css" type="text/css" media="screen" />
	<!--[if lt IE 9]>
	<link rel="stylesheet" href="css/ie.css" type="text/css" media="screen" />
	<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->
	<script src="js/admin/jquery-1.5.2.min.js" type="text/javascript"></script>
	<script src="js/admin/ideshow.js" type="text/javascript"></script>
	<script src="js/admin/jquery.tablesorter.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="js/admin/jquery.equalHeight.js"></script>
	
	
	

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
  
  
  <%
  
  int id=Integer.parseInt(request.getParameter("id")); 
  commentdal comdal=new commentdal();
ResultSet comment=comdal.searchcommentbyid(id);
  comment.next();
  
  blogdal bgdal=new blogdal();
String blogtitle=bgdal.getblogtitle(comment.getInt("mBid"));
  
   %>
   
   
   <div style="text-align:center">	
 评论人：  <%=comment.getString("mUser") %><br>
评论人邮箱：   <%=comment.getString("mEmail") %><br>
评论内容：   <%=comment.getString("mContent") %><br>
评论时间：   <%=comment.getString("mDate") %><br>
博客地址   <a href="pageview.jsp?id=<%=comment.getInt("mBid")%>"><%=blogtitle %></a><br>
  <br>
   <div>
  
    
   
	<div style="text-align:center">					
				
				
    
    <form action="CommentReply" method="post">
   
   <input type="hidden" id="cmid" name="cmid" value="<%=id%>">
    <textarea class="xheditor" id="reply" name="reply"> </textarea>
    </br>
    <input type="submit" value="发送" class="alt_btn" onclick="return check(this.form)">
	<input type="button" value="重置" onclick="reset_form();">
     
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
self.location="file.jsp";
}

}				 
</script>  
					
    
    
  </body>
</html>
