/**
 * 
 */
/**
 * @author lijiahui
 *
 */
package com.ningmeng.dao;
//dao包，封装对数据库的操作

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ningmeng.model.User;

public class UserDao {
    
    public User login(Connection con,User user) throws SQLException{
    	User resultUser=null;
        String sql="select * from user where username=? and password=?";////sql语句，搜索这个username和password在数据库是否存在
        PreparedStatement ps=con.prepareStatement(sql);//PreparedStatement是预编译的,把SQL提交到数据库中进行预处理
        ps.setString(1, user.getUsername());//sql里的第一个替换符替换成username
        ps.setString(2, user.getPassword());//sql里的第二个替换符替换成password
        ResultSet rs=ps.executeQuery();
        if(rs.next()){  //判断这个结果是否存在
            resultUser=new User();
            resultUser.setUsername(rs.getString("username"));//返回username
            resultUser.setPassword(rs.getString("password"));//返回password
        }
        return resultUser;
    }
}