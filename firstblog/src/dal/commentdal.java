package dal;

import java.sql.*;

import model.comment;
import utils.dbconstant;

public class commentdal {
	
	String driverClass=dbconstant.getDriverclass();

	 String  url=dbconstant.getUrl();

  String dbUser = dbconstant.getDbuser();   

  String dbPwd = dbconstant.getDbpwd();  
  
	Connection con = null;
	
	
	
	
	//��������id����ɾ������	
public  boolean  deletallcomment(int id){
		 
		 boolean f=false;
		 try{   
			  
          
    
				//ʹ������  ��ȡ����   ��ȡ Statement
			 Class.forName(driverClass);                 
            Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
            Statement stmt=con.createStatement();   
          
          String decommentSql="delete from  comment where mBid='"+id+"'";
          
          ResultSet comrs=searchcomment(id);
                            
           if(comrs.next())
           {
                 if(stmt.executeUpdate(decommentSql)==1){
           	
           	     f=true;
                  }
           }else{
        	   
        	   f=true;
           }     
             
           stmt.close();   

           con.close();   
            return f;
 
		 }catch(Exception ex)
             {   

                 System.out.print("����ʧ�ܣ���<br>"+ex.toString());   
                 return false;

            } 
		 	 
		 
}	
	
	
	

//��������
public  boolean  insertcomment(comment md){
	 
	boolean f=false;

    try{   
            
    

    	 Class.forName(driverClass);                 
         Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
         Statement stmt=con.createStatement();   
   
         
         

         String sql= "insert into comment(`mUser`,`mEmail`,`mContent`,`mDate`,`mBid`) values(\'"+md.getUserName()+"\',\'"+md.getUserEmail()+"\',\'"+md.getContent()+"\',"+"null,"+md.getBlogId()+")";

        

          if(stmt.executeUpdate(sql)==1); //ִ�в�ѯ 
        
          {
        	  f=true;
          }
          stmt.close();   

           con.close();  
           return f;

           }catch(Exception ex)
              {   

                 System.out.print("����ʧ�ܣ���<br>"+ex.toString());   
                 return false;

              } 
	 
}	

	
	
	
	
	//��������id����ȫ������
	
public  ResultSet searchcomment(int id){
		
		 
		 try{   
			  
          
			//ʹ������  ��ȡ����   ��ȡ Statement
			  Class.forName(driverClass);                 
             Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
             Statement stmt=con.createStatement();   

           
           
             String commentsql="select * from  comment where mBId='"+id+"'";
             ResultSet commentRs=stmt.executeQuery(commentsql); //ִ�в�ѯ 
          
             
            //  stmt.close();   

             //  con.close();   
              return commentRs;
 
		 }catch(Exception ex)
                {   

                    System.out.print("����ʧ�ܣ���<br>"+ex.toString());   
                    return null;

                  } 
		 
}
	
	
	
	

}
