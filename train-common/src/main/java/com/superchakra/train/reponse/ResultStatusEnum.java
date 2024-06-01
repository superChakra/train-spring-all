package com.superchakra.train.reponse;

import lombok.Getter;


@Getter
public enum ResultStatusEnum {

    SUCCESS("200", true, "操作成功！"),
    FAILED("500", false, "操作失败！"),

    USER_REGISTER_SUCCESS("200",true,"用户注册成功,请登陆"),


    // 50x 用户相关错误
    USER_REQUEST_TOO_FREQUENT("551", false, "用户请求验证码过于频繁，请60秒后再试"),
    INVALID_USERNAME_OR_PASSWORD("552", false, "用户账号或密码错误"),
    USER_NOT_REGISTERED("553", false, "用户未注册"),
    REGISTER_CODE_ERROR("554",false,"验证码错误"),
    USER_REGISTERED_ERROR("500",false,"手机号已注册"),



    // 54x 系统级别异常
    SYSTEM_INDEX_OUT_OF_BOUNDS("541", false, "系统错误，数组越界！"),
    SYSTEM_ARITHMETIC_BY_ZERO("542", false, "系统错误，无法除零！"),
    SYSTEM_NULL_POINTER("543", false, "系统错误，空指针！"),
    SYSTEM_NUMBER_FORMAT("544", false, "系统错误，数字转换异常！"),
    SYSTEM_PARSE_ERROR("545", false, "系统错误，解析异常！"),
    SYSTEM_IO_ERROR("546", false, "系统错误，IO输入输出异常！"),
    SYSTEM_FILE_NOT_FOUND("547", false, "系统错误，文件未找到！"),
    SYSTEM_CLASS_CAST_ERROR("548", false, "系统错误，类型强制转换错误！"),
    SYSTEM_PARSER_ERROR("549", false, "系统错误，解析出错！"),
    SYSTEM_DATE_PARSER_ERROR("550", false, "系统错误，日期解析出错！"),

    // 56x 管理系统相关错误
    ADMIN_USERNAME_NULL_ERROR("561", false, "管理员登录名不能为空！"),
    ADMIN_USERNAME_EXIST_ERROR("562", false, "管理员登录名已存在！"),
    ADMIN_NAME_NULL_ERROR("563", false, "管理员负责人不能为空！"),
    ADMIN_PASSWORD_ERROR("564", false, "密码不能为空或两次输入不一致！"),
    ADMIN_CREATE_ERROR("565", false, "添加管理员失败！"),
    ADMIN_PASSWORD_NULL_ERROR("566", false, "密码不能为空！"),
    ADMIN_NOT_EXIST_ERROR("567", false, "管理员不存在或密码错误！"),
    ADMIN_FACE_NULL_ERROR("568", false, "人脸信息不能为空！"),
    ADMIN_FACE_LOGIN_ERROR("569", false, "人脸识别失败，请重试！"),
    CATEGORY_EXIST_ERROR("570", false, "文章分类已存在，请换一个分类名！"),

    // 58x 媒体中心相关错误
    ARTICLE_COVER_NOT_EXIST_ERROR("580", false, "文章封面不存在，请选择一个！"),
    ARTICLE_CATEGORY_NOT_EXIST_ERROR("581", false, "请选择正确的文章领域！"),
    ARTICLE_CREATE_ERROR("582", false, "创建文章失败，请重试或联系管理员！"),
    ARTICLE_QUERY_PARAMS_ERROR("583", false, "文章列表查询参数错误！"),
    ARTICLE_DELETE_ERROR("584", false, "文章删除失败！"),
    ARTICLE_WITHDRAW_ERROR("585", false, "文章撤回失败！"),
    ARTICLE_REVIEW_ERROR("586", false, "文章审核出错！"),
    ARTICLE_ALREADY_READ_ERROR("587", false, "文章重复阅读！"),

    // 60x 人脸识别相关错误
    FACE_VERIFY_TYPE_ERROR("600", false, "人脸比对验证类型不正确！"),
    FACE_VERIFY_LOGIN_ERROR("601", false, "人脸登录失败！"),

    // 系统通用错误
    SYSTEM_ERROR("555", false, "系统繁忙，请稍后再试！"),
    SYSTEM_OPERATION_ERROR("556", false, "操作失败，请重试或联系管理员！"),
    SYSTEM_RESPONSE_NO_INFO("557", false, "无返回信息！");

    private final String code;
    private final boolean data;
    private final String msg;

    ResultStatusEnum(String code, boolean data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }


}
