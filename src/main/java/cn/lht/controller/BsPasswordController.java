package cn.lht.controller;

import cn.lht.entity.BsPassword;
import cn.lht.service.BsPasswordService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (BsPassword)表控制层
 *
 * @author makejava
 * @since 2020-04-14 08:39:10
 */
@RestController
@RequestMapping("bsPassword")
public class BsPasswordController {
    /**
     * 服务对象
     */
    @Resource
    private BsPasswordService bsPasswordService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public BsPassword selectOne(Object id) {
        return this.bsPasswordService.queryById(id);
    }


}