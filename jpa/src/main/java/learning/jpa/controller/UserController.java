package learning.jpa.controller;

import io.swagger.annotations.*;
import learning.jpa.bean.User;
import learning.jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Classname UserController
 * @Description TODO
 * @Date 2020/8/12 6:11 下午
 * @Author z7-x
 */
@RestController
@RequestMapping("/user")
@Api(tags = "基础用户控制", description = "CRUD操作")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "查询全部用户信息", notes = "查询全部用户信息")
    @RequestMapping(method = RequestMethod.GET, value = "/findUsers")
    public List<User> findUsers() {
        return userService.findUsers();
    }

    @ApiOperation(value = "新增用户信息", notes = "新增用户信息")
    @RequestMapping(method = RequestMethod.POST, value = "/createUser")
    public ResponseEntity<User> createUser(@RequestBody
                                               @ApiParam(value = "输入用户对象", required = true) User user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    @ApiOperation(value = "修改用户信息", notes = "修改用户信息")
    @RequestMapping(method = RequestMethod.POST, value = "/updateUser")
    public User updateUser(@RequestBody
                               @ApiParam(value = "输入用户对象", required = true) User user) {
        return userService.updateUser(user);
    }

    @ApiOperation(value = "删除用户信息", notes = "删除用户信息")
    //paramType = "query" 用于get/post请求的参数拼接，请求参数的获取：@RequestParam(代码中接收注解)
    //@ApiImplicitParam(name = "userId", value = "用户id", required = true, paramType = "query")
    @RequestMapping(method = RequestMethod.GET, value = "/deleteUser")
    public Boolean updateUser(@RequestParam
                                  @ApiParam(value = "输入用户id", required = true) Long userId) {
        return userService.deleteUser(userId);
    }
}
