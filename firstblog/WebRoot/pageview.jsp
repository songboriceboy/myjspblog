<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@ page import="dal.commentreply"%>
<%@ page import="dal.admindal"%>
<%@ page import="utils.option"%>
<%@ page import="utils.photosrcoption"%>
<%@ page import="utils.notice"%>
<%@ page import="java.io.*"%>   
  
<%@ page import="java.util.*"%>   
  
<%@ page import="java.sql.*"%>   

<%@ page import="dal.blogdal"%>

<%@ page import="dal.catedal"%>

<%@ page import="dal.commentdal"%>

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

<script type="text/javascript" src="js/xheditor-1.2.2.min.js"></script>

<link rel="stylesheet" href="css/styles/default.css">
<script src="js/highlight.pack.js"></script>
<script>hljs.initHighlightingOnLoad();</script>

<style>

.mcontent img[alt^="emot"] { float:left; }

</style>

<style>


    .elegant-aero {
    margin-left:auto;
    margin-right:auto;

    max-width: 700px;
    background: #D2E9FF;
    padding: 20px 20px 20px 20px;
    font: 12px Arial, Helvetica, sans-serif;
    color: #666;
    }
    .elegant-aero h1 {
    font: 24px "Trebuchet MS", Arial, Helvetica, sans-serif;
    padding: 10px 10px 10px 20px;
    display: block;
    background: #C0E1FF;
    border-bottom: 1px solid #B8DDFF;
    margin: -20px -20px 15px;
    }
    .elegant-aero h1>span {
    display: block;
    font-size: 11px;
    }

    .elegant-aero label>span {
    float: left;
    margin-top: 10px;
    color: #5E5E5E;
    }
    .elegant-aero label {
    display: block;
    margin: 0px 0px 5px;
    }
    .elegant-aero label>span {
    float: left;
    width: 20%;
    text-align: right;
    padding-right: 15px;
    margin-top: 10px;
    font-weight: bold;
    }
    .elegant-aero input[type="text"], .elegant-aero input[type="email"], .elegant-aero textarea, .elegant-aero select {
    color: #888;
    width: 70%;
    padding: 0px 0px 0px 5px;
    border: 1px solid #C5E2FF;
    background: #FBFBFB;
    outline: 0;
    -webkit-box-shadow:inset 0px 1px 6px #ECF3F5;
    box-shadow: inset 0px 1px 6px #ECF3F5;
    font: 200 12px/25px Arial, Helvetica, sans-serif;
    height: 30px;
    line-height:15px;
    margin: 2px 6px 16px 0px;
    }
    .elegant-aero textarea{
    height:200px;
    padding: 5px 0px 0px 5px;
    width: 75%;
    }
    .elegant-aero select {
    background: #fbfbfb url('down-arrow.png') no-repeat right;
    background: #fbfbfb url('down-arrow.png') no-repeat right;
    appearance:none;
    -webkit-appearance:none;
    -moz-appearance: none;
    text-indent: 0.01px;
    text-overflow: '';
    width: 70%;
    }
    .elegant-aero .button{
    padding: 10px 30px 10px 30px;
    background: #66C1E4;
    border: none;
    color: #FFF;
    box-shadow: 1px 1px 1px #4C6E91;
    -webkit-box-shadow: 1px 1px 1px #4C6E91;
    -moz-box-shadow: 1px 1px 1px #4C6E91;
    text-shadow: 1px 1px 1px #5079A3;

    }
    .elegant-aero .button:hover{
    background: #3EB1DD;
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
      <h2><span></span><b>文章</b>浏览</h2>
    
  
  <%
  
  
 
                  int blogid=Integer.parseInt(request.getParameter("id"));   
                   
                   blogdal bgdal=new blogdal();
                   ResultSet rs=bgdal.selectblogbyid(blogid);
   
                
                                    
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
   
   
<div>
     <center>
        <figure><img height="100px" width="100px" src="<%=rs.getString("bPicsrc")%>"></figure>
        <h3><a href="pageview.jsp?id=<%=rs.getInt("bId")%>">  <font size="3" color="red">  <%=rs.getString("bTitle")%> </font> </a></h3>
     </center>
        
        <ul>         
         <%=rs.getString("bContent")%>
          <p class="autor"><span class="lm f_l"><a href="cate.jsp?id=<%=bcateid%>"><%=bcatename%></a></span><span class="dtime f_l"><%=rs.getString("bDate")%></span><span class="viewnum f_r">浏览（<a href="pageview.jsp?id=<%=rs.getInt("bId")%>"><%=rs.getInt("bClicks")%></a>）</span><span class="pingl f_r">评论（<a href="pageview.jsp?id=<%=rs.getInt("bId")%>"><%=rs.getInt("bComments")%></a>）</span></p>
        </ul>
  
  </div>
  <%
} 
         
 bgdal.updateblogclick(blogid);
                   
                               


