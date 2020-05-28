package cn.lht.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (BsPassword)实体类
 *
 * @author makejava
 * @since 2020-04-14 08:39:10
 */
public class BsPassword implements Serializable {
    private static final long serialVersionUID = -10839909573063377L;
    /**
    * 自增id
    */
    private Integer bsUserid;
    /**
    * 账号
    */
    private String bsLoginname;
    /**
    * 密码
    */
    private String bsPassword;
    /**
    * 支付密码
    */
    private String bsPaypassword;
    /**
    * 创建时间
    */
    private String bsCreatetime;
    /**
    * 最后登录时间
    */
    private String bsLastlogintime;
    /**
    * 最后登录IP
    */
    private String bsLastloginip;


    public Integer getBsUserid() {
        return bsUserid;
    }

    public void setBsUserid(Integer bsUserid) {
        this.bsUserid = bsUserid;
    }

    public String getBsLoginname() {
        return bsLoginname;
    }

    public void setBsLoginname(String bsLoginname) {
        this.bsLoginname = bsLoginname;
    }

    public String getBsPassword() {
        return bsPassword;
    }

    public void setBsPassword(String bsPassword) {
        this.bsPassword = bsPassword;
    }

    public String getBsPaypassword() {
        return bsPaypassword;
    }

    public void setBsPaypassword(String bsPaypassword) {
        this.bsPaypassword = bsPaypassword;
    }

    public String getBsCreatetime() {
        return bsCreatetime;
    }

    public void setBsCreatetime(String bsCreatetime) {
        this.bsCreatetime = bsCreatetime;
    }

    public String getBsLastlogintime() {
        return bsLastlogintime;
    }

    public void setBsLastlogintime(String bsLastlogintime) {
        this.bsLastlogintime = bsLastlogintime;
    }

    public String getBsLastloginip() {
        return bsLastloginip;
    }

    public void setBsLastloginip(String bsLastloginip) {
        this.bsLastloginip = bsLastloginip;
    }

}