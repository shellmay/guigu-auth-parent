package com.atguigu.system.controller;
import com.atguigu.common.helper.MD5;
import com.atguigu.common.helper.JwtHelper;
import com.atguigu.common.result.Result;
import com.atguigu.common.result.ResultCodeEnum;
import com.atguigu.model.system.SysUser;
import com.atguigu.model.vo.LoginVo;
import com.atguigu.system.execption.GuiguException;
import com.atguigu.system.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Api(tags = "用户登录接口")
@RestController
@RequestMapping("/admin/system/index")
public class IndexController {

    @Autowired
    private SysUserService sysUserService;




    @ApiOperation(value = "登录")
    @PostMapping("/login")
    public Result login(@RequestBody LoginVo loginVo) {
        SysUser sysUser = sysUserService.getByUsername(loginVo.getUsername());
        if(null == sysUser) {
            throw new GuiguException(ResultCodeEnum.ACCOUNT_ERROR);
        }
        if(!MD5.encrypt(loginVo.getPassword()).equals(sysUser.getPassword())) {
            throw new GuiguException(ResultCodeEnum.PASSWORD_ERROR);
        }
        if(sysUser.getStatus().intValue() == 0) {
            throw new GuiguException(ResultCodeEnum.ACCOUNT_STOP);
        }

        Map<String, Object> map = new HashMap<>();
        map.put("token", JwtHelper.createToken(Long.valueOf(sysUser.getId()), sysUser.getUsername()));
        return Result.ok(map);
    }

    //login
    //{"code":20000,"data":{"token":"admin-token"}}
    /***
    @PostMapping("/login")
    public Result login(){
        Map<String, Object> map = new HashMap<>();
        map.put("token","admin-token");
        return Result.ok(map);
    }
    */
    //info
    //{"code":20000,"data":{"roles":["admin"],
    // "introduction":"I am a super administrator",
    // "avatar":"https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif",
    // "name":"Super Admin"}}


    @GetMapping("/info")
    public Result info(HttpServletRequest request) {
        /*
        Map<String, Object> map = new HashMap<>();
        map.put("roles","[admin]");
        //map.put("introduction","I am a super admini");
        map.put("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        map.put("name","Super Admin");
        Map<String, Object> map = new HashMap<>();
        map.put("roles","[admin]");
        map.put("name","admin");
        map.put("avatar","https://oss.aliyuncs.com/aliyun_id_photo_bucket/default_handsome.jpg");
        map.put("buttons", new ArrayList<>());
        map.put("routers", new ArrayList<>());
        */

        String username = JwtHelper.getUsername(request.getHeader("token"));
        Map<String, Object> map = sysUserService.getUserInfo(username);
        return Result.ok(map);
    }

    /**
     * 退出
     * @return
     */
    @PostMapping("/logout")
    public Result logout(){
        return Result.ok();
    }
}
