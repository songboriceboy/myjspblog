package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import model.notification;
import utils.dbconstant;

public class notificationdal {
	
	String driverClass=dbconstant.getDriverclass();

	 String  url=dbconstant.getUrl();

  String dbUser = dbconstant.getDbuser();   

  String dbPwd = dbconstant.getDbpwd();  
  
	Connection con = null;
	

	
	
public  boolean insertnoti(notification noti) {
        
		  boolean f=false;
		
          
        try{   

               
       
        	   Class.forName(driverClass);                 
	           Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
	           Statement stmt=con.createStatement();   

              
                
              String nsql= "insert into notification(`nName`,`nContent`,`nType`,`nDate`) values(\'"+noti.getName()+"\',\'"+noti.getContent()+"\',\'"+noti.getType()+"\',null)";
             
                
               if(stmt.executeUpdate(nsql)==1) 
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
	
	
	
	
	
	
	
	
	
	
	
	
//计算通知总数	
	
public int  sumnotification(){
		
	          int sum=0;
		 
		try{   
			    
				//使用驱动  获取连接   获取 Statement
			   Class.forName(driverClass);                 
	           Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
	           Statement stmt=con.createStatement();   
	           
	           String sumbnotiSql="select count(*) from  notification";
	           ResultSet sumRs=stmt.executeQuery(sumbnotiSql); //执行查询 
	           
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





//分页查询博客

public ResultSet selectnotipage(int pageSize,int pageNow){
	
	 
	try{   
		   
			//使用驱动  获取连接   获取 Statement
		   Class.forName(driverClass);                 
         Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
         Statement stmt=con.createStatement();   
         
         ResultSet pageRs=stmt.executeQuery("select * from notification order by nDate DESC LIMIT "+pageSize*(pageNow-1)+","+pageSize);
           //执行查询          
         
        // stmt.close();   
         
        // con.close(); 
         return pageRs;
      
	 }catch(Exception ex)
   {   

          System.out.print("连接失败！！<br>"+ex.toString());   
          return null;

      } 
	
	
}




	
	

}
