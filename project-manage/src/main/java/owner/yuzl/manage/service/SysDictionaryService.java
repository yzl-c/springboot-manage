package owner.yuzl.manage.service;

import owner.yuzl.manage.entity.po.SysDictionaryPO;

import java.util.List;

/**
 * @Author：yzl_c
 * @Date：2020/1/27 11:16
 * @Description：
 */
public interface SysDictionaryService {
    /**
     * 获取所有字典类型列表
     * @param
     * @return
     */
    List<SysDictionaryPO> getDictionarysList(SysDictionaryPO sysDictionary, Integer pageNum, Integer pageSize);

    /**
     * 获取查询结果总数
     * @param sysDictionary
     * @return
     */
    long countTotal(SysDictionaryPO sysDictionary);

    /**
     * 执行添加操作
     * @param sysDictionary
     */
    void create(SysDictionaryPO sysDictionary);

    /**
     * 执行更新操作
     * @param sysDictionary
     */
    void update(SysDictionaryPO sysDictionary);

    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    SysDictionaryPO getOneById(Long id);

    /**
     * 根据id逻辑删除
     * @param id
     */
    void logicDeleteById(Long id);

    /**
     * 查询code唯一性
     * @param code
     * @return
     */
    List<SysDictionaryPO> checkCodeUnique(String code);
}
