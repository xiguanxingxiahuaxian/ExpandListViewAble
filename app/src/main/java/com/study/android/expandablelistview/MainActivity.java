package com.study.android.expandablelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import com.study.android.expandablelistview.adapter.ExpandListAdapter;
import com.study.android.expandablelistview.bean.databean;

import java.util.ArrayList;
import java.util.List;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ExpandableListView listView = (ExpandableListView) findViewById(R.id.expand);

        List<databean> list = new ArrayList<>();
        //封装了一条数据
        databean databean = new databean();
        databean.setTitle("月亮");
        List<databean.bean> bean = new ArrayList<>();
        databean.bean data = new databean.bean();
        data.setText("嫦娥");
        bean.add(data);
        data = new databean.bean();
        data.setText("月小妹");
        bean.add(data);
        databean.setList(bean);
        list.add(databean);
        //封住了二条数据
        databean = new databean();
        databean.setTitle("太阳");
        bean = new ArrayList<>();
        data = new databean.bean();
        data.setText("后羿");
        bean.add(data);
        data = new databean.bean();
        data.setText("弓箭");
        bean.add(data);
        databean.setList(bean);
        list.add(databean);

        ExpandListAdapter expandListAdapter = new ExpandListAdapter(getApplicationContext(), list);
        listView.setAdapter(expandListAdapter);
    }
}
