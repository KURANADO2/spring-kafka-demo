package com.kuranado.result;

import lombok.Data;

/**
 * @author jing
 */
@Data
public class JsonResult<T> extends BaseResult {

    private T data;

    public JsonResult() {
        super();
    }

    public JsonResult(T data) {
        super();
        this.data = data;
    }

    public JsonResult(int status, String msg) {
        super(status, msg);
    }

    public JsonResult(int status, String msg, T data) {
        super(status, msg);
        this.data = data;
    }

    public JsonResult(int status, String msg, String sign) {
        super(status, msg, sign);
    }

    public JsonResult(int status, String msg, String sign, T data) {
        super(status, msg, sign);
        this.data = data;
    }
}
