<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@ page import="dal.blogdal"%>

<%@ page import="dal.lbblog"%>

<%@ page import="dal.catedal"%>

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

<!doctype html>
<html>
  <head>


    <script type="text/javascript">  
        window.onload = function(){  
            CKEDITOR.replace('content');  
        }  
    </script>  


 <script type="text/javascript" src="<%=request.getContextPath()%>/ckeditor/ckeditor.js"></script>
    
    
    
    <script type="text/javascript" language="javascript">
function reset_form()
{
	document.getElementById('title').value ='';
	 CKEDITOR.instances.content.setData("");
	return false;
}
					 
</script>
    
    <script type="text/javascript">
         function check(form) {

        
          if(form.title.value==''||form.title.value.length>100) {
                alert("请输入合适长度标题!");
                form.title.focus();
                return false;
           }
       
         
     var editor_data = CKEDITOR.instances.content.getData();  
    if(editor_data==null || editor_data==""){  
        alert("请填写博文内容！");  
        form.content.focus();
        return false;  
    }  
        
         
         return true;
         }
</script>
    
    
    
    <title>后台管理</title>
    
	
	<link rel="stylesheet" type="text/css" href="styles.css">
	<meta charset="utf-8"/>
	<title>博客后台管理</title>
	
	<link rel="stylesheet" href="css/layout.css" type="text/css" media="screen" />
	<!--[if lt IE 9]>
	<link rel="stylesheet" href="css/ie.css" type="text/css" media="screen" />
	<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->
	<script src="js/admin/jquery-1.5.2.min.js" type="text/javascript"></script>
	<script src="js/admin/ideshow.js" type="text/javascript"></script>
	<script src="js/admin/jquery.tablesorter.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="js/admin/jquery.equalHeight.js"></script>
	<script type="text/javascript">
	$(document).ready(function() 
    	{ 
      	  $(".tablesorter").tablesorter(); 
   	 } 
	);
	$(document).ready(function() {

	//When page loads...
	$(".tab_content").hide(); //Hide all content
	$("ul.tabs li:first").addClass("active").show(); //Activate first tab
	$(".tab_content:first").show(); //Show first tab content

	//On Click Event
	$("ul.tabs li").click(function() {

		$("ul.tabs li").removeClass("active"); //Remove any "active" class
		$(this).addClass("active"); //Add "active" class to selected tab
		$(".tab_content").hide(); //Hide all tab content

		var activeTab = $(this).find("a").attr("href"); //Find the href attribute value to identify the active tab + content
		$(activeTab).fadeIn(); //Fade in the active ID content
		return false;
	});

});
    </script>
    <script type="text/javascript">
    $(function(){
        $('.column').equalHeight();
    });
</script>
	
	

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

