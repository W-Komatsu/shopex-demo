package cn.shopex.demo.common.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author wangxiaosong
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageData<T> {
    private List<T> list;
    private Long count;
}
