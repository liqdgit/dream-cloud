package com.dream.admin.service.service;

import com.dream.admin.service.mapper.AdminUserMapper;
import com.dream.bean.admin.AdminUser;
import com.dream.core.base.DreamDaoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * <p>Title:      AdminUserService. </p>
 * <p>Description TODO </p>
 *
 * @author         <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate     2018/1/4 15:56
 */
@Service
public class AdminUserService implements DreamDaoService<AdminUser> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AdminUserMapper adminUserMapper;

    public List<AdminUser> queryList(){
        logger.info("-->queryList：查询全部用户信息");
        return adminUserMapper.queryList();
    }

    @Override
    public int insert(AdminUser record) {
        return adminUserMapper.insert(record);
    }

    @Override
    public int insertSelective(AdminUser record) {
        return adminUserMapper.insertSelective(record);
    }

    @Override
    public AdminUser queryById(Integer id) {
        return adminUserMapper.queryById(id);
    }

    @Override
    public int updateByIdSelective(AdminUser record) {
        return adminUserMapper.updateByIdSelective(record);
    }
}
