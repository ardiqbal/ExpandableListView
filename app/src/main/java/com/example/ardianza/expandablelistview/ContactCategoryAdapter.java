package com.example.ardianza.expandablelistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by ardianza on 21/09/17.
 */

public class ContactCategoryAdapter extends BaseExpandableListAdapter{

    private Context mContext;
    private List<String> listDataHeader;
    private HashMap<String, List<ListItem>> listDataChild;

    public ContactCategoryAdapter(Context mContext, List<String> listDataHeader, HashMap<String, List<ListItem>> listDataChild) {
        this.mContext = mContext;
        this.listDataHeader = listDataHeader;
        this.listDataChild = listDataChild;
    }

    @Override
    public int getGroupCount() {
        return this.listDataHeader.size();
    }

    @Override
    public int getChildrenCount(int groupPos) {
        return this.listDataChild.get(this.listDataHeader.get(groupPos)).size();
    }

    @Override
    public Object getGroup(int groupPos) {
        return this.listDataHeader.get(groupPos);
    }

    @Override
    public Object getChild(int groupPos, int childPos) {
        return this.listDataChild.get(this.listDataHeader.get(groupPos))
                .get(childPos);
    }

    @Override
    public long getGroupId(int groupPos) {
        return groupPos;
    }

    @Override
    public long getChildId(int groupPos, int childPos) {
        return childPos;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPos, boolean b, View view, ViewGroup viewGroup) {
        String headerTitle = (String) getGroup(groupPos);
        if (view == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = infalInflater.inflate(R.layout.list_group, null);
        }

        TextView headerName = (TextView) view.findViewById(R.id.list_header_name);
        headerName.setText(headerTitle);

        return view;
    }

    @Override
    public View getChildView(int groupPos, int childPos, boolean isLastCHild, View view, ViewGroup viewGroup) {
        ListItem childText = (ListItem) getChild(groupPos, childPos);
        String txtName = childText.getContactName();

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) this.mContext
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_child, null);
        }
        TextView contactName = (TextView)view.findViewById(R.id.list_child_name);
        ImageView contactImage = (ImageView)view.findViewById(R.id.list_child_image);

        contactName.setText(txtName);
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
