package servlet;

import javax.servlet.http.HttpServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dal.commentreply;



public class Commentreply extends HttpServlet {

	
	
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

  
  String reply="";
  int cmid=0;
  
  
if(req.getParameter("reply")!=""&&req.getParameter("reply").length()<500)
{ 
	reply=new String(req.getParameter("reply").getBytes("ISO-8859-1"),"UTF-8");
}else{
	ms+="--回复不正确";       
  }
if(req.getParameter("cmid")!=""&&req.getParameter("cmid").length()<10)
{ 
	cmid=Integer.parseInt(new String(req.getParameter("cmid").getBytes("ISO-8859-1"),"UTF-8"));
}else{
	ms+="--评论id不正确";       
  }



      
if(reply!=""&&cmid!=0){
	


        commentreply comply=new commentreply();

        if(comply.insertcommentreply(reply,cmid))
       {
        ms="成功添加回复";
        //session=req.getSession();
   	   // session.setAttribute("ms",ms);
      // res.sendRedirect("catelist.jsp");
        req.setAttribute("ms", ms);
		RequestDispatcher rd=req.getRequestDispatcher("commentlist.jsp");
		rd.forward(req,res);
       }
       else
      {
       ms+="--回复添加失败";
       //session=req.getSession();
   	   // session.setAttribute("ms",ms);
      // res.sendRedirect("catelist.jsp");
        req.setAttribute("ms", ms);
		RequestDispatcher rd=req.getRequestDispatcher("commentlist.jsp");
		rd.forward(req,res);
       }  


        
} else{
	 ms+="--回复添加失败";
     //session=req.getSession();
 	   // session.setAttribute("ms",ms);
    // res.sendRedirect("catelist.jsp");
      req.setAttribute("ms", ms);
		RequestDispatcher rd=req.getRequestDispatcher("commentlist.jsp");
		rd.forward(req,res);
	
	
}




         
}
	
	
	}
	
}
