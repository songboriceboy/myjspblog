package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import utils.dbconstant;

public class lbblog {
	
	

	
	
	
	//计算博客总数
public static int sumblog(){
		
		
		
		String driverClass=dbconstant.getDriverclass();

		 String  url=dbconstant.getUrl();

	    String dbUser = dbconstant.getDbuser();   

	    String dbPwd = dbconstant.getDbpwd();  
		
		
		 
		try{   
			    int sum=0;
				//使用驱动  获取连接   获取 Statement
			   Class.forName(driverClass);                 
	           Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
	           Statement stmt=con.createStatement();   
	           
	           String sumblogSql="select count(*) from  blog";
	           ResultSet sumRs=stmt.executeQuery(sumblogSql); //执行查询 
	           
	           if(sumRs.next()){
	                 sum=sumRs.getInt(1);
	             }
	           
	           stmt.close();   
	           
	           con.close(); 
	           return sum;
	        
		 }catch(Exception ex)
	     {   

	            System.out.print("连接失败！！<br>"+ex.toString());   
	            return 0;

	        } 
		
		
	}
	
	
	
	
//查询所有轮播博客
	
public static ResultSet searchlbblog()
	 {
		
		String driverClass=dbconstant.getDriverclass();

		 String  url=dbconstant.getUrl();

	    String dbUser = dbconstant.getDbuser();   

	    String dbPwd = dbconstant.getDbpwd();  
			
		
		 
		 try{   
			  
			 
          
    
			 //使用驱动  获取连接   获取 Statement
       	    Class.forName(driverClass);
       	    Connection con = DriverManager.getConnection(url,dbUser,dbPwd); 
             Statement stmt=con.createStatement();  

              int sumbg=sumblog();
           String sql="select * from blog limit 0,4";
            

           ResultSet lbrs=stmt.executeQuery(sql); //执行查询 
          
             
     // stmt.close();   

     // con.close();   
      return lbrs;
 
		 }
 
catch(Exception ex)
{   

System.out.print("连接失败！！<br>"+ex.toString());   
return null;

} 
		 
		 
	 }

}
