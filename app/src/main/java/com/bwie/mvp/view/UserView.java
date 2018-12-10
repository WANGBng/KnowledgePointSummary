package com.bwie.mvp.view;

import com.bwie.base.BaseView;
import com.bwie.my.bean.DuanBean;
import com.bwie.my.bean.UserBean;

/**
 * date:2018/12/10.
 * Created by 王丙均
 */

public interface UserView extends BaseView {
    void OnUserSuccess(UserBean userBean);
    void OnFailed(Throwable t);
}
