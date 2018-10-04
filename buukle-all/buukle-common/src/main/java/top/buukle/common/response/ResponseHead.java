package top.buukle.common.response;

import top.buukle.common.request.RequestHead;

import java.util.Date;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/9/19.
 * @Description : elog 公共响应头规范
 */
public class ResponseHead {


    private static final String DEFAULT_APPLICATION_NAME = "SYSTEM";
    /** 请求头来源*/
    private RequestHead requestHead;
    /** 响应系统名称*/
    private String applicationName;
    /** 响应时间*/
    private Date operationDatetime;


    public ResponseHead() {
        this.applicationName = DEFAULT_APPLICATION_NAME;
        this.operationDatetime = new Date();
    }

    public ResponseHead(RequestHead requestHead, String applicationName, Date operationDatetime) {
        this.requestHead = requestHead;
        this.applicationName = DEFAULT_APPLICATION_NAME;
        this.operationDatetime = new Date();
    }

    public RequestHead getRequestHead() {
        return requestHead;
    }

    public void setRequestHead(RequestHead requestHead) {
        this.requestHead = requestHead;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public Date getOperationDatetime() {
        return operationDatetime;
    }

    public void setOperationDatetime(Date operationDatetime) {
        this.operationDatetime = operationDatetime;
    }
}
