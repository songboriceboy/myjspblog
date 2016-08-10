package servlet;

import java.io.IOException;
import model.blog;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dal.blogdal;
import dal.catedal;

public class Updateblog extends HttpServlet {
	
	 
	
	String ms="";
	@Override
    protected void service(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
         
        //取得表单数据
         
		
		int blogid=Integer.parseInt(req.getParameter("blogid"));

  String title="";
  String content="";
  String cate="";
  String picsrc="";
  
  HttpSession session=req.getSession(false);  
  if(session==null){  
	  res.setHeader("Refresh","2;URL=login.jsp");
     return;
  }  
  String login =(String)session.getAttribute("Login");
  if(login==null){    
        
        res.setHeader("Refresh","2;URL=login.jsp");
  }else{
  
  
  
if(req.getParameter("title")!=""&&req.getParameter("title").length()<100)
{ 
title=new String(req.getParameter("title").getBytes("ISO-8859-1"),"UTF-8");
}else{
	ms+="--标题不正确";       
  }




if(req.getParameter("cate")!=""&&req.getParameter("cate").length()<50)
{ 
cate=new String(req.getParameter("cate").getBytes("ISO-8859-1"),"UTF-8");
}else{
	ms+="--类别不正确";       
  }


if(req.getParameter("picsrc")!=""&&req.getParameter("picsrc").length()<100)
{ 
picsrc=new String(req.getParameter("picsrc").getBytes("ISO-8859-1"),"UTF-8");
}else{
	ms+="--类别不正确";       
  }


if(req.getParameter("content")!="")
{
     content=new String(req.getParameter("content").getBytes("ISO-8859-1"),"UTF-8");
}
else{
ms+="--内容不正确";        
  }
      
if(title!=""&&content!=""&&picsrc!=""){
	
blogdal bgdal=new blogdal();
catedal ctdal=new catedal();

if(cate=="")
{
	 blog upbg;
	
	 int agocateid=bgdal.searchcateidbyblogid(blogid);
	 //博文类别 现在为空   ----开始为空--  直接更新博文   --------kkkkk
           if(bgdal.cateisnull(blogid))
          {
        	   upbg=new blog(blogid,picsrc,title,content);
	         if(bgdal.updateblogcatenulltonull(upbg))
	         { 
	        	 ms="博客成功更新";
	        	  session=req.getSession();
	 			 session.setAttribute("ms",ms);
	        	 res.sendRedirect("bloglist.jsp");
	         }else
	         {
	        	 ms+="博客更新失败";
	        	  session=req.getSession();
	 			 session.setAttribute("ms",ms);
	        	 res.sendRedirect("bloglist.jsp");
	        	}
	         
	         
          }else{         	  // 现在为空 博文类别开始不为空  减少类别数  更新博文
        	  
        	
        	  upbg=new blog(blogid,picsrc,title,content);
              if(ctdal.decateblogsum(agocateid))
             {
            	  if(bgdal.updateblogcatenotnulltonull(upbg)){
            		  ms="博客成功更新";
    	        	  session=req.getSession();
    	 			 session.setAttribute("ms",ms);
    	        	 res.sendRedirect("bloglist.jsp");
            	        }
            	  
              }else
              {
            	  ms+="博客更新失败";
	        	  session=req.getSession();
	 			 session.setAttribute("ms",ms);
	        	 res.sendRedirect("bloglist.jsp");
            	}
              
          }	
           
           
    }else{
    	
    	
    	
    	int cateid=ctdal.searchidbycatename(cate);
    	int agocateid=bgdal.searchcateidbyblogid(blogid);
    	blog upbg=new blog(blogid,cateid,picsrc,cate,title,content);
    	
    	 //现在不为空  博文类别开始为空   更新博文 添加类别数 -----kkkkkkkkkk
    	   if(bgdal.cateisnull(blogid))
           {
 	         if(bgdal.updateblogcatenulltonotnull(upbg))
 	         {   
 	            ctdal.addcateblogsum(cateid);
 	             ms="博客成功更新";
     	        session=req.getSession();
			    session.setAttribute("ms",ms);
     	        res.sendRedirect("bloglist.jsp");
     	 
     	 
 	         }else
 	         {
 	        	  ms+="博客更新失败";
	        	  session=req.getSession();
	 			 session.setAttribute("ms",ms);
	        	 res.sendRedirect("bloglist.jsp");
 	        	}
 	         
 	         
           }else{ //现在不为空 博文类别开始不为空   更新博文 
               if(bgdal.updateblogcatenotnulltonotnull(upbg))
              {
            	   ctdal.decateblogsum(agocateid);
            	   ctdal.addcateblogsum(cateid);
            	   ms="博客成功更新";
 	        	  session=req.getSession();
 	 			 session.setAttribute("ms",ms);
 	        	 res.sendRedirect("bloglist.jsp");
               }else
               {
            	   ms+="博客更新失败";
 	        	  session=req.getSession();
 	 			 session.setAttribute("ms",ms);
 	        	 res.sendRedirect("bloglist.jsp");
             	}
               
           }	
    	
    	
    	
    	
    	
    	
    	
    	
    }








}   
	
        
  



    }   
  
  
	}

}
