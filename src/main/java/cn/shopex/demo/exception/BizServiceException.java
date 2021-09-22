package cn.shopex.demo.exception;

import lombok.Getter;

/**
 * 自定义异常类
 *
 * @author wangxiaosong
 * @date 2020/3/26
 */
@Getter
public class BizServiceException extends RuntimeException {
    private final String errorCode;
    private final String errorMessage;

    public BizServiceException(String errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
