package cn.lht.controller;

import cn.lht.entity.BsAdmin;
import cn.lht.service.BsAdminService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

/**
 * (BsAdmin)表控制层
 *
 * @author makejava
 * @since 2020-04-13 23:03:00
 */
@Controller
@RequestMapping("bsAdmin")
public class BsAdminController {
    /**
     * 服务对象
     */
    @Resource
    private BsAdminService bsAdminService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public BsAdmin selectOne(Integer id) {
        return this.bsAdminService.queryById(id);
    }

    /**
     *
     * @param bsAdmin 实例对象
     * @return 影响行数
     */
    @RequestMapping("insertOne")
    @ResponseBody
    public Integer insertOne(@RequestBody BsAdmin bsAdmin){
        int i = 0;
        BsAdmin bsAdmin1 = new BsAdmin();
        bsAdmin1.setBsAdminlogin(bsAdmin.getBsAdminlogin());
        List<BsAdmin> bsAdminList = this.bsAdminService.queryAll(bsAdmin1);
        if(bsAdminList.size() == 0){
           i = this.bsAdminService.insert(bsAdmin);
        }
        return i;
    }

    /**
     * 登录
     *
     * @param bsAdmin 实例对象
     * @return 影响行数
     */
    @RequestMapping("selectBybsAdminlogin")
    @ResponseBody
    public Integer selectBybsAdminlogin(@RequestBody BsAdmin bsAdmin){
        int i = 0;
        List<BsAdmin> bsAdminList = this.bsAdminService.queryAll(bsAdmin);
        if(bsAdminList.size() != 0){
            i = 1;
        }
        return i;
    }
}