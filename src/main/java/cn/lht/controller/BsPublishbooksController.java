package cn.lht.controller;

import cn.lht.entity.BsPublishbooks;
import cn.lht.service.BsPublishbooksService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (BsPublishbooks)表控制层
 *
 * @author makejava
 * @since 2020-04-14 08:43:27
 */
@Controller
@RequestMapping("bsPublishbooks")
public class BsPublishbooksController {
    /**
     * 服务对象
     */
    @Resource
    private BsPublishbooksService bsPublishbooksService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public BsPublishbooks selectOne(Integer id) {
        return this.bsPublishbooksService.queryById(id);
    }

    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    @RequestMapping("selectAll")
    public String selectAll(Model model){
        List<BsPublishbooks> bsPublishbooksList = this.bsPublishbooksService.selectAll();
        model.addAttribute("bsPublishbooksList",bsPublishbooksList);
        return "publishbook";
    }

}