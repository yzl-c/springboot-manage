package owner.yuzl.manage.entity.po;

/**
 * @Author：yzl_c
 * @Date：2019/12/15 16:29
 * @Description：
 */
public class SysRoleAuthPO {
    private String roleCode;

    private String authCode;

    private String roleName;

    private String authName;

    public SysRoleAuthPO() {
    }

    public SysRoleAuthPO(String roleCode, String authCode, String roleName, String authName) {
        this.roleCode = roleCode;
        this.authCode = authCode;
        this.roleName = roleName;
        this.authName = authName;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "SysRoleAuthPO{" +
                "roleCode='" + roleCode + '\'' +
                ", authCode='" + authCode + '\'' +
                ", roleName='" + roleName + '\'' +
                ", authName='" + authName + '\'' +
                '}';
    }

    public String getAuthName() {
        return authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName;
    }
}
