package cn.lht.dao;

import cn.lht.entity.BsPublishbooks;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (BsPublishbooks)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-14 08:43:27
 */
public interface BsPublishbooksDao {

    /**
     * 通过ID查询单条数据
     *
     * @param bsBooksid 主键
     * @return 实例对象
     */
    BsPublishbooks queryById(Integer bsBooksid);

    /**
     * 查询所有书籍
     *
     * @return 对象列表
     */
    List<BsPublishbooks> selectAll();


    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<BsPublishbooks> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param bsPublishbooks 实例对象
     * @return 对象列表
     */
    List<BsPublishbooks> queryAll(BsPublishbooks bsPublishbooks);

    /**
     * 新增数据
     *
     * @param bsPublishbooks 实例对象
     * @return 影响行数
     */
    int insert(BsPublishbooks bsPublishbooks);

    /**
     * 修改数据
     *
     * @param bsPublishbooks 实例对象
     * @return 影响行数
     */
    int update(BsPublishbooks bsPublishbooks);

    /**
     * 通过主键删除数据
     *
     * @param bsBooksid 主键
     * @return 影响行数
     */
    int deleteById(Integer bsBooksid);

}