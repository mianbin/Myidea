package org.dmall.entity;

/**
 * Created by Administrator on 2016/12/15.
 */
public class Wife {

    private String name;

    private User user;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Wife{" +
                "name='" + name + '\'' +
                ", user=" + user +
                '}';
    }
}
