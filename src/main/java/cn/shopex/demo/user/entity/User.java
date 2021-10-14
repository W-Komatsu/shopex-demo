package cn.shopex.demo.user.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author wangxiaosong
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User implements Serializable {
    private Long id;
    private String name;
    private Integer age;
    private String address;
    private String account;
    private String password;
    private String mobile;
}
