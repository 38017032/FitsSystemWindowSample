package com.egos.fitssystemwindow.sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Egos on 2016/12/12.
 */
public class ListViewUnderSystemBarActivity extends AppCompatActivity {

    private ListView mList;

    private String strS[] = new String[]{"Egos", "Cool", "Tom", "Jay", "Jack", "Egos", "Cool", "Tom", "Jay", "Jack", "Egos", "Cool", "Tom", "Jay", "Jack", "Egos", "Cool", "Tom", "Jay", "Jack", "Egos", "Cool", "Tom", "Jay", "Jack", "Egos", "Cool", "Tom", "Jay", "Jack", "Egos", "Cool", "Tom", "Jay", "Jack", "Egos", "Cool", "Tom", "Jay", "Jack", "Egos", "Cool", "Tom", "Jay", "Jack", "Egos", "Cool", "Tom", "Jay", "Jack"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_under_system_bar);
        mList = (ListView) findViewById(R.id.list);
        mList.setAdapter(new MyAdapter());
    }

    private class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return strS.length;
        }

        @Override
        public String getItem(int position) {
            return strS[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
                holder.text = (TextView) convertView;
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.text.setText(strS[position]);
            return convertView;
        }
    }

    public class ViewHolder {
        TextView text;
    }
}