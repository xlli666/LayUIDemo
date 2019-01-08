package com.example.demo.pojo;

public class GoodsDomain extends SpuDomain {
    String cname;// 分类名称
    String bname;// 品牌名称

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }
}
