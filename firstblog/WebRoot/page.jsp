<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="dal.admindal"%>
<%@ page import="utils.photosrcoption"%>
<%@ page import="utils.option"%>

<%@ page import="utils.notice"%>

<%@ page import="java.io.*"%>   
  
<%@ page import="java.util.*"%>   
  
<%@ page import="java.sql.*"%>   

<%@ page import="dal.catedal"%>

<%@ page import="dal.blogdal"%>

<%@ page import="dal.lbblog"%>


<%

if(admindal.sumadmin()==0){

response.sendRedirect("blogsetting.jsp");

}

 %>


<!doctype html>
<html>
<head>
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






<header>
  <div class="logo f_l"> <a href="index.jsp"><div style="float:left">   <font  size="6"  color="coral"><%=option.getBlogname() %></font>   </div><img src="<%=photosrcoption.getLogopicsrc()%>"/></a> </div>
  <nav id="topnav" class="f_r">
    <ul>
      <a href="index.jsp" target="_blank">首页</a> <a href="aboutme.jsp" target="_blank">关于我</a> <a href="page.jsp?name=all" target="_blank">文章</a> <a href="moodlist.jsp" target="_blank">心情</a> <a href="photo.jsp" target="_blank">相册</a> <a href="liuyan.jsp" target="_blank">留言</a>
    </ul>
    <script src="js/nav.js"></script> 
  </nav>
</header>
<article>
  <div class="l_box f_l">
    <div class="banner">
      
        <div id="slide-holder">
      
      
      <% 
      
     
       ResultSet lbblogrs=lbblog.searchlbblog();
      int lbblogsum=lbblog.sumblog();

      int[] id;
      id= new int[4] ;
      String title[]= new String[4];
      String content[]= new String[4];
if(lbblogsum>4)
{
lbblogsum=4;
}
for(int bi=0;bi<lbblogsum;bi++)
{    
       lbblogrs.next();
      
      
      id[bi]=lbblogrs.getInt("bId");
                 if(lbblogrs.getString("bTitle")!=null&&lbblogrs.getString("bContent")!=null)
             {
                title[bi]=lbblogrs.getString("bTitle");
                if(lbblogrs.getString("bContent").length()>10)
                         {
                         content[bi]=lbblogrs.getString("bContent").substring(0,10);
                          }else{
                          
                          content[bi]=lbblogrs.getString("bContent");
                          }
                
               }else
                 {
                    title[bi]="没有图文推荐";
                    content[bi]="没有图文推荐";
                     }
      
      
    
}  
  
 for(int bl=lbblogsum;bl<4;bl++)
{  
      id[bl]=0;
      
      title[bl]="没有图文推荐";
       content[bl]="没有图文推荐";
}     
        %>
      
      
      <script>
	  if(!window.slider) {
		var slider={};
	}

	slider.data= [
    {
        "id":"slide-img-1", // 与slide-runner中的img标签id对应
        "client":"<%=title[0]%>",
        "desc":"<%=content[0]%>" //这里修改描述
    },
    {
        "id":"slide-img-2",
        "client":"<%=title[1]%>",
        "desc":"<%=content[1]%>" //这里修改描述
    },
    {
        "id":"slide-img-3",
        "client":"<%=title[2]%>",
        "desc":"<%=content[2]%>" //这里修改描述
    },
    {
        "id":"slide-img-4",
        "client":"<%=title[3]%>",
        "desc":"<%=content[3]%>" //这里修改描述
    } 
	];

	  </script> 
      
        <div id="slide-runner"> 
       <a href="pageview.jsp?id=<%=id[0]%>" target="_blank"><img id="slide-img-1" src="images/a1.jpg"  alt="" /></a><a href="pageview.jsp?id=<%=id[1]%>" target="_blank"><img id="slide-img-2" src="images/a2.jpg"  alt="" /></a> <a href="pageview.jsp?id=<%=id[2]%>" target="_blank"><img id="slide-img-3" src="images/a3.jpg"  alt="" /></a> <a href="pageview.jsp?id=<%=id[3]%>" target="_blank"><img id="slide-img-4" src="images/a4.jpg"  alt="" /></a> 
          
                  
          <div id="slide-controls">
            <p id="slide-client" class="text"><strong></strong><span></span></p>
            <p id="slide-desc" class="text"></p>
            <p id="slide-nav"></p>
          </div>       
        </div>
        
  
  
        
        
      </div>
      
      
    </div>
    <!-- banner代码 结束 -->
    <div class="topnews">
       <h2><span></span><b>文章</b>推荐</h2>
     
  
      


     
  
  <%
  
   Connection con = null; 
  
