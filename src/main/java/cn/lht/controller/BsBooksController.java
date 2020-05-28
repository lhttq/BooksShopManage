package cn.lht.controller;

import cn.lht.entity.BsBooks;
import cn.lht.entity.BsPress;
import cn.lht.service.BsBooksService;
import cn.lht.service.BsPressService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * (BsBooks)表控制层
 *
 * @author makejava
 * @since 2020-04-13 23:07:10
 */
@Controller
@RequestMapping("bsBooks")
public class BsBooksController {
    /**
     * 服务对象
     */
    @Resource
    private BsBooksService bsBooksService;
    /**
     * 服务对象
     */
    @Resource
    private BsPressService bsPressService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public BsBooks selectOne(Integer id) {
        return this.bsBooksService.queryById(id);
    }

    /**
     * 查询所有书籍
     *
     * @param model
     * @return 字符串
     */
    @RequestMapping("selectAll")
    public String selectAll(Model model){
        List<BsBooks> bsBooksList = this.bsBooksService.queryAllByLimit(0,10);
        List<BsPress> bsPressList = new ArrayList<BsPress>();
        BsPress bsPress = new BsPress();
        for (BsBooks b : bsBooksList) {
            bsPress.setBsPressnum(b.getBsPressnum());
            List<BsPress> bsPressList1 = this.bsPressService.queryAll(bsPress);
            bsPressList.add(bsPressList1.get(0));
        }
        model.addAttribute("bsBooksList",bsBooksList);
        model.addAttribute("bsPressList",bsPressList);
        return "homepage";
    }
    @RequestMapping("delById")
    @ResponseBody
    public Integer delById(@RequestBody BsBooks bsBooks){
        int i = 0;
        Integer bookId = bsBooks.getBsBookid();
        boolean flog = this.bsBooksService.deleteById(bookId);
        if(flog){
            i = 1;
        }
        return i;
    }

    /**
     *
     * @param bsBooks
     * @return
     * @throws ParseException
     */
    @RequestMapping("insertBook")
    @ResponseBody
    public Integer insertBook(@RequestBody BsBooks bsBooks) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat.parse(bsBooks.getBsBookbt1());
        java.sql.Date resultDate = new java.sql.Date(date.getTime());
        bsBooks.setBsBookbt(resultDate);
        Integer i = 0;
        i = this.bsBooksService.insert(bsBooks);
        return i;
    }
}