%>



 <div class="share"> 
        <!-- Baidu Button BEGIN -->
        <div id="bdshare" class="bdshare_t bds_tools get-codes-bdshare"> <span class="bds_more">分享到：</span> <a class="bds_qzone"></a> <a class="bds_tsina"></a> <a class="bds_tqq"></a> <a class="bds_renren"></a> <a class="bds_t163"></a> <a class="shareCount"></a> </div>
        <script type="text/javascript" id="bdshare_js" data="type=tools&amp;uid=6574585" ></script> 
        <script type="text/javascript" id="bdshell_js"></script> 
        <script type="text/javascript">
document.getElementById("bdshell_js").src = "http://bdimg.share.baidu.com/static/js/shell_v2.js?cdnversion=" + Math.ceil(new Date()/3600000)
</script> 
        <!-- Baidu Button END --> 
      </div>
      
      </br>
      </br>
      </br>
      </br>

     
     <%
     

                   commentdal comdal=new commentdal();
  
                   ResultSet comrs=comdal.searchcomment(blogid); //执行查询
                   
                   
                    
        while(comrs.next()){
%>

<div class="mcontent">
<%=comrs.getString("mContent")%>

<% 
commentreply cmrpl=new commentreply();
int cmid=comrs.getInt("mId");
 ResultSet cmrplrs=cmrpl.searchallreplybycmid(cmid);
 while(cmrplrs.next()){
%>

<p>      回复：<%=cmrplrs.getString("creply") %> 时间：  <%=cmrplrs.getString("crDate") %></p>
      <br>

<%} %>

</div>

 
<div style="float:right"> 
评论人:<%=comrs.getString("mUser")%>
邮箱:<%=comrs.getString("mEmail")%>
发布时间:<%=comrs.getString("mDate")%>
</div>
</br>
<HR style="FILTER: alpha(opacity=100,finishopacity=0,style=3)" width="80%" color=#987cb9 SIZE=3>
</br>
</br>


  <%
} 
           
      %>
     
      
     
     
     
     
    <form action="AddComment" method="post" class="elegant-aero">
    <h1>留言评论
    <span>输入评论内容</span>
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
    <span>内容 :</span>
    <textarea class="xheditor" id="message" name="message" ></textarea>
    </label>
    
    
    <lable>
       
      <input id="code" type="text" name="authcode" maxlength="4" size="10"> 输入验证码
       <img id="codeimg" name="codeimg" border=0 src="authcode.jsp">
       <a href="javascript:reloadImage('authcode.jsp')">看不清</a><br/>
     </lable>
     
    <input id ="bid" type="hidden" name="blogid" value=<%=blogid%>></input>
   
    
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
    <%=notice.getContent()%></div>
    <div class="moreSelect" id="lp_right_select"> 
      <script>
window.onload = function ()
{
       //显示评论消息
        if("<%=msg%>"!="")
      {
           alert("<%=msg%>");
           self.location="pageview.jsp?id=<%=blogid%>";

         }
  
    
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
