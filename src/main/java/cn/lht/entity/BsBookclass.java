package cn.lht.entity;

import java.io.Serializable;

/**
 * (BsBookclass)实体类
 *
 * @author makejava
 * @since 2020-04-13 23:03:26
 */
public class BsBookclass implements Serializable {
    private static final long serialVersionUID = -74191949048038996L;
    /**
    * 图书类别Id
    */
    private Integer bsBookclassid;
    /**
    * 图书类别名称
    */
    private String bsBookclassname;


    public Integer getBsBookclassid() {
        return bsBookclassid;
    }

    public void setBsBookclassid(Integer bsBookclassid) {
        this.bsBookclassid = bsBookclassid;
    }

    public String getBsBookclassname() {
        return bsBookclassname;
    }

    public void setBsBookclassname(String bsBookclassname) {
        this.bsBookclassname = bsBookclassname;
    }

}