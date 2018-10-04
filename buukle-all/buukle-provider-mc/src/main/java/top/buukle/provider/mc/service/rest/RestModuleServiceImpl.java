/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.provider.mc.service.rest;

import top.buukle.api.inner.mc.rest.ModuleService;
import top.buukle.common.constants.BaseResponseCode;
import top.buukle.common.exception.BaseException;
import top.buukle.common.request.BaseRequest;
import top.buukle.common.response.BaseResponse;
import top.buukle.daoEntity.mc.dao.ModuleMapper;
import top.buukle.daoEntity.mc.entity.Module;
import top.buukle.daoEntity.mc.entity.Role;
import top.buukle.daoEntity.mc.vo.result.UserLoginPermissionResult;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 
 * @author elvin
 *
 */
@Service("restModuleService")
public class RestModuleServiceImpl implements ModuleService {
	@Resource
    ModuleMapper moduleMapper;
	@Override
	public List<Module> getModuleByParas(Module module, PageBounds pageBounds) throws Exception {
		return moduleMapper.getModuleByParas(module, pageBounds);
	}
	@Override
	public Module getModuleById(Integer id) throws Exception{
		return moduleMapper.getModuleById(id);
	}
	
	@Override
	public List<Module> getModuleByParas(Module module) throws Exception {
		return moduleMapper.getModuleByParas(module);
	}
	@Override
	public void save(Module module) throws Exception {
		moduleMapper.save(module);
	}
	@Override
	public void update(Module module) throws Exception {
		moduleMapper.update(module);
	}
	@Override
	public void delete(Module module) throws Exception {
	}
	@Override
	public List<Module> getModulesByParasNoPage(Module module) throws Exception {
		return null;
	}

	/**
	 * 获取全局菜单列表
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@Override
	public BaseResponse getGlobalModuleList(BaseRequest request) throws Exception {
        List<Module> moduleList = moduleMapper.getGlobalModuleList();
	    return new BaseResponse.Builder().buildSuccess(moduleList);
	}

    /**
     * 获取用户菜单列表
     * @param request
     * @return
     * @throws Exception
     */
	@Override
	public BaseResponse getUserModuleList(BaseRequest request) throws Exception {
        //初始化请求参数
        List<Role> roleList = request.getInfoList(Role.class);
        //校验参数
        this.validateGetUserModuleListParam(roleList);
        UserLoginPermissionResult userLoginPermissionResult = new UserLoginPermissionResult();
        userLoginPermissionResult.setRoleList(roleList);
        List<Module> userModuleListByRoleList = moduleMapper.getUserModuleListByRoleList(userLoginPermissionResult);
        return new BaseResponse.Builder().buildSuccess(userModuleListByRoleList);
	}

    /**
     * 校验参数
     * @param infoList
     */
    private void validateGetUserModuleListParam(List<Role> infoList) {
        if(CollectionUtils.isEmpty(infoList)){
            throw new BaseException(BaseResponseCode.USER_PERMISSION_USER_ROLE_LIST_NULL_MC);
        }
    }
}
