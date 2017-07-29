package com.example.cal_demo;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MyAdapter extends BaseAdapter {

    Context context;
    ArrayList<buyaction> list;
    private LayoutInflater inflater;
    public MyAdapter(Context context,ArrayList list){
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }
    
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public buyaction getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Holder holder;
        if(convertView==null){
            holder = new Holder();
            convertView = inflater.inflate(R.layout.item_listview, null);
            holder.name = (TextView) convertView.findViewById(R.id.name);
            holder.num = (TextView) convertView.findViewById(R.id.num);
            holder.val = (TextView) convertView.findViewById(R.id.val);
            holder.itembtn = (Button) convertView.findViewById(R.id.item_btn);
            convertView.setTag(holder);
        }else{
            holder = (Holder) convertView.getTag();
        }
        holder.name.setText(list.get(position).name);
        holder.num.setText(String.valueOf(list.get(position).num)+"次提示 ");
        if(list.get(position).num<10)
        	holder.val.setText("    ¥"+String.valueOf(list.get(position).val));
        else if(list.get(position).num<100)
        	holder.val.setText("  ¥"+String.valueOf(list.get(position).val));
        else holder.val.setText("¥"+String.valueOf(list.get(position).val));
        holder.itembtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "成功购买"+list.get(position).name+" 花费"+String.valueOf(list.get(position).val)+"RMB 获得"+String.valueOf(list.get(position).num)+"次提示", Toast.LENGTH_LONG).show();
            }
        });
        return convertView;
    }

    protected class Holder{
        TextView name;
        TextView num;
        TextView val;
        Button itembtn;
    }
}