//定义四个分页会用到的变量
int pageSize=5;
int pageNow=1;//默认显示第一页
int browCount=0;//该值从数据库中查询
int pageCount=0;//该值是通过pageSize和rowCount
//接受用户希望显示的页数（pageNow）
String sname=request.getParameter("name");
String s_pageNow=request.getParameter("pageNow");
if(s_pageNow!=null){
//接收到了pageNow
pageNow=Integer.parseInt(s_pageNow);
}
//查询得到rowCount
                          
           blogdal bgdal=new blogdal();
           
browCount=bgdal.sumblog();

//计算pageCount
if(browCount%pageSize==0){
pageCount=browCount/pageSize;
}else{
pageCount=browCount/pageSize+1;
}
//查询出需要显示的记录

String sql="select * from blog order by bDate DESC LIMIT "+pageSize*(pageNow-1)+","+pageSize;

if(sname.equals("all"))
{
sql="select * from blog order by bDate DESC LIMIT "+pageSize*(pageNow-1)+","+pageSize;
}

if(sname.equals("clicks"))
{
sql="select * from blog order by bClicks DESC LIMIT "+pageSize*(pageNow-1)+","+pageSize;
}

if(sname.equals("news"))
{
sql="select * from blog order by bDate DESC LIMIT "+pageSize*(pageNow-1)+","+pageSize;
}

if(sname.equals("tjs"))
{
sql="select * from blog where bIstj='1' order by bDate DESC LIMIT "+pageSize*(pageNow-1)+","+pageSize;
}

ResultSet rs=bgdal.selectblogpagebysql(sql, pageSize, pageNow);

while(rs.next()){

String bcatename="";
int bcateid=1;
if(rs.getString("bCatename")==null)
{
bcatename="没有分类";
}else{
bcatename=rs.getString("bCatename");
bcateid=rs.getInt("bCateid");
}



%>
   
<div class="blogs">
        <figure><img src="<%=rs.getString("bPicsrc")%>"></figure>
        <ul>
          <h3><a href="pageview.jsp?id=<%=rs.getInt("bId")%>"><%=rs.getString("bTitle")%></a></h3>
         <%
        String summary;
         if(rs.getString("bContent").length()>10)       
         summary=rs.getString("bContent").substring(0,10);
         else
         summary=rs.getString("bContent");
         %>
         <%=summary%>
          <p class="autor"><span class="lm f_l"><a href="cate.jsp?id=<%=bcateid%>"><%=bcatename%></a></span><span class="dtime f_l"><%=rs.getString("bDate")%></span><span class="viewnum f_r">浏览（<a href="pageview.jsp?id=<%=rs.getInt("bId")%>"><%=rs.getInt("bClicks")%></a>）</span><span class="pingl f_r">评论（<a href="pageview.jsp?id=<%=rs.getInt("bId")%>"><%=rs.getInt("bComments")%></a>）</span></p>
        </ul>
  
  </div>
  <%
} 

%>
     
     
     
 <%
  if (pageNow== 1) {
    out.print(" 首页 上一页");
  }
  else {
%>
<a href = "page.jsp?name=all&pageNow=1" >首页</a>  &nbsp &nbsp &nbsp &nbsp &nbsp 
<a href = "page.jsp?name=all&pageNow=<%=pageNow-1%>" >上一页</a>  &nbsp &nbsp &nbsp 
<%}%>    
   

<%
  if (pageNow == pageCount) {
    out.print("下一页 尾页");
  }
  else {
%>
<a href = "page.jsp?name=all&pageNow=<%=pageNow+1%>" >下一页</a>   &nbsp &nbsp &nbsp 
<a href = "page.jsp?name=all&pageNow=<%=pageCount%>" >尾页</a>   &nbsp &nbsp &nbsp 
<%}%>



