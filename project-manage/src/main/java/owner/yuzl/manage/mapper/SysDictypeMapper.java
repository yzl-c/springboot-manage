package owner.yuzl.manage.mapper;

import owner.yuzl.manage.entity.po.SysDictypePO;

import java.util.List;
import java.util.Map;

/**
 * @Author：yzl_c
 * @Date：2020/1/27 11:17
 * @Description：
 */
public interface SysDictypeMapper {
    List<SysDictypePO> getDictypes(Map param);

    Long countTotal(Map param);

    void insert(SysDictypePO sysDictype);

    void update(SysDictypePO sysDictype);

    void logicDeleteById(Long id);

    SysDictypePO getDictypeById(Long id);

    List<SysDictypePO> getDictypesByCode(Map<String, Object> params);
}
