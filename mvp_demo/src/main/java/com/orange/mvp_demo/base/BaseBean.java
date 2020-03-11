package com.orange.mvp_demo.base;

import java.io.Serializable;

/**
 * Time: 2020/3/11 9:14
 * <p>
 * Author: 橘子丶
 */
public class BaseBean<T> implements Serializable {
    /**
     * data :
     * errorCode : 0
     * errorMsg :
     */

    public int errorCode;
    public String errorMsg;
    public T data;

    public BaseBean(int code, String data) {
        this.errorCode = code;
        this.data = (T) data;
    }
}
