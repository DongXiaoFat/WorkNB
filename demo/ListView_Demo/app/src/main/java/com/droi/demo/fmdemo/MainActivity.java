package com.droi.demo.fmdemo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends Activity implements  View.OnClickListener {

    ListView mListView_t, mListView_l;
    int gonePosition = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        findViewById(R.id.gone).setOnClickListener(this);
        findViewById(R.id.vis).setOnClickListener(this);

        mListView_t = findViewById(R.id.list_t);
        mListView_l = findViewById(R.id.list_l);
        mListView_t.setAdapter(new MyAdapter(this,R.layout.item));
        mListView_l.setAdapter(new MyAdapter(this,R.layout.item_layout));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.gone:
                gonePosition = 0;
                break;
            case R.id.vis:
                gonePosition = -1;
                break;
        }
        mListView_t.invalidateViews();
        mListView_l.invalidateViews();


    }

    private class MyAdapter extends BaseAdapter {
        Context mContext;
        int layoutResId;
        ArrayList<String> arrayList = new ArrayList<String>(){{add("Item1");add("Item2");add("Item3");}};

        MyAdapter(Context mContext, int layoutId) {
            this.mContext = mContext;
            layoutResId = layoutId;
        }

        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if (convertView == null) {
                convertView = LayoutInflater.from(mContext).inflate(layoutResId,null);
                viewHolder = new ViewHolder();
                viewHolder.textView = convertView.findViewById(R.id.item_layout);
                convertView.setTag(viewHolder);
            }else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.textView.setText(arrayList.get(position));
            viewHolder.textView.setVisibility(gonePosition == position? View.GONE : View.VISIBLE);
            return convertView;
        }

        class ViewHolder {
            TextView textView;
        }
    }
}
