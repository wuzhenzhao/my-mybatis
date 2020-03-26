package com.wuzz.demo.mybatis.v1;

import java.lang.reflect.Proxy;
import java.util.ResourceBundle;
/**
 * Create with IntelliJ IDEA
 * User: Wuzhenzhao
 * Date: 2019/3/21
 * Time: 14:52
 * Description 描述: 参照mybatis ---> Configuration
 * 系统配置类，mybatis用xml。这里用properties
 */
public class WuzzConfiguration {
    public static final ResourceBundle sqlMappings;

    static{
        sqlMappings = ResourceBundle.getBundle("v1sql");
    }

    public <T> T getMapper(Class clazz, WuzzSqlSession sqlSession) {
        return (T)Proxy.newProxyInstance(this.getClass().getClassLoader(),
                new Class[]{clazz},
                new WuzzMapperProxy(sqlSession));
    }
}
