package com.wuzz.demo.mybatis.v1.mapper;
/**
 * Create with IntelliJ IDEA
 * User: Wuzhenzhao
 * Date: 2019/3/21
 * Time: 14:52
 * Description 描述:
 */
public interface BlogMapper {
    /**
     * 根据主键查询文章
     *
     * @param bid
     * @return
     */
    public Blog selectBlogById(Integer bid);

}
