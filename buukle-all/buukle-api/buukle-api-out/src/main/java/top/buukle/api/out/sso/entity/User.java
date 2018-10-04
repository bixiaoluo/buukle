/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.api.out.sso.entity;
/**
 * 注释:User实体
 * @author elvin
 */
public class User implements java.io.Serializable{
	private static final long serialVersionUID = -1L;
	
	//columns START
	/**
	 * 主键id
	 */
	private Integer id;
	/**
	 * 登录名
	 */
	private String username;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 用户代码 : 生成规则待定,全局唯一
	 */
	private String userId;
	/**
	 * 粉丝数目
	 */
	private String fansNumber;
	/**
	 * 手机号码
	 */
	private String phone;
	/**
	 * 性别 1：男 0：女
	 */
	private String gender;
	/**
	 * 年龄
	 */
	private String age;
	/**
	 * 签名
	 */
	private String slogen;
	/**
	 * 登录策略 1: 一周 0:系统默认时间
	 */
	private Integer loginStrategy;
	/**
	 * 头像url
	 */
	private String headImageUrl;
	/**
	 * 头像静态服务器数据库id
	 */
	private String headImageId;
	/**
	 * 主题
	 */
	private String theme;
	/**
	 * 主题id
	 */
	private Integer themeId;
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
	 * 中文姓名昵称
	 */
	private String nameCn;
	/**
	 * 中文姓名全称
	 */
	private String fullNameCn;
	/**
	 * 英文姓名昵称
	 */
	private String nameEn;
	/**
	 * 英文姓名全称
	 */
	private String fullNameEn;
	/**
	 * 状态 1：启用 0：停用 -1 : 删除
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

    public User(Integer id) {
    	this.id = id;
    }
    public User() {
    }
    //columns END

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return this.id;
	}
	public void setUsername(String username) {
	    this.username = username==null?null:username.trim();
	}
	
	public String getUsername() {
		return this.username;
	}
	public void setPassword(String password) {
	    this.password = password==null?null:password.trim();
	}
	
	public String getPassword() {
		return this.password;
	}
	public void setUserId(String userId) {
	    this.userId = userId==null?null:userId.trim();
	}
	
	public String getUserId() {
		return this.userId;
	}
	public void setFansNumber(String fansNumber) {
	    this.fansNumber = fansNumber==null?null:fansNumber.trim();
	}
	
	public String getFansNumber() {
		return this.fansNumber;
	}
	public void setPhone(String phone) {
	    this.phone = phone==null?null:phone.trim();
	}
	
	public String getPhone() {
		return this.phone;
	}
	public void setGender(String gender) {
	    this.gender = gender==null?null:gender.trim();
	}
	
	public String getGender() {
		return this.gender;
	}
	public void setAge(String age) {
	    this.age = age==null?null:age.trim();
	}
	
	public String getAge() {
		return this.age;
	}
	public void setSlogen(String slogen) {
	    this.slogen = slogen==null?null:slogen.trim();
	}
	
	public String getSlogen() {
		return this.slogen;
	}
	public void setLoginStrategy(Integer loginStrategy) {
		this.loginStrategy = loginStrategy;
	}
	
	public Integer getLoginStrategy() {
		return this.loginStrategy;
	}
	public void setHeadImageUrl(String headImageUrl) {
	    this.headImageUrl = headImageUrl==null?null:headImageUrl.trim();
	}
	
	public String getHeadImageUrl() {
		return this.headImageUrl;
	}
	public void setHeadImageId(String headImageId) {
	    this.headImageId = headImageId==null?null:headImageId.trim();
	}
	
	public String getHeadImageId() {
		return this.headImageId;
	}
	public void setTheme(String theme) {
	    this.theme = theme==null?null:theme.trim();
	}
	
	public String getTheme() {
		return this.theme;
	}
	public void setThemeId(Integer themeId) {
		this.themeId = themeId;
	}
	
	public Integer getThemeId() {
		return this.themeId;
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
	public void setNameCn(String nameCn) {
	    this.nameCn = nameCn==null?null:nameCn.trim();
	}
	
	public String getNameCn() {
		return this.nameCn;
	}
	public void setFullNameCn(String fullNameCn) {
	    this.fullNameCn = fullNameCn==null?null:fullNameCn.trim();
	}
	
	public String getFullNameCn() {
		return this.fullNameCn;
	}
	public void setNameEn(String nameEn) {
	    this.nameEn = nameEn==null?null:nameEn.trim();
	}
	
	public String getNameEn() {
		return this.nameEn;
	}
	public void setFullNameEn(String fullNameEn) {
	    this.fullNameEn = fullNameEn==null?null:fullNameEn.trim();
	}
	
	public String getFullNameEn() {
		return this.fullNameEn;
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


