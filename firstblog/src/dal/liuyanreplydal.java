package dal;

import java.sql.*;

import model.admin;
import utils.dbconstant;
public class liuyanreplydal {
	
	 String driverClass=dbconstant.getDriverclass();

	 String  url=dbconstant.getUrl();

    String dbUser = dbconstant.getDbuser();   

    String dbPwd = dbconstant.getDbpwd();  
  
	Connection con = null;
	
	//插入回复
	
	public  boolean insertliuyanreply(String lreply,int lyid) {
	    
	    boolean f=false;


	 try{   

		  //使用驱动  获取连接   获取 Statement
		  Class.forName(driverClass);
		  con = DriverManager.getConnection(url,dbUser,dbPwd); 
	     Statement stmt=con.createStatement();  	          
	  
	     
	   
	   	  
	   	  String inliuyanreplySql= "insert into liuyanreply(`lreply`,`lyId`,`lrDate`) values(\'"+lreply+"\',\'"+lyid+"\',null)";
	   	  
	    
	         
	   //执行插入
	     if(stmt.executeUpdate(inliuyanreplySql)==1)  
	      {	   	  
	   	  f=true;
	      }
	         stmt.close();   
	         con.close(); 
	       return f;


	}catch(Exception ex)
	   {   

	           System.out.print("连接失败！！<br>"+ex.toString());   
	           return false;

	     }    

	}

	
	
	
	
	
	//根据留言id查询所有回复

	public  ResultSet searchallreplybycmid(int lyid){
		 
		 try{   
			  
	      

			//使用驱动  获取连接   获取 Statement
			   Class.forName(driverClass);                 
	          Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
	          Statement stmt=con.createStatement();   
			 
	   

	       String liuyanreplysql="select * from liuyanreply where lyId='"+lyid+"'";                    

	       ResultSet rs=stmt.executeQuery(liuyanreplysql); //执行查询 
	      
	         
	 // stmt.close();   

	 // con.close();   
	  return rs;

		 }

	catch(Exception ex)
	{   

	System.out.print("连接失败！！<br>"+ex.toString());   
	return null;

	} 
		 
		 
	}

	
	
	
	
	

}
