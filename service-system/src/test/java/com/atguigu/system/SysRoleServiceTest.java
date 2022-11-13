package com.atguigu.system;

import com.atguigu.model.system.SysRole;
import com.atguigu.system.mapper.SysRoleMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.atguigu.system.service.SysRoleService;

import java.util.List;
import java.util.Locale;

@SpringBootTest
public class SysRoleServiceTest {
    @Autowired
    private SysRoleService sysRoleService;

    @Test
    public void testSelectList(){
        System.out.println(("----- selectAll method test ------"));
        //UserMapper 中的 selectList() 方法的参数为 MP 内置的条件封装器 Wrapper
        //所以不填写就是无任何条件
        List<SysRole> roles = sysRoleService.list();
        for (SysRole role : roles) {
            System.out.println("role = " + role);
        }
    }

    @Test
    public void testInsert(){
        SysRole sysRole=new SysRole();
        sysRole.setRoleName("角色管理员");
        sysRole.setRoleCode("role");
        sysRole.setDescription("角色管理员");
        boolean save = sysRoleService.save(sysRole);
        System.out.println(save);
    }

    @Test
    public void testUpdated(){
        SysRole sysRole=new SysRole();
        sysRole.setId(String.valueOf(1L));
        sysRole.setRoleName("角色管理员");
        boolean b = sysRoleService.updateById(sysRole);
        System.out.println(b);
    }


}

