package owner.yuzl.manage.mapper;

import owner.yuzl.manage.entity.po.SysDepartmentPO;

import java.util.List;
import java.util.Map;

/**
 * @Author：yzl_c
 * @Date：2020/1/2 16:30
 * @Description：
 */
public interface SysDepartmentMapper {

    Long countTotal(Map param);

    void insert(SysDepartmentPO sysDepartmentPO);

    void update(SysDepartmentPO sysDepartmentPO);

    void logicDeleteById(Long id);

    List<SysDepartmentPO> getDepartments(Map param);

    SysDepartmentPO getDepartmentById(Long id);

}
