package owner.yuzl.manage.entity.po;

import owner.yuzl.manage.entity.base.BaseEntity;

import java.util.Date;

/**
 * @Author：yzl-c
 * @Date：2019/12/15 16:22
 * @Description：
 */
public class SysUserPO extends BaseEntity{
    private String account;

    private String name;

    private String password;

    public SysUserPO() {
    }

    public SysUserPO(String account, String name, String password) {
        this.account = account;
        this.name = name;
        this.password = password;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "SysUserPO{" +
                "account='" + account + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
