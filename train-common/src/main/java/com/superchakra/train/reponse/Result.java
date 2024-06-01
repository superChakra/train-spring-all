package com.superchakra.train.reponse;

import lombok.Data;

@Data
public class Result<T> {
    private String code;
    private String msg;
    private T data;
    private long timestamp;

    public Result() {
        this.timestamp = System.currentTimeMillis();
    }

    public Result(ResultStatusEnum resultStatusEnum) {
        this.code = resultStatusEnum.getCode();
        this.msg = resultStatusEnum.getMsg();
        this.timestamp = System.currentTimeMillis();
    }

    public Result<T> success(ResultStatusEnum resultStatusEnum,T data){
        Result<T> result = new Result<>(resultStatusEnum);
        result.setCode("200");
        result.setMsg("success");
        result.setData(data);
        return result;
    }
    public Result<T> success(T data){
        Result<T> result = new Result<>(ResultStatusEnum.SUCCESS);
        result.setData(data);
        return result;
    }

    public Result<T> error(ResultStatusEnum resultStatusEnum,T data){
        Result result = new Result(resultStatusEnum);
        result.setData(data);
        return result;
    }

}
