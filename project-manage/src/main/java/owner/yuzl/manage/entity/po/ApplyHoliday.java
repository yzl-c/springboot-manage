package owner.yuzl.manage.entity.po;

import lombok.Data;

import java.util.Date;

/**
 * @Author：yzl_c
 * @Date：2020/2/3 13:24
 * @Description：
 */
@Data
public class ApplyHoliday {
    private Long id;

    private String type;

    private String typeName;

    private String status;

    private String statusName;

    private String result;

    private String resultName;

    private Date beginDate;

    private Date endDate;

    private String content;

    private Long createUser;

    private String createUserAccount;

    private String createUserName;

    private Long modifyUser;

    private Date createTime;

    private Date modifyTime;

    private Integer deleted;
}
