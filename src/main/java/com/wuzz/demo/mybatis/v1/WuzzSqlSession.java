package com.wuzz.demo.mybatis.v1;

/**
 * Create with IntelliJ IDEA
 * User: Wuzhenzhao
 * Date: 2019/3/21
 * Time: 14:52
 * Description 描述: 参照mybatis ---> DefaultSqlSession
 */
public class WuzzSqlSession {
    //全局配置类
    private WuzzConfiguration configuration;
    //执行器类
    private WuzzExecutor executor;

    //构造器初始化两个成员变量
    public WuzzSqlSession(WuzzConfiguration configuration, WuzzExecutor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }
    //将动作转交
    public <T> T selectOne(String statementId, Object paramater) {
        // 根据statementId拿到SQL
        String sql = WuzzConfiguration.sqlMappings.getString(statementId);
        if (null != sql && !"".equals(sql)) {
            return executor.query(sql, paramater);
        }
        return null;
    }

    public <T> T getMapper(Class clazz) {
        return configuration.getMapper(clazz, this);
    }

}
