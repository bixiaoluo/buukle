/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.provider.mc.entity;

/**
 * 注释:AsyncTask实体
 * @author elvin
 */
public class AsyncTask implements java.io.Serializable{
	private static final long serialVersionUID = -1L;
	
	//columns START
	/**
	 * id
	 */
	private Integer id;
	/**
	 * 类名字（反射使用）
	 */
	private String className;
	/**
	 * 方法名字（反射使用）
	 */
	private String methodName;
	/**
	 * 定时任务执行参数
	 */
	private String parameter;
	/**
	 * 描述
	 */
	private String description;
	/**
	 * 提醒邮箱
	 */
	private String alarmMail;
	/**
	 * 启动提醒
                        1 是
                        0 否
	 */
	private Integer startAlarm;
	/**
	 * 停止提醒
                        1 是
                        0 否
	 */
	private Integer stopAlarm;
	/**
	 * 异常提醒
                        1 是
                        0 否
	 */
	private Integer errorAlarm;
	/**
	 * 执行计划规则
	 */
	private String cronExpression;
	/**
	 * 启动开始时间
	 */
	private java.util.Date startDate;
	/**
	 * 类型
                        0 重复执行
                        1 执行一次
	 */
	private Integer type;
	/**
	 * 运行环境类型 0 灰度 1 线上
	 */
	private Integer runType;
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
	public void setClassName(String className) {
	    this.className = className==null?null:className.trim();
	}
	
	public String getClassName() {
		return this.className;
	}
	public void setMethodName(String methodName) {
	    this.methodName = methodName==null?null:methodName.trim();
	}
	
	public String getMethodName() {
		return this.methodName;
	}
	public void setParameter(String parameter) {
	    this.parameter = parameter==null?null:parameter.trim();
	}
	
	public String getParameter() {
		return this.parameter;
	}
	public void setDescription(String description) {
	    this.description = description==null?null:description.trim();
	}
	
	public String getDescription() {
		return this.description;
	}
	public void setAlarmMail(String alarmMail) {
	    this.alarmMail = alarmMail==null?null:alarmMail.trim();
	}
	
	public String getAlarmMail() {
		return this.alarmMail;
	}
	public void setStartAlarm(Integer startAlarm) {
		this.startAlarm = startAlarm;
	}
	
	public Integer getStartAlarm() {
		return this.startAlarm;
	}
	public void setStopAlarm(Integer stopAlarm) {
		this.stopAlarm = stopAlarm;
	}
	
	public Integer getStopAlarm() {
		return this.stopAlarm;
	}
	public void setErrorAlarm(Integer errorAlarm) {
		this.errorAlarm = errorAlarm;
	}
	
	public Integer getErrorAlarm() {
		return this.errorAlarm;
	}
	public void setCronExpression(String cronExpression) {
	    this.cronExpression = cronExpression==null?null:cronExpression.trim();
	}
	
	public String getCronExpression() {
		return this.cronExpression;
	}
	public void setStartDate(java.util.Date startDate) {
		this.startDate = startDate;
	}
	
	public java.util.Date getStartDate() {
		return this.startDate;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	
	public Integer getType() {
		return this.type;
	}
	public void setRunType(Integer runType) {
		this.runType = runType;
	}
	
	public Integer getRunType() {
		return this.runType;
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


