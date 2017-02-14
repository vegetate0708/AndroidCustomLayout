package com.zxf.androidcustomlayout.CanvasAndPaint.TimeListDemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zxf.androidcustomlayout.R;

import java.util.List;

/**
 * Created by Administrator on 2016/11/17.
 */
public class TimeListAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private Context context;
    private List<String> datas;
    private LayoutInflater inflater;
    public TimeListAdapter(Context context, List<String> datas) {
        this.context=context;
        this.datas=datas;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.item_recycle_timelist,parent,false);
        MyViewHolder myViewHolder=new MyViewHolder(view,inflater.getContext(),viewType);
        return myViewHolder;
    }

    @Override
    public int getItemViewType(int position) {
        int size=datas.size()-1;
        if(size==0){
            return ItemType.NO;
        }else if(position==0){
            return ItemType.TOP;
        }else if(position==size){
            return ItemType.BOTTOM;
        }else {
            return ItemType.NORMAL;
        }
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }
}
class MyViewHolder extends RecyclerView.ViewHolder{
    TextView tv;
    public MyViewHolder(View itemView,Context context,int type) {
        super(itemView);
        TimeListView timeListView= (TimeListView) itemView.findViewById(R.id.tlv);
        if (type==ItemType.NO){
            timeListView.setmStartLine(null);
            timeListView.setmEndLine(null);
        }else if(type==ItemType.TOP){
            timeListView.setmStartLine(null);
        }else if(type==ItemType.BOTTOM){
            timeListView.setmEndLine(null);
        }
    }
}
