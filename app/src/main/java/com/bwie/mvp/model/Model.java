package com.bwie.mvp.model;

import com.bwie.my.bean.DuanBean;
import com.bwie.my.bean.UserBean;
import com.bwie.my.utils.HttpUtils;

import io.reactivex.Observable;

/**
 * date:2018/12/10.
 * Created by 王丙均
 */

public class Model {
    public Observable<DuanBean> getDuanB(){
        Observable<DuanBean> duan = HttpUtils.getdatanet().api.duan();
        return duan;
    }
    public Observable<UserBean> getUse(){
        Observable<UserBean> use = HttpUtils.getdatanet().api.userb();
        return use;
    }
}
