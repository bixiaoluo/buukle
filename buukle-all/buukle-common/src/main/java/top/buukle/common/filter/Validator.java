package top.buukle.common.filter;

import top.buukle.common.response.BaseResponse;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/10/7.
 * @Description :
 */
public abstract class Validator {
    public abstract BaseResponse validate(String body);
}
