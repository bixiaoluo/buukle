package top.buukle.common.request;

import com.alibaba.fastjson.JSON;
import top.buukle.common.constants.BaseResponseCode;
import top.buukle.common.exception.BaseException;

import java.util.List;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/9/19.
 * @Description : elog 公共请求规范
 */
public class BaseRequest<T>{

    /** 请求头*/
    private RequestHead requestHead;
    /** 请求参数*/
    private T info;
    /** String 扩展请求参数*/
    private String expandParameterString;
    /** String 扩展请求参数*/
    private Integer expandParameterInteger;

    public RequestHead getRequestHead() {
        return requestHead;
    }

    public void setRequestHead(RequestHead requestHead) {
        this.requestHead = requestHead;
    }

    public T getInfo(Class<T> clazz) {
        return JSON.parseObject(JSON.toJSONString(info),clazz);
    }

    public List<T> getInfoList(Class<T> clazz) {
        if(info instanceof List){
            return JSON.parseArray(JSON.toJSONString(info), clazz);
        }else{
            throw new BaseException(BaseResponseCode.BASE_REQUEST_FORMAT_INFO_LIST_WRONG);
        }
    }

    public Object getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public String getExpandParameterString() {
        return expandParameterString;
    }

    public void setExpandParameterString(String expandParameterString) {
        this.expandParameterString = expandParameterString;
    }

    public Integer getExpandParameterInteger() {
        return expandParameterInteger;
    }

    public void setExpandParameterInteger(Integer expandParameterInteger) {
        this.expandParameterInteger = expandParameterInteger;
    }

    /** 内部建造类*/
    public static class Builder{
        BaseRequest baseRequest = new BaseRequest();

        /** 基础build*/
        public BaseRequest build(String applicationName) {
            baseRequest.requestHead = new RequestHead.Builder().build(applicationName);
            return baseRequest;
        }
    }
}
