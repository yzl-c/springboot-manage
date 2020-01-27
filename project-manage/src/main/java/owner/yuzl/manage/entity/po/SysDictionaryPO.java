package owner.yuzl.manage.entity.po;

import lombok.Data;

import java.util.Date;

/**
 * @Author：yzl_c
 * @Date：2020/1/27 10:26
 * @Description：系统数据字典
 */
@Data
public class SysDictionaryPO {
    private Long id;

    private String code;

    private String name;

    private Long typeId;

    private Integer createUser;

    private Integer modifyUser;

    private Date createTime;

    private Date modifyTime;

    private Integer deleted;

}
