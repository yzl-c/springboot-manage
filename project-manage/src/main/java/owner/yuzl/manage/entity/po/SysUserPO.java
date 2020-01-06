package owner.yuzl.manage.entity.po;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author：yzl-c
 * @Date：2019/12/15 16:22
 * @Description：
 */
@Data
@Entity
@Table(name = "T_SYS_USER")
public class SysUserPO{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String account;

    private String name;

    private String password;

    @Column(name = "create_user")
    private Integer createUser;

    @Column(name = "modify_user")
    private Integer modifyUser;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "modify_time")
    private Date modifyTime;

    private Integer deleted;

}