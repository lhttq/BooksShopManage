package cn.lht.controller;

import cn.lht.entity.BsStubooks;
import cn.lht.service.BsStubooksService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (BsStubooks)表控制层
 *
 * @author makejava
 * @since 2020-04-14 08:45:47
 */
@RestController
@RequestMapping("bsStubooks")
public class BsStubooksController {
    /**
     * 服务对象
     */
    @Resource
    private BsStubooksService bsStubooksService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public BsStubooks selectOne(Integer id) {
        return this.bsStubooksService.queryById(id);
    }

}