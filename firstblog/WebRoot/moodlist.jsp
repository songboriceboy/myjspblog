<%@ page language="java" import="java.util.*" 
import="dal.mooddal"
import="java.sql.*"
pageEncoding="UTF-8"%>

<%@ page import="java.io.*"%>   

<%@ page import="utils.option"%>      
<%@ page import="java.util.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>心情</title>
    <meta charset="utf-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<title>兔小白个人博客</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="css/base.css" rel="stylesheet">
<link href="css/index.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/sliders.js"></script>

	
<link href="css/mood.css" rel="stylesheet">
<link href="css/moodbase.css" rel="stylesheet">
<!--[if lt IE 9]>
<script src="js/modernizr1.js"></script>
<![endif]-->


  </head>
  
  <body>
  
  
  
<%@ page import="java.io.*"%>   
  
<%@ page import="java.util.*"%> 

<%@ page import="model.mood"%>   
  
<%@ page import="dal.mooddal"%>     
  
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
  
  
  
    
    
    <header>
  <div class="logo f_l"> <a href="index.jsp"><img src="images/logo.png"></a> </div>
  <nav id="topnav" class="f_r">
    <ul>
      <a href="index.jsp" target="_blank">首页</a> <a href="aboutme.jsp" target="_blank">关于我</a> <a href="page.jsp?name=all" target="_blank">文章</a> <a href="moodlist.jsp" target="_blank">心情</a> <a href="photo.jsp" target="_blank">相册</a> <a href="liuyan.jsp" target="_blank">留言</a>
    </ul>
    <script src="js/nav.js"></script> 
  </nav>
</header>


<div class="moodlist">
  <h1 class="t_nav"><a href="addmood.jsp">添加心情 </a>  <span>删删写写，回回忆忆，虽无法行云流水，却也可碎言碎语。</span><a href="index.jsp" class="n1">网站首页</a><a href="moodlist.jsp" class="n2">碎言碎语</a></h1>
  <div class="bloglist">
  
  
 
 
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
                          
                   mooddal mddal=new mooddal();
  
                   browCount=mddal.summood(); //执行查询 
                   
                    
//计算pageCount
if(browCount%pageSize==0){
pageCount=browCount/pageSize;
}else{
pageCount=browCount/pageSize+1;
}
//查询出需要显示的记录


ResultSet rs=mddal.selectmoodpage(pageSize,pageNow);


while(rs.next()){
%>
   

         <ul class="arrow_box">
     <div class="sy">
     <img  class="img"  src=<%=rs.getString("mopicsrc")%> >
      <p> <%=rs.getString("moContent")%> </p>
      </div>
      <span class="dateview"> <%=rs.getString("moDate")%> </span>
    </ul>

  
  <%
} 
  

%>
     
     
     
 <%
  if (pageNow== 1) {
    out.print(" 首页 上一页");
  }
  else {
%>
<a href = "moodlist.jsp?pageNow=1" >首页</a>  &nbsp &nbsp &nbsp &nbsp &nbsp 
<a href = "moodlist.jsp?pageNow=<%=pageNow-1%>" >上一页</a>  &nbsp &nbsp &nbsp 
<%}%>    
   

<%
  if (pageNow == pageCount) {
    out.print("下一页 尾页");
  }
  else {
%>
<a href = "moodlist.jsp?pageNow=<%=pageNow+1%>" >下一页</a>   &nbsp &nbsp &nbsp 
<a href = "moodlist.jsp?pageNow=<%=pageCount%>" >尾页</a>   &nbsp &nbsp &nbsp 
<%}%>



第<%=pageNow%>页/共<%=pageCount%>页 
 





 </br>
 </br>
 </br>
    
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


</div>
<footer>
  <p>Design by DanceSmile <a href="http://www.miitbeian.gov.cn/" target="_blank"><%=option.getICPLicensing() %></a> <a href="/">网站统计</a></p>
</footer>
<script src="js/silder.js"></script>
    
    
    
  </body>
</html>
