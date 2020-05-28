package cn.lht.service;

import cn.lht.entity.BsUsers;
import java.util.List;

/**
 * (BsUsers)表服务接口
 *
 * @author makejava
 * @since 2020-04-14 08:37:25
 */
public interface BsUsersService {

    /**
     * 通过ID查询单条数据
     *
     * @param bsUserid 主键
     * @return 实例对象
     */
    BsUsers queryById(Object bsUserid);

    /**
     * 查询所有用户
     *
     * @return 对象列表
     */
    List<BsUsers> selectAll();
    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<BsUsers> queryAllByLimit(int offset, int limit);

    /**
     * 选择查询
     *
     * @param bsUsers 实例对象
     * @return 兑现列表
     */
    List<BsUsers> queryAll(BsUsers bsUsers);
    /**
     * 新增数据
     *
     * @param bsUsers 实例对象
     * @return 实例对象
     */
    BsUsers insert(BsUsers bsUsers);

    /**
     * 修改数据
     *
     * @param bsUsers 实例对象
     * @return 实例对象
     */
    Integer update(BsUsers bsUsers);

    /**
     * 通过主键删除数据
     *
     * @param bsUserid 主键
     * @return 是否成功
     */
    boolean deleteById(Object bsUserid);

}