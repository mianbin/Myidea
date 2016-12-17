package org.dmall.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/12/13.
 */
public class User implements Serializable {

    private int userId ;

    private String userName ;

    private String passWord ;

    private String lastIp ;

    private Date lastVisit ;

    private List<String> listbean = new ArrayList<>();

    public List<String> getListbean() {
        return listbean;
    }

    public void setListbean(List<String> listbean) {
        this.listbean = listbean;
    }

    public User() {
        super();
    }

    public User(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getLastIp() {
        return lastIp;
    }

    public void setLastIp(String lastIp) {
        this.lastIp = lastIp;
    }

    public Date getLastVisit() {
        return lastVisit;
    }

    public void setLastVisit(Date lastVisit) {
        this.lastVisit = lastVisit;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", lastIp='" + lastIp + '\'' +
                ", lastVisit=" + lastVisit +
                ", listbean=" + listbean +
                '}';
    }
}
