/**
 * 
 */
/**
 * @author lijiahui
 *
 */
package com.ningmeng.model;
//model包，对User类进行封装数据

public class User {

    private int id;
    private String username;
    private String password;
    
    public User() {
        super();//super()从子类中调用父类的构造方法，this()在同一类内调用其它方法
    }
    public User(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    
}