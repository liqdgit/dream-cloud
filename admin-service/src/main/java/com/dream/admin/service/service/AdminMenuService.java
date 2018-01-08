package com.dream.admin.service.service;

import com.dream.admin.service.mapper.AdminMenuMapper;
import com.dream.bean.admin.AdminMenu;
import com.dream.core.base.DreamDaoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>Title:      AdminMenuService. </p>
 * <p>Description TODO </p>
 *
 * @author         <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate     2018/1/8 11:16
 */
@Service
public class AdminMenuService implements DreamDaoService<AdminMenu> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AdminMenuMapper adminMenuMapper;

    /**
     * <p>Title:      分页查询. </p>
     * <p>Description </p>
     *
     * @param         adminMenu
     * @author        <a href="liqd163@163.com"/>李清栋</a>
     * @CreateDate    2018/1/8 11:13
     * @return
     */
    public List<AdminMenu> queryPageList(AdminMenu adminMenu){
        return adminMenuMapper.queryPageList(adminMenu);
    }

    @Override
    public int insert(AdminMenu record) {
        return adminMenuMapper.insert(record);
    }

    @Override
    public int insertSelective(AdminMenu record) {
        return adminMenuMapper.insertSelective(record);
    }

    @Override
    public AdminMenu queryById(Integer id) {
        return adminMenuMapper.queryById(id);
    }

    @Override
    public int updateByIdSelective(AdminMenu record) {
        return adminMenuMapper.updateByIdSelective(record);
    }
}
