package com.atguigu.system.service;

import com.atguigu.model.system.SysLoginLog;
import com.atguigu.model.vo.SysLoginLogQueryVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 异步调用日志服务
 */
public interface SysLoginLogService extends IService<SysLoginLog> {
    //列表显示
    IPage<SysLoginLog> selectPage(Page<SysLoginLog> pageParam, SysLoginLogQueryVo sysLoginLogQueryVo);

    void recordLoginLog(String username, int i, String ipAddress, String susscess);
}