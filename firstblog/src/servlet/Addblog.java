package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dal.blogdal;
import model.blog;
import dal.catedal;

public class Addblog extends HttpServlet {
	
	
	
	String ms="";
	@Override
    protected void service(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
         
        //ȡ�ñ�����
         
	


  String title="";
  String content="";
  String cate="";
  String picsrc="";
  
  HttpSession session=req.getSession(false);  
  if(session==null){  
	  res.setHeader("Refresh","2;URL=login.jsp");
       
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


if(req.getParameter("content")!="")
{
     content=new String(req.getParameter("content").getBytes("ISO-8859-1"),"UTF-8");
}
else{
ms+="--���ݲ���ȷ";        
  }
      

if(req.getParameter("picsrc")!=""&&req.getParameter("picsrc").length()<100)
{
     picsrc=new String(req.getParameter("picsrc").getBytes("ISO-8859-1"),"UTF-8");
}
else{
ms+="--ͼƬ��ַ����ȷ";        
  }



if(title!=""&&content!=""&&picsrc!=""){
	
blogdal bgdal=new blogdal();
catedal ctdal=new catedal();

blog bg;
if(cate=="")
{
     bg=new blog(picsrc,title,content);
     if(bgdal.insertblog(bg))
     {
     ms="�ɹ���Ӳ���";
     //���ش�����Ϣ
	 session=req.getSession();
	 session.setAttribute("ms",ms);  
	 res.sendRedirect("bloglist.jsp");
	 
     }
     else
     {
     ms+="--�������ʧ��";
     session=req.getSession();
	 session.setAttribute("ms",ms);
     res.sendRedirect("bloglist.jsp");
     }
     
     
}else{
	 int cateid= ctdal.searchidbycatename(cate);
	 
if(ctdal.hassamename(cate))  //�������Ƿ����
{	 
     bg=new blog(cateid,picsrc,cate,title,content);
         
     if(bgdal.insertblog(bg))
     {
    	 ctdal.addcateblogsum(cateid);
     ms="�ɹ���Ӳ���";
     session=req.getSession();
	 session.setAttribute("ms",ms);
     res.sendRedirect("bloglist.jsp");
     }
     else
     {
     ms+="--�������ʧ��";
     session=req.getSession();
	 session.setAttribute("ms",ms);
     res.sendRedirect("bloglist.jsp");
     }
     
     
}else{
	ms+="--��𲻴��ڲ������ʧ��";
    session=req.getSession();
	 session.setAttribute("ms",ms);
    res.sendRedirect("bloglist.jsp");
	
}


}



	} else{
		ms+="--�������ʧ��";
		session=req.getSession();
		 session.setAttribute("ms",ms);
		res.sendRedirect("bloglist.jsp");
	      }
        
        
         
    } 
  
	}

}
