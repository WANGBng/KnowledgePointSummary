package com.bwie.my.utils;

import com.bwie.my.bean.DuanBean;
import com.bwie.my.bean.UserBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * date:2018/12/10.
 * Created by 王丙均
 */

public interface Api {
    @GET("quarter/getJokes?source=android&appVersion=1&page=1")
    Observable<DuanBean> duan();
    @GET("user/getUserInfo?uid=71")
    Observable<UserBean> userb();
}
