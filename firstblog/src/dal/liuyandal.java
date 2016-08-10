package dal;
import java.sql.*;

import model.liuyan;
import utils.dbconstant;

public class liuyandal {
	
	
	String driverClass=dbconstant.getDriverclass();

	 String  url=dbconstant.getUrl();

  String dbUser = dbconstant.getDbuser();   

  String dbPwd = dbconstant.getDbpwd();  
  
	Connection con = null;

	
	//查询留言总数
	
public int sumliuyan(){
		
		 
		try{   
			    int sum=0;
				//使用驱动  获取连接   获取 Statement
			   Class.forName(driverClass);                 
	           Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
	           Statement stmt=con.createStatement();   
	           
	           String sumliuyansql="select count(*) from  liuyan";
	           ResultSet sumRs=stmt.executeQuery(sumliuyansql); //执行查询 
	           
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


public ResultSet selectliuyanpage(int pageSize,int pageNow){
	
	 
	try{   
		   
			//使用驱动  获取连接   获取 Statement
		   Class.forName(driverClass);                 
           Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
           Statement stmt=con.createStatement();   
           
           ResultSet liuyanRs=stmt.executeQuery("select * from liuyan order by lDate DESC LIMIT "+pageSize*(pageNow-1)+","+pageSize);
             //执行查询          
           
          // stmt.close();   
           
          // con.close(); 
           return liuyanRs;
        
	 }catch(Exception ex)
     {   

            System.out.print("连接失败！！<br>"+ex.toString());   
            return null;

        } 
	
	
}




	//插入留言
	
public  boolean insertliuyan(liuyan ly) {
	                 
		 boolean f=false;
		 
	  	          
	              try{   
	   
	                     
	             
	            	//使用驱动  获取连接   获取 Statement
	   			   Class.forName(driverClass);                 
	   	           Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
	   	           Statement stmt=con.createStatement(); 
	  
	                    
	                      
	                    String sql= "insert into liuyan(`lUser`,`lEmail`,`lContent`,`lPicsrc`,`lDate`) values(\'"+ly.getUserName()+"\',\'"+ly.getUserEmail()+"\',\'"+ly.getMessage()+"\',\'"+ly.getPicSrc()+"\',null)";
	                   
	                     System.out.print(sql);
	                                          
	                      
	                      if(stmt.executeUpdate(sql)==1) //执行查询 
		                     {
	                    	  f=true;
		                     }
		                     stmt.close();   
		                      con.close(); 
		                   return f;   
	   
	          
	       }
	          
	 catch(Exception ex)
	 {   
	   
	 System.out.print("连接失败！！<br>"+ex.toString());   
	 return false;
	   
	 } 

	 }
	 
	 



public  ResultSet searchliuyan(){
		 		 
		 try{   
			  
           
     
			//使用驱动  获取连接   获取 Statement
			   Class.forName(driverClass);                 
	           Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
	           Statement stmt=con.createStatement();   
			 
        

            String liuyansql="select * from liuyan";                     

            ResultSet rs=stmt.executeQuery(liuyansql); //执行查询 
           
              
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


