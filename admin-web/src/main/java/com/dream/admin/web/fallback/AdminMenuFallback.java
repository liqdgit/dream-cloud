package com.dream.admin.web.fallback;

import com.dream.admin.web.service.AdminMenuService;
import com.dream.bean.admin.AdminMenu;
import com.dream.core.common.Page;
import com.dream.core.common.wrapper.WrapMapper;
import com.dream.core.common.wrapper.Wrapper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>Title:      AdminMenuFallback. </p>
 * <p>Description TODO </p>
 *
 * @author         <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate     2018/1/8 11:34
 */
@Component
@RequestMapping("/fallback")
public class AdminMenuFallback implements AdminMenuService {

    @Override
    public Wrapper<PageInfo<AdminMenu>> queryPageList(Page<AdminMenu> page) {
        return WrapMapper.error();
    }
}