<header id="header">
		<hgroup>
			<h1 class="site_title"><a href="admin.jsp">后台管理</a></h1>
			<h2 class="section_title">仪表盘</h2><div class="btn_view_site"><a href="index.jsp">主页</a></div>
		</hgroup>
	</header> <!-- end of header bar -->
	
	<% notificationdal notidal=new notificationdal(); %>
	
	<section id="secondary_bar">
		<div class="user">
			<p>Admin(<a href="notification.jsp"><%=notidal.sumnotification() %> 通知</a>)</p>
			<!-- <a class="logout_user" href="#" title="Logout">Logout</a> -->
		</div>
		<div class="breadcrumbs_container">
			<article class="breadcrumbs"><a href="admin.jsp">网站后台管理</a> <div class="breadcrumb_divider"></div> <a class="current">仪表盘</a></article>
		</div>
	</section><!-- end of secondary bar -->
	
	<aside id="sidebar" class="column">
		<form class="quick_search">
			<input type="text" value="Quick Search" onfocus="if(!this._haschanged){this.value=''};this._haschanged=true;">
		</form>
		<hr/>
		<h3>内容</h3>
		<ul class="toggle">
			<li class="icn_new_article"><a href="#publog">添加博文</a></li>
			<li class="icn_edit_article"><a href="addmood.jsp">添加心情</a></li>
			<li class="icn_categories"><a href="catelist.jsp">类别管理</a></li>
			<li class="icn_tags"><a href="bloglist.jsp">博文列表</a></li>
			<li class="icn_edit_article"><a href="liuyanlist.jsp">留言管理</a></li>
			<li class="icn_edit_article"><a href="commentlist.jsp">评论管理</a></li>
		</ul>
		<h3>用户</h3>
		<ul class="toggle">
			
			<li class="icn_view_users"><a href="aboutme.jsp">查看用户</a></li>
			<li class="icn_profile"><a href="myinfo.jsp">个人信息</a></li>
		</ul>
		<h3>媒体</h3>
		<ul class="toggle">
			<li class="icn_folder"><a href="file.jsp">文件管理</a></li>
			<li class="icn_photo"><a href="photos.jsp">画廊</a></li>
			<li class="icn_audio"><a href="music.jsp">音乐</a></li>
			<li class="icn_video"><a href="video.jsp">视频</a></li>
		</ul>
		<h3>管理</h3>
		<ul class="toggle">
		    <li class="icn_add_user"><a href="photooption.jsp">图片选项设置</a></li>
			<li class="icn_settings"><a href="option.jsp">选项</a></li>
			<li class="icn_security"><a href="updatenotice.jsp">公告</a></li>
			<li class="icn_jump_back"><a href="LogOut">退出</a></li>
		</ul>
		
		<footer>
			<hr />
			<p><strong>Copyright &copy; 2016 Website Admin</strong></p>
			<p>Theme by <a href="http://www.medialoot.com">MediaLoot</a></p>
		</footer>
	</aside><!-- end of sidebar -->
	
	<section id="main" class="column">
		
		<h4 class="alert_info">欢迎进入后台管理.</h4>
		
		<article class="module width_full">
			<header><h3>状态</h3></header>
			<div class="module_content">
				<article class="stats_graph">
					<img src="" width="520" height="140" alt="" />
				</article>
				
				<%
				hitsdal hd=new hitsdal();
				int htimes=0;
			htimes =hd.searchhits();
		    int prtimes=0;
		    
		    
     Date date = new Date();  
	//设置日期格式化样式为：yyyy-MM-dd  
	SimpleDateFormat  SDF = new SimpleDateFormat("yyyy-MM-dd");  
	//格式化当前日期  
	String nowdate=SDF.format(date.getTime()); 
		    
		    prtimes =hd.prevtimes(nowdate);
				 %>
				
				<article class="stats_overview">
					<div class="overview_today">
						<p class="overview_day">今天</p>
						<p class="overview_count"><%=htimes%></p>
						<p class="overview_type">点击</p>
						<p class="overview_count"><%=htimes%></p>
						<p class="overview_type">阅读</p>
					</div>
					<div class="overview_previous">
						<p class="overview_day">昨天</p>
						<p class="overview_count"><%=prtimes%></p>
						<p class="overview_type">点击</p>
						<p class="overview_count"><%=prtimes%></p>
						<p class="overview_type">阅读</p>
					</div>
				</article>
				<div class="clear"></div>
			</div>
		</article><!-- end of stats article -->
		
		<article class="module width_3_quarter">
		<header><h3 class="tabs_involved">内容管理</h3>
		<ul class="tabs">
   			<li><a href="#tab1">博文列表</a></li>
		</ul>
		</header>

		<div class="tab_container">
			<div id="tab1" class="tab_content">
			<table class="tablesorter" cellspacing="0"> 
			
				<tr> 
   					<th></th> 
    				<th>标题</th> 
    				<th>类别</th> 
    				<th>发布时间</th> 
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
                          
          blogdal bgdal=new blogdal();
                     


browCount=bgdal.sumblog();

//计算pageCount
if(browCount%pageSize==0){
pageCount=browCount/pageSize;
}else{
pageCount=browCount/pageSize+1;
}
//查询出需要显示的记录


ResultSet blogrs=bgdal.selectblogpage(pageSize, pageNow);

while(blogrs.next()){

String bcatename="";
int bcateid=1;
if(blogrs.getString("bCatename")==null)
{
bcatename="没有分类";
}else{
bcatename=blogrs.getString("bCatename");
bcateid=blogrs.getInt("bCateid");
}


%>

   
   
				<tr> 
   					<td><input type="checkbox"></td> 
    				<td><a href="pageview.jsp?id=<%=blogrs.getInt("bId")%>"> <%=blogrs.getString("bTitle")%> </a></td> 
    				<td> <a href="cate.jsp?id=<%=bcateid%>"> <%=bcatename%> </a> </td> 
    				<td><%=blogrs.getString("bDate")%></td> 
   				 	<td><a href="editblog.jsp?id=<%=blogrs.getString("bId")%>"><input type="image" src="images/icn_edit.png" title="Edit">  </a> <a href="DeletBlog?id=<%=blogrs.getString("bId")%>"><input type="image" src="images/icn_trash.png" title="Trash"></a></td> 
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
<a href = "admin.jsp?pageNow=1" >首页</a>  &nbsp &nbsp &nbsp &nbsp &nbsp 
<a href = "admin.jsp?pageNow=<%=pageNow-1%>" >上一页</a>  &nbsp &nbsp &nbsp 
<%}%>    
   

