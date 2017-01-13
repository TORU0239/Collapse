package me.toru.collapse;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by wonyoung on 2017. 1. 13..
 */

public class MainAdapter extends RecyclerView.Adapter<MainViewHolder> {

    private List<String> adapterResourceList;

    public MainAdapter(List<String> adapterResourceList) {
        this.adapterResourceList = adapterResourceList;
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_adapter, parent, false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, int position) {
        holder.update(adapterResourceList.get(position));
    }

    @Override
    public int getItemCount() {
        return adapterResourceList.size();
    }
}

class MainViewHolder extends RecyclerView.ViewHolder{

    private TextView textView;

    public MainViewHolder(View itemView) {
        super(itemView);
        textView = (TextView)itemView.findViewById(R.id.main_adapter_text);
    }

    protected void update(String data){
        textView.setText(data);
    }
}
