package com.dream.core.common.base;

import com.dream.bean.base.BaseBean;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>Title:      BaseService. </p>
 * <p>Description TODO </p>
 *
 * @author         <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate     2018/1/25 13:17
 */
public class BaseService<D extends DreamMapper<T>, T extends BaseBean> implements DreamDaoService<T>{

    @Autowired
    protected D mapper;


    @Override
    public int insert(T record) {
        return mapper.insert(record);
    }

    @Override
    public int insertSelective(T record) {
        return mapper.insertSelective(record);
    }

    @Override
    public T queryById(Integer id) {
        return mapper.queryById(id);
    }

    @Override
    public int updateByIdSelective(T record) {
        return mapper.updateByIdSelective(record);
    }
}
