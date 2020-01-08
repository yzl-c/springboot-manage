package owner.yuzl.manage.entity.base;

import lombok.Data;

import java.util.Date;

/**
 * @Author：yzl_c
 * @Date：2020/1/2 16:32
 * @Description：基本实体类
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
