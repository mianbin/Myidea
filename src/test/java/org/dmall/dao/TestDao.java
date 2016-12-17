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

import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void TestqueryUserCount(){
        UserQueryVo userQueryVo = new UserQueryVo();
        UserCustom userCustom = new UserCustom();
        userCustom.setUserName("root");
        userQueryVo.setUserCustom(userCustom);
        int count = userMapper.queryUserCount(userQueryVo);
        System.out.println(count);
    }

    @Test
    public void TestqueryUserCustom(){
        UserQueryVo userQueryVo = new UserQueryVo();
        UserCustom userCustom = new UserCustom();
        userCustom.setUserName("root");
        userQueryVo.setUserCustom(userCustom);
        UserCustom userCustom1 = userMapper.queryUserCustom(userQueryVo);
        System.out.println(userCustom1);
    }

    @Test/*这里面有个大坑，看mapper文件有说*/
    public void TestqueryUserContainIfAndWhere(){
        UserQueryVo userQueryVo = new UserQueryVo();
        UserCustom userCustom = new UserCustom();
        userCustom.setUserName("root");
//      userCustom.setPassWord("mianbin");
        userQueryVo.setUserCustom(userCustom);
        User user = userMapper.queryUserContainIfAndWhere(userQueryVo);
        System.out.println(user);
    }

    @Test
    public void TestqueryUserContainSql(){
        UserQueryVo userQueryVo = new UserQueryVo();
        UserCustom userCustom = new UserCustom();
        userCustom.setUserName("root");
        userQueryVo.setUserCustom(userCustom);
        User user = userMapper.queryUserContainSql(userQueryVo);
        System.out.println(user);
    }

    @Test
    public void TestqueryUserByForeach(){
        UserQueryVo userQueryVo = new UserQueryVo();
        UserCustom userCustom = new UserCustom();
        userQueryVo.setUserCustom(userCustom);
        List<Integer> list = new ArrayList<>();
        list.add(1000);
        list.add(1001);
        userQueryVo.setIds(list);
        List<User> users = userMapper.queryUserByForeach(userQueryVo);
        System.out.println(users);
    }

    @Test
    public void TestNewBranchTestGit(){
        System.out.println("第一次使用分支失败，并没有创建成功，这次继续");
    }

}
