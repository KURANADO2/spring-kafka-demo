package com.kuranado.result;

import lombok.Data;

/**
 * @author jing
 */
@Data
public class BaseResult {

    private Integer status;
    private String msg;
    private String sign;

    public BaseResult() {
        super();
        this.status = ResultEnum.SUCCESS.getCode();
        this.msg = ResultEnum.SUCCESS.getMsg();
    }

    public BaseResult(int status, String msg) {
        super();
        this.status = status;
        this.msg = msg;
    }

    public BaseResult(ResultEnum resultEnum) {
        super();
        this.status = resultEnum.getCode();
        this.msg = resultEnum.getMsg();
    }

    public BaseResult(int status, String msg, String sign) {
        super();
        this.status = status;
        this.msg = msg;
        this.sign = sign;
    }

}
