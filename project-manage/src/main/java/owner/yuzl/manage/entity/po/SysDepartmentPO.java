package owner.yuzl.manage.entity.po;

import lombok.Data;

import java.util.Date;
import java.util.Set;


/**
 * @Author：yzl-c
 * @Date：2020/1/2 16:22
 * @Description：部门类
 */
@Data
public class SysDepartmentPO {
    private Long id;

    private String code;

    private String name;

    private Integer createUser;

    private Integer modifyUser;

    private Date createTime;

    private Date modifyTime;

    private Integer deleted;

}
