package cn.lht.entity;

import java.io.Serializable;

/**
 * (BsPress)实体类
 *
 * @author makejava
 * @since 2020-04-14 08:36:57
 */
public class BsPress implements Serializable {
    private static final long serialVersionUID = -25176575285111073L;
    /**
    * 出版社Id
    */
    private Integer bsPressid;
    /**
    * 出版社编号
    */
    private String bsPressnum;
    /**
    * 出版社名称
    */
    private String bsPressname;


    public Integer getBsPressid() {
        return bsPressid;
    }

    public void setBsPressid(Integer bsPressid) {
        this.bsPressid = bsPressid;
    }

    public String getBsPressnum() {
        return bsPressnum;
    }

    public void setBsPressnum(String bsPressnum) {
        this.bsPressnum = bsPressnum;
    }

    public String getBsPressname() {
        return bsPressname;
    }

    public void setBsPressname(String bsPressname) {
        this.bsPressname = bsPressname;
    }

}