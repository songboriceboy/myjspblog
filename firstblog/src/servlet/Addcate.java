package servlet;

import javax.servlet.http.HttpServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dal.catedal;
import model.category;


public class Addcate extends HttpServlet {

	
	
	String ms="";
	@Override
    protected void service(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
         
        //取得表单数据
         
		
		HttpSession session=req.getSession(false);  
		  if(session==null){  
			  res.setHeader("Refresh","2;URL=login.jsp");
		       
		  }  
		  
		  String login =(String)session.getAttribute("Login");
		  if(login==null){    
		        
		        res.setHeader("Refresh","2;URL=login.jsp");
		  }else{

  
  String catename="";
  
  
  
if(req.getParameter("catename")!=""&&req.getParameter("catename").length()<50)
{ 
	catename=new String(req.getParameter("catename").getBytes("ISO-8859-1"),"UTF-8");
}else{
	ms+="--类别不正确";       
  }




      
if(catename!=""){
	
catedal ctdal=new catedal();
category cate=new category(catename,0);


if(!ctdal.hassamename(catename)){
        if(ctdal.insertcate(cate))
       {
        ms="成功添加类别";
        //session=req.getSession();
   	   // session.setAttribute("ms",ms);
      // res.sendRedirect("catelist.jsp");
        req.setAttribute("ms", ms);
		RequestDispatcher rd=req.getRequestDispatcher("catelist.jsp");
		rd.forward(req,res);
       }
       else
      {
       ms+="--类别添加失败";
       //session=req.getSession();
   	   // session.setAttribute("ms",ms);
      // res.sendRedirect("catelist.jsp");
        req.setAttribute("ms", ms);
		RequestDispatcher rd=req.getRequestDispatcher("catelist.jsp");
		rd.forward(req,res);
       }  
}else{
	
	 ms+="--类别同名添加失败";
	  //session=req.getSession();
 	   // session.setAttribute("ms",ms);
    // res.sendRedirect("catelist.jsp");
      req.setAttribute("ms", ms);
		RequestDispatcher rd=req.getRequestDispatcher("catelist.jsp");
		rd.forward(req,res);
}



	} else{
		
		ms+="--类别为空,添加失败";
		  //session=req.getSession();
	   	   // session.setAttribute("ms",ms);
	      // res.sendRedirect("catelist.jsp");
	        req.setAttribute("ms", ms);
			RequestDispatcher rd=req.getRequestDispatcher("catelist.jsp");
			rd.forward(req,res);
	       }


        
        
         
    }   
	
	
	}
	
}
