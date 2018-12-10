package com.bwie.my.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bwie.R;
import com.bwie.my.fragment.DuanFragment;
import com.bwie.my.fragment.FaFragment;
import com.bwie.my.fragment.ShiFragment;
import com.bwie.my.fragment.TuiFragment;
import com.hjm.bottomtabbar.BottomTabBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {
//获得控件
    @BindView(R.id.bottomTabBar)
    BottomTabBar bottomTabBar;
    Unbinder unbinder;//butterKnife

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);

        //初始化,展示
        bottomTabBar.init(getSupportFragmentManager())
                .setImgSize(50,50)
                .setFontSize(8)
                .setTabPadding(4,6,10)
                .setChangeColor(Color.RED,Color.DKGRAY)
                .addTabItem("推荐",R.drawable.add_icon, TuiFragment.class)
                .addTabItem("段子",R.drawable.edit_icon, DuanFragment.class)
                .addTabItem("发现",R.drawable.user_icon, FaFragment.class)
                .addTabItem("视频",R.drawable.add_icon, ShiFragment.class)
                .isShowDivider(false);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
