package owner.yuzl.manage.service;

import owner.yuzl.manage.entity.po.SysDictypePO;

import java.util.List;

/**
 * @Author：yzl_c
 * @Date：2020/1/27 11:15
 * @Description：
 */
public interface SysDictypeService {

    /**
     * 获取所有字典类型列表
     * @param
     * @return
     */
    List<SysDictypePO> getDictypesList(SysDictypePO sysDictype, Integer pageNum, Integer pageSize);

    /**
     * 获取查询结果总数
     * @param sysDictype
     * @return
     */
    long countTotal(SysDictypePO sysDictype);

    /**
     * 执行添加操作
     * @param sysDictype
     */
    void create(SysDictypePO sysDictype);

    /**
     * 执行更新操作
     * @param sysDictype
     */
    void update(SysDictypePO sysDictype);

    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    SysDictypePO getOneById(Long id);

    /**
     * 根据id逻辑删除
     * @param id
     */
    void logicDeleteById(Long id);
}
