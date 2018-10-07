package top.buukle.common.filter.reqestAndResponseParameterFilter.validatorAndHandler;

import top.buukle.common.filter.reqestAndResponseParameterFilter.validatorAndHandler.base.BaseRequestValidator;
import top.buukle.common.util.logger.BaseLogger;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/10/7.
 * @Description : 默认参数检验类
 */
public  class DefaultRequestValidator extends BaseRequestValidator {

    private static final BaseLogger LOGGER = BaseLogger.getLogger(DefaultRequestValidator.class);

    @Override
    public void doValidate(HttpServletRequest httpServletRequest, String uri, String requestBody, ServletResponse servletResponse) {

    }
}
