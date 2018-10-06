/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.provider.mc.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import top.buukle.provider.mc.dao.FriendLinkMapper;
import top.buukle.provider.mc.entity.FriendLink;
import top.buukle.provider.mc.service.FriendLinkService;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

/**
 * 
 * @author elvin
 *
 */
@Service("friendLinkService")
public class FriendLinkServiceImpl implements FriendLinkService {
	@Resource
	FriendLinkMapper friendLinkMapper;
	@Override
	public List<FriendLink> getFriendLinkByParas(FriendLink friendLink, PageBounds pageBounds) throws Exception {
		return friendLinkMapper.getFriendLinkByParas(friendLink, pageBounds);
	}
	@Override
	public FriendLink getFriendLinkById(Integer id) throws Exception{
		return friendLinkMapper.getFriendLinkById(id);
	}
	
	@Override
	public List<FriendLink> getFriendLinkByParas(FriendLink friendLink) throws Exception {
		return friendLinkMapper.getFriendLinkByParas(friendLink);
	}
	@Override
	public void save(FriendLink friendLink) throws Exception {
		friendLinkMapper.save(friendLink);
	}
	@Override
	public void update(FriendLink friendLink) throws Exception {
		friendLinkMapper.update(friendLink);
	}
	@Override
	public void delete(FriendLink friendLink) throws Exception {
	}
	@Override
	public List<FriendLink> getFriendLinksByParasNoPage(FriendLink friendLink) throws Exception {
		return null;
	}
}
