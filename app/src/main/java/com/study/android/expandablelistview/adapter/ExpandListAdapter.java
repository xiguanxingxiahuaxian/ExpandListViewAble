package com.study.android.expandablelistview.adapter;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.study.android.expandablelistview.R;
import com.study.android.expandablelistview.bean.databean;

import org.w3c.dom.Text;

import java.security.acl.Group;
import java.util.ArrayList;
import java.util.List;

import static android.R.id.list;

/**
 * Created by maw on 2017/6/22.
 */
//华丽的布局，明天搞搞，要动态的实现。

/**
 * 基于纯文字的显示，所有的内容应该很好展示
 */
public class ExpandListAdapter implements ExpandableListAdapter {

    private final Context context;
    private final List<databean> list;


    public ExpandListAdapter(Context context, List<databean> list1) {
        this.context = context;
        this.list = list1;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getGroupCount() {
        return list.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return list.get(groupPosition).getList().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groupPosition;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return list.get(groupPosition).getList().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    /**
     * @param groupPosition
     * @param isExpanded
     * @param convertView
     * @param parent
     * @return
     * @maw
     * @describe 提供两个子的布局，分别来对应其显示的内容
     */
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        group group = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.group, null);
            group = new group(convertView);
            convertView.setTag(group);
        } else {
            group = (group) convertView.getTag();
        }
        group.title.setText(list.get(groupPosition).getTitle().toString());
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        child child = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.child, null);
            child = new child(convertView);
            convertView.setTag(child);
        } else {
            child = (child) convertView.getTag();
        }
        child.text.setText(list.get(groupPosition).getList().get(childPosition).getText().toString());
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void onGroupExpanded(int groupPosition) {
        Toast.makeText(context, groupPosition + "", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onGroupCollapsed(int groupPosition) {
        Toast.makeText(context, groupPosition + "", Toast.LENGTH_SHORT).show();
    }

    @Override
    public long getCombinedChildId(long groupId, long childId) {
        return childId;
    }

    @Override
    public long getCombinedGroupId(long groupId) {
        return groupId;
    }

    class group {
        TextView title;

        public group(View view) {
             title = (TextView) view.findViewById(R.id.group);
        }
    }

    class child {
        TextView text;

        public child(View view) {
             text = (TextView) view.findViewById(R.id.text);
        }
    }
}

