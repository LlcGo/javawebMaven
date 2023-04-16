package com.lc.bbs.bean;

import lombok.Data;

import java.util.Date;

/**
 * @Author Lc
 * @Date 2023/4/16
 * @Description
 */
@Data
public class Detail {
    //帖子编号
    private Integer id;
    //版区编号
    private Integer sortId;
    //标题
    private String title;
    //详情
    private String detail;
    //作者
    private String author;
    //创建时间
    private Date createDate;
    //回复数量
    private Integer replyCount;

}
