package owner.yuzl.manage.entity.po;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * @Author：yzl_c
 * @Date：2019/12/15 16:29
 * @Description：
 */
@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "T_SYS_ROLE_AUTH")
public class SysRoleAuthPO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role_code")
    private String roleCode;

    @Column(name = "auth_code")
    private String authCode;

    @Column(name = "role_name")
    private String roleName;

    @Column(name = "auth_name")
    private String authName;

}
