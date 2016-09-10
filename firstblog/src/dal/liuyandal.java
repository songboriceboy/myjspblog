package dal;
import java.sql.*;

import org.apache.commons.lang.StringEscapeUtils;

import model.liuyan;
import utils.dbconstant;
import model.notification;

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
	
public  boolean insertliuyan(liuyan ly,notification noti) {
	                 
		 boolean f=false;
		 
	  	          
	              try{   
	   
	                     
	             
	            	//使用驱动  获取连接   获取 Statement
	   			   Class.forName(driverClass);                 
	   	           Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
	   	          // Statement stmt=con.createStatement(); 
	   	        PreparedStatement   pstmt=null;
	            
	            con.setAutoCommit(false); 
	            
	          
	           
	                    
	                      
	                    String inliuyansql= "insert into liuyan(`lUser`,`lEmail`,`lContent`,`lPicsrc`,`lDate`) values(\'"+ly.getUserName()+"\',\'"+ly.getUserEmail()+"\',\'"+ly.getMessage()+"\',\'"+ly.getPicSrc()+"\',null)";
	                   // inliuyansql = StringEscapeUtils.escapeSql(inliuyansql);
	                    pstmt=con.prepareStatement(inliuyansql);
	    	            pstmt.executeUpdate();
	                    
	                    
	                    String innotisql= "insert into notification(`nName`,`nContent`,`nType`,`nDate`) values(\'"+noti.getName()+"\',\'"+noti.getContent()+"\',\'"+noti.getType()+"\',null)";
	                    pstmt=con.prepareStatement(innotisql);
	    	            pstmt.executeUpdate();                    
	                      
	    	            con.commit();
	    	            pstmt.close();
	    	            con.close();
	    	            return true; 
	   
	          
	       }
	          
	 catch(Exception ex)
	 {   
	   
	 System.out.print("连接失败！！<br>"+ex.toString());   
	 return false;
	   
	 } 

	 }
	 
	 


//查询所有留言
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
	 
	 
	







//通过id查询留言


public  ResultSet searchliuyanbyid(int id){
	 
	 try{   
		  
      

		//使用驱动  获取连接   获取 Statement
		   Class.forName(driverClass);                 
          Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
          Statement stmt=con.createStatement();   
		 
   

       String liuyansql="select * from liuyan where lId='"+id+"'";                     

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








//通过id删除留言


public  boolean deleteliuyanbyid(int id){
	boolean f=false;

	 
	 try{   
		  
    

		//使用驱动  获取连接   获取 Statement
		   Class.forName(driverClass);                 
        Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
        //Statement stmt=con.createStatement();   
		 
        PreparedStatement   pstmt=null;     
       
       con.setAutoCommit(false); 
       
       String delliuyansql="delete from liuyan where lId='"+id+"'";
       pstmt=con.prepareStatement(delliuyansql);
       pstmt.executeUpdate();
       String delreplysql="delete from liuyanreply where lyId='"+id+"'";
       pstmt=con.prepareStatement(delreplysql);
       pstmt.executeUpdate();
       con.commit();
       pstmt.close();
       con.close();
       return true;          


	 }

catch(Exception ex)
{   

System.out.print("连接失败！！<br>"+ex.toString());   
return false;

} 
	 
	 
}





















}




