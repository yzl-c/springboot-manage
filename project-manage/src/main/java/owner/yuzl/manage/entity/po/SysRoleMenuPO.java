package owner.yuzl.manage.entity.po;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * @Author：yzl_c
 * @Date：2020/1/2 16:29
 * @Description：权限菜单实体类
 */
@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "T_SYS_ROLE_MENU")
public class SysRoleMenuPO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role_code")
    private String roleCode;

    @Column(name = "menu_code")
    private String menuCode;

    @Column(name = "role_name")
    private String roleName;

    @Column(name = "menu_name")
    private String menuName;

}
