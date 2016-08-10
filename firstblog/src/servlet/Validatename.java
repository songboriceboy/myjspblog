package servlet;

import javax.servlet.http.HttpServlet;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

import model.admin;
import utils.dbconstant;


public class Validatename extends HttpServlet {
	
	 String driverClass=dbconstant.getDriverclass();

	 String  url=dbconstant.getUrl();

      String dbUser = dbconstant.getDbuser();   

      String dbPwd = dbconstant.getDbpwd();  
  
	  Connection con = null;
	
	
	
	  @Override
	 public void doPost(HttpServletRequest request, HttpServletResponse response) 
		        throws IOException, ServletException {
		            String user_name = new String(request.getParameter("userName").getBytes("ISO-8859-1"), "UTF-8");	  
		            PrintWriter out = response.getWriter();
		          
		            ResultSet rs = null;
		            String sqlString = "select * from admin where uAccount=\'"+user_name+"\'";
		            try {
		              
		            	  Class.forName(driverClass);
		            	  con = DriverManager.getConnection(url,dbUser,dbPwd); 
		                  Statement stmt=con.createStatement();  	 
		            	
		                
		                rs = stmt.executeQuery(sqlString);
		                if(rs.next())
		                    out.println("1");
		                else
		                    out.println("0");
		            } catch(ClassNotFoundException e) {
		                out.println("ClassNotFoundException"); 
		            } catch(SQLException ex) {
		                out.println("SQLException");
		            } catch(Exception exe) {
		                out.println("OtherException");
		            }           
		  }
		

}
	
	


