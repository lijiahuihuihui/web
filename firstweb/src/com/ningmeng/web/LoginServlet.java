/**
 * 
 */
/**
 * @author lijiahui
 *
 */
package com.ningmeng.web;
//web����ʹ��Servlet�����ݽ��д���Ͳ���

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ningmeng.dao.UserDao;
import com.ningmeng.model.User;
import com.ningmeng.util.DbUtil;

public class LoginServlet extends HttpServlet{

    DbUtil db=new DbUtil();
    UserDao userDao=new UserDao();
    /**
     * 
     */
    private static final long serialVersionUID = 1L;//serialVersionUID   ����������Ĳ�ͬ�汾��ļ����ԡ�

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);//��ȡGet������ֵ����������Get����
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");//������login.jsp���û���
        String password=request.getParameter("password");//������login.jsp������
        Connection con=null;
        try {
            User user=new User(username,password);
            con=db.getCon();
            User currentUser=userDao.login(con, user);
            if(currentUser==null){
                request.setAttribute("error", "�û��������������");//����һ��error,��������ָ������error���Ա���һ����תҳ��ʹ�ã�request������������
                request.setAttribute("username", username);//����һ��username��������username�����ݸ�ֵ��ǰ��һ��username���Ա���һ��ҳ��ʹ��
                request.setAttribute("password", password);//����һ��password��������password�����ݸ�ֵ��ǰ��һ��password���Ա���һ��ҳ��ʹ��
                request.getRequestDispatcher("login.jsp").forward(request, response);//��תҳ�浽login.jsp
            }else{
                HttpSession session=request.getSession();//��Session�д�ȡ��¼��Ϣ
                session.setAttribute("currentUser",currentUser);//��currentUser������󱣴���session��������,session��������ȫ�ֵģ�requestֻ�ܵ�ǰҳ��ʹ��
                response.sendRedirect("main.jsp");//ͨ��response�����sendRedirect�����ض���,��ת��main.jsp
            }
        } catch (Exception e) {//��׽�쳣
            e.printStackTrace();//�������д�ӡ�쳣��Ϣ,��ʾ�ڳ����г����λ�ü�ԭ��
        }      
    } 
}