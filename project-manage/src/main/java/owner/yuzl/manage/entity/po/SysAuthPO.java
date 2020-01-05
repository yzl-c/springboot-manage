package owner.yuzl.manage.entity.po;

/**
 * @Author：yzl-c
 * @Date：2019/12/15 16:22
 * @Description：
 */
public class SysAuthPO {
    private String code;

    private String name;

    public SysAuthPO() {
    }

    public SysAuthPO(String code, String name) {
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
        return "SysAuthPO{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
