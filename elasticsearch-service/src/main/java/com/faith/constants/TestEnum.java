package com.faith.constants;

/**
 * @description:
 * @author:faith
 * @time:2023/6/1915:37
 */
public enum TestEnum {
    吃饭(12),喝酒(13);
    private Integer code;
    TestEnum(int code){
    this.code = code;
    }
    public Integer getCode(){
        return code;
    }
}
