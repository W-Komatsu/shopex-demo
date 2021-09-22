package cn.shopex.demo.user.service;

import cn.shopex.demo.user.domain.CreateUserReq;
import cn.shopex.demo.user.domain.UpdateUserReq;
import cn.shopex.demo.user.entity.User;

import java.util.List;

/**
 * @author wangxiaosong
 */
public interface UserService {
    /**
     * 分页查询用户信息
     *
     * @return 用户信息
     */
    List<User> getPageUserInfo();


    /**
     * 创建用户
     *
     * @param req 用户信息
     */
    void createUser(CreateUserReq req);

    /**
     * 修改用户
     *
     * @param req 用户信息
     */
    void updateUser(UpdateUserReq req);
}
