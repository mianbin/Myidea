package org.dmall.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/17.
 * @description 包装类型
 */
public class UserQueryVo {
    //这里用来包装所需要的查询条件
    List<Integer> ids = new ArrayList<>();
    //用户查询条件
    private UserCustom userCustom;

    //可以包装其他信息，比如其他商品信息


    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public UserCustom getUserCustom() {
        return userCustom;
    }

    public void setUserCustom(UserCustom userCustom) {
        this.userCustom = userCustom;
    }
}
