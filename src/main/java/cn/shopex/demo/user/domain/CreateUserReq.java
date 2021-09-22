package cn.shopex.demo.user.domain;

import cn.shopex.demo.common.validate.Mobile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author wangxiaosong
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserReq {
    @NotBlank
    @Length(max = 5)
    private String name;
    @NotNull
    private Integer age;
    private String address;
    @NotBlank
    private String account;
    @NotBlank
    private String password;
    @Mobile
    private String mobile;
}
