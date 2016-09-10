package dal;

import java.sql.*;

import org.apache.commons.lang.StringEscapeUtils;

import model.admin;
import model.blog;
import utils.dbconstant;

public class admindal {
	
	 String driverClass=dbconstant.getDriverclass();

	 String  url=dbconstant.getUrl();

    String dbUser = dbconstant.getDbuser();   

    String dbPwd = dbconstant.getDbpwd();  
  
	Connection con = null;

	
//查询是否有用户 判断是否首次运行	
public static int sumadmin(){
			
			
			
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
		           
		           String sumblogSql="select count(*) from  admin";
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
		
	
	
	//登录
public ResultSet adminlogin(admin adm){
	
	
	   try{   
		  
      
		 Class.forName(driverClass);
   	     con = DriverManager.getConnection(url,dbUser,dbPwd); 
         Statement stmt=con.createStatement();  	
		

          String sql="select * from  admin where uAccount='"+adm.getAccount()+"'and uPassword='"+adm.getPassword()+"'";        
          //sql = StringEscapeUtils.escapeSql(sql);  //防sql注入
          
          ResultSet rs=stmt.executeQuery(sql); //执行查询 
          return rs;
	    }catch(Exception ex)
	          {   

	                 System.out.print("连接失败！！<br>"+ex.toString());   
	                 return null;

	           } 

}  
	


//重置密码

public boolean resetpwd(admin adm){
	
	
	   try{   
		  boolean f=false;
   
		 Class.forName(driverClass);
	     con = DriverManager.getConnection(url,dbUser,dbPwd); 
      Statement stmt=con.createStatement();  	
		

       String sql="select * from  admin where uAccount='"+adm.getAccount()+"'";
       ResultSet rs=stmt.executeQuery(sql); //执行查询
       if(rs.next()){
    	   
    	   if(rs.getString("uZiploc").equals(adm.getQuestion())&&rs.getString("answer").equals(adm.getAnswer()))
    	   {
    		   
    		   String uppwdsql = "update admin set uPassword=\""+adm.getPassword()+"\"";

    	        
               
                        if(stmt.executeUpdate(uppwdsql)==1); //执行查询 
                     {f=true;}
                  
                           stmt.close();   

                         con.close();   
                          return f;
    	            }
    	   
               }else{
    	   
    	   f=false;
    	   
       }
       return f;
       
	    }catch(Exception ex)
	          {   

	                 System.out.print("连接失败！！<br>"+ex.toString());   
	                 return false;

	           } 

}  




public  boolean insertadmin(admin inadmin) {
    
    boolean f=false;


 try{   

	  //使用驱动  获取连接   获取 Statement
	  Class.forName(driverClass);
	  con = DriverManager.getConnection(url,dbUser,dbPwd); 
     Statement stmt=con.createStatement();  	          
     String inadminSql="";
     
   
   	  
   	  inadminSql= "insert into admin(`uAccount`,`uPassword`,`uZiploc`,`uAnswer`) values(\'"+inadmin.getAccount()+"\',\'"+inadmin.getPassword()+"\',\'"+inadmin.getQuestion()+"\',\'"+inadmin.getAnswer()+"\')";
   	  
    
         
   //执行插入
     if(stmt.executeUpdate(inadminSql)==1)  
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







	
}
	
	
	
	


