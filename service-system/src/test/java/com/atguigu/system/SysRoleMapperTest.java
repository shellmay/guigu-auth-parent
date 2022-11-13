package com.atguigu.system;

import com.atguigu.model.system.SysRole;
import com.atguigu.system.mapper.SysRoleMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class SysRoleMapperTest {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Test
    public void testSelectList() {
        System.out.println(("----- selectAll method test ------"));
        //UserMapper 中的 selectList() 方法的参数为 MP 内置的条件封装器 Wrapper
        //所以不填写就是无任何条件
        List<SysRole> users = sysRoleMapper.selectList(null);
        for (SysRole sysRole : users) {
            System.out.println("sysRole = " + sysRole);
        }
    }

    @Test
    public void  testInsert(){
        SysRole sysRole = new SysRole();
        sysRole.setRoleName("管理员");
        sysRole.setRoleCode("role");
        sysRole.setDescription("角色管理员");
        int insert = sysRoleMapper.insert(sysRole);
        System.out.println(insert);
        System.out.println(sysRole.getId());
    }

    @Test
    public void testUpdate(){
        SysRole sysRole = new SysRole();
        sysRole.setId(String.valueOf(1L));
        sysRole.setRoleName("角色管理员");
        int result = sysRoleMapper.updateById(sysRole);
        System.out.println("end of"+result);
    }

    @Test
    public void testDeleteById(){
        int i = sysRoleMapper.deleteById(String.valueOf(2L));
        System.out.println(i);
    }

    @Test
    public void testBatchDelete(){
        int i = sysRoleMapper.deleteBatchIds(Arrays.asList(1, 2));
        System.out.println(i);
    }

    @Test
    public void testQuerywrapper(){
        QueryWrapper<SysRole> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.ge("role_code","role");
        List<SysRole> sysRoles = sysRoleMapper.selectList(objectQueryWrapper);
        System.out.println(sysRoles);
    }



}