package com.bwie.my.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwie.R;
import com.bwie.my.bean.DuanBean;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * date:2018/12/10.
 * Created by 王丙均
 */

public class DuanAdpater extends RecyclerView.Adapter<DuanAdpater.ViewHolder> {
    private Context context;
    private List<DuanBean.DataBean> duanlist;

    public DuanAdpater(Context context, List<DuanBean.DataBean> duanlist) {
        this.context = context;
        this.duanlist = duanlist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(context, R.layout.duan_adapter_layout, null));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Uri uri = Uri.parse(duanlist.get(position).getUser().getIcon());
        RoundingParams roundingParams = new RoundingParams();
        roundingParams.setRoundAsCircle(true);
        holder.duan_simple.getHierarchy().setRoundingParams(roundingParams);
        holder.duan_simple.setImageURI(uri);

        holder.duan_name.setText(duanlist.get(position).getUser().getNickname());
        holder.duan_data.setText(duanlist.get(position).getCreateTime());
        holder.duan_haha.setText(duanlist.get(position).getContent());

//        Uri uri2 = Uri.parse(String.valueOf(duanlist.get(position).getImgUrls()));
        Uri uri2 = Uri.parse(duanlist.get(position).getUser().getIcon());
        holder.duan2_simple.setImageURI(uri2);

    }

    @Override
    public int getItemCount() {
        return duanlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
         SimpleDraweeView duan_simple;
         TextView duan_name;
         TextView duan_data;
         TextView duan_haha;
         SimpleDraweeView duan2_simple;

        public ViewHolder(View itemView) {
            super(itemView);
            duan_simple = (SimpleDraweeView) itemView.findViewById(R.id.duan_simple);
            duan_name = (TextView) itemView.findViewById(R.id.duan_name);
            duan_data = (TextView) itemView.findViewById(R.id.duan_data);
            duan_haha = (TextView) itemView.findViewById(R.id.duan_haha);

            duan2_simple = (SimpleDraweeView) itemView.findViewById(R.id.duan2_simple);
        }
    }
}
