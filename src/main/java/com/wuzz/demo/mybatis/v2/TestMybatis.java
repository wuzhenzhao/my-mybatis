package com.wuzz.demo.mybatis.v2;

import com.wuzz.demo.mybatis.v2.mapper.Blog;
import com.wuzz.demo.mybatis.v2.mapper.BlogMapper;
import com.wuzz.demo.mybatis.v2.session.DefaultSqlSession;
import com.wuzz.demo.mybatis.v2.session.SqlSessionFactory;

public class TestMybatis {

    public static void main(String[] args) {
        SqlSessionFactory factory = new SqlSessionFactory();
        //build() 初始化时解析全局配置文件，加载配置，加载拦截器链
        //openSqlSession()
        DefaultSqlSession sqlSession = factory.build().openSqlSession();
        // 获取MapperProxy代理
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog = mapper.selectBlogById(1);

        System.out.println("第一次查询: " + blog);
        System.out.println();
//        blog = mapper.selectBlogById(1);
//        System.out.println("第二次查询: " + blog);
    }
}
