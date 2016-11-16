package com.example.magshehu.happybirthdaybeauty;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Toast;
import android.view.LayoutInflater;
import android.widget.TextView;
import java.util.List;

/**
 * Created by MagShehu on 10/11/2016.
 */

public class CustomAdapter extends BaseAdapter {

    private LayoutInflater layoutinflater;
    private List<ItemObject> listStorage;
    private Context context;

    public CustomAdapter(Context context, List<ItemObject> customizedListView) {
        this.context = context;
        layoutinflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        listStorage = customizedListView;
    }

    @Override
    public int getCount() {
        return listStorage.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder listViewHolder;
        if(convertView == null){
            listViewHolder = new ViewHolder();
            convertView = layoutinflater.inflate(R.layout.display_adapter, parent, false);
            listViewHolder.textInListView = (TextView)convertView.findViewById(R.id.textView);
            listViewHolder.imageInListView = (ImageView)convertView.findViewById(R.id.imageView);
            convertView.setTag(listViewHolder);
        }else{
            listViewHolder = (ViewHolder)convertView.getTag();
        }

        listViewHolder.textInListView.setText(listStorage.get(position).getContent());
        int imageResourceId = this.context.getResources().getIdentifier(listStorage.get(position).getImageResource(), "drawable", this.context.getPackageName());
        listViewHolder.imageInListView.setImageResource(imageResourceId);

        return convertView;
    }

    static class ViewHolder{
        TextView textInListView;
        ImageView imageInListView;
    }

}