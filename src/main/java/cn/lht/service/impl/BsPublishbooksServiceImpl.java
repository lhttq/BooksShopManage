package cn.lht.service.impl;

import cn.lht.entity.BsPublishbooks;
import cn.lht.dao.BsPublishbooksDao;
import cn.lht.service.BsPublishbooksService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (BsPublishbooks)表服务实现类
 *
 * @author makejava
 * @since 2020-04-14 08:43:27
 */
@Service("bsPublishbooksService")
public class BsPublishbooksServiceImpl implements BsPublishbooksService {
    @Resource
    private BsPublishbooksDao bsPublishbooksDao;

    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    @Override
    public List<BsPublishbooks> selectAll() {
        return this.bsPublishbooksDao.selectAll();
    }

    /**
     * 通过ID查询单条数据
     *
     * @param bsBooksid 主键
     * @return 实例对象
     */
    @Override
    public BsPublishbooks queryById(Integer bsBooksid) {
        return this.bsPublishbooksDao.queryById(bsBooksid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<BsPublishbooks> queryAllByLimit(int offset, int limit) {
        return this.bsPublishbooksDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param bsPublishbooks 实例对象
     * @return 实例对象
     */
    @Override
    public BsPublishbooks insert(BsPublishbooks bsPublishbooks) {
        this.bsPublishbooksDao.insert(bsPublishbooks);
        return bsPublishbooks;
    }

    /**
     * 修改数据
     *
     * @param bsPublishbooks 实例对象
     * @return 实例对象
     */
    @Override
    public BsPublishbooks update(BsPublishbooks bsPublishbooks) {
        this.bsPublishbooksDao.update(bsPublishbooks);
        return this.queryById(bsPublishbooks.getBsBooksid());
    }

    /**
     * 通过主键删除数据
     *
     * @param bsBooksid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer bsBooksid) {
        return this.bsPublishbooksDao.deleteById(bsBooksid) > 0;
    }
}