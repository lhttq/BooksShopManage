package cn.lht.controller;

import cn.lht.entity.BsBookclass;
import cn.lht.service.BsBookclassService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (BsBookclass)表控制层
 *
 * @author makejava
 * @since 2020-04-13 23:03:26
 */
@Controller
@RequestMapping("bsBookclass")
public class BsBookclassController {
    /**
     * 服务对象
     */
    @Resource
    private BsBookclassService bsBookclassService;

    /**
     *
     * @return 字符串
     */
    @RequestMapping("selectAll")
    public String selectAll(Model model){
        List<BsBookclass> bsBookclassList = this.bsBookclassService.selectAll();
        model.addAttribute("bsBookclassList",bsBookclassList);
        return "bookcless";
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public BsBookclass selectOne(Object id) {
        return this.bsBookclassService.queryById(id);
    }

    /**
     *插入行
     *
     * @param bsBookclass 实例对象
     * @return 影响行数
     */
    @RequestMapping("insertOne")
    @ResponseBody
    public Integer insertOne(@RequestBody BsBookclass bsBookclass){
        return this.bsBookclassService.insert(bsBookclass);
    }
    /**
     * 通过Id删除
     *
     * @param bsBookclass 实例对象
     * @return 影响行数
     */
    @RequestMapping("delById")
    @ResponseBody
    public Integer delById(@RequestBody BsBookclass bsBookclass){
        boolean flog;
        Integer i = 0;
        Integer bsBookclassid = bsBookclass.getBsBookclassid();
        flog = this.bsBookclassService.deleteById(bsBookclassid);
        if(flog){
            i = 1;
        }
        return i;
    }

}