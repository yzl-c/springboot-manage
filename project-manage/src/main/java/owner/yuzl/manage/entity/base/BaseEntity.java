package owner.yuzl.manage.entity.base;

import lombok.Data;

import java.util.Date;

/**
 * @Author：yzl_c
 * @Date：2019/12/15 16:32
 * @Description：
 */
@Data
public class BaseEntity {
    private Integer id;
    private Integer createUser;
    private Integer modifyUser;
    private Date createTime;
    private Date modifyTime;
    private Integer deleted;
}
