package cn.shopex.demo.user.controller;


import cn.shopex.demo.common.domain.CommonResponse;
import cn.shopex.demo.exception.BizServiceException;
import cn.shopex.demo.user.domain.CreateUserReq;
import cn.shopex.demo.user.domain.UpdateUserReq;
import cn.shopex.demo.user.entity.User;
import cn.shopex.demo.user.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author wangxiaosong
 */
@RestController
@RequestMapping("user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("page")
    public CommonResponse getPageUserInfo(@RequestParam(value = "name", required = false) String name,
                                          @RequestParam(value = "age", required = false) Integer age,
                                          @RequestParam(value = "address", required = false) String address,
                                          @RequestParam(value = "mobile", required = false) String mobile,
                                          @RequestParam(value = "page", defaultValue = "0") Integer page,
                                          @RequestParam(value = "size", defaultValue = "10") Integer size){
        System.out.println("page = " + page);
        System.out.println("size = " + size);
        User user = new User();
        user.setName("张三");
        user.setAge(25);
        user.setAddress("徐汇");
        List<User> res = userService.getPageUserInfo();
        return new CommonResponse(res, null, null);
    }
    @PutMapping
    public CommonResponse createUser(@RequestBody @Valid CreateUserReq request){
        System.out.println("name:" + request.getName());
        System.out.println("age:" + request.getAge());
        userService.createUser(request);
        return new CommonResponse();
    }
    @PostMapping
    public CommonResponse updateUser(@RequestBody @Valid UpdateUserReq request){
        if ("法外狂徒".equals(request.getName())) {
            throw new BizServiceException("errorCode001", "非法的用户名");
        }
        System.out.println(request.getName());
        return new CommonResponse();
    }
}
