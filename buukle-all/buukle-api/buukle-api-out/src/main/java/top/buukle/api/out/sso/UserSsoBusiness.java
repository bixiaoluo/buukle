package top.buukle.api.out.sso;

import top.buukle.common.request.BaseRequest;
import top.buukle.common.response.BaseResponse;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/9/20.
 * @Description : 用户sso API 接口类
 */
public interface UserSsoBusiness {

    void addStr(String key, String value);

    String getStr(String key);

    BaseResponse getUserById(Integer id);

    BaseResponse getUserById(BaseRequest request) throws Exception;
}
