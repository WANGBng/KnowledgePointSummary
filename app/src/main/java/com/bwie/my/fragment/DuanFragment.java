package com.bwie.my.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bwie.R;
import com.bwie.mvp.presenter.DuanPresenter;
import com.bwie.mvp.view.DuanIView;
import com.bwie.my.activity.UserActivity;
import com.bwie.my.adapter.DuanAdpater;
import com.bwie.my.bean.DuanBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * date:2018/12/10.
 * Created by 王丙均
 */

public class DuanFragment extends Fragment implements DuanIView {

    @BindView(R.id.user_a)
    ImageView userA;
    @BindView(R.id.duan_rec)
    RecyclerView duanRec;
    Unbinder unbinder;

    DuanPresenter duanPresenter;
    DuanAdpater duanAdpater;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.duan_layout, container, false);
        duanPresenter = new DuanPresenter();
        duanPresenter.attachView(this);
        duanPresenter.getDuan();

        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        duanPresenter.detachView();
    }

    @OnClick(R.id.user_a)
    public void onViewClicked() {
        Intent intent = new Intent(getActivity(), UserActivity.class);
        startActivity(intent);
    }

    @Override
    public void OnSuccess(DuanBean duanBean) {
        List<DuanBean.DataBean> data = duanBean.getData();

        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL);
        duanRec.setLayoutManager(manager);
        duanAdpater = new DuanAdpater(getActivity(),data);
        duanRec.setAdapter(duanAdpater);

    }

    @Override
    public void OnFailed(Throwable t) {

    }
}
