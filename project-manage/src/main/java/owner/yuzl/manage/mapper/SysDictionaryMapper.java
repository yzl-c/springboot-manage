package owner.yuzl.manage.mapper;

import owner.yuzl.manage.entity.po.SysDictionaryPO;

import java.util.List;
import java.util.Map;

/**
 * @Author：yzl_c
 * @Date：2020/1/27 11:17
 * @Description：
 */
public interface SysDictionaryMapper {

    List<SysDictionaryPO> getDictionarys(Map param);

    Long countTotal(Map param);

    void insert(SysDictionaryPO sysDictionary);

    void update(SysDictionaryPO sysDictionary);

    void logicDeleteById(Long id);

    SysDictionaryPO getDictionaryById(Long id);

    void logicDeleteByTypeId(Long typeId);

    List<SysDictionaryPO> getDictionarysByCode(Map<String, Object> params);
}
