package com.dzzdsj.demo.codeutils.HttpDemo.RestTemplateDemo;

public class CoreConstants {

    /**
     * 成功code
     */
    public static final String REQUEST_SUCCESS_CODE = "0";
    /**
     * 参数错误
     */
    public static final String REQUEST_ERROR_PARAMS = "-1";

    /**
     * 程序异常code
     */
    public static final String REQUEST_PROGRAM_ERROR_CODE = "-100";

    /**
     * 鉴权失败
     */
    public static final String REQUEST_ERROR_AUTHENTICATION = "-200";
    /**
     * 授权失败
     */
    public static final String REQUEST_ERROR_AUTHORIZE = "-201";
    /**
     * 非法访问
     */
    public static final String REQUEST_ERROR_ILLEGALLY = "-202";
    /**
     * 应用不存在
     */
    public static final String REQUEST_ERROR_NOAPP = "-100001";
    /**
     * 服务不存在
     */
    public static final String REQUEST_ERROR_NOSERVICE = "-200001";
    /**
     * IP拒绝code
     */
    public static final String REQUEST_REFUSE_IP_ERROR_CODE = "-60";
    /**
     * responseCode 状态码 调用成功
     */
//    public static final Integer REQUEST_RESPONSECODE_SUCCESS = 200;
    /**
     * responseCode 状态码 调用失败
     */
    public static final Integer REQUEST_RESPONSECODE_FAILD = 404;
    /**
     * responseCode 状态码 调用异常
     */
    public static final Integer REQUEST_RESPONSECODE_ERROR = 500;
    /**
     * 校验caseKey错误
     */
    public static final String REQUEST_CASEKEY_ERROR_CODE = "-300";

    /**
     * 根据caseId未查询到办件
     */
    public static final String REQUEST_CASEINFO_ERROR = "-110";

    /**
     * 参数最大长度
     */
    public static final int PARAM_MAX_LENGTH = 1000;

}