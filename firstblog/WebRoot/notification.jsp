<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<%@ page import="java.io.*"%>   
  
<%@ page import="java.util.*"%>   
  
<%@ page import="java.sql.*"%>  

<%@ page import="java.io.*"%>   
  
<%@ page import="java.util.*"%>   
  
<%@ page import="java.sql.*"%>   

<%@ page import="utils.gettime"%>

<%@ page import="java.util.Date"%>   
  
<%@ page import="java.text.DateFormat"%>   

<%@ page import="java.text.SimpleDateFormat"%>

<%@ page import="dal.hitsdal"%>

<%@ page import="dal.notificationdal"%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>通知管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

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






<article class="module width_3_quarter">
		<header><h3 class="tabs_involved">通知管理</h3>
		<ul class="tabs">
   			<li><a href="notification.jsp">通知</a></li>
		</ul>
		</header>

		<div class="tab_container">
			<div id="tab1" class="tab_content">
			<table class="tablesorter" cellspacing="0"> 
			
				<tr> 
   					<th></th> 
    				<th>用户名</th> 
    				<th>类型</th>
    				<th>内容</th>  
    				<th>时间</th> 
				</tr> 
			
				
				  <%
  
   Connection con = null; 
  
//定义四个分页会用到的变量
int pageSize=5;
int pageNow=1;//默认显示第一页
int browCount=0;//该值从数据库中查询
int pageCount=0;//该值是通过pageSize和rowCount
//接受用户希望显示的页数（pageNow）
String s_pageNow=request.getParameter("pageNow");
if(s_pageNow!=null){
//接收到了pageNow
pageNow=Integer.parseInt(s_pageNow);
}
//查询得到rowCount
                          
           notificationdal notidal=new notificationdal();
                     


browCount=notidal.sumnotification();

//计算pageCount
if(browCount%pageSize==0){
pageCount=browCount/pageSize;
}else{
pageCount=browCount/pageSize+1;
}
//查询出需要显示的记录


ResultSet notirs=notidal.selectnotipage(pageSize, pageNow);


while(notirs.next()){

String noticontent;
if(notirs.getString("nContent").length()>10)
{
 noticontent=notirs.getString("nContent").substring(0,10);
}else{

noticontent=notirs.getString("nContent");
}

%>
   
   
				<tr> 
   					<td><input type="checkbox"></td>  
    				<td><%=notirs.getString("nName")%></td> 
    				<td><%=notirs.getString("nType")%></td> 
    				<td><%=noticontent%></td>   
    				<td><%=notirs.getString("nDate")%></td> 
   				
				</tr>  
   
  <%
} 
  

%>
     
     
     
 <%
  if (pageNow==1) {
    out.print(" 首页 上一页");
  }
  else {
%>
<a href = "notification.jsp?pageNow=1" >首页</a>  &nbsp &nbsp &nbsp &nbsp &nbsp 
<a href = "notification.jsp?pageNow=<%=pageNow-1%>" >上一页</a>  &nbsp &nbsp &nbsp 
<%}%>    
   

<%
  if (pageNow == pageCount) {
    out.print("下一页 尾页");
  }
  else {
%>
<a href = "notification.jsp?pageNow=<%=pageNow+1%>" >下一页</a>   &nbsp &nbsp &nbsp 
<a href = "notification.jsp?pageNow=<%=pageCount%>" >尾页</a>   &nbsp &nbsp &nbsp 
<%}%>



第<%=pageNow%>页/共<%=pageCount%>页 		
	</br>
	</br>			
			
			</table>
			</div><!-- end of #tab1 -->
			
			
		</div><!-- end of .tab_container -->
		
		</article><!-- end of content manager article -->
		
		<article class="module width_quarter">





  </body>
</html>
