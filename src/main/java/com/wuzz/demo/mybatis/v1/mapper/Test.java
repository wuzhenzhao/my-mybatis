package com.wuzz.demo.mybatis.v1.mapper;

/**
 * Create with IntelliJ IDEA
 * User: Wuzhenzhao
 * Date: 2019/3/21
 * Time: 14:52
 * Description 描述:
 */
public class Test {
    public static void main(String[] args) {
        String input = "%d %s %d";
        Object[] objs = new Object[]{1,"2",3};
        String result = String.format(input,objs);
        System.out.println(result);
    }
}
