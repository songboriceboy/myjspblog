<%@ page language="java" import="java.util.*" 
import="dal.liuyandal"
import="java.sql.*"
pageEncoding="UTF-8"

contentType="text/html; charset=UTF-8"

%>
<%@ page import="dal.liuyanreplydal"%> 
<%@ page import="java.io.*"%>   
<%@ page import="utils.option"%>     
 <%@ page import="utils.photosrcoption"%> 
<%@ page import="java.util.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>我的留言板</title>
    
    <link href="css/mood.css" rel="stylesheet">
<link href="css/moodbase.css" rel="stylesheet">
<!--[if lt IE 9]>
<script src="js/modernizr1.js"></script>
<![endif]-->
    
    <title>兔小白个人博客</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="css/base.css" rel="stylesheet">
<link href="css/index.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/sliders.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		
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
.smart-green {
margin-left:auto;
margin-right:auto;

max-width: 700px;
background: #F8F8F8;
padding: 30px 30px 20px 30px;
font: 12px Arial, Helvetica, sans-serif;
color: #666;
border-radius: 5px;
-webkit-border-radius: 5px;
-moz-border-radius: 5px;
}
.smart-green h1 {
font: 24px "Trebuchet MS", Arial, Helvetica, sans-serif;
padding: 20px 0px 20px 40px;
display: block;
margin: -30px -30px 10px -30px;
color: #FFF;
background: #9DC45F;
text-shadow: 1px 1px 1px #949494;
border-radius: 5px 5px 0px 0px;
-webkit-border-radius: 5px 5px 0px 0px;
-moz-border-radius: 5px 5px 0px 0px;
border-bottom:1px solid #89AF4C;

}
.smart-green h1>span {
display: block;
font-size: 11px;
color: #FFF;
}

