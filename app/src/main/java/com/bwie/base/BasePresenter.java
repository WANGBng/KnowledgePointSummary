package com.bwie.base;

/**
 * date:2018/12/10.
 * Created by 王丙均
 */

public class BasePresenter<V extends BaseView> {
    private V iv;
    public void attachView(V iv){
        this.iv = iv;
    }
    public void detachView(){
        this.iv = null;
    }
    public V getView(){
        return iv;
    }
}
