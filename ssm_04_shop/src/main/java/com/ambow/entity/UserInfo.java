package com.ambow.entity;

import lombok.Data;

@Data
public class UserInfo {

    private int uid ;
    private String uname ;
    private String upwd ;
    private String uflag ;
    private double umoeny ;

    @Override
    public String toString() {
        return "UserInfo{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", upwd='" + upwd + '\'' +
                ", uflag='" + uflag + '\'' +
                ", umoeny=" + umoeny +
                '}';
    }
}
