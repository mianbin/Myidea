package org.dmall.dao;

import org.apache.ibatis.annotations.Param;
import org.dmall.entity.User;
import org.dmall.entity.UserQueryVo;

/**
 * Created by Administrator on 2016/12/13.
 */
public interface UserMapper {

    public User queryById(@Param("id") int id);

    public User queryByName(@Param("name") String name);

    /*这里用一个包装类进行查询*/
    public User queryByUserQueryVo(@Param("userQueryVo") UserQueryVo userQueryVo);


}
