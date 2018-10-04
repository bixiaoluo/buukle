package top.buukle.plugin.sso.util;

import com.alibaba.fastjson.JSON;
import top.buukle.common.response.BaseResponse;
import top.buukle.common.util.http.HttpClientUtil;
import top.buukle.plugin.sso.constants.Constants;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class HttpUtil{

    /** sso 服务中心接口服务 地址&前缀 */
    private static final String SSO_DOMAIN_HOST_AND_PREFIX =  Constants.SSO_HOST.get(0) + "/api/out/sso";

    /** 方法名,方法路径映射map*/
    public static final Map<String, String> METHOD_URL_MAP =new HashMap<>();

    /** 默认编码*/
    public static final String DEFAULT_ENCODING = "UTF-8";

    /** 默认超时时间*/
    public static final Integer DEFAULT_TIMEOUT = 2000;

    /** post 请求参数名*/
    public static String PARAM_NAME = HttpClientUtil.PARAM_NAME;

    public static final String METHOD_SSO_PLUGIN_USER_DO_LOGIN = "METHOD_SSO_PLUGIN_USER_DO_LOGIN";
    public static final String METHOD_SSO_PLUGIN_USER_AUTHENTICATION = "METHOD_SSO_PLUGIN_USER_AUTHENTICATION";
    public static final String METHOD_SSO_PLUGIN_USER_SET_PERMISSION = "METHOD_SSO_PLUGIN_USER_SET_PERMISSION";

    static{
        METHOD_URL_MAP.put(METHOD_SSO_PLUGIN_USER_DO_LOGIN, SSO_DOMAIN_HOST_AND_PREFIX +"/login");
        METHOD_URL_MAP.put(METHOD_SSO_PLUGIN_USER_AUTHENTICATION, SSO_DOMAIN_HOST_AND_PREFIX +"/authentication");
        METHOD_URL_MAP.put(METHOD_SSO_PLUGIN_USER_SET_PERMISSION, SSO_DOMAIN_HOST_AND_PREFIX +"/setPermission");
	}

    /**
     * 调用执行方法,并转化返回结果(get)
     * @param methodKey     请求url的key
     * @param list          请求参数 : List<String> 形式的restful参数
     * @return
     */
    public static BaseResponse invoker(String methodKey, List<String> list ){
        return JSON.parseObject(executeGET(methodKey, list), BaseResponse.class);
    }

    /**
     * 调用执行方法,并转化返回结果(post)
     * @param methodKey     请求url的key
     * @param reqJson       请求参数 : json形式的 String
     * @return
     */
    public static BaseResponse invoker(String methodKey, String reqJson ) throws Exception {
        return  JSON.parseObject(executePOST(methodKey, reqJson), BaseResponse.class);
    }

    /**
     * 处理参数,并执行get请求
     * @param methodKey     请求url的key
     * @param paramList     请求参数 : json形式的 String
     * @return
     */
    public static String executeGET(String methodKey, List<String> paramList){
        String urlValue= METHOD_URL_MAP.get(methodKey);
        Map<String, List<String>> paras = new HashMap<>(16);
        paras.put(PARAM_NAME, paramList);
        return HttpClientUtil.requestAsRestHttpGET(urlValue, paras, DEFAULT_ENCODING, DEFAULT_TIMEOUT);
    }

    /**
     *处理参数,并执行post请求
     * @param methodKey     请求url的key
     * @param reqJson       请求参数 : json形式的 String
     * @return
     * @throws Exception
     */
    public static String executePOST(String methodKey, String reqJson) throws Exception {
        String urlValue= METHOD_URL_MAP.get(methodKey);
        return HttpClientUtil.requestAsHttpPOST(urlValue, reqJson, DEFAULT_ENCODING, DEFAULT_TIMEOUT);
    }
}
