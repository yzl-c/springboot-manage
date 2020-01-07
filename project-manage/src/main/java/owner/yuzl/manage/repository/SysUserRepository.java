package owner.yuzl.manage.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import owner.yuzl.manage.entity.po.SysUserPO;

import java.util.List;

/**
 * @Author：yzl_c
 * @Date：2020/1/6 17:14
 * @Description：
 */
public interface SysUserRepository extends JpaRepository<SysUserPO, Long> {
    Page<SysUserPO> findSysUserPOSByAccountAndName(String account, String name, Pageable pageable);

}
