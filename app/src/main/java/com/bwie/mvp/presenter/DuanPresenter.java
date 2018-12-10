package com.bwie.mvp.presenter;

import com.bwie.base.BasePresenter;
import com.bwie.mvp.model.Model;
import com.bwie.mvp.view.DuanIView;
import com.bwie.my.bean.DuanBean;
import com.bwie.my.bean.UserBean;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * date:2018/12/10.
 * Created by 王丙均
 */
//这是段子的p层
public class DuanPresenter extends BasePresenter<DuanIView> {
    private final Model model;

    public DuanPresenter() {
        model = new Model();
    }

    public void getDuan() {
        model.getDuanB()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DuanBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DuanBean duanBean) {
                        if (duanBean != null) {
//                            List<DuanBean.DataBean> data = duanBean.getData();
                            getView().OnSuccess(duanBean);
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
