package owner.yuzl.manage.entity.po;

import lombok.Data;

import java.util.Date;

/**
 * @Author：yzl_c
 * @Date：2020/2/3 13:24
 * @Description：
 */
@Data
public class Holiday {
    private Long id;

    private String type;

    private String typeName;

    private Integer duration;

    private Integer status;

    private Date beginDate;

    private Date endDate;

    private Integer createUser;

    private String createUserAccount;

    private Integer modifyUser;

    private Date createTime;

    private Date modifyTime;

    private Integer deleted;
}
