<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<%@ page import="utils.notice"%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>更新公告</title>
    
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/xheditor-1.2.2.min.js"></script>
    
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
	document.getElementById('title').value ='';
	document.getElementById('content').value ='';
	return false;
}
					 
</script>
    
    <script type="text/javascript">
         function check(form) {

        
          if(form.title.value==''||form.title.value.length>100) {
                alert("请输入合适公告标题!");
                form.title.focus();
                return false;
           }
           
           if(form.content.value.length>1000) {
                alert("请输入合适公告内容!");
                form.content.focus();
                return false;
           }
           
        
                 
         
         return true;
         }
</script>






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
  
  
   <%
 
 String title="";
 String content="";
 String glogin =(String)session.getAttribute("Login");
if(glogin!=null){
 
 if (request.getParameter("title") !=null&& request.getParameter("content") !=null)
 {
  title=new String(request.getParameter("title").getBytes("ISO-8859-1"),"UTF-8");
  content=new String(request.getParameter("content").getBytes("ISO-8859-1"),"UTF-8");
  notice.setTitle(title);
  notice.setContent(content);
  %>
 <font size="4" color="red">  公告更新成功  </font>
 </br>
 </br>
  <%
 } else  
       {  
           %>    
            <font size="4" color="red">  公告主题与内容不能为空  </font>
        </br>
         </br>
      
         
           <%              
        }
            
}            
 
  %>
  
  
  
  
  <form action="updatenotice.jsp" method="post">
  
   
   
   公告标题: <input type="text" id="title" name="title" >
    </br>
   </br>

 公告内容: <textarea class="xheditor" id="content"  rows="20" name="content" placeholder="输入公告" style="width:700px;height:400px;"></textarea>
    </br></br> </br>
  
  
   <input type="submit" value="发送" onclick="return check(this.form)">    
   <input type="button" value="重置"   onclick="reset_form();">    
</form> 
   
   </div>
 
 

   

  
  
 
  </body>
</html>
