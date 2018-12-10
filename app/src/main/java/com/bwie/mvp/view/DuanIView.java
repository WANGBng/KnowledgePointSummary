package com.bwie.mvp.view;

import com.bwie.base.BaseView;
import com.bwie.my.bean.DuanBean;

/**
 * date:2018/12/10.
 * Created by 王丙均
 */

public interface DuanIView extends BaseView {
    void OnSuccess(DuanBean duanBean);
    void OnFailed(Throwable t);
}
