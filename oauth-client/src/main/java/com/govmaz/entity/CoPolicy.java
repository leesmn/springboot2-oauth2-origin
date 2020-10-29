package com.govmaz.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import constant.EDataStatus;

import java.io.Serializable;
import java.util.Date;


/**
 * 
 * 
 * @author jv_team
 * @email 
 * @date 2020-10-17 23:36:08
 */
public class CoPolicy implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //
    private Integer id;
	
	    //项目名
    private String projectName;
	
	    //地区代码
    private String areaCode;
	
	    //地区名称
    private String areaName;
	
	    //受理部门
    private String acceptDep;
	
	    //申报开始日期
		@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date declareStart;
	
	    //申报结束日期
		@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date declareEnd;
	
	    //申报说明
    private String declareInstruction;
	
	    //
    private Integer createBy;
	
	    //
    private Date createAt;
	
	    //N,正常；D,删除
    private EDataStatus dataStatus;
	

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：项目名
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	/**
	 * 获取：项目名
	 */
	public String getProjectName() {
		return projectName;
	}
	/**
	 * 设置：地区代码
	 */
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	/**
	 * 获取：地区代码
	 */
	public String getAreaCode() {
		return areaCode;
	}
	/**
	 * 设置：地区名称
	 */
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	/**
	 * 获取：地区名称
	 */
	public String getAreaName() {
		return areaName;
	}
	/**
	 * 设置：受理部门
	 */
	public void setAcceptDep(String acceptDep) {
		this.acceptDep = acceptDep;
	}
	/**
	 * 获取：受理部门
	 */
	public String getAcceptDep() {
		return acceptDep;
	}
	/**
	 * 设置：申报开始日期
	 */
	public void setDeclareStart(Date declareStart) {
		this.declareStart = declareStart;
	}
	/**
	 * 获取：申报开始日期
	 */
	public Date getDeclareStart() {
		return declareStart;
	}
	/**
	 * 设置：申报结束日期
	 */
	public void setDeclareEnd(Date declareEnd) {
		this.declareEnd = declareEnd;
	}
	/**
	 * 获取：申报结束日期
	 */
	public Date getDeclareEnd() {
		return declareEnd;
	}
	/**
	 * 设置：申报说明
	 */
	public void setDeclareInstruction(String declareInstruction) {
		this.declareInstruction = declareInstruction;
	}
	/**
	 * 获取：申报说明
	 */
	public String getDeclareInstruction() {
		return declareInstruction;
	}
	/**
	 * 设置：
	 */
	public void setCreateBy(Integer createBy) {
		this.createBy = createBy;
	}
	/**
	 * 获取：
	 */
	public Integer getCreateBy() {
		return createBy;
	}
	/**
	 * 设置：
	 */
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	/**
	 * 获取：
	 */
	public Date getCreateAt() {
		return createAt;
	}
	/**
	 * 设置：N,正常；D,删除
	 */
	public void setDataStatus(EDataStatus dataStatus) {
		this.dataStatus = dataStatus;
	}
	/**
	 * 获取：N,正常；D,删除
	 */
	public EDataStatus getDataStatus() {
		return dataStatus;
	}
}
