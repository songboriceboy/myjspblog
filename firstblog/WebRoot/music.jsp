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

    
	
	<link rel="stylesheet" type="text/css" href="styles.css">
	<meta charset="utf-8"/>
	<title>音乐管理</title>
	
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
function reset_form()
{
	
	document.getElementById('upfile1').value ='';
	document.getElementById('upfile2').value ='';
	document.getElementById('upfile3').value ='';
	document.getElementById('upfile4').value ='';
	document.getElementById('upfile5').value ='';
	
	return false;
}
					 
</script>
    
    <script type="text/javascript">
         function check(form) {

           
             if(form.upfile1.value.length>200) {
                alert("请输入合适大小文件名!");
                form.upfile1.focus();
                return false;
           }
           
          if(form.upfile2.value.length>200) {
                alert("请输入合适大小文件名!");
                form.upfile2.focus();
                return false;
           }
           
           if(form.upfile3.value.length>200) {
               alert("请输入合适大小文件名!");
                form.upfile3.focus();
                return false;
           }
           if(form.upfile4.value.length>200) {
               alert("请输入合适大小文件名!");
                form.upfile4.focus();
                return false;
           }
           if(form.upfile5.value.length>200) {
                alert("请输入合适大小文件名!");
                form.upfile5.focus();
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
				
    
<form action='UploadMusic' method='post' enctype='multipart/form-data'>

请选择要上传的文件1<input type='file' id="upfile1" name='upfile1' size='200'>
</br>
请选择要上传的文件2<input type='file' id="upfile2" name='upfile2' size='200'>
</br>
请选择要上传的文件3<input type='file' id="upfile3" name='upfile3' size='200'>
</br>
请选择要上传的文件4<input type='file' id="upfile4" name='upfile4' size='200'>
</br>
请选择要上传的文件5<input type='file' id="upfile5" name='upfile5' size='200'>

</br>
</br>
<input type="submit" class="button" value="提交" onclick="return check(this.form)"/>
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
	
	</br>
	</br>
	
	<%
	
	        String filepath =request.getSession().getServletContext().getRealPath("/")+"upload/musics/";
	        
         File f = new File(filepath);
         if (!f.exists()) {
             System.out.println(filepath + " not exists");
             return;
         }
 
          
         File fa[] = f.listFiles();
         for (int i = 0; i < fa.length; i++) {
             File fs = fa[i];
             if (fs.isDirectory()) {
                 System.out.println(fs.getName() + " [目录]");
             } else {
             String file=fs.getName();
            String fp="upload/musics/"+file;
            String type="m";
              %>
               <li>
               
               
            <a href=<%=fp%> target="_blank">
               <span><%=file%></span>               
            </a>
            &nbsp &nbsp &nbsp
          <a href="DeleteMusic?path=<%=file%>" target="_blank">
               <span>删除</span>               
            </a>
           &nbsp &nbsp &nbsp
          <a href="rename.jsp?type=<%=type%>&path=<%=file%>" target="_blank">
               <span>重命名</span>               
            </a>
          
             </li> 
             </br>
            
              <%
                    }
        }
               %>

	
</div>					
   
   
  
  
   
   
    
    
  </body>
</html>
