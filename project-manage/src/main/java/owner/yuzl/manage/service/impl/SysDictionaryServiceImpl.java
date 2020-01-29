package owner.yuzl.manage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import owner.yuzl.manage.common.util.MapUtil;
import owner.yuzl.manage.entity.po.SysDictionaryPO;
import owner.yuzl.manage.mapper.SysDictionaryMapper;
import owner.yuzl.manage.service.SysDictionaryService;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author：yzl_c
 * @Date：2020/1/27 11:16
 * @Description：
 */
@Service
@Transactional
public class SysDictionaryServiceImpl implements SysDictionaryService {
    @Autowired
    SysDictionaryMapper sysDictionaryMapper;

    /**
     * 获取所有字典类型列表
     * @param
     * @return
     */
    @Override
    public List<SysDictionaryPO> getDictionarysList(SysDictionaryPO sysDictionary, Integer pageNum, Integer pageSize) {
        Map param = null;
        try {
            param = MapUtil.objectToMap(sysDictionary);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            System.out.println("Object 转换 Map 异常！");
        }
        param.put("beginIndex", (pageNum - 1) * pageSize );
        param.put("pageSize", pageSize);
        return sysDictionaryMapper.getDictionarys(param);
    }

    /**
     * 获取查询结果总数
     * @param sysDictionary
     * @return
     */
    @Override
    public long countTotal(SysDictionaryPO sysDictionary) {
        Map param = null;
        try {
            param = MapUtil.objectToMap(sysDictionary);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            System.out.println("Object 转换 Map 异常！");
        }
        Long countTotal = sysDictionaryMapper.countTotal(param);
        return countTotal == null ? 0 : countTotal;
    }

    /**
     * 执行添加操作
     * @param sysDictionary
     */
    @Override
    public void create(SysDictionaryPO sysDictionary) {
        sysDictionary.setCreateTime(new Date());
        sysDictionaryMapper.insert(sysDictionary);
    }

    /**
     * 执行更新操作
     * @param sysDictionary
     */
    @Override
    public void update(SysDictionaryPO sysDictionary) {
        sysDictionary.setModifyTime(new Date());
        sysDictionaryMapper.update(sysDictionary);
    }

    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    @Override
    public SysDictionaryPO getOneById(Long id) {
        return sysDictionaryMapper.getDictionaryById(id);
    }

    /**
     * 根据id逻辑删除
     * @param id
     */
    @Override
    public void logicDeleteById(Long id) {
        sysDictionaryMapper.logicDeleteById(id);
    }

    /**
     * 查询code唯一性
     * @param code
     * @return
     */
    @Override
    public List<SysDictionaryPO> checkCodeUnique(String code) {
        Map<String, Object> params = new HashMap<>();
        params.put("code", code);
        return sysDictionaryMapper.getDictionarysByCode(params);
    }
}
