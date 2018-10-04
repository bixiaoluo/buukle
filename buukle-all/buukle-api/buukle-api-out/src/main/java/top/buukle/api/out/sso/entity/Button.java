/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.api.out.sso.entity;

/**
 * 注释:Button实体
 * @author tengbx
 */
public class Button implements java.io.Serializable{
	private static final long serialVersionUID = -1L;
	
	//columns START
	/**
	 * 
	 */
	private Integer id;
	/**
	 * 请求url
	 */
	private String url;
	/**
	 * 所属菜单id
	 */
	private Integer moduleId;
	/**
	 * 按钮操作类型 ==> 0:添加 1删除 2:修改 3:详情 4: 申请启用 5:审核 6;启/停用 7:分配角色 8:分配菜单)
	 */
	private Integer operationType;
	/**
	 * 按钮响应类型 ==> 0:confirm(确认框) 1:frame(弹层)
	 */
	private Integer responseType;
	/**
	 * 按钮分布级别 ==> 0:页面级别 1: 列表级别
	 */
	private Integer layoutLevel;
	/**
	 * 按钮的页面响应DOM元素 id
	 */
	private String responseDomId;
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
	public void setUrl(String url) {
	    this.url = url==null?null:url.trim();
	}
	
	public String getUrl() {
		return this.url;
	}
	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}
	
	public Integer getModuleId() {
		return this.moduleId;
	}
	public void setOperationType(Integer operationType) {
		this.operationType = operationType;
	}
	
	public Integer getOperationType() {
		return this.operationType;
	}
	public void setResponseType(Integer responseType) {
		this.responseType = responseType;
	}
	
	public Integer getResponseType() {
		return this.responseType;
	}
	public void setLayoutLevel(Integer layoutLevel) {
		this.layoutLevel = layoutLevel;
	}
	
	public Integer getLayoutLevel() {
		return this.layoutLevel;
	}
	public void setResponseDomId(String responseDomId) {
	    this.responseDomId = responseDomId==null?null:responseDomId.trim();
	}
	
	public String getResponseDomId() {
		return this.responseDomId;
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


