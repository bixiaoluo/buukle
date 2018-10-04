package top.buukle.common.util.http;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.*;


import com.alibaba.fastjson.JSON;
import top.buukle.common.constants.BaseResponseCode;
import top.buukle.common.exception.BaseException;
import top.buukle.common.response.BaseResponse;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.util.CollectionUtils;


/**
 * HttpClientUtil
 * @author elvin
 */
public class HttpClientUtil {

    public static String PARAM_NAME = "param";
    private static String SEPARATORS_SLASH = "/";
    final private static Set<Integer> ERROR_CODE_SET = new HashSet<>();

    static{
        ERROR_CODE_SET.add(400);
        ERROR_CODE_SET.add(302);
        ERROR_CODE_SET.add(404);
        ERROR_CODE_SET.add(500);
        ERROR_CODE_SET.add(415);
        ERROR_CODE_SET.add(405);
    }
    /**
     * 使用指定的字符集向指定的URL连接get数据，延时可指定
     * @param urlValue
     * @param paras
     * @param charset
     * @param timeout
     * @return
     */
    public static String requestAsRestHttpGET(String urlValue, Map<String, List<String>> paras , String charset, int timeout) {
        HttpClient http = new HttpClient();
        HttpConnectionManagerParams managerParams = http.getHttpConnectionManager().getParams();
        managerParams.setConnectionTimeout(3000);
        managerParams.setSoTimeout(timeout);
        managerParams.setDefaultMaxConnectionsPerHost(32);
        managerParams.setMaxTotalConnections(256);
        List<String> paramList = paras.get(PARAM_NAME);
        if(!CollectionUtils.isEmpty(paramList)){
            StringBuilder urlValueBuilder = new StringBuilder(urlValue);
            for (String param: paramList) {
                urlValueBuilder.append(SEPARATORS_SLASH).append(param);
            }
            urlValue = urlValueBuilder.toString();
        }
        GetMethod method = new GetMethod(urlValue);
        method.getParams().setHttpElementCharset(charset);
        method.getParams().setContentCharset(charset);
        method.getParams().setCredentialCharset(charset);
        try {
            http.executeMethod(method);
            return method.getResponseBodyAsString();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 使用指定的字符集向指定的URL连接POST数据，延时可指定
     * @param urlValue
     * @param charset
     * @param timeout
     * @return
     */
	public static String requestAsHttpPOST(String urlValue, String reqJson , String charset, int timeout) throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault();
	    String body = null;
        CloseableHttpResponse httpresponse=null;
        try {
            // Post请求
            HttpPost httppost = new HttpPost(urlValue);
            // 初始化并设置参数
            StringEntity entity = new StringEntity(reqJson);
            // 设置参数内容类型
            entity.setContentType("application/json");
            httppost.setEntity(entity);
            //设置超时
            httppost.setConfig(RequestConfig.custom().setConnectionRequestTimeout(timeout).setSocketTimeout(timeout).build());
            // 发送请求
            httpresponse = httpClient.execute(httppost);
            // 获取返回数据
            HttpEntity responseEntity = httpresponse.getEntity();
            body = EntityUtils.toString(responseEntity,charset);
        } catch (SocketTimeoutException e) {
            throw e;
        } catch (Exception e) {
            return "";
        }
        int statusCode = httpresponse.getStatusLine().getStatusCode();
        if(ERROR_CODE_SET.contains(statusCode)){
            return JSON.toJSONString(new BaseResponse.Builder().buildFailedInner(new BaseException(BaseResponseCode.FAILED,body)));
        }
        return body;
	}

	/**
	 * 将传入的参数进行分割然后封装成Map数据，key是参数，value是参数对应的值，暂未使用
	 * @param paras
	 * @param regx
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map convertParas2Map(String paras , String regx) {
		Map attachValue = new HashMap();
		String[] vs = paras.split(regx);
		for (int i = 0; i < vs.length ; i ++) {
			String v = vs[i];
			String[] ts = v.split("=");
			if (ts.length == 2){
				attachValue.put(ts[0], ts[1]);
			}
		}
		return attachValue;
	}
}
