package com.bwie.my.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;

import com.bwie.R;
import com.bwie.mvp.presenter.UserPresenter;
import com.bwie.mvp.view.UserView;
import com.bwie.my.adapter.UserAdapter;
import com.bwie.my.bean.DaoSession;
import com.bwie.my.bean.UserBean;
import com.bwie.my.bean.Uset;
import com.bwie.my.bean.UsetDao;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class UserActivity extends AppCompatActivity implements UserView {
    private static final String TAG ="MainActivity" ;
    private DaoSession daoSession;
    private int index;
    private UsetDao personDao;
    @BindView(R.id.user_recyclerView)
    RecyclerView userRecyclerView;
    Unbinder unbinder;
    UserPresenter userPresenter;
    UserAdapter userAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        unbinder = ButterKnife.bind(this);
        userPresenter = new UserPresenter();
        userPresenter.attachView(this);
        userPresenter.getUs();
       /* index++;
        Uset person = new Uset(null,"name" + index,index * 10);
        personDao.insert(person);
        List<Uset> list = personDao.queryBuilder()
                .where(UsetDao.Properties.Age.lt(500))
                .orderDesc(UsetDao.Properties.Mingzi)
                .build()
                .list();
        for (Uset uset: list ) {
            Log.e(TAG, "query: "+person.toString() );

        }*/
    }
//防止内存溢出
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
        userPresenter.detachView();
    }

    @Override
    public void OnUserSuccess(UserBean userBean) {
        UserBean.DataBean data = userBean.getData();

        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL);
        userRecyclerView.setLayoutManager(manager);
        userAdapter = new UserAdapter(UserActivity.this, data);
        userRecyclerView.setAdapter(userAdapter);

    }

    @Override
    public void OnFailed(Throwable t) {

    }
}
