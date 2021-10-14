package cn.shopex.demo.demo;

import cn.shopex.demo.user.entity.User;
import cn.shopex.demo.user.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Test
    void testMapper() {
        List<User> result = userMapper.selectAllUser();
        System.out.println(result);
    }
}
