package com.djn.cn.op.abm.base.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "T_SYS_UserInfo")
public class UserInfo {
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

    /**
     * 用户名
     */
    @Column(name = "userName")
    private String userName;

    /**
     * 密码
     */
    @Column(name = "password")
    private String password;

    /**
     * 密码盐 UUID
     */
    @Column(name = "salt")
    private String salt;

    /**
     * 邮箱地址
     */
    @Column(name = "email")
    private String email;

    /**
     * 年龄
     */
    @Column(name = "age")
    private Integer age;

    /**
     * QQ号码
     */
    @Column(name = "qq")
    private String qq;

    /**
     * 电话号码
     */
    @Column(name = "telphone")
    private String telphone;

    /**
     * 地址
     */
    @Column(name = "address")
    private String address;

    /**
     * 性别
     */
    @Column(name = "sex")
    private String sex;

    /**
     * 是否锁定
     */
    @Column(name = "locked")
    private Boolean locked;

    /**
     * 是否激活
     */
    @Column(name = "activated")
    private Boolean activated;

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
     * 获取用户名
     *
     * @return userName - 用户名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户名
     *
     * @param userName 用户名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取密码盐 UUID
     *
     * @return salt - 密码盐 UUID
     */
    public String getSalt() {
        return salt;
    }

    /**
     * 设置密码盐 UUID
     *
     * @param salt 密码盐 UUID
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     * 获取邮箱地址
     *
     * @return email - 邮箱地址
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱地址
     *
     * @param email 邮箱地址
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取年龄
     *
     * @return age - 年龄
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 设置年龄
     *
     * @param age 年龄
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 获取QQ号码
     *
     * @return qq - QQ号码
     */
    public String getQq() {
        return qq;
    }

    /**
     * 设置QQ号码
     *
     * @param qq QQ号码
     */
    public void setQq(String qq) {
        this.qq = qq;
    }

    /**
     * 获取电话号码
     *
     * @return telphone - 电话号码
     */
    public String getTelphone() {
        return telphone;
    }

    /**
     * 设置电话号码
     *
     * @param telphone 电话号码
     */
    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    /**
     * 获取地址
     *
     * @return address - 地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置地址
     *
     * @param address 地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取性别
     *
     * @return sex - 性别
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置性别
     *
     * @param sex 性别
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 获取是否锁定
     *
     * @return locked - 是否锁定
     */
    public Boolean getLocked() {
        return locked;
    }

    /**
     * 设置是否锁定
     *
     * @param locked 是否锁定
     */
    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    /**
     * 获取是否激活
     *
     * @return activated - 是否激活
     */
    public Boolean getActivated() {
        return activated;
    }

    /**
     * 设置是否激活
     *
     * @param activated 是否激活
     */
    public void setActivated(Boolean activated) {
        this.activated = activated;
    }
}