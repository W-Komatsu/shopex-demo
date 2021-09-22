package cn.shopex.demo.user.mapper;

import cn.shopex.demo.user.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author wangxiaosong
 */
@Mapper
public interface UserMapper {
    /**
     * 查询全部用户信息
     *
     * @return 用户信息
     */
    List<User> selectAllUser();

    /**
     * 创建用户
     *
     * @param user 用户信息
     */
    void createUser(User user);

    /**
     * 修改用户信息
     *
     * @param user 用户信息
     */
    void updateUser(User user);
}
