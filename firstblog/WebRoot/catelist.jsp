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

<%@ page import="dal.catedal"%>



<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>类别列表</title>
    
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
		<header><h3 class="tabs_involved">类别管理</h3>
		<ul class="tabs">
   			<li><a href="catelist.jsp">类别列表</a></li>
		</ul>
		</header>

		<div class="tab_container">
			<div id="tab1" class="tab_content">
			<table class="tablesorter" cellspacing="0"> 
			
				<tr> 
   					<th></th> 
    				<th>类别</th> 
    				<th>发布时间</th> 
    				<th>博客数</th> 
    				<th>操作</th> 
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
                          
            
                  
                   
catedal ctdal=new catedal();                     

browCount=ctdal.sumcate();

//计算pageCount
if(browCount%pageSize==0){
pageCount=browCount/pageSize;
}else{
pageCount=browCount/pageSize+1;
}
//查询出需要显示的记录


ResultSet caters=ctdal.selectcatepage(pageSize, pageNow);


while(caters.next()){
%>
   
   
				<tr> 
   					<td><input type="checkbox"></td>  
    				<td><%=caters.getString("cName")%></td> 
    				<td><%=caters.getString("cDate")%></td> 
    				<td><%=caters.getString("cBlogsum")%></td>
   				 	<td><a href="editcate.jsp?id=<%=caters.getString("cId")%>"><input type="image" src="images/icn_edit.png" title="Edit">  </a> <a href="DeleteCate?id=<%=caters.getString("cId")%>"><input type="image" src="images/icn_trash.png" title="Trash"></a>
   				 	<a href="addcate.jsp">添加 </a>
   				 	</td> 
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
<a href = "catelist.jsp?pageNow=1" >首页</a>  &nbsp &nbsp &nbsp &nbsp &nbsp 
<a href = "catelist.jsp?pageNow=<%=pageNow-1%>" >上一页</a>  &nbsp &nbsp &nbsp 
<%}%>    
   

<%
  if (pageNow == pageCount) {
    out.print("下一页 尾页");
  }
  else {
%>
<a href = "catelist.jsp?pageNow=<%=pageNow+1%>" >下一页</a>   &nbsp &nbsp &nbsp 
<a href = "catelist.jsp?pageNow=<%=pageCount%>" >尾页</a>   &nbsp &nbsp &nbsp 
<%}%>



第<%=pageNow%>页/共<%=pageCount%>页 		
	</br>
	</br>			
			
			</table>
			</div><!-- end of #tab1 -->
			
			
		</div><!-- end of .tab_container -->
		
		</article><!-- end of content manager article -->
		
	<!--	<article class="module width_quarter">  -->

</br>
</br>
<a href="addcate.jsp"> 添加类别  </a>
</br>
</br>

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
{

alert("<%=msg%>");
self.location="catelist.jsp";

}
}
					 
</script>  




  </body>
</html>
