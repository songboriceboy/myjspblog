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
         
        //ȡ�ñ�����
         
		


  
  
  
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



//���Ϊ�� ɾ������ ��������� ɾ������ 
if(!bgdal.cateisnull(id))
{
	
	int blogcateid=bgdal.getblogcateid(id);
	if(comdal.deletallcomment(id)&&ctdal.decateblogsum(blogcateid))
	{
		if(bgdal.deletblog(id))
		{
			ms="�ɹ�ɾ������";
			session=req.getSession();
			 session.setAttribute("ms",ms);
			res.sendRedirect("bloglist.jsp");
			
		}
		else			
		{   
			ms="ɾ������ʧ��";
			session=req.getSession();
		   session.setAttribute("ms",ms);
			res.sendRedirect("bloglist.jsp");
		

		}    
	}
	//���Ϊ�� ɾ������ ɾ������ 
}else
{
	
	if(comdal.deletallcomment(id))
	{
		if(bgdal.deletblog(id))
		{
			
		ms="�ɹ�ɾ������";	
		session=req.getSession();
		 session.setAttribute("ms",ms);
		res.sendRedirect("bloglist.jsp");
		}
		else
		{
			ms="ɾ������ʧ��";
			session=req.getSession();
		   session.setAttribute("ms",ms);
			res.sendRedirect("bloglist.jsp");

		}    
	}
	
}


   

 
}
         
    }   

	
	
	

}
