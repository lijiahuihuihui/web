/**
 * 
 */
/**
 * @author lijiahui
 *
 */
package com.ningmeng.web;
//web包，使用Servlet对数据进行处理和操作

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
    private static final long serialVersionUID = 1L;//serialVersionUID   用来表明类的不同版本间的兼容性。

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);//获取Get传来的值，用来处理Get请求
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");//请求获得login.jsp的用户名
        String password=request.getParameter("password");//请求获得login.jsp的密码
        Connection con=null;
        try {
            User user=new User(username,password);
            con=db.getCon();
            User currentUser=userDao.login(con, user);
            if(currentUser==null){
                request.setAttribute("error", "用户名或者密码错误");//设置一个error,将后面的字赋给这个error，以便下一个跳转页面使用，request的作用域有限
                request.setAttribute("username", username);//设置一个username，将后面username其内容赋值给前面一个username，以便下一个页面使用
                request.setAttribute("password", password);//设置一个password，将后面password其内容赋值给前面一个password，以便下一个页面使用
                request.getRequestDispatcher("login.jsp").forward(request, response);//跳转页面到login.jsp
            }else{
                HttpSession session=request.getSession();//向Session中存取登录信息
                session.setAttribute("currentUser",currentUser);//将currentUser这个对象保存在session作用域中,session作用域是全局的，request只能当前页面使用
                response.sendRedirect("main.jsp");//通过response对象的sendRedirect方法重定向,跳转到main.jsp
            }
        } catch (Exception e) {//捕捉异常
            e.printStackTrace();//在命令行打印异常信息,显示在程序中出错的位置及原因
        }      
    } 
}