package com.govmaz.entity;

import java.io.Serializable;
import java.util.Date;


public class ChinaAddress implements Serializable {
    private static final long serialVersionUID = 1L;


    private String id;

    private String mytexts;


    private String parentid;


    private String mytables;


    private String mycolums;


    private Integer sort;


    private String remark;


    private Date createtime;


    private String createperson;


    private Date updatetime;


    private String updateperson;

    /**
     * @return Id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return MyTexts
     */
    public String getMytexts() {
        return mytexts;
    }

    /**
     * @param mytexts
     */
    public void setMytexts(String mytexts) {
        this.mytexts = mytexts;
    }

    /**
     * @return ParentId
     */
    public String getParentid() {
        return parentid;
    }

    /**
     * @param parentid
     */
    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

    /**
     * @return MyTables
     */
    public String getMytables() {
        return mytables;
    }

    /**
     * @param mytables
     */
    public void setMytables(String mytables) {
        this.mytables = mytables;
    }

    /**
     * @return MyColums
     */
    public String getMycolums() {
        return mycolums;
    }

    /**
     * @param mycolums
     */
    public void setMycolums(String mycolums) {
        this.mycolums = mycolums;
    }

    /**
     * @return Sort
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * @param sort
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * @return Remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * @return CreateTime
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * @param createtime
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * @return CreatePerson
     */
    public String getCreateperson() {
        return createperson;
    }

    /**
     * @param createperson
     */
    public void setCreateperson(String createperson) {
        this.createperson = createperson;
    }

    /**
     * @return UpdateTime
     */
    public Date getUpdatetime() {
        return updatetime;
    }

    /**
     * @param updatetime
     */
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    /**
     * @return UpdatePerson
     */
    public String getUpdateperson() {
        return updateperson;
    }

    /**
     * @param updateperson
     */
    public void setUpdateperson(String updateperson) {
        this.updateperson = updateperson;
    }
}