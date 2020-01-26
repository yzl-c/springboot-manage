package owner.yuzl.manage.entity.po;

import lombok.Data;
//import org.hibernate.annotations.DynamicInsert;
//import org.hibernate.annotations.DynamicUpdate;
//
//import javax.persistence.*;

/**
 * @Author：yzl_c
 * @Date：2020/1/2 16:28
 * @Description：用户角色实体类
 */
@Data
//@Entity
//@DynamicInsert
//@DynamicUpdate
//@Table(name = "T_SYS_USER_ROLE")
public class SysUserRolePO {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    //    @Column(name = "role_code")
    private Long roleId;

//    @Column(name = "user_account")
    private String userAccount;

//    @Column(name = "role_code")
    private String roleCode;

//    @Column(name = "user_name")
    private String userName;

//    @Column(name = "role_name")
    private String roleName;

}
