package servlet;

import javax.servlet.http.HttpServlet;


import javax.servlet.http.HttpSession;



import dal.blogdal;
import java.io.IOException;
import dal.commentdal;
import dal.catedal;
 



import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Deletblog extends HttpServlet {
	
	
	
	String ms;
	@Override
    protected void service(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
         
        //取得表单数据
         
		


  
  
  
int id=Integer.parseInt(req.getParameter("id"));


HttpSession session=req.getSession(false);  
if(session==null){  
	  res.setHeader("Refresh","2;URL=login.jsp");
     
}  

String login =(String)session.getAttribute("Login");
if(login==null){    
      
      res.setHeader("Refresh","2;URL=login.jsp");
}else{

      

blogdal bgdal=new blogdal();
catedal ctdal=new catedal();
commentdal comdal=new commentdal();



//类别不为空 删除评论 减少类别数 删除博客 
if(!bgdal.cateisnull(id))
{
	
	int blogcateid=bgdal.getblogcateid(id);
	if(comdal.deletallcomment(id)&&ctdal.decateblogsum(blogcateid))
	{
		if(bgdal.deletblog(id))
		{
			ms="成功删除博客";
			session=req.getSession();
			 session.setAttribute("ms",ms);
			res.sendRedirect("bloglist.jsp");
			
		}
		else			
		{   
			ms="删除博客失败";
			session=req.getSession();
		   session.setAttribute("ms",ms);
			res.sendRedirect("bloglist.jsp");
		

		}    
	}
	//类别为空 删除评论 删除博客 
}else
{
	
	if(comdal.deletallcomment(id))
	{
		if(bgdal.deletblog(id))
		{
			
		ms="成功删除博客";	
		session=req.getSession();
		 session.setAttribute("ms",ms);
		res.sendRedirect("bloglist.jsp");
		}
		else
		{
			ms="删除博客失败";
			session=req.getSession();
		   session.setAttribute("ms",ms);
			res.sendRedirect("bloglist.jsp");

		}    
	}
	
}


   

 
}
         
    }   

	
	
	

}
