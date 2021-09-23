package com.ambow.entity;

import lombok.Data;

@Data
public class YuyueInfo {
    private int yid ;
    private UserInfo yuid;
    private BookInfo ybid;
    private String ytimebegin;
    private String ytimeend;
    private int yflag ;  //0 表示预约中  1 表示成功
}
