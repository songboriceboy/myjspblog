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

	
	//��ѯ��������
	
public int sumliuyan(){
		
		 
		try{   
			    int sum=0;
				//ʹ������  ��ȡ����   ��ȡ Statement
			   Class.forName(driverClass);                 
	           Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
	           Statement stmt=con.createStatement();   
	           
	           String sumliuyansql="select count(*) from  liuyan";
	           ResultSet sumRs=stmt.executeQuery(sumliuyansql); //ִ�в�ѯ 
	           
	           if(sumRs.next()){
	                 sum=sumRs.getInt(1);
	             }
	           
	           stmt.close();   
	           
	           con.close(); 
	           return sum;
	        
		 }catch(Exception ex)
	     {   

	            System.out.print("����ʧ�ܣ���<br>"+ex.toString());   
	            return 0;

	        } 
		
		
	}	
	


//��ҳ��ѯ����


public ResultSet selectliuyanpage(int pageSize,int pageNow){
	
	 
	try{   
		   
			//ʹ������  ��ȡ����   ��ȡ Statement
		   Class.forName(driverClass);                 
           Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
           Statement stmt=con.createStatement();   
           
           ResultSet liuyanRs=stmt.executeQuery("select * from liuyan order by lDate DESC LIMIT "+pageSize*(pageNow-1)+","+pageSize);
             //ִ�в�ѯ          
           
          // stmt.close();   
           
          // con.close(); 
           return liuyanRs;
        
	 }catch(Exception ex)
     {   

            System.out.print("����ʧ�ܣ���<br>"+ex.toString());   
            return null;

        } 
	
	
}




	//��������
	
public  boolean insertliuyan(liuyan ly,notification noti) {
	                 
		 boolean f=false;
		 
	  	          
	              try{   
	   
	                     
	             
	            	//ʹ������  ��ȡ����   ��ȡ Statement
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
	   
	 System.out.print("����ʧ�ܣ���<br>"+ex.toString());   
	 return false;
	   
	 } 

	 }
	 
	 


//��ѯ��������
public  ResultSet searchliuyan(){
		 		 
		 try{   
			  
           
     
			//ʹ������  ��ȡ����   ��ȡ Statement
			   Class.forName(driverClass);                 
	           Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
	           Statement stmt=con.createStatement();   
			 
        

            String liuyansql="select * from liuyan";                     

            ResultSet rs=stmt.executeQuery(liuyansql); //ִ�в�ѯ 
           
              
      // stmt.close();   

      // con.close();   
       return rs;
  
		 }
  
catch(Exception ex)
{   

System.out.print("����ʧ�ܣ���<br>"+ex.toString());   
return null;

} 
		 
		 
	 }
	 
	 
	







//ͨ��id��ѯ����


public  ResultSet searchliuyanbyid(int id){
	 
	 try{   
		  
      

		//ʹ������  ��ȡ����   ��ȡ Statement
		   Class.forName(driverClass);                 
          Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
          Statement stmt=con.createStatement();   
		 
   

       String liuyansql="select * from liuyan where lId='"+id+"'";                     

       ResultSet rs=stmt.executeQuery(liuyansql); //ִ�в�ѯ 
      
         
 // stmt.close();   

 // con.close();   
  return rs;

	 }

catch(Exception ex)
{   

System.out.print("����ʧ�ܣ���<br>"+ex.toString());   
return null;

} 
	 
	 
}








//ͨ��idɾ������


public  boolean deleteliuyanbyid(int id){
	boolean f=false;

	 
	 try{   
		  
    

		//ʹ������  ��ȡ����   ��ȡ Statement
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

System.out.print("����ʧ�ܣ���<br>"+ex.toString());   
return false;

} 
	 
	 
}





















}




