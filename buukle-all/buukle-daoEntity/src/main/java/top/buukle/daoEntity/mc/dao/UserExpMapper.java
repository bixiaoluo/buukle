/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.daoEntity.mc.dao;

import top.buukle.daoEntity.mc.entity.UserExp;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.apache.ibatis.annotations.Param;

/**
 * 
 * @author elvin
 *
 */

public interface UserExpMapper {
	/** 
	 * @Description:	分页获取UserExp
	 * @param userExp
	 * @param pageBounds
	 * @return
	 * @return	PageList<UserExp>
	 * @Date	2015年6月12日 上午10:29:17 
	 */
	public PageList<UserExp> getUserExpByParas(UserExp userExp, PageBounds pageBounds) throws Exception;
	
	/** 
	 * @Description:	根据id获取UserExp
	 * @return
	 * @throws Exception
	 * @return	UserExp
	 * @Date	2015年6月12日 上午10:29:35 
	 */
	public UserExp getUserExpById(Integer id) throws Exception;
	
	/** 
	 * @Description:	根据条件获取UserExp
	 * @param userExp
	 * @return
	 * @throws Exception
	 * @return	UserExp
	 * @Date	2015年6月12日 上午10:29:35 
	 */
	public PageList<UserExp> getUserExpByParas(UserExp userExp) throws Exception;
	/** 
	 * @Description:	添加UserExp
	 * @param userExp
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:49 
	 */
	public Integer save(UserExp userExp) throws Exception;
	/** 
	 * @Description:	更新UserExp
	 * @param userExp
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:56 
	 */
	public Integer update(UserExp userExp) throws Exception;
	/** 
	 * @Description:	删除UserExp
	 * @param userExp
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:30:05 
	 */
	public Integer delete(UserExp userExp) throws Exception;
	/** 
	 * @Description:	获取UserExp信息 不带分页
	 * @param userExp
	 * @return
	 * @throws Exception
	 * @return	PageList<UserExp>
	 * @Date	2015年6月12日 上午10:30:13 
	 */
	public PageList<UserExp> getUserExpsByParasNoPage(UserExp userExp) throws Exception;

	/**
	 * 根据用户编码获取用户扩展信息
	 * @param userId
	 * @return
	 */
    UserExp getUserExpByUserId(@Param("userId") String userId);
}
