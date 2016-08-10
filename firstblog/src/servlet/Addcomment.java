package servlet;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dal.blogdal;
import dal.commentdal;
import dal.notificationdal;
import model.comment;
import model.notification;

public class Addcomment extends HttpServlet {
	
	

	String ms="";
	@Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
        //取得表单数据
         
	


		 String blogid="";
         String authcode="";
         blogid=request.getParameter("blogid");   
         HttpSession session=request.getSession(false); 
         
         
         if(request.getParameter("authcode")!="")
         {
                    authcode=request.getParameter("authcode");
         }
   




if(session.getAttribute("code").equals(authcode))          
{  
  
          String Name="";
          String Email="";
          String Message="";
          
          
          
  if(request.getParameter("name")!=""&&request.getParameter("name").length()<50)
    { 
    Name=new String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
    }else{
    	ms+="--用户名不正确";   
    }
    

     boolean flag = false;
     String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
      Pattern regex = Pattern.compile(check);
     Matcher matcher = regex.matcher(request.getParameter("email"));
      flag = matcher.matches();
    
     if(request.getParameter("email")!=""&&request.getParameter("email").length()<50&&flag)
      {

           Email = new String(request.getParameter("email").getBytes("ISO-8859-1"),"UTF-8"); 
      }else{
    	  ms+="--邮箱不正确";       
        }
  
  
      if(request.getParameter("message")!=""&&request.getParameter("message").length()<500)
      {
             Message=new String(request.getParameter("message").getBytes("ISO-8859-1"),"UTF-8");
       }
       else{
    	   ms+="--评论内容不正确";  
       }
   
   
      
   String Selection=request.getParameter("selection");
   
   
   
   
          
  if(Name!=""&&Email!=""&&Message!="")           
  {
       
            int id=Integer.parseInt(blogid);
            
            comment md=new comment(id,Name,Email,Message);      
            notification noti=new notification("评论",Name,Message);

            blogdal bgdal=new blogdal();
            commentdal comdal=new commentdal();
            notificationdal notidal=new notificationdal();
            
            if(comdal.insertcomment(md))
            {
             bgdal.updateblogcomment(id);
             notidal.insertnoti(noti);
             ms="评论成功";
             session=request.getSession();
        	 session.setAttribute("ms",ms);  
        	 response.sendRedirect("pageview.jsp?id="+blogid);
              
            }else
            {
            	ms+="评论失败";
                session=request.getSession();
           	 session.setAttribute("ms",ms);  
           	 response.sendRedirect("pageview.jsp?id="+blogid);
            }
          
                      
 
     }           

}else
{

	  ms+="验证码不正确评论失败";
     session=request.getSession();
	 session.setAttribute("ms",ms);  
	 response.sendRedirect("pageview.jsp?="+blogid);

}     
	  
  
	  
	  	  
	  

  
             }
	

}
