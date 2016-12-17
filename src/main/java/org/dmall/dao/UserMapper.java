package org.dmall.dao;

import org.apache.ibatis.annotations.Param;
import org.dmall.entity.User;
import org.dmall.entity.UserCustom;
import org.dmall.entity.UserQueryVo;

import java.util.List;

/**
 * Created by Administrator on 2016/12/13.
 * @description 通用mapper用多了，都快忘记一些基础内容了，复习一下
 */
public interface UserMapper {

    public User queryById(@Param("id") int id);

    public User queryByName(@Param("name") String name);

    /*这里用一个包装类进行查询*/
    public User queryByUserQueryVo(@Param("userQueryVo") UserQueryVo userQueryVo);

    /*做个分页查询，所以先要搞个usercount*/
    public int queryUserCount(UserQueryVo userQueryVo);

    /*一个最基本的resultMap的例子*/
    public UserCustom queryUserCustom(UserQueryVo userQueryVo);

    /*写一个测试if的例子*/
    public User queryUserContainIfAndWhere(UserQueryVo userQueryVo);

    /*加了sql的例子*/
    public User queryUserContainSql(UserQueryVo userQueryVo);

    /*一个foreach的例子*/
    public List<User> queryUserByForeach(UserQueryVo userQueryVo);

}
