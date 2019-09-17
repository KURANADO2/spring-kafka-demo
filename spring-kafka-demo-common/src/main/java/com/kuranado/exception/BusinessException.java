package com.kuranado.exception;

import com.kuranado.result.ResultEnum;

import lombok.Data;

/**
 * @Author: Xinling Jing
 * @Date: 2019-09-16 15:57
 */
@Data
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = -6375664354763349242L;

    private int status;
    private String msg;

    public BusinessException(int status, String msg) {
        super();
        this.status = status;
        this.msg = msg;
    }

    public BusinessException(ResultEnum resultEnum) {
        super();
        this.status = resultEnum.getCode();
        this.msg = resultEnum.getMsg();
    }

    public BusinessException() {
        super();
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

}
