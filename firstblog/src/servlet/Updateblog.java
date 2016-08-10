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
         
        //ȡ�ñ�����
         
		
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
	ms+="--���ⲻ��ȷ";       
  }




if(req.getParameter("cate")!=""&&req.getParameter("cate").length()<50)
{ 
cate=new String(req.getParameter("cate").getBytes("ISO-8859-1"),"UTF-8");
}else{
	ms+="--�����ȷ";       
  }


if(req.getParameter("picsrc")!=""&&req.getParameter("picsrc").length()<100)
{ 
picsrc=new String(req.getParameter("picsrc").getBytes("ISO-8859-1"),"UTF-8");
}else{
	ms+="--�����ȷ";       
  }


if(req.getParameter("content")!="")
{
     content=new String(req.getParameter("content").getBytes("ISO-8859-1"),"UTF-8");
}
else{
ms+="--���ݲ���ȷ";        
  }
      
if(title!=""&&content!=""&&picsrc!=""){
	
blogdal bgdal=new blogdal();
catedal ctdal=new catedal();

if(cate=="")
{
	 blog upbg;
	
	 int agocateid=bgdal.searchcateidbyblogid(blogid);
	 //������� ����Ϊ��   ----��ʼΪ��--  ֱ�Ӹ��²���   --------kkkkk
           if(bgdal.cateisnull(blogid))
          {
        	   upbg=new blog(blogid,picsrc,title,content);
	         if(bgdal.updateblogcatenulltonull(upbg))
	         { 
	        	 ms="���ͳɹ�����";
	        	  session=req.getSession();
	 			 session.setAttribute("ms",ms);
	        	 res.sendRedirect("bloglist.jsp");
	         }else
	         {
	        	 ms+="���͸���ʧ��";
	        	  session=req.getSession();
	 			 session.setAttribute("ms",ms);
	        	 res.sendRedirect("bloglist.jsp");
	        	}
	         
	         
          }else{         	  // ����Ϊ�� �������ʼ��Ϊ��  ���������  ���²���
        	  
        	
        	  upbg=new blog(blogid,picsrc,title,content);
              if(ctdal.decateblogsum(agocateid))
             {
            	  if(bgdal.updateblogcatenotnulltonull(upbg)){
            		  ms="���ͳɹ�����";
    	        	  session=req.getSession();
    	 			 session.setAttribute("ms",ms);
    	        	 res.sendRedirect("bloglist.jsp");
            	        }
            	  
              }else
              {
            	  ms+="���͸���ʧ��";
	        	  session=req.getSession();
	 			 session.setAttribute("ms",ms);
	        	 res.sendRedirect("bloglist.jsp");
            	}
              
          }	
           
           
    }else{
    	
    	
    	
    	int cateid=ctdal.searchidbycatename(cate);
    	int agocateid=bgdal.searchcateidbyblogid(blogid);
    	blog upbg=new blog(blogid,cateid,picsrc,cate,title,content);
    	
    	 //���ڲ�Ϊ��  �������ʼΪ��   ���²��� �������� -----kkkkkkkkkk
    	   if(bgdal.cateisnull(blogid))
           {
 	         if(bgdal.updateblogcatenulltonotnull(upbg))
 	         {   
 	            ctdal.addcateblogsum(cateid);
 	             ms="���ͳɹ�����";
     	        session=req.getSession();
			    session.setAttribute("ms",ms);
     	        res.sendRedirect("bloglist.jsp");
     	 
     	 
 	         }else
 	         {
 	        	  ms+="���͸���ʧ��";
	        	  session=req.getSession();
	 			 session.setAttribute("ms",ms);
	        	 res.sendRedirect("bloglist.jsp");
 	        	}
 	         
 	         
           }else{ //���ڲ�Ϊ�� �������ʼ��Ϊ��   ���²��� 
               if(bgdal.updateblogcatenotnulltonotnull(upbg))
              {
            	   ctdal.decateblogsum(agocateid);
            	   ctdal.addcateblogsum(cateid);
            	   ms="���ͳɹ�����";
 	        	  session=req.getSession();
 	 			 session.setAttribute("ms",ms);
 	        	 res.sendRedirect("bloglist.jsp");
               }else
               {
            	   ms+="���͸���ʧ��";
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
