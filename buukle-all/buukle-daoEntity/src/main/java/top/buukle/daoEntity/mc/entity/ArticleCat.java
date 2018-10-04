/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.daoEntity.mc.entity;

/**
 * 注释:ArticleCat实体
 * @author elvin
 */
public class ArticleCat implements java.io.Serializable{
	private static final long serialVersionUID = -1L;
	
	//columns START
	/**
	 * 主键id
	 */
	private Integer id;
	/**
	 * 上级分类id
	 */
	private Long pid;
	/**
	 * 用户代码
	 */
	private String userId;
	/**
	 * 分类名
	 */
	private String articleCat;
	/**
	 * 描述
	 */
	private String description;
	/**
	 * 创建者(用户名)
	 */
	private String creator;
	/**
	 * 创建者代码
	 */
	private String creatorCode;
	/**
	 * 创建时间
	 */
	private java.util.Date gmtCreated;
	/**
	 * 修改者(用户名)
	 */
	private String modifier;
	/**
	 * 修改者代码
	 */
	private String modifierCode;
	/**
	 * 更新时间
	 */
	private java.util.Date gmtModified;
	/**
	 * 
	 */
	private Integer status;
	/**
	 * 备用
	 */
	private String bak01;
	/**
	 * 备用
	 */
	private String bak02;
	/**
	 * 备用
	 */
	private String bak03;
	/**
	 * 备用
	 */
	private String bak04;
	/**
	 * 备用
	 */
	private String bak05;
	//columns END

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return this.id;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	
	public Long getPid() {
		return this.pid;
	}
	public void setUserId(String userId) {
	    this.userId = userId==null?null:userId.trim();
	}
	
	public String getUserId() {
		return this.userId;
	}
	public void setArticleCat(String articleCat) {
	    this.articleCat = articleCat==null?null:articleCat.trim();
	}
	
	public String getArticleCat() {
		return this.articleCat;
	}
	public void setDescription(String description) {
	    this.description = description==null?null:description.trim();
	}
	
	public String getDescription() {
		return this.description;
	}
	public void setCreator(String creator) {
	    this.creator = creator==null?null:creator.trim();
	}
	
	public String getCreator() {
		return this.creator;
	}
	public void setCreatorCode(String creatorCode) {
	    this.creatorCode = creatorCode==null?null:creatorCode.trim();
	}
	
	public String getCreatorCode() {
		return this.creatorCode;
	}
	public void setGmtCreated(java.util.Date gmtCreated) {
		this.gmtCreated = gmtCreated;
	}
	
	public java.util.Date getGmtCreated() {
		return this.gmtCreated;
	}
	public void setModifier(String modifier) {
	    this.modifier = modifier==null?null:modifier.trim();
	}
	
	public String getModifier() {
		return this.modifier;
	}
	public void setModifierCode(String modifierCode) {
	    this.modifierCode = modifierCode==null?null:modifierCode.trim();
	}
	
	public String getModifierCode() {
		return this.modifierCode;
	}
	public void setGmtModified(java.util.Date gmtModified) {
		this.gmtModified = gmtModified;
	}
	
	public java.util.Date getGmtModified() {
		return this.gmtModified;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public Integer getStatus() {
		return this.status;
	}
	public void setBak01(String bak01) {
	    this.bak01 = bak01==null?null:bak01.trim();
	}
	
	public String getBak01() {
		return this.bak01;
	}
	public void setBak02(String bak02) {
	    this.bak02 = bak02==null?null:bak02.trim();
	}
	
	public String getBak02() {
		return this.bak02;
	}
	public void setBak03(String bak03) {
	    this.bak03 = bak03==null?null:bak03.trim();
	}
	
	public String getBak03() {
		return this.bak03;
	}
	public void setBak04(String bak04) {
	    this.bak04 = bak04==null?null:bak04.trim();
	}
	
	public String getBak04() {
		return this.bak04;
	}
	public void setBak05(String bak05) {
	    this.bak05 = bak05==null?null:bak05.trim();
	}
	
	public String getBak05() {
		return this.bak05;
	}

}


