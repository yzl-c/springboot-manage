package owner.yuzl.manage.entity.po;

/**
 * @Author：yzl_c
 * @Date：2019/12/15 16:29
 * @Description：
 */
public class SysRoleMenuPO {
    private String roleCode;

    private String menuCode;

    private String roleName;

    private String menuName;

    public SysRoleMenuPO() {
    }

    public SysRoleMenuPO(String roleCode, String menuCode, String roleName, String menuName) {
        this.roleCode = roleCode;
        this.menuCode = menuCode;
        this.roleName = roleName;
        this.menuName = menuName;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    @Override
    public String toString() {
        return "SysRoleMenuPO{" +
                "roleCode='" + roleCode + '\'' +
                ", menuCode='" + menuCode + '\'' +
                ", roleName='" + roleName + '\'' +
                ", menuName='" + menuName + '\'' +
                '}';
    }
}
