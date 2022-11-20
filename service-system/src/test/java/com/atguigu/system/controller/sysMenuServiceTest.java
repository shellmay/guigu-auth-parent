package com.atguigu.system.controller;

import com.atguigu.model.system.SysMenu;

import com.atguigu.system.service.SysMenuService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class sysMenuServiceTest {

    @Autowired
    private SysMenuService sysMenuService;
    @Test
    public void testInsert(){
        SysMenu sysMenu=new SysMenu();
        sysMenu.setParentId(2L);
        sysMenu.setPath("sysUser");
        sysMenu.setName("用户管理");
        boolean save =sysMenuService.save(sysMenu);
        System.out.println(save);
    }
}
