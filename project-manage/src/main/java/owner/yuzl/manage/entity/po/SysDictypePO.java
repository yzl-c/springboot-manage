package owner.yuzl.manage.entity.po;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @Author：yzl_c
 * @Date：2020/1/27 10:25
 * @Description：数据字典类型
 */
@Data
public class SysDictypePO {
    private Long id;

    private String code;

    private String name;

    private Integer createUser;

    private Integer modifyUser;

    private Date createTime;

    private Date modifyTime;

    private Integer deleted;

    private List<SysDictionaryPO> dictionarys;
}
