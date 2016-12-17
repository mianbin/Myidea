package org.dmall.entity;

import java.util.Date;

/**
 * Created by Administrator on 2016/12/17.
 */
public class UserCustom extends  User{
    /*这里是用来扩展用户信息的*/
    private Date createTime;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
