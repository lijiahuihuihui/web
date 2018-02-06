/**
 * 
 */
/**
 * @author lijiahui
 *
 */
package com.ningmeng.util;
//util包，封装好数据库并进行测试是否连接成功

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
    
    private String url="jdbc:mysql://localhost:3306/db_jsp";//数据库Mysql的地址
    private String user="lijiahui";//数据库用户名
    private String password="hui980428";//数据库密码
    private String driver="com.mysql.jdbc.Driver";//Mysql驱动
    
    public Connection getCon() throws Exception{
        Class.forName(driver);//指定连接类型
        Connection con=DriverManager.getConnection(url, user, password);//获取连接  
        return con;
    }
    
    public static void getClose(Connection con) throws SQLException{//该方法可能会抛出SQLException，使用throws来处理SQLException
        if(con!=null){
            con.close();
        }
    }
    
   public static void main(String[] args) { //测试连接是否成功
        DbUtil db=new DbUtil();
        try {
            db.getCon();
            System.out.println("测试连接数据库，连接成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("测试连接数据库，连接失败");
        }
        
    }
}