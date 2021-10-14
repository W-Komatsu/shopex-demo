package cn.shopex.demo.user.controller;


import cn.shopex.demo.common.domain.CommonResponse;
import cn.shopex.demo.common.domain.CommonResponsePageGeneric;
import cn.shopex.demo.common.domain.PageData;
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
    public CommonResponsePageGeneric<User> getPageUserInfo(@RequestParam(value = "name", required = false) String name,
                                                           @RequestParam(value = "age", required = false) Integer age,
                                                           @RequestParam(value = "address", required = false) String address,
                                                           @RequestParam(value = "mobile", required = false) String mobile,
                                                           @RequestParam(value = "page", defaultValue = "1") Integer page,
                                                           @RequestParam(value = "size", defaultValue = "10") Integer size){
        PageData<User> res = userService.getPageUserInfo(name, age, address, mobile, page, size);
        return CommonResponsePageGeneric.<User>builder().data(res).build();
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
