package com.log4j2.admin.common.result;


import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @描述: 返回数据
 * @制作人: jian
 * @时间: 2019-08-1009:56
 */
@Data
@NoArgsConstructor
public class R {

    private Integer code;
    private boolean status;
    private String msg;
    private Integer count;
    private Object data;

    public R(RCode code){
        this.status = code.status;
        this.code = code.code;
        this.msg = code.msg;
    }

    public R(RCode code, Integer count,Object data){
        this.status = code.status;
        this.code = code.code;
        this.msg =  code.msg;
        this.count = count;
        this.data = data;
    }

    public R(Integer code,String msg,boolean status) {
        this.code = code;
        this.msg = msg;
        this.status = status;
    }

    public static R SUCCESS(){
        return new R(RCode.SUCCESS);
    }

    public static R FAIL(){
        return new R(RCode.FAIL);
    }
}
