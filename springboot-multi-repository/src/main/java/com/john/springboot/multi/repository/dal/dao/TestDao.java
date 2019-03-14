package com.john.springboot.multi.repository.dal.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TestDao {
	
	private final SqlSessionTemplate template;

    protected TestDao(@Qualifier("sqlSessionTemplate") SqlSessionTemplate template) {
        this.template = template;
    }

  
    /**
     * 基础列表查询
     * @param
     * @param
     * @return
     */
    public List<?> selectList(String sqlId, Map param) {
        return this.template.selectList(sqlId, param);
    }

    /**
     * 基础主键查询
     * @param
     * @param
     * @return
     */
    public Object selectOne(String sqlId, Map param) {
        return this.template.selectOne(sqlId, param);
    }

    /**
     * 求和查询
     * @param
     * @param
     * @return
     */
    public Long count(String sqlId, Object condition) {
        return this.template.selectOne(sqlId, condition);
    }

    /**
     * 基础更新
     * @param
     * @param
     * @return
     */
    public int update(String sqlId, Object condition) {
        return this.template.update(sqlId, condition);
    }

    /**
     * 基础插入
     * @param
     * @param
     * @return
     */
    public int insert(String sqlId, Object condition) {
        return this.template.insert(sqlId, condition);
    }

    /**
     * 基础删除，项目不使用物理删除
     * @param
     * @param
     * @return
     */
    public int delete(String sqlId, Object condition) {
        return this.template.delete(sqlId, condition);
    }

}
