package dal;
import java.sql.*;

import model.mood;
import utils.dbconstant;

public class mooddal {
	
	
	 String driverClass=dbconstant.getDriverclass();

	 String  url=dbconstant.getUrl();

    String dbUser = dbconstant.getDbuser();   

    String dbPwd = dbconstant.getDbpwd();  
  
	Connection con = null;

	
	
	//查询心情总数
public int summood(){
		
		 
		try{   
			    int sum=0;
				//使用驱动  获取连接   获取 Statement
			   Class.forName(driverClass);                 
	           Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
	           Statement stmt=con.createStatement();   
	           
	           String summoodsql="select count(*) from  mood";
	           ResultSet sumRs=stmt.executeQuery(summoodsql); //执行查询 
	           
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
	
	

	//分页查询留言


public ResultSet selectmoodpage(int pageSize,int pageNow){
		
		 
		try{   
			   
				//使用驱动  获取连接   获取 Statement
			   Class.forName(driverClass);                 
	           Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
	           Statement stmt=con.createStatement();   
	           
	           ResultSet moodRs=stmt.executeQuery("select * from mood order by moDate DESC LIMIT "+pageSize*(pageNow-1)+","+pageSize);
	             //执行查询          
	           
	          // stmt.close();   
	           
	          // con.close(); 
	           return moodRs;
	        
		 }catch(Exception ex)
	     {   

	            System.out.print("连接失败！！<br>"+ex.toString());   
	            return null;

	        } 
		
		
	}
	
	
	
	
	
	
	//插入心情
 public  boolean insertmood(mood md) {
	                 
		           
		            boolean f=false;
	  	          
	              try{   
	   
	                     
	             
	            	  //使用驱动  获取连接   获取 Statement
	            	  Class.forName(driverClass);
	            	  con = DriverManager.getConnection(url,dbUser,dbPwd); 
	                  Statement stmt=con.createStatement();  
	                    
	                      
	                    String inmoodsql= "insert into mood(`mopicsrc`,`moContent`,`moDate`) values(\'"+md.getPicSrc()+"\',\'"+md.getContent()+"\',"+"null)";
	                   
	                                        
	                      
	                     if(stmt.executeUpdate(inmoodsql)==1); 
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
	 

 
 
	 
public  ResultSet searchmood()
	 {
		 
		 
		 try{   
			  
           
     
            Class.forName("com.mysql.jdbc.Driver");

            String sql="select * from mood";
            
            Connection con = DriverManager.getConnection(url,dbUser,dbPwd);

           // out.print("已连接5。。。。。");   

            Statement stmt=con.createStatement();   

            ResultSet rs=stmt.executeQuery(sql); //执行查询 
           
              
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
