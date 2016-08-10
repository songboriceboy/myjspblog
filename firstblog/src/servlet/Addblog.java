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
         
        //取得表单数据
         
	


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
	ms+="--标题不正确";       
  }




if(req.getParameter("cate")!=""&&req.getParameter("cate").length()<50)
{ 
cate=new String(req.getParameter("cate").getBytes("ISO-8859-1"),"UTF-8");
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
      

if(req.getParameter("picsrc")!=""&&req.getParameter("picsrc").length()<100)
{
     picsrc=new String(req.getParameter("picsrc").getBytes("ISO-8859-1"),"UTF-8");
}
else{
ms+="--图片地址不正确";        
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
     ms="成功添加博客";
     //返回错误信息
	 session=req.getSession();
	 session.setAttribute("ms",ms);  
	 res.sendRedirect("bloglist.jsp");
	 
     }
     else
     {
     ms+="--博客添加失败";
     session=req.getSession();
	 session.setAttribute("ms",ms);
     res.sendRedirect("bloglist.jsp");
     }
     
     
}else{
	 int cateid= ctdal.searchidbycatename(cate);
	 
if(ctdal.hassamename(cate))  //检测类别是否存在
{	 
     bg=new blog(cateid,picsrc,cate,title,content);
         
     if(bgdal.insertblog(bg))
     {
    	 ctdal.addcateblogsum(cateid);
     ms="成功添加博客";
     session=req.getSession();
	 session.setAttribute("ms",ms);
     res.sendRedirect("bloglist.jsp");
     }
     else
     {
     ms+="--博客添加失败";
     session=req.getSession();
	 session.setAttribute("ms",ms);
     res.sendRedirect("bloglist.jsp");
     }
     
     
}else{
	ms+="--类别不存在博客添加失败";
    session=req.getSession();
	 session.setAttribute("ms",ms);
    res.sendRedirect("bloglist.jsp");
	
}


}



	} else{
		ms+="--博客添加失败";
		session=req.getSession();
		 session.setAttribute("ms",ms);
		res.sendRedirect("bloglist.jsp");
	      }
        
        
         
    } 
  
	}

}
