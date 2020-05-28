package cn.lht.service.impl;

import cn.lht.entity.BsStubooks;
import cn.lht.dao.BsStubooksDao;
import cn.lht.service.BsStubooksService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (BsStubooks)表服务实现类
 *
 * @author makejava
 * @since 2020-04-14 08:45:47
 */
@Service("bsStubooksService")
public class BsStubooksServiceImpl implements BsStubooksService {
    @Resource
    private BsStubooksDao bsStubooksDao;

    /**
     * 通过ID查询单条数据
     *
     * @param bsBookid 主键
     * @return 实例对象
     */
    @Override
    public BsStubooks queryById(Integer bsBookid) {
        return this.bsStubooksDao.queryById(bsBookid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<BsStubooks> queryAllByLimit(int offset, int limit) {
        return this.bsStubooksDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param bsStubooks 实例对象
     * @return 实例对象
     */
    @Override
    public BsStubooks insert(BsStubooks bsStubooks) {
        this.bsStubooksDao.insert(bsStubooks);
        return bsStubooks;
    }

    /**
     * 修改数据
     *
     * @param bsStubooks 实例对象
     * @return 实例对象
     */
    @Override
    public BsStubooks update(BsStubooks bsStubooks) {
        this.bsStubooksDao.update(bsStubooks);
        return this.queryById(bsStubooks.getBsBookid());
    }

    /**
     * 通过主键删除数据
     *
     * @param bsBookid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer bsBookid) {
        return this.bsStubooksDao.deleteById(bsBookid) > 0;
    }
}