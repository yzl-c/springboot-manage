package owner.yuzl.manage.entity.base;

import java.util.Date;

/**
 * @Author：yzl_c
 * @Date：2019/12/15 16:32
 * @Description：
 */
public class BaseEntity {
    private Integer id;
    private Integer createUser;
    private Integer modifyUser;
    private Date createTime;
    private Date modifyTime;
    private Integer deleted;

    public BaseEntity() {
    }

    public BaseEntity(Integer id, Integer createUser, Integer modifyUser, Date createTime, Date modifyTime, Integer deleted) {
        this.id = id;
        this.createUser = createUser;
        this.modifyUser = modifyUser;
        this.createTime = createTime;
        this.modifyTime = modifyTime;
        this.deleted = deleted;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    public Integer getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(Integer modifyUser) {
        this.modifyUser = modifyUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }
}
