package com.atguigu.system.service.impl;

import com.atguigu.model.system.SysLoginLog;

import com.atguigu.model.vo.SysLoginLogQueryVo;
import com.atguigu.system.mapper.SysLoginLogMapper;
import com.atguigu.system.service.SysLoginLogService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;

@Service
public class SysLoginLogServiceImpl implements SysLoginLogService {
    @Autowired
    private SysLoginLogMapper sysLoginLogMapper;



    @Override
    public IPage<SysLoginLog> selectPage(Page<SysLoginLog> pageParam, SysLoginLogQueryVo sysLoginLogQueryVo) {
        return sysLoginLogMapper.selectPage(pageParam, sysLoginLogQueryVo);
    }

    @Override
    public void recordLoginLog(String username, int i, String ipAddress, String susscess) {
        SysLoginLog sysLoginLog = new SysLoginLog();
        sysLoginLog.setUsername(username);
        sysLoginLog.setMsg(susscess);
        sysLoginLog.setIpaddr(ipAddress);
        sysLoginLog.setStatus(i);
        sysLoginLogMapper.insert(sysLoginLog);

    }

    @Override
    public boolean saveBatch(Collection<SysLoginLog> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<SysLoginLog> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<SysLoginLog> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(SysLoginLog entity) {
        return false;
    }

    @Override
    public SysLoginLog getOne(Wrapper<SysLoginLog> queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Map<String, Object> getMap(Wrapper<SysLoginLog> queryWrapper) {
        return null;
    }

    @Override
    public <V> V getObj(Wrapper<SysLoginLog> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public BaseMapper<SysLoginLog> getBaseMapper() {
        return null;
    }

    @Override
    public Class<SysLoginLog> getEntityClass() {
        return null;
    }
}
