<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@ page import="java.io.*"%>   
  
<%@ page import="java.util.*"%>   

<%@ page import="model.blog"%>   
  
<%@ page import="dal.blogdal"%>   

<%@ page import="dal.catedal"%>
  
<%@ page import="java.sql.*"%>  

<!DOCTYPE HTML>
<html>
  <head>


    <script type="text/javascript">  
        window.onload = function(){  
            CKEDITOR.replace('content');  
        }  
    </script>  


 <script type="text/javascript" src="<%=request.getContextPath()%>/ckeditor/ckeditor.js"></script>
    
    
    
    <script type="text/javascript">
function reset_form()
{
	document.getElementById('title').value ='';
	document.getElementById('cate').value ='';
	 CKEDITOR.instances.content.setData("");
	return false;
}
					 
</script>
    
    <script type="text/javascript">
         function check(form) {

        
          if(form.title.value==''||form.title.value.length>50) {
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
  
  
    
    <article id="publog" class="module width_full">
		
		
		
		
		<form action="UpdateBlog" method="post">
			<header><h3>发布博文</h3></header>
				<div class="module_content">
				
				
				<%  				
							
							int blogid=Integer.parseInt(request.getParameter("id"));
                 
             
                    blogdal bgdal=new blogdal();
             
                   ResultSet rs=bgdal.selectblogbyid(blogid); //执行查询
                   if(rs.next()){
%> 
    
    
    
    <input name="blogid" type="hidden" value="<%=blogid%>" >
    
<fieldset>
							<label>博文标题</label>
							<input name="title" id="title" type="text" value="<%=rs.getString("bTitle")%>" >
						</fieldset>
						<fieldset>
							
							
							
							
                        <textarea class="ckeditor" cols="80" id="content" name="content" rows="10">  
                          <%=rs.getString("bContent")%>
                        </textarea>  
	
	

	
							
						</fieldset>
						<fieldset style="width:48%; float:left; margin-right: 3%;"> <!-- to make two field float next to one another, adjust values accordingly -->
							<label>类别</label>
							
							<% 
							String bcatename="";
							if(rs.getString("bCatename")!=null)
							 bcatename=rs.getString("bCatename");
							%>
							
							<select id="cate" name="cate" style="width:92%;">
							
							<option><%=bcatename %></option>
	<%
}   
               
      
%>							
							
							
							
							<%  
                 
             
             
  
                    
                   catedal ctdal=new catedal();
                   ResultSet caters=ctdal.searchcate(); //执行查询
                   while(caters.next()){
%> 
    <option></option>
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
							<label>博文头标</label>
							<img id="imgface" name="imgface" src="images/01.jpg"  />
							 <select id="SelFace" name="SelFace" onchange="GetFace();">
<option value="1">头像1</option>
<option value="2">头像2</option>
<option value="3">头像3</option>
<option value="4">头像4</option>
<option value="5">头像5</option>
<option value="6">头像6</option>
</select> 
       <input id="picsrc" name="picsrc" type="hidden" value="images/01.jpg" >                      
						
						</fieldset>
						
						
						<div class="clear"></div>					
				</div>
				
				
				
				
				
				
			<footer>
				<div class="submit_link">
					<select>
						<option>推荐</option>
						<option>不推荐</option>
					</select>
				
					<input type="submit" value="发送" class="alt_btn" onclick="return check(this.form)">
					<input type="button" value="重置" onclick="reset_form();">
				</div>
			</footer>
			</form>
		</article><!-- end of post new article -->
    
    
  </body>
</html>
