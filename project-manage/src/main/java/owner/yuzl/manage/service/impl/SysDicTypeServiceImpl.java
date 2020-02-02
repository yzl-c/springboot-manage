package owner.yuzl.manage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import owner.yuzl.manage.common.util.MapUtil;
import owner.yuzl.manage.entity.po.SysDictypePO;
import owner.yuzl.manage.mapper.SysDictionaryMapper;
import owner.yuzl.manage.mapper.SysDictypeMapper;
import owner.yuzl.manage.service.SysDictypeService;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author：yzl_c
 * @Date：2020/1/27 11:15
 * @Description：
 */
@Service
@Transactional
public class SysDicTypeServiceImpl implements SysDictypeService {
    @Autowired
    SysDictypeMapper sysDictypeMapper;

    @Autowired
    SysDictionaryMapper sysDictionaryMapper;
    
    /**
     * 获取所有字典类型列表
     * @param
     * @return
     */
    @Override
    public List<SysDictypePO> getDictypesList(SysDictypePO sysDictype, Integer pageNum, Integer pageSize) {
        Map param = null;
        try {
            param = MapUtil.objectToMap(sysDictype);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            System.out.println("Object 转换 Map 异常！");
        }
        if (!ObjectUtils.isEmpty(pageNum) && !ObjectUtils.isEmpty(pageSize)) {
            param.put("beginIndex", (pageNum - 1) * pageSize );
            param.put("pageSize", pageSize);
        }
        return sysDictypeMapper.getDictypes(param);
    }

    /**
     * 获取查询结果总数
     * @param sysDictype
     * @return
     */
    @Override
    public long countTotal(SysDictypePO sysDictype) {
        Map param = null;
        try {
            param = MapUtil.objectToMap(sysDictype);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            System.out.println("Object 转换 Map 异常！");
        }
        Long countTotal = sysDictypeMapper.countTotal(param);
        return countTotal == null ? 0 : countTotal;
    }

    /**
     * 执行添加操作
     * @param sysDictype
     */
    @Override
    public void create(SysDictypePO sysDictype) {
        sysDictype.setCreateTime(new Date());
        sysDictypeMapper.insert(sysDictype);
    }

    /**
     * 执行更新操作
     * @param sysDictype
     */
    @Override
    public void update(SysDictypePO sysDictype) {
        sysDictype.setModifyTime(new Date());
        sysDictypeMapper.update(sysDictype);
    }

    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    @Override
    public SysDictypePO getOneById(Long id) {
        return sysDictypeMapper.getDictypeById(id);
    }

    /**
     * 根据id逻辑删除
     * @param id
     */
    @Override
    public void logicDeleteById(Long id) {
        sysDictypeMapper.logicDeleteById(id);
        //删除类型为该类型的字典
        sysDictionaryMapper.logicDeleteByTypeId(id);
    }

    /**
     * 查询code唯一性
     * @param code
     * @return
     */
    @Override
    public List<SysDictypePO> checkCodeUnique(String code) {
        Map<String, Object> params = new HashMap<>();
        params.put("code", code);
        return sysDictypeMapper.getDictypesByCode(params);
    }
}
