package org.dmall.spring.Annotation;

import org.dmall.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2016/12/15.
 */
@Configuration
public class AnnotationApplicationBeans {

    @Bean(name = "user")
    public User buildUser(){
        User user = new User();
        user.setUserName("Annotation-root");
        user.setPassWord("Annotation-mianbin");
        user.setLastIp("192.168.3.120");
        return user;
    }

}
