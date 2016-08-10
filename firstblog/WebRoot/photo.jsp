<%@ page language="java" 
import="java.util.*" 
import="java.io.File"
pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>相册</title>
    <meta charset="utf-8">
<title>兔小白个人博客</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="css/base.css" rel="stylesheet">
<link href="css/index.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/sliders.js"></script>
<!--[if lt IE 9]>
<script src="js/modernizr.js"></script>
<![endif]-->
<!-- 返回顶部调用 begin -->
<script type="text/javascript" src="js/up/jquery.js"></script>
<script type="text/javascript" src="js/up/js.js"></script>
<!-- 返回顶部调用 end-->
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  <style type="text/css">
	ul.imglist{ margin:0 auto; width:1000px; overflow:hidden} 
    ul.imglist li{ float:left; padding:4px 8px; width:300px} 
    ul.imglist li img{ display:block; width:300px; height:300px} 
    ul.imglist li span{ display:block; width:100%; height:30px; line-height:30px; background:#F6F6F6} 	
   </style>

  </head>
  
  <header>
  <div class="logo f_l"> <a href="index.jsp"><img src="images/logo.png"></a> </div>
  <nav id="topnav" class="f_r">
    <ul>
      <a href="index.jsp" target="_blank">首页</a> <a href="aboutme.jsp" target="_blank">关于我</a> <a href="page.jsp?name=all" target="_blank">文章</a> <a href="moodlist.jsp" target="_blank">心情</a> <a href="photo.jsp" target="_blank">相册</a> <a href="liuyan.jsp" target="_blank">留言</a>
    </ul>
    <script src="js/nav.js"></script> 
  </nav>
</header>
  
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
  
  
  
  
  
  
  
 <div class="box">
     
	         <ul class="imglist"> 
	         
	          <%
	        String photopath =request.getSession().getServletContext().getRealPath("/")+"upload/photos/";
	         // 路径
         File f = new File(photopath);
         if (!f.exists()) {
             System.out.println(photopath + " not exists");
             return;
         }
 
          
         File fa[] = f.listFiles();
         for (int i = 0; i < fa.length; i++) {
             File fs = fa[i];
             if (fs.isDirectory()) {
                 System.out.println(fs.getName() + " [目录]");
             } else {
              String file=fs.getName();
             String fp="upload/photos/"+fs.getName();
              %>
               <li>
            <a href=<%=fp%> target="_blank">
               <img src=<%=fp%> />
               <span><%=file%></span>
            </a>
             </li> 
              <%
                    }
        }
               %>
                 
    </ul> 
	   
		
    </div> 
 
   
  </body>
</html>
