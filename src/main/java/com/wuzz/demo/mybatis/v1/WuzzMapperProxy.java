package com.wuzz.demo.mybatis.v1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Create with IntelliJ IDEA
 * User: Wuzhenzhao
 * Date: 2019/3/21
 * Time: 14:52
 * Description 描述: 参照mybatis ---> MapperProxy
 * Mapper代理类
 */
public class WuzzMapperProxy implements InvocationHandler {
    private WuzzSqlSession sqlSession;

    public WuzzMapperProxy(WuzzSqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String mapperInterface = method.getDeclaringClass().getName();
        String methodName = method.getName();
        String statementId = mapperInterface + "." + methodName;
        return sqlSession.selectOne(statementId, args[0]);
    }
}
