package cn.lht.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (BsAdmin)实体类
 *
 * @author makejava
 * @since 2020-04-13 23:03:00
 */
public class BsAdmin implements Serializable {
    private static final long serialVersionUID = 439524097964872711L;
    /**
    * 管理员id
    */
    private Integer bsAdminid;
    /**
    * 管理员账号
    */
    private String bsAdminlogin;
    /**
    * 管理员密码
    */
    private String bsAdminpass;
    /**
    * 职工编号
    */
    private String bsAdminnum;
    /**
    * 创建时间
    */
    private String bsCreatetime;
    /**
    * 最后登陆时间
    */
    private String bsLatelogintime;
    /**
    * 最后登录IP
    */
    private String bsLatelateip;


    public Integer getBsAdminid() {
        return bsAdminid;
    }

    public void setBsAdminid(Integer bsAdminid) {
        this.bsAdminid = bsAdminid;
    }

    public String getBsAdminlogin() {
        return bsAdminlogin;
    }

    public void setBsAdminlogin(String bsAdminlogin) {
        this.bsAdminlogin = bsAdminlogin;
    }

    public String getBsAdminpass() {
        return bsAdminpass;
    }

    public void setBsAdminpass(String bsAdminpass) {
        this.bsAdminpass = bsAdminpass;
    }

    public String getBsAdminnum() {
        return bsAdminnum;
    }

    public void setBsAdminnum(String bsAdminnum) {
        this.bsAdminnum = bsAdminnum;
    }

    public String getBsCreatetime() {
        return bsCreatetime;
    }

    public void setBsCreatetime(String bsCreatetime) {
        this.bsCreatetime = bsCreatetime;
    }

    public String getBsLatelogintime() {
        return bsLatelogintime;
    }

    public void setBsLatelogintime(String bsLatelogintime) {
        this.bsLatelogintime = bsLatelogintime;
    }

    public String getBsLatelateip() {
        return bsLatelateip;
    }

    public void setBsLatelateip(String bsLatelateip) {
        this.bsLatelateip = bsLatelateip;
    }

}