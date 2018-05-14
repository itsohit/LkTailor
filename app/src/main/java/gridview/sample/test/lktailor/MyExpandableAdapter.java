package gridview.sample.test.lktailor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by IT sohit on 8/17/2017.
 */

class MyExpandableAdapter extends BaseExpandableListAdapter {
      Context context;
    HashMap<String,List<String>> data;
        ArrayList<String> head;
    public MyExpandableAdapter(Context c, ArrayList h, HashMap<String, List<String>> list) {
                    this.context = c;
            data= list;
         head = h;
    }

    @Override
    public int getGroupCount() {
        return head.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return data.get(head.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return head.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return data.get(head.get(groupPosition)).get(childPosition);
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

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String s = (String) getGroup(groupPosition);
      if(convertView==null) {
          LayoutInflater in = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = in.inflate(R.layout.header_layot,parent,false);
      }
        TextView tv = (TextView) convertView.findViewById(R.id.header_textview);
          tv.setText(s);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String s = (String) getChild(groupPosition,childPosition);
        if(convertView==null) {
            LayoutInflater in = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = in.inflate(R.layout.child_textview,parent,false);
        }
        TextView tv = (TextView) convertView.findViewById(R.id.child_text);
        tv.setText(s);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
