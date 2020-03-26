package com.wuzz.demo.mybatis.v1;

import com.wuzz.demo.mybatis.v1.mapper.BlogMapper;
/**
 * Create with IntelliJ IDEA
 * User: Wuzhenzhao
 * Date: 2019/3/21
 * Time: 14:52
 * Description 描述:
 */
public class MyBatisBoot {

//    1、存放参数和结果映射关系、存放 SQL 语句，我们需要定义一个配置类；
//    2、执行对数据库的操作，处理参数和结果集的映射，创建和释放资源，我们需要定义一个执行器；
//    3、有了这个执行器以后，我们不能直接调用它，而是定义一个给应用层使用的 API，它可以根据 SQL 的 id 找到 SQL 语句，交给执行器执行；
//    4、直接使用 id 查找 SQL 语句太麻烦了，我们干脆把存放 SQL 的命名空间定义成一 个接口，把 SQL 的 id 定义成方法，这样只要调用接口
//    方法就可以找到要执行的 SQL。这个时候我们需要引入一个代理类。
    public static void main(String[] args) {
        WuzzSqlSession sqlSession = new WuzzSqlSession(new WuzzConfiguration(), new WuzzExecutor());
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        blogMapper.selectBlogById(1);
    }

//V1 的不足
//    1、在 Executor 中，对参数、语句和结果集的处理是耦合的，没有实现职责分离；
//    2、参数：没有实现对语句的预编译，只有简单的格式化（format），效率不高，还存在 SQL 注入的风险；
//    3、语句执行：数据库连接硬编码；
//    4、结果集：还只能处理 Blog 类型，没有实现根据实体类自动映射。确实有点搓，拿不出手。
//V1 的优化目标
//    支持参数预编译；
//    支持结果集的自动处理（通过反射）；
//    对 Executor 的职责进行细化。
//    V V1 10 .0 的功能 增强 目标
//    在方法上使用注解配置 SQL；
//    查询带缓存功能；
//    支持自定义插件。
}
