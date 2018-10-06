package top.buukle.common.request;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/9/19.
 * @Description : buukle 公共请求头规范
 */
@Valid
public class RequestHead {
    /** 请求系统名称*/

    @NotNull // 不允许为空
    @Size(min = 1, max = 1) // 长度或大小范围
    private String applicationName;
    /** 请求操作时间*/
    private Date operationDatetime;
    /** 请求操作人登录名*/
    private String operationLoginName;
    /** 请求操作人*/
    private String operationName;
    /** 请求操作人Id*/
    private Integer operationId;

    public String getApplicationName() {
        return applicationName;
    }

    public Date getOperationDatetime() {
        return operationDatetime;
    }

    public String getOperationLoginName() {
        return operationLoginName;
    }

    public String getOperationName() {
        return operationName;
    }

    public Integer getOperationId() {
        return operationId;
    }


    /** 内部建造类*/
    public static class Builder {
        RequestHead requestHead = new RequestHead();

        public Builder setApplicationName(String applicationName) {
            requestHead.applicationName = applicationName;
            return this;
        }
        public Builder setOperationDatetime(Date operationDatetime) {
            requestHead.operationDatetime = operationDatetime;
            return this;
        }
        public Builder setOperationLoginName(String operationLoginName) {
            requestHead.operationLoginName = operationLoginName;
            return this;
        }
        public Builder setOperationName(String operationName) {
            requestHead.operationName = operationName;
            return this;
        }
        public Builder setOperationId(Integer operationId) {
            requestHead.operationId = operationId;
            return this;
        }

        public RequestHead build(String applicationName) {
            requestHead.applicationName = applicationName;
            requestHead.operationDatetime = new Date();
            return requestHead;
        }
    }

}
