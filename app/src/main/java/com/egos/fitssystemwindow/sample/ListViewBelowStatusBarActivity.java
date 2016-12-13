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
public class ListViewBelowStatusBarActivity extends AppCompatActivity {
    private View mContentLayout;
    private ListView mList;

    private String strS[] = new String[]{"Egos", "Cool", "Tom", "Jay", "Jack", "Egos", "Cool", "Tom", "Jay", "Jack", "Egos", "Cool", "Tom", "Jay", "Jack", "Egos", "Cool", "Tom", "Jay", "Jack", "Egos", "Cool", "Tom", "Jay", "Jack", "Egos", "Cool", "Tom", "Jay", "Jack", "Egos", "Cool", "Tom", "Jay", "Jack", "Egos", "Cool", "Tom", "Jay", "Jack", "Egos", "Cool", "Tom", "Jay", "Jack", "Egos", "Cool", "Tom", "Jay", "Jack"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_below_status_bar);
        mContentLayout = findViewById(R.id.content_layout);
        mList = (ListView) findViewById(R.id.list);
        mList.setAdapter(new MyAdapter());

        // todo 动态计算Navigation Bar的高度
        ViewGroup viewGroup = (ViewGroup) getWindow().getDecorView().findViewById(android.R.id.content);
        viewGroup.setPadding(0, 0, 0, -144);  // 设置整体（DecorView）能够展示的区域－144代表的是在屏幕最下面向上144
        mList.setPadding(0, 0, 0, 144);  // item可以出现在超出自身区域的位置。
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
