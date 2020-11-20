package com.example.wri.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.wri.Activity.Company.Company_Specialize_List_Student;
import com.example.wri.R;

import java.util.HashMap;
import java.util.List;

public class ExpandableListViewAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<String> specializelist;

    private HashMap<String, List<String>> specializeitemlist;//create list

    public ExpandableListViewAdapter(Context context, List<String> specializelist, HashMap<String, List<String>> specializeitemlist) {
        this.context = context;
        this.specializelist = specializelist;
        this.specializeitemlist = specializeitemlist;
    }

    @Override
    public int getGroupCount() {
        return this.specializelist.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this.specializeitemlist.get(this.specializelist.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.specializelist.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this.specializeitemlist.get(this.specializelist.get(groupPosition)).get(childPosition);
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
   //flection xml parent
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String specializetitle = (String) getGroup(groupPosition);
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.specialize_list_company,null);

        }
        TextView specialize_tv = convertView.findViewById(R.id.specialize_tv);
        specialize_tv.setText(specializetitle);
        return convertView;
    }
    //flection xml child
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String specializeitemtitle = (String) getChild(groupPosition,childPosition);
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.specialize_item_list,null);

        }
        TextView specializeitem_tv = convertView.findViewById(R.id.special_item_tv);
        specializeitem_tv.setText(specializeitemtitle);
        specializeitem_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Company_Specialize_List_Student.class);
                context.startActivity(intent);
            }
        });
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {

        return false;
    }
}

