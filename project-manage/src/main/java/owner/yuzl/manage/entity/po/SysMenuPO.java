package owner.yuzl.manage.entity.po;

/**
 * @Author：yzl_c
 * @Date：2019/12/15 16:28
 * @Description：
 */
public class SysMenuPO {
    private String code;

    private String name;

    public SysMenuPO() {
    }

    public SysMenuPO(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SysMenuPO{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
