package owner.yuzl.manage.entity.po;

/**
 * @Author：yzl_c
 * @Date：2019/12/15 16:28
 * @Description：
 */
public class SysUserRolePO {
    private String userAccount;

    private String roleCode;

    private String userName;

    private String roleName;

    public SysUserRolePO() {
    }

    public SysUserRolePO(String userAccount, String roleCode, String userName, String roleName) {
        this.userAccount = userAccount;
        this.roleCode = roleCode;
        this.userName = userName;
        this.roleName = roleName;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "SysUserRolePO{" +
                "userAccount='" + userAccount + '\'' +
                ", roleCode='" + roleCode + '\'' +
                ", userName='" + userName + '\'' +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
