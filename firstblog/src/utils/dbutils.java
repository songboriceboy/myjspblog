package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbutils {
	
	
	public static Connection getConnection(String dburl,String dbname,String dbuser,String dbpwd){  
        
        try{  
            Class.forName(dbconstant.getDriverclass());  
            Connection conn=DriverManager.getConnection(dburl+dbname,dbuser,dbpwd);//获取连接对象  
            return conn;  
        }catch(ClassNotFoundException e){  
            e.printStackTrace();  
            return null;  
        }catch(SQLException e){  
            e.printStackTrace();  
            return null;  
        }  

}
}
