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

    /**
     * 根据复杂条件查询用户信息
     *
     * @param name    姓名
     * @param age     年龄
     * @param address 地址
     * @param mobile  电话
     * @param offset  开始位置
     * @param size    最大数据量
     * @return 用户信息
     */
    List<User> getUserByComplexCondition(String name, Integer age, String address, String mobile, Integer offset, Integer size);

    /**
     * 根据复杂条件查询用户数量
     *
     * @param name    姓名
     * @param age     年龄
     * @param address 地址
     * @param mobile  电话
     * @return 用户数量
     */
    Long getUserCountByComplexCondition(String name, Integer age, String address, String mobile);
}
