package com.study.android.expandablelistview.bean;

import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maw on 2017/6/23.
 */

public class databean {
    private String title;
    private List<bean> list=new ArrayList<>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<bean> getList() {
        return list;
    }

    public void setList(List<bean> list) {

        this.list = list;
    }

   public static class bean {
        String text;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }
}