第<%=pageNow%>页/共<%=pageCount%>页  
     
      
   </div>
    
    
  </div>
  <div class="r_box f_r">
    <div class="tit01">
      <h3>关注我</h3>
      <div class="gzwm">
        <ul>
          <li><a class="xlwb" href="<%=option.getWeibourl() %>>" target="_blank">新浪微博</a></li>
          <li><a class="txwb" href="<%=option.getTweibourl() %>" target="_blank">腾讯微博</a></li>
          <li><a class="rss" href="portal.php?mod=rss" target="_blank">RSS</a></li>
          <li><a class="wx" href="mailto:admin@admin.com">邮箱</a></li>
        </ul>
      </div>
    </div>
    <!--tit01 end-->
    <div class="ad300x100">  <font  size="4"  color="coral">  公告：<%=notice.getTitle() %>  </font>
     
      </br>
    <%=notice.getContent()%> </div>
    <div class="moreSelect" id="lp_right_select"> 
      <script>
window.onload = function ()
{
	var oLi = document.getElementById("tab").getElementsByTagName("li");
	var oUl = document.getElementById("ms-main").getElementsByTagName("div");
	
	for(var i = 0; i < oLi.length; i++)
	{
		oLi[i].index = i;
		oLi[i].onmouseover = function ()
		{
			for(var n = 0; n < oLi.length; n++) oLi[n].className="";
			this.className = "cur";
			for(var n = 0; n < oUl.length; n++) oUl[n].style.display = "none";
			oUl[this.index].style.display = "block"
		}	
	}
}
</script>
      <div class="ms-top">
        <ul class="hd" id="tab">
          <li class="cur"><a href="page.jsp?name=clicks">点击排行</a></li>
          <li><a href="page.jsp?name=news">最新文章</a></li>
          <li><a href="page.jsp?name=tjs">站长推荐</a></li>
        </ul>
      </div>
      <div class="ms-main" id="ms-main">
        <div style="display: block;" class="bd bd-news" >
        
          <ul>
          
          
                <%  
                                         
                          
            ResultSet clickrs=bgdal.selectblogbyclick();
                   
                     
while(clickrs.next())   
{  

%>
  
<li><a href="pageview.jsp?id=<%=clickrs.getInt("bId")%>" target="_blank"><%=clickrs.getString("bTitle")%></a></li>
<%
}   
        
      
%>
          
          </ul>
          
          
          
        </div>
        
        
        <div  class="bd bd-news">
          <ul>
          
            <%  
                 
             
            ResultSet newsrs=bgdal.selectblogbydate();                   
while(newsrs.next())   
{  

%>
  
<li><a href="pageview.jsp?id=<%=newsrs.getInt("bId")%>" target="_blank"><%=newsrs.getString("bTitle")%></a></li>
<%
}   
       
      
%>
          
          
         
  
 

           
            
          </ul>
        </div>
       
          
          
          
          
          
        
        <div  class="bd bd-news">
          <ul>
          
            <%  
                 
             
           ResultSet tjrs=bgdal.selectblogbytj();
                   
                     
while(tjrs.next())   
{  

%>
  
 <li><a href="pageview.jsp?id=<%=tjrs.getInt("bId")%>" target="_blank"><%=tjrs.getString("bTitle")%></a></li>
<%
}   
                  
      
%>
          
           
            
          </ul>
        </div>
      </div>
      <!--ms-main end --> 
    </div>
    <!--切换卡 moreSelect end -->
    
    <div class="cloud">
      <h3>类别云</h3>
      <ul>
      
 <%  
                 
        catedal ctdal=new catedal();
        ResultSet caters=ctdal.searchcate();
        while(caters.next())
        {
       String cate=caters.getString("cName")+"("+caters.getInt("cBlogsum")+")";

%>
  <li><a href="cate.jsp?id=<%=caters.getInt("cId")%>"> <%=cate%> </a></li>
<%
}   
%>

</ul>
    </div>
    <div class="tuwen">
      <h3>扫描加微信 QQ</h3>
      <ul>
        
      </ul>
    </div>
    <div class="ad"> <img src="<%=photosrcoption.getWeixinpicsrc()%>"> </div>
    <div class="links">
      <h3><span>[<a href="addlink.jsp">申请友情链接</a>]</span>友情链接</h3>
      <ul>
        
        <li><a href="http://www.csdn.net">csdn</a></li>
        <li><a href="http://www.baidu.com">百度</a></li>
      </ul>
    </div>
  </div>
  <!--r_box end --> 
</article>
<footer>
  <p class="ft-copyright">兔小白博客 Design by DanceSmile <%=option.getICPLicensing() %></p>
  <div id="tbox"> <a id="togbook" href="/"></a> <a id="gotop" href="javascript:void(0)"></a> </div>
</footer>
</body>
</html>
