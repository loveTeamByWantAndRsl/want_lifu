package com.example.wantlifu.entity;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class Trademark implements Serializable {
    private Integer id;
    @NotNull(message = "品牌名不能为空")
    @Length(min=1,max = 50,message = "名字长度不和法")
    private String name;

    @NotNull(message = "品牌详细不能为空")
    @Length(min=1,message = "品牌详细长度不和法")
    private String detail;

    private Integer lovecount;
    @Length(min=1,message = "品牌图片长度不和法")
    @NotNull(message = "品牌图片不能为空")
    private String pic;
    @Length(min=1,message = "品牌logo长度不和法")
    @NotNull(message = "品牌logo不能为空")
    private String logo;

    private Integer lifucount;

    private String firstchar;

    private Integer commentcount;
    @NotNull(message = "品牌状态不能为空")
    private Integer status;

    private String remark;

    private String remark1;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Integer getLovecount() {
        return lovecount;
    }

    public void setLovecount(Integer lovecount) {
        this.lovecount = lovecount;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Integer getLifucount() {
        return lifucount;
    }

    public void setLifucount(Integer lifucount) {
        this.lifucount = lifucount;
    }

    public String getFirstchar() {
        return firstchar;
    }

    public void setFirstchar(String firstchar) {
        this.firstchar = firstchar;
    }

    public Integer getCommentcount() {
        return commentcount;
    }

    public void setCommentcount(Integer commentcount) {
        this.commentcount = commentcount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", detail=").append(detail);
        sb.append(", lovecount=").append(lovecount);
        sb.append(", pic=").append(pic);
        sb.append(", logo=").append(logo);
        sb.append(", lifucount=").append(lifucount);
        sb.append(", firstchar=").append(firstchar);
        sb.append(", commentcount=").append(commentcount);
        sb.append(", status=").append(status);
        sb.append(", remark=").append(remark);
        sb.append(", remark1=").append(remark1);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}