package com.ambow.dao;

import com.ambow.entity.ShopInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopDao {

    public void addShop(ShopInfo shopInfo);

    public void updateShop(ShopInfo shopInfo);

    public void updateShopFlag(ShopInfo shopInfo);

    public List<ShopInfo> myShop(@Param("uid") int uid , @Param("sflag") String sflag );


    public ShopInfo myShopBook(@Param("uid") int uid , @Param("bookid") int bookid );

    public ShopInfo byidShop(int sid);
}
