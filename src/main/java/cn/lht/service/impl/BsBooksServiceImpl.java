package cn.lht.service.impl;

import cn.lht.entity.BsBooks;
import cn.lht.dao.BsBooksDao;
import cn.lht.service.BsBooksService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (BsBooks)表服务实现类
 *
 * @author makejava
 * @since 2020-04-13 23:07:10
 */
@Service("bsBooksService")
public class BsBooksServiceImpl implements BsBooksService {
    @Resource
    private BsBooksDao bsBooksDao;

    /**
     * 通过ID查询单条数据
     *
     * @param bsBookid 主键
     * @return 实例对象
     */
    @Override
    public BsBooks queryById(Integer bsBookid) {
        return this.bsBooksDao.queryById(bsBookid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<BsBooks> queryAllByLimit(int offset, int limit) {
        return this.bsBooksDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param bsBooks 实例对象
     * @return 实例对象
     */
    @Override
    public Integer insert(BsBooks bsBooks) {
        return this.bsBooksDao.insert(bsBooks);
    }

    /**
     * 修改数据
     *
     * @param bsBooks 实例对象
     * @return 实例对象
     */
    @Override
    public BsBooks update(BsBooks bsBooks) {
        this.bsBooksDao.update(bsBooks);
        return this.queryById(bsBooks.getBsBookid());
    }

    /**
     * 通过主键删除数据
     *
     * @param bsBookid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer bsBookid) {
        return this.bsBooksDao.deleteById(bsBookid) > 0;
    }
}