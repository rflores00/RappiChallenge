package com.adv.rappichallenge.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.adv.rappichallenge.R;
import com.adv.rappichallenge.helpers.CircleTransform;
import com.adv.rappichallenge.models.Entry;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Ruben Flores on 12/19/2016.
 */

public class Entry_list extends BaseAdapter {
    private Context context;
    private List<Entry> _items;
    private int _item_resourse;
    public Entry_list(Context context, List<Entry> _items, int item_resoure) {
        this.context = context;
        this._items = _items;
        this._item_resourse = item_resoure;
    }

    @Override
    public int getCount() {
        return _items.size();
    }

    @Override
    public Entry getItem(int i) {
        return _items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        Entry item = getItem(i);

        Holder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(_item_resourse, viewGroup, false);
            holder = new Holder();

            holder.icon = (ImageView) convertView.findViewById(R.id.iconApp);
            holder.textAppName = (TextView) convertView.findViewById(R.id.textAppName);
            holder.textPrice = (TextView) convertView.findViewById(R.id.textPrice);

            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        Picasso.with(context)
                .load(item.getIm_image().get(1).getLabel())
                .placeholder(R.drawable.ic_cached)
                .transform(new CircleTransform())
                .into(holder.icon);

        holder.textAppName.setText(item.getIm_name().getLabel());
        double amount = Double.parseDouble(item.getIm_price().getAttributes_price().getAmount());
        if(amount > 0){
            holder.textPrice.setText("$ "+ amount);
        }else{
            holder.textPrice.setText("Gratis");
        }

        return convertView;
    }

    static class Holder {
        ImageView icon;
        TextView textAppName;
        TextView textPrice;
    }
}
