package top.buukle.provider.sso.business.impl;

import top.buukle.api.out.sso.UserSsoBusiness;
import top.buukle.common.request.BaseRequest;
import top.buukle.common.response.BaseResponse;
import top.buukle.common.util.common.NumberUtil;
import top.buukle.provider.sso.constants.UserInfoCacheConstants;
import top.buukle.provider.sso.invoker.UserInvoker;
import top.buukle.common.util.jedis.RedisString;
import org.springframework.stereotype.Component;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/9/21.
 * @Description :
 */
@Component("userSsoBussiness")
public class UserSsoBusinessImpl implements UserSsoBusiness {


    /**
     * 添加redis String值
     * @param key
     * @param value
     */
    @Override
    public void addStr(String key, String value) {
//        RedisString.set(key,value);
        RedisString.setWithExpire(UserInfoCacheConstants.APPLICATION_DEFAULT_MAX_AGE_PREFIX + "es",value, NumberUtil.LONG_ONE_DAY_SECOND);
    }

    @Override
    public String getStr(String key) {
        String s = RedisString.get(UserInfoCacheConstants.APPLICATION_DEFAULT_MAX_AGE_PREFIX + "es");
        return s;
    }

    /**
     * 根据id获取用户信息 (get)
     * @param id
     * @return
     */
    @Override
    public BaseResponse getUserById(Integer id) {
        return UserInvoker.getUserById(id);
    }

    /**
     * 根据id获取用户信息(post 请求响应规范化)
     * @param request
     * @return
     */
    @Override
    public BaseResponse getUserById(BaseRequest request) throws Exception {
        return UserInvoker.getUserById(request);
    }
}
