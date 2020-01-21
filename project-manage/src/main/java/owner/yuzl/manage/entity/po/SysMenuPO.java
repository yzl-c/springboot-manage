package owner.yuzl.manage.entity.po;

import lombok.Data;
//import org.hibernate.annotations.DynamicInsert;
//import org.hibernate.annotations.DynamicUpdate;
//
//import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @Author：yzl_c
 * @Date：2020/1/2 16:28
 * @Description：菜单实体类
 */
@Data
//@Entity
//@DynamicInsert
//@DynamicUpdate
//@Table(name = "T_SYS_MENU")
public class SysMenuPO {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private String name;

//    @Column(name = "parent_id")
    private Long parentId;

//    @Column(name = "create_user")
    private Integer createUser;

//    @Column(name = "modify_user")
    private Integer modifyUser;

//    @Column(name = "create_time")
    private Date createTime;

//    @Column(name = "modify_time")
    private Date modifyTime;

    private Integer deleted;

//    @Transient
    private List<SysMenuPO> subMenus;
}
