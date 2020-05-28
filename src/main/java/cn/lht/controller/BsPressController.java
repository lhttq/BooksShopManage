package cn.lht.controller;

import cn.lht.entity.BsPress;
import cn.lht.entity.BsUsers;
import cn.lht.service.BsPressService;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * (BsPress)表控制层
 *
 * @author makejava
 * @since 2020-04-14 08:36:57
 */
@Controller
@RequestMapping("bsPress")
public class BsPressController {
    /**
     * 服务对象
     */
    @Resource
    private BsPressService bsPressService;

    /**
     *
     * @param model Model对象
     * @return 新页面
     */
    @RequestMapping("selectAll")
    public String selectAll(Model model){
        List<BsPress> bsPressList = this.bsPressService.selectAll();
        model.addAttribute("bsPressList",bsPressList);
        return "press";
    }

    /**
     *
     * @param httpSession
     * @return
     */
    @RequestMapping("selectAll1")
    @ResponseBody
     public List<BsPress> selectAll1(HttpSession httpSession){
        List<BsPress> bsPressList = this.bsPressService.selectAll();
        return bsPressList;
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public BsPress selectOne(Integer id) {
        return this.bsPressService.queryById(id);
    }

    /**
     *插入行
     *
     * @param bsPress 实例对象
     * @return 影响行数
     */
    @RequestMapping("insertOne")
    @ResponseBody
    public Integer insertOne(@RequestBody BsPress bsPress){
        Integer i = 0;
        i = this.bsPressService.insert(bsPress);
        return i;
    }
    /**
     * 通过id删除
     *
     * @param bsPress 实例对象
     * @return 是否删除
     */
    @RequestMapping("delById")
    @ResponseBody
    public Integer delById(@RequestBody BsPress bsPress){
        Integer i = 0;
        Integer bsPressid = bsPress.getBsPressid();
        boolean flog = this.bsPressService.deleteById(bsPressid);
        if(flog){
            i = 1;
        }
        return i;
    }
}