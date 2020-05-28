package cn.lht.service;

import cn.lht.entity.BsBooks;
import java.util.List;

/**
 * (BsBooks)表服务接口
 *
 * @author makejava
 * @since 2020-04-13 23:07:10
 */
public interface BsBooksService {

    /**
     * 通过ID查询单条数据
     *
     * @param bsBookid 主键
     * @return 实例对象
     */
    BsBooks queryById(Integer bsBookid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<BsBooks> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param bsBooks 实例对象
     * @return 实例对象
     */
    Integer insert(BsBooks bsBooks);

    /**
     * 修改数据
     *
     * @param bsBooks 实例对象
     * @return 实例对象
     */
    BsBooks update(BsBooks bsBooks);

    /**
     * 通过主键删除数据
     *
     * @param bsBookid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer bsBookid);

}