package org.dmall.dao;

import org.dmall.entity.User;
import org.dmall.entity.UserCustom;
import org.dmall.entity.UserQueryVo;
import org.dmall.entity.Wife;
import org.dmall.spring.Annotation.AnnotationApplicationBeans;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2016/12/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/applicationContext*.xml"})
public class TestDao {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void environment(){
        System.out.println("OK");
    }

    @Test//环境测试完成对mybatis的测试
    public void QueryUserByIdTest(){
        User user = userMapper.queryById(1000);
        System.out.println(user);
    }

    @Test//环境测试完成Mybatis的测试
    public void QueryUserByNameTest(){
        User user = userMapper.queryByName("root");
        System.out.println(user);
    }

    @Test//环境测试bean的加载。classpath：和classpath*：在同一目录下org.dmall中，有M1.xml,M2.xml,M3.xml,带*的则全加载，不带的，
    //如果为classpath:org/dmall/M*.xml,则只加载第一个。**表示多重路径匹配
    public void TestApplicationContext(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        User user = (User)applicationContext.getBean("user");
        System.out.println(user);
    }


    @Test//测试注解获取bean---奇技淫巧
    public void TestGetBeanApplicationtoAnnotation(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AnnotationApplicationBeans.class);
        User user = applicationContext.getBean("user", User.class);
        System.out.println(user);
    }

    @Test//初始化构造函数的例子
    public void TestConstructorValue(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        User bean = applicationContext.getBean("userConstructor", User.class);
        System.out.println(bean);
    }

    @Test//测试有ref的bean
    public void TestWifeAndUser(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        Wife wife = applicationContext.getBean("wife", Wife.class);
        System.out.println(wife);
    }

    @Test
    public void TestUserList(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        User userList = applicationContext.getBean("userList", User.class);
        System.out.println(userList);
    }

    @Test
    public void TestqueryByUserQueryVo(){
        UserQueryVo userQueryVo = new UserQueryVo();
        UserCustom userCustom = new UserCustom();
        userCustom.setUserName("root");
        userQueryVo.setUserCustom(userCustom);
        User user = userMapper.queryByUserQueryVo(userQueryVo);
        System.out.println(user);
    }

}
