package cn.shopex.demo.user.domain;

import cn.shopex.demo.common.validate.Mobile;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author wangxiaosong
 */
@Data
public class UpdateUserReq {
    @NotNull
    private Long id;
    @NotBlank
    private String name;
    @NotNull
    private Integer age;
    private String address;
    @Mobile
    private String mobile;
}
