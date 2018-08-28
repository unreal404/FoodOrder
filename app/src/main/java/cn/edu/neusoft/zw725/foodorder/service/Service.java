package cn.edu.neusoft.zw725.foodorder.service;

import java.util.List;

import cn.edu.neusoft.zw725.foodorder.bean.AllShopBean;
import cn.edu.neusoft.zw725.foodorder.bean.ByBean;
import cn.edu.neusoft.zw725.foodorder.bean.CollectBean;
import cn.edu.neusoft.zw725.foodorder.bean.FoodByShopBean;
import cn.edu.neusoft.zw725.foodorder.bean.LoginBean;
import cn.edu.neusoft.zw725.foodorder.bean.RegBean;
import cn.edu.neusoft.zw725.foodorder.bean.UserCollectionBean;
import cn.edu.neusoft.zw725.foodorder.bean.UserDateBean;
import cn.edu.neusoft.zw725.foodorder.listener.ListListener;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by china on 2017/11/6.
 */

public interface Service {
    @GET("userLogin.do")
    Call<LoginBean> getLoginBean(@Query("username") String username, @Query("userpass") String userpass);
    @GET("userRegister.do")
    Call<RegBean> getRegBean(@Query("username") String username, @Query("userpass") String userpass, @Query("mobilenum") String mobilenum,
                             @Query("address") String address, @Query("comment") String comment);
    @GET("getAllShops.do")
    Call<List<AllShopBean>> getAllSopBean();
    @GET("getFoodByShop.do")
    Call<List<FoodByShopBean>> getFoodByShopBean(@Query("shop_id") String shop_id);

    @GET("insertOrder.do")
    Call<ByBean> getByBean(@Query("user_id") String user_id,@Query("food_id") String food_id,@Query("num") String num,@Query("sum") String sum,
                           @Query("suggesttime") String suggesttime);
    @GET("userCollectShop.do")
    Call<RegBean> getCollectShop(@Query("user_id") String user_id,@Query("shop_id") String shop_id);
    @GET("userCollectFood.do")
    Call<RegBean> getCollectFood(@Query("user_id") String user_id,@Query("food_id") String food_id);
    @GET("isCollected.do")
    Call<CollectBean> isCollected(@Query("user_id") String user_id,@Query("shop_food_id") String shop_food_id,@Query("flag") String flag);
    @GET("getAllUserCollection.do")
    Call<List<UserCollectionBean>> getUserCollectionBean(@Query("user_id") String user_id,@Query("flag") String flag);
    @GET("getFoodBySearch.do")
    Call<List<FoodByShopBean>> getAllFood(@Query("search") String search);
    @GET("updateUserById.do")
    Call<RegBean> getUpdate(@Query("user_id") String user_id, @Query("username") String username, @Query("userpass") String userpass,
                            @Query("mobilenum") String mobilenum, @Query("address") String address);
    @GET("getUserById.do")
    Call<UserDateBean> getUserDate(@Query("user_id") String user_id);

}
