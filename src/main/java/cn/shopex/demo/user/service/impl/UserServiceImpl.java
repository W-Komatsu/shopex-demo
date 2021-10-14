package cn.shopex.demo.user.service.impl;

import cn.shopex.demo.common.domain.PageData;
import cn.shopex.demo.exception.BizServiceException;
import cn.shopex.demo.user.domain.CreateUserReq;
import cn.shopex.demo.user.domain.UpdateUserReq;
import cn.shopex.demo.user.entity.User;
import cn.shopex.demo.user.mapper.UserMapper;
import cn.shopex.demo.user.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.*;

/**
 * @author wangxiaosong
 */
@Service
public class UserServiceImpl implements UserService {
    @Value("test.name")
    private String name;

    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public PageData<User> getPageUserInfo(String name, Integer age, String address, String mobile, Integer page, Integer size) {
        List<User> list = userMapper.getUserByComplexCondition(name, age, address, mobile, (page-1) * size, size);
        Long count = userMapper.getUserCountByComplexCondition(name, age, address, mobile);
        return new PageData<>(list, count);
    }

    @Override
    @Transactional(rollbackFor = BizServiceException.class)
    public void createUser(CreateUserReq req) {
        int salt = 123;
        // 对密码进行加密处理
        String password = DigestUtils.md5DigestAsHex((req.getPassword() + "/" + salt).getBytes());
        System.out.println(password);
        User user = new User();
        user.setName(req.getName());
        user.setAge(req.getAge());
        user.setAddress(req.getAddress());
        user.setAccount(req.getAccount());
        user.setPassword(password);
        user.setMobile(req.getMobile());
        userMapper.createUser(user);
        if (req.getAge() < 18) {
            throw new BizServiceException("errorCode2","未成年");
        }
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void updateUser(UpdateUserReq req) {

    }
}
