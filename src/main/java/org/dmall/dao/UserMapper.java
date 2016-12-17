package org.dmall.dao;

import org.apache.ibatis.annotations.Param;
import org.dmall.entity.User;

/**
 * Created by Administrator on 2016/12/13.
 */
public interface UserMapper {

    public User queryById(@Param("id") int id);

    public User queryByName(@Param("name") String name);

}
