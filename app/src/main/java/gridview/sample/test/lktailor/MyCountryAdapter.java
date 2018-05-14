package gridview.sample.test.lktailor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by IT sohit on 8/31/2017.
 */

class MyCountryAdapter extends BaseAdapter {
        String []name;
     Context c;
   MyCountryAdapter(Context c,String []nm){
            this.c=c;
          name=nm;
   }
    @Override
    public int getCount() {
        return name.length;
    }

    @Override
    public Object getItem(int position) {
        return name[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
          if(convertView==null) {
              LayoutInflater layoutInflater = (LayoutInflater) c.getSystemService(c.LAYOUT_INFLATER_SERVICE);
                    convertView = layoutInflater.inflate(R.layout.spinner_text,parent,false);
          }
        TextView tv = (TextView) convertView.findViewById(R.id.textview_spinner);
          tv.setText(name[position]);
        return tv;
    }
}
