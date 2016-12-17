package org.dmall.entity;

/**
 * Created by Administrator on 2016/12/17.
 * @description 包装类型
 */
public class UserQueryVo {
    //这里用来包装所需要的查询条件

    //用户查询条件
    private UserCustom userCustom;

    //可以包装其他信息，比如用户订单商品等


    public UserCustom getUserCustom() {
        return userCustom;
    }

    public void setUserCustom(UserCustom userCustom) {
        this.userCustom = userCustom;
    }
}
