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





 <script type="text/javascript" language="javascript">
function reset_form()
{
	document.getElementById('filename').value ='';
	return false;
}
					 
</script>


    
    <script type="text/javascript">
         function check(form) {

        
          if(form.filename.value==''||form.filename.length>100) {
                alert("请输入合适文件名!");
                form.title.focus();
                return false;
           }
         
         
         return true;
         }
</script>

    
    
    
    <title>后台管理</title>
    
	
	<link rel="stylesheet" type="text/css" href="styles.css">
	<meta charset="utf-8"/>
	<title>文件后台管理</title>
	
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
  
  
    
   
   
   <div style="text-align:center">		
				
				
				<%  
						
							
							String type=request.getParameter("type");
									             
                            String filename="";
                            filename=request.getParameter("path");
                            
                            
                                                       
                                       
					%>
					
					
					 <form action="UpdateFile" method="post">
  
    <input type="text" id="filename" name="filename" value="<%=filename %>" > 
    <input  type="hidden" name="types" value="<%=type%>" >
    <input  type="hidden" name="filepath" value="<%=filename%>" >     
    <input type="submit" value="发送" class="alt_btn" onclick="return check(this.form)">
	<input type="button" value="重置" onclick="reset_form();">
     
    </form>
	
	
	
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
