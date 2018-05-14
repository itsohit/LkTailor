package gridview.sample.test.lktailor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

/**
 * Created by IT sohit on 8/17/2017.
 */

class GridAdapter extends BaseAdapter{
   Context c;
      int []img={R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,
              R.drawable.img5,R.drawable.img6};
    public GridAdapter(Context context) {
            c=context;
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
         if(convertView==null){
             LayoutInflater in = (LayoutInflater) c.getSystemService(c.LAYOUT_INFLATER_SERVICE);
              convertView = in.inflate(R.layout.grid_layout,parent,false);
         }
        ImageView  im = (ImageView) convertView.findViewById(R.id.image_view_gridview);
           im.setImageResource(img[position]);
        return convertView;
    }
}
