package owner.yuzl.manage.entity.po;

import lombok.Data;

import java.util.Date;

/**
 * @Author：yzl_c
 * @Date：2020/2/4 10:47
 * @Description：
 */
@Data
public class ProcessHoliday {
    private Long id;

    private Long applyId;

    private Long applyUser;

    private String applyUserAccount;

    private String applyUserName;

    private Date applyTime;

    private Long approveUser;

    private String approveUserAccount;

    private String approveUserName;

    private Date approveTime;

    private String result;

    private String resultName;

    private Integer deleted;
}
