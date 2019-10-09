package com.log4j2.admin.common.result;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @描述: 状态
 * @制作人: jian
 * @时间: 2019-08-1010:13
 */

public enum  RCode {


    SUCCESS(0,true,"操作成功！"),
    FAIL(1001,false,"操作失败");


    //操作代码
    int code;
    //操作是否成功
    boolean status;
    //提示信息
    String msg;

    RCode(int code,boolean status,String msg){
        this.status = status;
        this.code = code;
        this.msg = msg;
    }

    public boolean status(){
        return status;
    }

    public int code(){
        return code;
    }

    public String msg(){
        return msg;
    }


}
