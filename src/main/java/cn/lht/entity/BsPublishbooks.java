package cn.lht.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (BsPublishbooks)实体类
 *
 * @author makejava
 * @since 2020-04-14 08:43:27
 */
public class BsPublishbooks implements Serializable {
    private static final long serialVersionUID = 939879951181556437L;
    /**
    * 自增Id
    */
    private Integer bsBooksid;
    /**
    * 账号
    */
    private String bsLoginname;
    /**
    * 图书名称
    */
    private String bsBookname;
    /**
    * 图书作者
    */
    private String bsBookauthor;
    /**
    * 出版社名称
    */
    private String bsPressname;
    /**
    * 图书价格
    */
    private double bsBookprice;
    /**
    * 图书封面
    */
    private String bsBookcover;
    /**
    * 书籍数量
    */
    private Integer bsBooknum;
    /**
    * 书籍所在省份
    */
    private String bsProvince;
    /**
    * 创建时间
    */
    private String bsCratetime;


    public Integer getBsBooksid() {
        return bsBooksid;
    }

    public void setBsBooksid(Integer bsBooksid) {
        this.bsBooksid = bsBooksid;
    }

    public String getBsLoginname() {
        return bsLoginname;
    }

    public void setBsLoginname(String bsLoginname) {
        this.bsLoginname = bsLoginname;
    }

    public String getBsBookname() {
        return bsBookname;
    }

    public void setBsBookname(String bsBookname) {
        this.bsBookname = bsBookname;
    }

    public String getBsBookauthor() {
        return bsBookauthor;
    }

    public void setBsBookauthor(String bsBookauthor) {
        this.bsBookauthor = bsBookauthor;
    }

    public String getBsPressname() {
        return bsPressname;
    }

    public void setBsPressname(String bsPressname) {
        this.bsPressname = bsPressname;
    }

    public double getBsBookprice() {
        return bsBookprice;
    }

    public void setBsBookprice(double bsBookprice) {
        this.bsBookprice = bsBookprice;
    }

    public String getBsBookcover() {
        return bsBookcover;
    }

    public void setBsBookcover(String bsBookcover) {
        this.bsBookcover = bsBookcover;
    }

    public Integer getBsBooknum() {
        return bsBooknum;
    }

    public void setBsBooknum(Integer bsBooknum) {
        this.bsBooknum = bsBooknum;
    }

    public String getBsProvince() {
        return bsProvince;
    }

    public void setBsProvince(String bsProvince) {
        this.bsProvince = bsProvince;
    }

    public String getBsCratetime() {
        return bsCratetime;
    }

    public void setBsCratetime(String bsCratetime) {
        this.bsCratetime = bsCratetime;
    }

}