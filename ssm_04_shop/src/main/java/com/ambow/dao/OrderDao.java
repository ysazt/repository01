package com.ambow.dao;

import com.ambow.entity.OrderDetailInfo;
import com.ambow.entity.OrderInfo;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderDao {

    public void addOrder(OrderInfo orderInfo);

    public List<OrderDetailInfo> myOrder(@Param("uid") int uid , @Param("flag") int flag );

    public void updateOrder(OrderInfo orderInfo);

}
