package com.djn.cn.op.abm.base.entity;

import javax.persistence.*;
import java.util.Date;

@Table(name = "T_SYS_RoleInfo")
public class RoleInfo {
    /**
     * ID
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 生成时间
     */
    @Column(name = "createTime")
    private Date createTime;

    /**
     * 最后修改时间
     */
    @Column(name = "lastUpdateTime")
    private Date lastUpdateTime;

    /**
     * 描述
     */
    @Column(name = "description")
    private String description;

    /**
     *  创建者Id
     */
    @Column(name = "creatorId")
    private Long creatorId;

    /**
     * 最后修改者
     */
    @Column(name = "lastUpdateUserId")
    private Long lastUpdateUserId;

    /**
     * 是否删除 
     */
    @Column(name = "deleted")
    private Boolean deleted;

    /**
     * 当前版本号
     */
    @Column(name = "version")
    private Long version;

    /**
     * key to pretend order duplication
     */
    @Column(name = "dedupKey")
    private String dedupKey;

    @Column(name = "status")
    private Integer status;

    /**
     * 获取ID
     *
     * @return id - ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置ID
     *
     * @param id ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取名称
     *
     * @return name - 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称
     *
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取生成时间
     *
     * @return createTime - 生成时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置生成时间
     *
     * @param createTime 生成时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取最后修改时间
     *
     * @return lastUpdateTime - 最后修改时间
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * 设置最后修改时间
     *
     * @param lastUpdateTime 最后修改时间
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    /**
     * 获取描述
     *
     * @return description - 描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置描述
     *
     * @param description 描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取 创建者Id
     *
     * @return creatorId -  创建者Id
     */
    public Long getCreatorId() {
        return creatorId;
    }

    /**
     * 设置 创建者Id
     *
     * @param creatorId  创建者Id
     */
    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * 获取最后修改者
     *
     * @return lastUpdateUserId - 最后修改者
     */
    public Long getLastUpdateUserId() {
        return lastUpdateUserId;
    }

    /**
     * 设置最后修改者
     *
     * @param lastUpdateUserId 最后修改者
     */
    public void setLastUpdateUserId(Long lastUpdateUserId) {
        this.lastUpdateUserId = lastUpdateUserId;
    }

    /**
     * 获取是否删除 
     *
     * @return deleted - 是否删除 
     */
    public Boolean getDeleted() {
        return deleted;
    }

    /**
     * 设置是否删除 
     *
     * @param deleted 是否删除 
     */
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    /**
     * 获取当前版本号
     *
     * @return version - 当前版本号
     */
    public Long getVersion() {
        return version;
    }

    /**
     * 设置当前版本号
     *
     * @param version 当前版本号
     */
    public void setVersion(Long version) {
        this.version = version;
    }

    /**
     * 获取key to pretend order duplication
     *
     * @return dedupKey - key to pretend order duplication
     */
    public String getDedupKey() {
        return dedupKey;
    }

    /**
     * 设置key to pretend order duplication
     *
     * @param dedupKey key to pretend order duplication
     */
    public void setDedupKey(String dedupKey) {
        this.dedupKey = dedupKey;
    }

    /**
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}