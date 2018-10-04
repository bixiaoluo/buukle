/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.daoEntity.mc.dao;

import top.buukle.daoEntity.mc.entity.Groups;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
 * @author tengbx
 *
 */

public interface GroupsMapper {
	/** 
	 * @Description:	分页获取Group
	 * @param group
	 * @param pageBounds
	 * @return
	 * @return	PageList<Groups>
	 * @Date	2015年6月12日 上午10:29:17 
	 */
	public PageList<Groups> getGroupByParas(Groups group, PageBounds pageBounds) throws Exception;
	
	/** 
	 * @Description:	根据id获取Group
	 * @return
	 * @throws Exception
	 * @return	Groups
	 * @Date	2015年6月12日 上午10:29:35 
	 */
	public Groups getGroupById(Integer id) throws Exception;
	
	/** 
	 * @Description:	根据条件获取Group
	 * @param group
	 * @return
	 * @throws Exception
	 * @return	Groups
	 * @Date	2015年6月12日 上午10:29:35 
	 */
	public PageList<Groups> getGroupByParas(Groups group) throws Exception;
	/** 
	 * @Description:	添加Group
	 * @param group
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:49 
	 */
	public Integer save(Groups group) throws Exception;
	/** 
	 * @Description:	更新Group
	 * @param group
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:56 
	 */
	public Integer update(Groups group) throws Exception;
	/** 
	 * @Description:	删除Group
	 * @param group
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:30:05 
	 */
	public Integer delete(Groups group) throws Exception;
	/** 
	 * @Description:	获取Group信息 不带分页
	 * @param group
	 * @return
	 * @throws Exception
	 * @return	PageList<Groups>
	 * @Date	2015年6月12日 上午10:30:13 
	 */
	public PageList<Groups> getGroupsByParasNoPage(Groups group) throws Exception;

	/**
	 * 根据用户编码获取组别信息
	 * @param userId
	 * @return
	 */
    List<Groups> getUserGroupListByUserId(@Param("userId") String userId);
}
