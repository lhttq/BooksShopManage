package cn.lht.service.impl;

import cn.lht.entity.BsUsers;
import cn.lht.dao.BsUsersDao;
import cn.lht.service.BsUsersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (BsUsers)表服务实现类
 *
 * @author makejava
 * @since 2020-04-14 08:37:25
 */
@Service("bsUsersService")
public class BsUsersServiceImpl implements BsUsersService {
    /**
     * 查询所有用户
     *
     * @return 对象列表
     */
    @Override
    public List<BsUsers> selectAll() {
        return this.bsUsersDao.selectAll();
    }

    @Resource
    private BsUsersDao bsUsersDao;

    /**
     * 通过ID查询单条数据
     *
     * @param bsUserid 主键
     * @return 实例对象
     */
    @Override
    public BsUsers queryById(Object bsUserid) {
        return this.bsUsersDao.queryById(bsUserid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<BsUsers> queryAllByLimit(int offset, int limit) {
        return this.bsUsersDao.queryAllByLimit(offset, limit);
    }

    /**
     * 选择查询
     *
     * @param bsUsers 实例对象
     * @return 兑现列表
     */
    @Override
    public List<BsUsers> queryAll(BsUsers bsUsers) {
        return this.bsUsersDao.queryAll(bsUsers);
    }

    /**
     * 新增数据
     *
     * @param bsUsers 实例对象
     * @return 实例对象
     */
    @Override
    public BsUsers insert(BsUsers bsUsers) {
        this.bsUsersDao.insert(bsUsers);
        return bsUsers;
    }

    /**
     * 修改数据
     *
     * @param bsUsers 实例对象
     * @return 实例对象
     */
    @Override
    public Integer update(BsUsers bsUsers) {
        return this.bsUsersDao.update(bsUsers);
    }

    /**
     * 通过主键删除数据
     *
     * @param bsUserid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Object bsUserid) {
        return this.bsUsersDao.deleteById(bsUserid) > 0;
    }
}