<%
  if (pageNow == pageCount) {
    out.print("下一页 尾页");
  }
  else {
%>
<a href = "admin.jsp?pageNow=<%=pageNow+1%>" >下一页</a>   &nbsp &nbsp &nbsp 
<a href = "admin.jsp?pageNow=<%=pageCount%>" >尾页</a>   &nbsp &nbsp &nbsp 
<%}%>



第<%=pageNow%>页/共<%=pageCount%>页 		
	</br>
	</br>			
			
			</table>
			</div><!-- end of #tab1 -->
			
			
		</div><!-- end of .tab_container -->
		
		</article><!-- end of content manager article -->
		
		<article class="module width_quarter">
			<header><h3>消息</h3></header>
			<div class="message_list">
				<div class="module_content">
					<div class="message"><p>Vivamus sagittis lacus vel augue laoreet rutrum faucibus dolor.</p>
					<p><strong>John Doe</strong></p></div>
					<div class="message"><p>Vivamus sagittis lacus vel augue laoreet rutrum faucibus dolor.</p>
					<p><strong>John Doe</strong></p></div>
					<div class="message"><p>Vivamus sagittis lacus vel augue laoreet rutrum faucibus dolor.</p>
					<p><strong>John Doe</strong></p></div>
					<div class="message"><p>Vivamus sagittis lacus vel augue laoreet rutrum faucibus dolor.</p>
					<p><strong>John Doe</strong></p></div>
					<div class="message"><p>Vivamus sagittis lacus vel augue laoreet rutrum faucibus dolor.</p>
					<p><strong>John Doe</strong></p></div>
				</div>
			</div>
			<footer>
				<form class="post_message">
					<input type="text" value="Message" onfocus="if(!this._haschanged){this.value=''};this._haschanged=true;">
					<input type="submit" class="btn_post_message" value=""/>
				</form>
			</footer>
		</article><!-- end of messages article -->
		
		<div class="clear"></div>
		
		<article id="publog" class="module width_full">
		
		<form action="AddBlog" method="post">
			<header><h3>发布博文</h3></header>
				<div class="module_content">
				
				
						<fieldset>
							<label>博文标题</label>
							<input name="title" id="title" type="text">
						</fieldset>
						<fieldset>
							
							
                        <textarea class="ckeditor" cols="80" id="content" name="content" rows="10">  
                          
                        </textarea>  
							
						</fieldset>
						<fieldset style="width:48%; float:left; margin-right: 3%;"> <!-- to make two field float next to one another, adjust values accordingly -->
							<label>类别</label>
							<select name="cate" style="width:92%;">
							
							<option></option>
							
							<%  
                 
          
                  catedal ctdal=new catedal();
                   ResultSet caters=ctdal.searchcate(); //执行查询
                   while(caters.next()){
%> 
    
<option><%=caters.getString("cName")%></option>
							
<%
}   
                   
      
%>
						
							
								
							</select>
						</fieldset>
						
						
						
						<script type="text/javascript">
  
  function GetFace() {
var faceid = $("#SelFace").val();
if (faceid.length == 1) { faceid = "0" + faceid; }
$("#imgface").attr("src", "images/"+faceid+".jpg");
$("#picsrc").attr("value", "images/"+faceid+".jpg");
}
  
</script>     
						
						
						<fieldset style="width:48%; float:left;"> <!-- to make two field float next to one another, adjust values accordingly -->
							
							
								 <!-- to make two field float next to one another, adjust values accordingly -->
							<label>博文头标</label>
							<img id="imgface" name="imgface" src="images/01.jpg"  />
							 <select id="SelFace" name="SelFace" onchange="GetFace();" >
<option value="1">头像1</option>
<option value="2">头像2</option>
<option value="3">头像3</option>
<option value="4">头像4</option>
<option value="5">头像5</option>
<option value="6">头像6</option>
</select> 
                             
							<input name="picsrc" type="hidden" value="images/01.jpg" style="width:50%;">
							
							
						</fieldset><div class="clear"></div>
				</div>
			<footer>
				<div class="submit_link">
					<select>
						<option>推荐</option>
						<option>不推荐</option>
					</select>
					<input type="submit" value="发布" class="alt_btn" onclick="return check(this.form)">
					<input type="button" value="重置" onclick="reset_form();">
				</div>
			</footer>
			</form>
		</article><!-- end of post new article -->
		

  </body>
</html>
