package top.buukle.common.filter;

import top.buukle.common.response.BaseResponse;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/10/7.
 * @Description : 默认参数检验类
 */
public  class DefaultValidator extends Validator{
    @Override
    public BaseResponse validate(String body) {
        //默认不作校验
        return new BaseResponse.Builder().buildSuccess();
    }
}
