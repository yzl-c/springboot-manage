package owner.yuzl.manage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import owner.yuzl.manage.common.util.MapUtil;
import owner.yuzl.manage.entity.po.SysDepartmentPO;
import owner.yuzl.manage.mapper.SysDepartmentMapper;
import owner.yuzl.manage.service.SysRoleService;
import owner.yuzl.manage.service.SysDepartmentService;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author：yzl_c
 * @Date：2020/1/2 14:46
 * @Description：
 */
@Transactional
@Service(value = "SysDepartmentService")
public class SysDepartmentServiceImpl implements SysDepartmentService {

    @Autowired
    SysDepartmentMapper sysDepartmentMapper;

    /**
     * 获取查询结果总数
     * @param queryDepartment
     * @return
     */
    @Override
    public long countTotal(SysDepartmentPO queryDepartment) {
        Map param = null;
        try {
            param = MapUtil.objectToMap(queryDepartment);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            System.out.println("Object 转换 Map 异常！");
        }
        Long countTotal = sysDepartmentMapper.countTotal(param);
        return countTotal == null ? 0 : countTotal;
    }

    /**
     * 执行添加操作
     * @param sysDepartmentPO
     */
    @Override
    public void create(SysDepartmentPO sysDepartmentPO) {
        sysDepartmentPO.setCreateTime(new Date());
        sysDepartmentMapper.insert(sysDepartmentPO);
    }

    /**
     * 执行更新操作
     * @param sysDepartmentPO
     */
    @Override
    public void update(SysDepartmentPO sysDepartmentPO) {
        sysDepartmentPO.setModifyTime(new Date());
        sysDepartmentMapper.update(sysDepartmentPO);
    }

    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    @Override
    public SysDepartmentPO getOneById(Long id) {
        return sysDepartmentMapper.getDepartmentById(id);
    }

    /**
     * 根据id逻辑删除
     * @param id
     */
    @Override
    public void logicDeleteById(Long id) {
        sysDepartmentMapper.logicDeleteById(id);
    }

    /**
     * 获取查询结果
     * @param queryDepartment
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public List<SysDepartmentPO> getDepartments(SysDepartmentPO queryDepartment, Integer pageNum, Integer pageSize) {
        Map param = null;
        try {
            param = MapUtil.objectToMap(queryDepartment);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            System.out.println("Object 转换 Map 异常！");
        }
        if (!ObjectUtils.isEmpty(pageNum) && !ObjectUtils.isEmpty(pageSize)) {
            param.put("beginIndex", (pageNum - 1) * pageSize );
            param.put("pageSize", pageSize);
        }
        return sysDepartmentMapper.getDepartments(param);
    }

}
