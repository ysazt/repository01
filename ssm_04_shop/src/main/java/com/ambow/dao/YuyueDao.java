package com.ambow.dao;

import com.ambow.entity.YuyueInfo;

import java.util.List;

public interface YuyueDao {

    public  void addYuyue(YuyueInfo yuyueInfo);

    public YuyueInfo byUidYuyue(int uid );

    public List<Integer> byFlagYuyue(int flag);
}
