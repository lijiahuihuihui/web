/**
 * 
 */
/**
 * @author lijiahui
 *
 */
package com.ningmeng.dao;
//dao������װ�����ݿ�Ĳ���

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ningmeng.model.User;

public class UserDao {
    
    public User login(Connection con,User user) throws SQLException{
    	User resultUser=null;
        String sql="select * from user where username=? and password=?";////sql��䣬�������username��password�����ݿ��Ƿ����
        PreparedStatement ps=con.prepareStatement(sql);//PreparedStatement��Ԥ�����,��SQL�ύ�����ݿ��н���Ԥ����
        ps.setString(1, user.getUsername());
        ps.setString(2, user.getPassword());
        ResultSet rs=ps.executeQuery();
        if(rs.next()){  //�ж��������Ƿ����
            resultUser=new User();
            resultUser.setUsername(rs.getString("username"));
            resultUser.setPassword(rs.getString("password"));
        }
        return resultUser;
    }
}