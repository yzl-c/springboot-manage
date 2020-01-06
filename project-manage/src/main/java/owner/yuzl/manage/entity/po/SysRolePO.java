package owner.yuzl.manage.entity.po;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @Author：yzl_c
 * @Date：2019/12/15 16:28
 * @Description：
 */
@Data
public class SysRolePO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String code;

    private String name;

    private Integer createUser;

    private Integer modifyUser;

    private Date createTime;

    private Date modifyTime;

    private Integer deleted;
}
