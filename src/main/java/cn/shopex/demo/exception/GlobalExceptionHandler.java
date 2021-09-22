package cn.shopex.demo.exception;

import cn.shopex.demo.common.domain.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author wangxiaosong
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 处理业务异常
     * @param e 业务异常
     * @return 错误响应
     */
    @ExceptionHandler({BizServiceException.class})
    public ResponseEntity<CommonResponse> handleBizServiceException(BizServiceException e) {
        log.warn("[handleBizServiceException] : ", e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CommonResponse(null, e.getErrorCode(), e.getMessage()));
    }
    /**
     * 处理HTTP请求方法错误异常
     * @param e HTTP请求方法错误异常
     * @return 错误响应
     */
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public ResponseEntity<CommonResponse> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        return ResponseEntity.badRequest().body(new CommonResponse(null, null, "HTTP请求方法错误"));
    }

    /**
     * 处理参数校验异常
     * @param e 参数校验异常
     * @return 错误响应
     */
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<CommonResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        StringBuilder errorMessage = new StringBuilder();
        for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
            errorMessage.append(fieldError.getField()).append(":").append(fieldError.getDefaultMessage()).append(";");
        }
        return ResponseEntity.badRequest().body(new CommonResponse(null, null, errorMessage.toString()));
    }

    /**
     * 处理其他异常
     * @param e 异常
     * @return 错误响应体
     */
    @ExceptionHandler({Exception.class})
    public ResponseEntity<CommonResponse> handleException(Exception e) {
        log.error("[handleException] : ", e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CommonResponse(null, String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()), e.getMessage()));
    }
}
