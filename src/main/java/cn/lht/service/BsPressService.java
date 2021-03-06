package cn.lht.service;

import cn.lht.entity.BsPress;
import java.util.List;

/**
 * (BsPress)表服务接口
 *
 * @author makejava
 * @since 2020-04-14 08:36:57
 */
public interface BsPressService {
    /**
     * 查询所有
     *
     * @return 对象列表
     */
    List<BsPress> selectAll();
    /**
     * 通过ID查询单条数据
     *
     * @param bsPressid 主键
     * @return 实例对象
     */
    BsPress queryById(Integer bsPressid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<BsPress> queryAllByLimit(int offset, int limit);

    /**
     *
     * @param bsPress
     * @return
     */
    List<BsPress> queryAll(BsPress bsPress);
    /**
     * 新增数据
     *
     * @param bsPress 实例对象
     * @return 实例对象
     */
    Integer insert(BsPress bsPress);

    /**
     * 修改数据
     *
     * @param bsPress 实例对象
     * @return 实例对象
     */
    BsPress update(BsPress bsPress);

    /**
     * 通过主键删除数据
     *
     * @param bsPressid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer bsPressid);

}