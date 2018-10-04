/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.provider.mc.service.rest;

import top.buukle.api.inner.mc.rest.ButtonService;
import top.buukle.common.constants.BaseResponseCode;
import top.buukle.common.exception.BaseException;
import top.buukle.common.request.BaseRequest;
import top.buukle.common.response.BaseResponse;
import top.buukle.daoEntity.mc.dao.ButtonMapper;
import top.buukle.daoEntity.mc.entity.Button;
import top.buukle.daoEntity.mc.entity.Module;
import top.buukle.daoEntity.mc.vo.result.UserLoginPermissionResult;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 
 * @author elvin
 *
 */
@Service("restButtonService")
public class RestButtonServiceImpl implements ButtonService {
	@Resource
	ButtonMapper buttonMapper;
	@Override
	public List<Button> getButtonByParas(Button button, PageBounds pageBounds) throws Exception {
		return buttonMapper.getButtonByParas(button, pageBounds);
	}
	@Override
	public Button getButtonById(Integer id) throws Exception{
		return buttonMapper.getButtonById(id);
	}
	
	@Override
	public List<Button> getButtonByParas(Button button) throws Exception {
		return buttonMapper.getButtonByParas(button);
	}
	@Override
	public void save(Button button) throws Exception {
		buttonMapper.save(button);
	}
	@Override
	public void update(Button button) throws Exception {
		buttonMapper.update(button);
	}
	@Override
	public void delete(Button button) throws Exception {
	}
	@Override
	public List<Button> getButtonsByParasNoPage(Button button) throws Exception {
		return null;
	}

    /**
     * 获取全局按钮列表
     * @param request
     * @return
     * @throws Exception
     */
	@Override
	public BaseResponse getGlobalButtonList(BaseRequest request) throws Exception {
		List<Button> globalButtonList = buttonMapper.getGlobalButtonList();
	    return new BaseResponse.Builder().buildSuccess(globalButtonList);
	}

    /**
     * 获取用户按钮列表
     * @param request
     * @return
     * @throws Exception
     */
	@Override
	public BaseResponse getUserButtonList(BaseRequest request) throws Exception {
        //初始化请求参数
        List<Module> moduleList = request.getInfoList(Module.class);
        //校验参数
        this.validateGetUserModuleListParam(moduleList);
        UserLoginPermissionResult userLoginPermissionResult = new UserLoginPermissionResult();
        userLoginPermissionResult.setModuleList(moduleList);
        List<Button> buttonList = buttonMapper.getUserButtonListByModuleList(userLoginPermissionResult);
        return new BaseResponse.Builder().buildSuccess(buttonList);
	}

    /**
     * 校验参数
     * @param moduleList
     */
    private void validateGetUserModuleListParam(List<Module> moduleList) {
        if(null ==moduleList){
            throw new BaseException(BaseResponseCode.BASE_REQUEST_NULL);
        }
    }
}
