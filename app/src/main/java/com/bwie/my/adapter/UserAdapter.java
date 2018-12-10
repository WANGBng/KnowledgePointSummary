package com.bwie.my.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwie.R;
import com.bwie.my.bean.UserBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;
/**
 * date:2018/12/10.
 * Created by 王丙均
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    private Context context;
    private UserBean.DataBean list;
    public UserAdapter(Context context, UserBean.DataBean list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(context, R.layout.user_adapter_layout, null));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Uri uri = Uri.parse(list.getIcon());
        holder.user_simple.setImageURI(uri);
        holder.user_name.setText(list.getUsername());
        holder.user_nicheng.setText(list.getNickname());
        holder.user_sex.setText(String.valueOf(list.getAge()));
        holder.user_date.setText(list.getCreatetime());
      /*  Uri uri = Uri.parse(list.get(position).getIcon());
        holder.user_simple.setImageURI(uri);
        holder.user_name.setText(list.get(position).getUsername());
        holder.user_nicheng.setText(list.get(position).getNickname());
        holder.user_sex.setText(String.valueOf(list.get(position).getAge()));
        holder.user_date.setText(list.get(position).getCreatetime());*/

    }

    @Override
    public int getItemCount() {
        return list.toString().length();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
         SimpleDraweeView user_simple;
         TextView user_name;
         TextView user_nicheng;
         TextView user_sex;
         TextView user_date;
        public ViewHolder(View itemView) {
            super(itemView);
            user_simple = (SimpleDraweeView) itemView.findViewById(R.id.user_simple);
            user_name = (TextView) itemView.findViewById(R.id.user_name);
            user_nicheng = (TextView) itemView.findViewById(R.id.user_nicheng);
            user_sex = (TextView) itemView.findViewById(R.id.user_sex);
            user_date = (TextView) itemView.findViewById(R.id.user_date);
        }
    }
}