.smart-green label {
display: block;
margin: 0px 0px 5px;
}
.smart-green label>span {
float: left;
margin-top: 10px;
color: #5E5E5E;
}
.smart-green input[type="text"], .smart-green input[type="email"], .smart-green textarea, .smart-green select {
color: #555;
height: 30px;
line-height:15px;
width: 100%;
padding: 0px 0px 0px 10px;
margin-top: 2px;
border: 1px solid #E5E5E5;
background: #FBFBFB;
outline: 0;
-webkit-box-shadow: inset 1px 1px 2px rgba(238, 238, 238, 0.2);
box-shadow: inset 1px 1px 2px rgba(238, 238, 238, 0.2);
font: normal 14px/14px Arial, Helvetica, sans-serif;
}
.smart-green textarea{
height:250px;
padding-top: 10px;
}
.smart-green select {
background: url('down-arrow.png') no-repeat right, -moz-linear-gradient(top, #FBFBFB 0%, #E9E9E9 100%);
background: url('down-arrow.png') no-repeat right, -webkit-gradient(linear, left top, left bottom, color-stop(0%,#FBFBFB), color-stop(100%,#E9E9E9));
appearance:none;
-webkit-appearance:none;
-moz-appearance: none;
text-indent: 0.01px;
text-overflow: '';
width:100%;
height:30px;
}
.smart-green .button {
background-color: #9DC45F;
border-radius: 5px;
-webkit-border-radius: 5px;
-moz-border-border-radius: 5px;
border: none;
padding: 10px 25px 10px 25px;
color: #FFF;
text-shadow: 1px 1px 1px #949494;
}
.smart-green .button:hover {
background-color:#80A24A;
}

</style>

<script type="text/javascript">
function reset_form()
{
	document.getElementById('name').value ='';
	document.getElementById('email').value ='';
	document.getElementById('message').value ='';
	document.getElementById('code').value ='';
	return false;
}
					 
</script>


<script type="text/javascript">
         function check(form) {

         var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;

          if(form.name.value==''||form.name.value.length>50) {
                alert("请输入用户姓名!");
                form.name.focus();
                return false;
           }
       if(form.email.value==''||!myreg.test(form.email.value)){
                alert("请输入正确邮箱!");
                form.email.focus();
                return false;
         }
         
       
      
       
          if(form.authcode.value=='') {
                alert("请输正确入验证码!");
                form.name.focus();
                return false;
           } 
         
         return true;
         }
</script>






  </head>
  
    <header>
  <div class="logo f_l"> <a href="index.jsp"><img src="<%=photosrcoption.getLogopicsrc()%>"></a> </div>
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
  
  
  
  
  
  
  

<div class="moodlist">
  <h1 class="t_nav"><span>删删写写，回回忆忆，虽无法行云流水，却也可碎言碎语。</span><a href="index.jsp" class="n1">网站首页</a><a href="liuyan.jsp" class="n2">碎言碎语</a></h1>
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
                          
            
                   
                     
liuyandal lydal=new liuyandal();

browCount=lydal.sumliuyan();

//计算pageCount
if(browCount%pageSize==0){
pageCount=browCount/pageSize;
}else{
pageCount=browCount/pageSize+1;
}
//查询出需要显示的记录


ResultSet rs=lydal.selectliuyanpage(pageSize, pageNow);

while(rs.next()){
%>
   

         <ul class="arrow_box">
     <div class="sy">
     <img class="img" src="<%=rs.getString("lPicsrc")%>" >
      <p> <%=rs.getString("lContent")%> </p>
      <% 
      liuyanreplydal lyrpldal=new liuyanreplydal();
      int lyid=rs.getInt("lId");
      ResultSet rplrs=lyrpldal.searchallreplybycmid(lyid);
      while(rplrs.next()){
      %>
<p>      回复：<%=rplrs.getString("lreply") %> 时间：  <%=rplrs.getString("lrDate") %></p>
      <br>
      <%} %>
      
      <div float="right" style="position: absolute;right: 10px;bottom: 10px;">留言人:<%=rs.getString("lUser")%></div>
    
      
      </div>
      <span class="dateview">  <%=rs.getString("lDate")%> </span>
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
<a href = "liuyan.jsp?pageNow=1" >首页</a>  &nbsp &nbsp &nbsp &nbsp &nbsp 
<a href = "liuyan.jsp?pageNow=<%=pageNow-1%>" >上一页</a>  &nbsp &nbsp &nbsp 
<%}%>    
   

<%
  if (pageNow == pageCount) {
    out.print("下一页 尾页");
  }
  else {
%>
<a href = "liuyan.jsp?pageNow=<%=pageNow+1%>" >下一页</a>   &nbsp &nbsp &nbsp 
<a href = "liuyan.jsp?pageNow=<%=pageCount%>" >尾页</a>   &nbsp &nbsp &nbsp 
<%}%>



第<%=pageNow%>页/共<%=pageCount%>页 
 
 
   </br>
   </br>
   </br>
    
  </div>

</div>

  
  



 
    <form action="LiuYan" method="post" class="smart-green">
    
    
     
    
    <h1>留言板
    <span>请输入留言内容.</span>
    </h1>
    <label>
    <span>姓名 :</span>
    <input id="name" type="text" name="name" placeholder="姓名" />
    </label>

    <label>
    <span>邮箱 :</span>
    <input id="email" type="email" name="email" placeholder="邮箱" />
    </label>

    <label>
    <span>留言内容 :</span>
    <textarea class="xheditor" id="message" name="message" placeholder="留言内容"></textarea>
    </label>
    
 <label></label>
							<img id="imgface" name="imgface" src="images/01.jpg"  style="width:100px;height:100px;"/>
							 <select id="SelFace" name="SelFace" style="width:200px;float:left;" onchange="GetFace();">
<option value="1">头像1</option>
<option value="2">头像2</option>
<option value="3">头像3</option>
<option value="4">头像4</option>
<option value="5">头像5</option>
<option value="6">头像6</option>
</select> 

  <input id="picsrc" name="picsrc" type="hidden" value="images/01.jpg" >
 
  <script type="text/javascript">
  
  function GetFace() {
var faceid = $("#SelFace").val();
if (faceid.length == 1) { faceid = "0" + faceid; }
$("#imgface").attr("src", "images/"+faceid+".jpg");
$("#picsrc").attr("value", "images/"+faceid+".jpg");
}
  
</script>     
 
 

 
   
 
       <input id="code" style="width:100px;" type="text" name="authcode" maxlength="4" size="8"> 输入验证码
        
       <img id="codeimg" name="codeimg" border=0 src="authcode.jsp" style="float:left;">
       <a href="javascript:reloadImage('authcode.jsp')">看不清</a><br/>
    
     
     <script language="javascript" type="text/javascript">
      function reloadImage(imgurl){
          var getimagecode=document.getElementById("codeimg");
          getimagecode.src= imgurl + "?id=" + Math.random();
      }
  </script>
     
     
    
    <label>
    <span>&nbsp;</span>
    <input type="submit" class="button" value="发送" onclick="return check(this.form)"/>
    <input type="button" value="重置" onclick="reset_form();">
    </label>
    </form>
 
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
self.location="liuyan.jsp";
}

}				 
</script>  
  
 
<footer>
  <p>Design by DanceSmile <a href="http://www.miitbeian.gov.cn/" target="_blank"><%=option.getICPLicensing() %></a> <a href="/">网站统计</a></p>
</footer>
<script src="js/silder.js"></script>
        
  
  </body>
</html>
