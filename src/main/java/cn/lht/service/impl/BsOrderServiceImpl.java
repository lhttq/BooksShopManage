package cn.lht.service.impl;

import cn.lht.entity.BsOrder;
import cn.lht.dao.BsOrderDao;
import cn.lht.service.BsOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (BsOrder)表服务实现类
 *
 * @author makejava
 * @since 2020-04-13 16:10:48
 */
@Service("bsOrderService")
public class BsOrderServiceImpl implements BsOrderService {
    @Resource
    private BsOrderDao bsOrderDao;

    /**
     * 通过ID查询单条数据
     *
     * @param bsOrderid 主键
     * @return 实例对象
     */
    @Override
    public BsOrder queryById(Integer bsOrderid) {
        return this.bsOrderDao.queryById(bsOrderid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<BsOrder> queryAllByLimit(int offset, int limit) {
        return this.bsOrderDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param bsOrder 实例对象
     * @return 实例对象
     */
    @Override
    public BsOrder insert(BsOrder bsOrder) {
        this.bsOrderDao.insert(bsOrder);
        return bsOrder;
    }

    /**
     * 修改数据
     *
     * @param bsOrder 实例对象
     * @return 实例对象
     */
    @Override
    public BsOrder update(BsOrder bsOrder) {
        this.bsOrderDao.update(bsOrder);
        return this.queryById(bsOrder.getBsOrderid());
    }

    /**
     * 通过主键删除数据
     *
     * @param bsOrderid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer bsOrderid) {
        return this.bsOrderDao.deleteById(bsOrderid) > 0;
    }
}