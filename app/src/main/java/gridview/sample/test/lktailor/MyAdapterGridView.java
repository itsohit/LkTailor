package gridview.sample.test.lktailor;

import android.content.Context;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by IT sohit on 8/24/2017.
 */

class MyAdapterGridView extends BaseAdapter {
      Context c;
        int []img;
    public MyAdapterGridView(Context context,int []i) {
                c=context;
        img=i;
    }

    @Override
    public int getCount() {
        return img.length;
    }

    @Override
    public Object getItem(int position) {
        return img[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageview;
         if(convertView==null){
                 imageview = new ImageView(c);
               imageview.setLayoutParams(new GridView.LayoutParams(150,150));

//             LayoutInflater inflate = (LayoutInflater) c.getSystemService(c.LAYOUT_INFLATER_SERVICE);
//               convertView = inflate.inflate(R.layout.gridview_array_of,parent,false);
         }
           else
         {  imageview = (ImageView) convertView;   }
             imageview.setImageResource(img[position]);
//        ImageView imgview = (ImageView) convertView.findViewById(R.id.image_view_array_of);
//           imgview.setImageResource(img[position]);
        return imageview;
    }
}
