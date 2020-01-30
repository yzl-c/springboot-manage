package owner.yuzl.manage.entity.po;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Author：yzl_c
 * @Date：2020/1/2 16:28
 * @Description：菜单实体类
 */
@Data
public class SysMenuPO implements Serializable {
    private Long id;

    private String code;

    private String name;

    private Long parentId;

    private Integer level;

    private Integer createUser;

    private Integer modifyUser;

    private Date createTime;

    private Date modifyTime;

    private Integer deleted;

    private List<SysMenuPO> subMenus;
}
