package dal;

import java.sql.*;

import org.apache.commons.lang.StringEscapeUtils;

import model.comment;
import model.notification; 
import utils.dbconstant;

public class commentdal {
	
	String driverClass=dbconstant.getDriverclass();

	 String  url=dbconstant.getUrl();

  String dbUser = dbconstant.getDbuser();   

  String dbPwd = dbconstant.getDbpwd();  
  
	Connection con = null;
	

	
	  //��ҳ��ѯ���

	public ResultSet selectcommentpage(int pageSize,int pageNow){
		        	
		        	 
		        	try{   
		        		   
		        			//ʹ������  ��ȡ����   ��ȡ Statement
		        		   Class.forName(driverClass);                 
		                   Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
		                   Statement stmt=con.createStatement();   
		                   
		                   ResultSet pageRs=stmt.executeQuery("select * from comment order by mDate DESC LIMIT "+pageSize*(pageNow-1)+","+pageSize);
		                     //ִ�в�ѯ          
		                   
		                  // stmt.close();   
		                   
		                  // con.close(); 
		                   return pageRs;
		                
		        	 }catch(Exception ex)
		             {   

		                    System.out.print("����ʧ�ܣ���<br>"+ex.toString());   
		                    return null;

		                } 
		        	
		        	
		        }	
		        	
	
	

	//��ѯ��������	        
    
	public int sumcomment(){
		        	
		       	 
		        	try{   
		        		    int sum=0;
		        			//ʹ������  ��ȡ����   ��ȡ Statement
		        		   Class.forName(driverClass);                 
		                   Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
		                   Statement stmt=con.createStatement();   
		                   
		                   String sumcateSql="select count(*) from  comment";
		                   ResultSet sumRs=stmt.executeQuery(sumcateSql); //ִ�в�ѯ 
		                   
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
		        
		        	
	
	
	
	//��������idɾ������	
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
public  boolean  insertcomment(comment md,notification noti,int id){
	 
	boolean f=false;

    try{   
            
    

    	 Class.forName(driverClass);                 
         Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
         //Statement stmt=con.createStatement();   
         PreparedStatement   pstmt=null;
         
         con.setAutoCommit(false); 
         
         String incommentsql= "insert into comment(`mUser`,`mEmail`,`mContent`,`mDate`,`mBid`) values(\'"+md.getUserName()+"\',\'"+md.getUserEmail()+"\',\'"+md.getContent()+"\',"+"null,"+md.getBlogId()+")";
        // incommentsql=StringEscapeUtils.escapeSql(incommentsql);
         
         pstmt=con.prepareStatement(incommentsql);
         pstmt.executeUpdate();
         String innotisql= "insert into notification(`nName`,`nContent`,`nType`,`nDate`) values(\'"+noti.getName()+"\',\'"+noti.getContent()+"\',\'"+noti.getType()+"\',null)";
         pstmt=con.prepareStatement(innotisql);
         pstmt.executeUpdate();
         String upblogcommentsql="UPDATE blog SET bComments=bComments+1 where bId='"+id+"'";
         pstmt=con.prepareStatement(upblogcommentsql);
         pstmt.executeUpdate();
         con.commit();
         pstmt.close();
         con.close();
         return true;

 
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
	
	

public int getblogidbycommentid(int commentid){
	
	int blogid=0;
	
	 try{   
		  
         
			//ʹ������  ��ȡ����   ��ȡ Statement
			  Class.forName(driverClass);                 
          Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
          Statement stmt=con.createStatement();   

        
        
          String commentsql="select * from  comment where mId='"+commentid+"'";
          ResultSet commentRs=stmt.executeQuery(commentsql); //ִ�в�ѯ 
       
          blogid=commentRs.getInt("mBid");
           stmt.close();   

           con.close();   
           return  blogid;

		 }catch(Exception ex)
             {   

                 System.out.print("����ʧ�ܣ���<br>"+ex.toString());   
                 return 0;

               } 
	
	
	
	
	
}


//����idɾ������

public  boolean deletecommentbyid(int id){
	
	 
	 boolean f=false;
	 try{   
		  
      

			//ʹ������  ��ȡ����   ��ȡ Statement
		 Class.forName(driverClass);                 
        Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
        //Statement stmt=con.createStatement();   
        PreparedStatement   pstmt=null;
     
       int blogid=getblogidbycommentid(id);
      
      
      con.setAutoCommit(false); 
      
      String decommentSql="delete from  comment where mId='"+id+"'";
      pstmt=con.prepareStatement(decommentSql);
      pstmt.executeUpdate();
      String dereplySql="delete from  commentreply where cmId='"+id+"'";
      pstmt=con.prepareStatement(dereplySql);
      pstmt.executeUpdate();
      String upblogcommentsql="UPDATE blog SET bComments=bComments-1 where bId='"+blogid+"'";
      pstmt=con.prepareStatement(upblogcommentsql);
      pstmt.executeUpdate();
      con.commit();
      pstmt.close();
      con.close();
      return true;               

	 }catch(Exception ex)
         {   

             System.out.print("����ʧ�ܣ���<br>"+ex.toString());   
             return false;

        } 
	 
}





//����id��������

public  ResultSet searchcommentbyid(int id){
	
	 
	 try{   
		  
    
		//ʹ������  ��ȡ����   ��ȡ Statement
		  Class.forName(driverClass);                 
       Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
       Statement stmt=con.createStatement();   

     
     
       String commentsql="select * from  comment where mId='"+id+"'";
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
