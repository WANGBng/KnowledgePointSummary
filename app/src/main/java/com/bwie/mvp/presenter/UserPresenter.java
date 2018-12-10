package com.bwie.mvp.presenter;

import com.bwie.base.BasePresenter;
import com.bwie.mvp.model.Model;
import com.bwie.mvp.view.UserView;
import com.bwie.my.bean.DuanBean;
import com.bwie.my.bean.UserBean;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * date:2018/12/10.
 * Created by 王丙均
 */

public class UserPresenter extends BasePresenter<UserView> {
    private final Model model;
    public UserPresenter(){
        model = new Model();
    }

    public void getUs(){
        model.getUse()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }
                    @Override
                    public void onNext(UserBean userBean) {
                        if (userBean != null) {
//                            UserBean.DataBean data = userBean.getData();
                            getView().OnUserSuccess(userBean);
                        }
                    }
                    @Override
                    public void onError(Throwable e) {
                    }
                    @Override
                    public void onComplete() {
                    }
                });
    }
}
