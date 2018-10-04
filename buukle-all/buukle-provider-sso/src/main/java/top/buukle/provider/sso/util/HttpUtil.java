package top.buukle.provider.sso.util;

import com.alibaba.fastjson.JSON;
import top.buukle.common.response.BaseResponse;
import top.buukle.common.util.common.PropertiesUtil;
import top.buukle.common.util.http.HttpClientUtil;

import java.util.*;

public class HttpUtil{


    /** mc 管理中心 域名/ip */
    private static final String MC_DOMAIN_HOST_AND_PREFIX = PropertiesUtil.getProperties("config/properties/system.properties").getProperty("mc.rest.host") + "/api/inner/mc";

    /** 方法名,方法路径映射map*/
    public static final Map<String, String> METHOD_URL_MAP =new HashMap<>();

    /** 默认编码*/
    public static final String DEFAULT_ENCODING = "UTF-8";

    /** 默认超时时间*/
    public static final Integer DEFAULT_TIMEOUT = 2000;

    /** post 请求参数名*/
    public static String PARAM_NAME = HttpClientUtil.PARAM_NAME;

	/** 用户*/
    public static final String METHOD_SSO_GET_USER_BY_ID = "METHOD_SSO_GET_USER_BY_ID";
    public static final String METHOD_SSO_GET_USER_INFO_FOR_LOGIN = "METHOD_SSO_GET_USER_INFO_FOR_LOGIN";

    /** 权限*/
    public static final String METHOD_SSO_GET_GLOBAL_MODULE_LIST = "METHOD_SSO_GET_GLOBAL_MODULE_LIST";
    public static final String METHOD_SSO_GET_GLOBAL_BUTTON_LIST = "METHOD_SSO_GET_GLOBAL_BUTTON_LIST";
    public static final String METHOD_SSO_GET_USER_ROLE_LIST = "METHOD_SSO_GET_USER_ROLE_LIST";
    public static final String METHOD_SSO_GET_USER_MODULE_LIST = "METHOD_SSO_GET_USER_MODULE_LIST";
    public static final String METHOD_SSO_GET_USER_BUTTON_LIST = "METHOD_SSO_GET_USER_BUTTON_LIST";

    static{
        METHOD_URL_MAP.put(METHOD_SSO_GET_USER_BY_ID, MC_DOMAIN_HOST_AND_PREFIX +"/user/getUserById");
		METHOD_URL_MAP.put(METHOD_SSO_GET_USER_INFO_FOR_LOGIN, MC_DOMAIN_HOST_AND_PREFIX +"/user/getUserInfoForLogin");
		METHOD_URL_MAP.put(METHOD_SSO_GET_GLOBAL_MODULE_LIST, MC_DOMAIN_HOST_AND_PREFIX +"/module/getGlobalModuleList");
		METHOD_URL_MAP.put(METHOD_SSO_GET_GLOBAL_BUTTON_LIST, MC_DOMAIN_HOST_AND_PREFIX +"/button/getGlobalButtonList");
		METHOD_URL_MAP.put(METHOD_SSO_GET_USER_ROLE_LIST, MC_DOMAIN_HOST_AND_PREFIX +"/role/getUserRoleList");
		METHOD_URL_MAP.put(METHOD_SSO_GET_USER_MODULE_LIST, MC_DOMAIN_HOST_AND_PREFIX +"/module/getUserModuleList");
		METHOD_URL_MAP.put(METHOD_SSO_GET_USER_BUTTON_LIST, MC_DOMAIN_HOST_AND_PREFIX +"/button/getUserButtonList");
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
