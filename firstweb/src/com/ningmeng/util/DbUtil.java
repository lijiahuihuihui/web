/**
 * 
 */
/**
 * @author lijiahui
 *
 */
package com.ningmeng.util;
//util������װ�����ݿⲢ���в����Ƿ����ӳɹ�

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
    
    private String url="jdbc:mysql://localhost:3306/db_jsp";//���ݿ�Mysql�ĵ�ַ
    private String user="lijiahui";//���ݿ��û���
    private String password="hui980428";//���ݿ�����
    private String driver="com.mysql.jdbc.Driver";//Mysql����
    
    public Connection getCon() throws Exception{
        Class.forName(driver);//ָ����������
        Connection con=DriverManager.getConnection(url, user, password);//��ȡ����  
        return con;
    }
    
    public static void getClose(Connection con) throws SQLException{//�÷������ܻ��׳�SQLException��ʹ��throws������SQLException
        if(con!=null){
            con.close();
        }
    }
    
   public static void main(String[] args) { //���������Ƿ�ɹ�
        DbUtil db=new DbUtil();
        try {
            db.getCon();
            System.out.println("�����������ݿ⣬���ӳɹ�");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("�����������ݿ⣬����ʧ��");
        }
        
    }
}