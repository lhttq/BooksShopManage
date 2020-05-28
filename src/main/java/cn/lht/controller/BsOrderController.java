package cn.lht.controller;

import cn.lht.entity.BsOrder;
import cn.lht.service.BsOrderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (BsOrder)表控制层
 *
 * @author makejava
 * @since 2020-04-13 16:10:49
 */
@RestController
@RequestMapping("bsOrder")
public class BsOrderController {
    /**
     * 服务对象
     */
    @Resource
    private BsOrderService bsOrderService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public BsOrder selectOne(Integer id) {
        return this.bsOrderService.queryById(id);
    }

}