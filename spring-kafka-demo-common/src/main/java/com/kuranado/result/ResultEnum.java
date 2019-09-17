package com.kuranado.result;

import lombok.Getter;

/**
 * 接口返回状态码
 * @Author: Xinling Jing
 * @Date: 2019-08-25 13:37
 */
@Getter
public enum ResultEnum {

    /**
     * 接口返回状态码
     */
    SUCCESS(1000, "成功"),
    NO_NEW_VERSION(2001, "暂无新版本"),
    CAR_NOT_REGISTER(2002, "车辆未注册"),
    CAR_NOT_EXIST(2003, "车辆不存在"),
    JSON_FORMATE_EXCEPTION(5001, "参数Json格式转换异常"),
    PARAM_VERIFICATION_FAIL(5002, "参数校验失败"),
    SIGN_AUTHENTICATION_FAIL(5003, "签名验证失败"),
    MESSAGE_DECRYPTION_FAIL(5004, "请求报文解密失败"),
    VEHICLE_ILLEGALITY(5005, "车辆不合法"),
    FILE_SAVE_EXCEPTION(5006, "文件保存异常"),
    FILE_FORMAT_EXCEPTION(5007, "文件格式非法"),
    VEHICLE_FREQUENT_REQUEST(5008, "同一车辆频繁请求"),
    TASK_HAVE_ALREADY_STOPPED(6000, "任务终止"),
    UNKNOW_ERROR(10000, "服务器内部异常");

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
