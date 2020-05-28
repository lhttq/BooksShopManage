package cn.lht.controller;

import cn.lht.entity.BsPassword;
import cn.lht.entity.BsUsers;
import cn.lht.service.BsPasswordService;
import cn.lht.service.BsUsersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * (BsUsers)表控制层
 *
 * @author makejava
 * @since 2020-04-14 08:37:25
 */
@Controller
@RequestMapping("bsUsers")
public class BsUsersController {
    /**
     * 服务对象
     */
    @Resource
    private BsUsersService bsUsersService;
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
    public BsUsers selectOne(Object id) {
        return this.bsUsersService.queryById(id);
    }
    /**
     *
     * @param model
     * @return 页面
     */
    @RequestMapping("selectAll")
    public String selectAll(Model model){
        List<BsUsers> bsUsersList = this.bsUsersService.selectAll();
        model.addAttribute("bsUsersList",bsUsersList);
        return "user";
    }
    /**
     * 通过用户名查询单条数据
     *
     * @param bsUsers 实例对象
     * @return 实例对象
     */
    @RequestMapping("selectPybsLoginname")
    public BsUsers selectPybsLoginname(@RequestBody BsUsers bsUsers){
        List<BsUsers> bsUsersList = this.bsUsersService.queryAll(bsUsers);
        if(bsUsersList.size() != 0){
          bsUsers = bsUsersList.get(0);
        }
        return bsUsers;
    }

    /**
     * 更新行
     *
     * @param bsUsers 实例对象
     * @return 影响行数
     */
    @RequestMapping("updateOne")
    @ResponseBody
    public Integer updateOne(@RequestBody BsUsers bsUsers) throws ParseException {
        Integer i= -1;
        Integer bsUserid = bsUsers.getBsUserid();
        BsUsers bsUsers1 = this.bsUsersService.queryById(bsUserid);
        if(bsUsers1 != null){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = simpleDateFormat.parse(bsUsers.getBsUserbrithday1());
            java.sql.Date resultDate = new java.sql.Date(date.getTime());
            bsUsers.setBsUserbrithday(resultDate);
            i = this.bsUsersService.update(bsUsers);
        }else{
            i = 0;
        }
        return i;
    }

    /**
     * 删除行
     *
     * @param bsUsers 实例对象
     * @return 影响行数
     */
    @RequestMapping("delById")
    @ResponseBody
    public Integer delById(@RequestBody BsUsers bsUsers){
       Integer i = 0;
       boolean flog;
       Integer bsUserid = bsUsers.getBsUserid();
       bsUsers = this.bsUsersService.queryById(bsUserid);
       String bsLoginname = bsUsers.getBsLoginname();
       BsPassword bsPassword = new BsPassword();
       bsPassword.setBsLoginname(bsLoginname);
       List<BsPassword> bsPasswordList = this.bsPasswordService.queryAll(bsPassword);
       Integer bsUseridp = bsPasswordList.get(0).getBsUserid();
       flog = this.bsUsersService.deleteById(bsUserid);
       if(flog){
           i = 1;
           this.bsPasswordService.deleteById(bsUseridp);
       }
       return i;
    }

}