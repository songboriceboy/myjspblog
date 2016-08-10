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
	
	
	
	
	//根据文章id查找删除评论	
public  boolean  deletallcomment(int id){
		 
		 boolean f=false;
		 try{   
			  
          
    
				//使用驱动  获取连接   获取 Statement
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

                 System.out.print("连接失败！！<br>"+ex.toString());   
                 return false;

            } 
		 	 
		 
}	
	
	
	

//插入评论
public  boolean  insertcomment(comment md){
	 
	boolean f=false;

    try{   
            
    

    	 Class.forName(driverClass);                 
         Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
         Statement stmt=con.createStatement();   
   
         
         

         String sql= "insert into comment(`mUser`,`mEmail`,`mContent`,`mDate`,`mBid`) values(\'"+md.getUserName()+"\',\'"+md.getUserEmail()+"\',\'"+md.getContent()+"\',"+"null,"+md.getBlogId()+")";

        

          if(stmt.executeUpdate(sql)==1); //执行查询 
        
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

	
	
	
	
	//根据文章id查找全部评论
	
public  ResultSet searchcomment(int id){
		
		 
		 try{   
			  
          
			//使用驱动  获取连接   获取 Statement
			  Class.forName(driverClass);                 
             Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
             Statement stmt=con.createStatement();   

           
           
             String commentsql="select * from  comment where mBId='"+id+"'";
             ResultSet commentRs=stmt.executeQuery(commentsql); //执行查询 
          
             
            //  stmt.close();   

             //  con.close();   
              return commentRs;
 
		 }catch(Exception ex)
                {   

                    System.out.print("连接失败！！<br>"+ex.toString());   
                    return null;

                  } 
		 
}
	
	
	
	

}
