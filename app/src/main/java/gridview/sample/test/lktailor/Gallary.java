package gridview.sample.test.lktailor;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;


public class Gallary extends Fragment {
        GridView gallary_gridview;
    int []images = {R.drawable.gallery_img1,R.drawable.gallery_img2,R.drawable.gallery_img3,R.drawable.gallery_img4
            ,R.drawable.img1,R.drawable.img2};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
          View view = inflater.inflate(R.layout.fragment_gallary,container,false);
                  gallary_gridview = (GridView) view.findViewById(R.id.gallary_gridview);

                MyAdaptergallary adaptergallary = new MyAdaptergallary(getContext(),images);
            gallary_gridview.setAdapter(adaptergallary);

                gallary_gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            
                    }
                });
        return view;
    }

    private class MyAdaptergallary extends BaseAdapter {
          Context c ;
         int []img;
         String []names={"NO.L1","NO.L2","NO.L3","NO.L4","NO.L5","NO.L6"};
        public MyAdaptergallary(Context context,int []i) {
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
           if(convertView==null){
                 LayoutInflater in = (LayoutInflater) c.getSystemService(c.LAYOUT_INFLATER_SERVICE);
                 convertView = in.inflate(R.layout.gallary_girdview,parent,false);
           }
            ImageView image = (ImageView) convertView.findViewById(R.id.gridview_image);
            TextView text = (TextView) convertView.findViewById(R.id.gridview_text);
                image.setImageResource(img[position]);
              text.setText(names[position]);
            return convertView;
        }
    }
}
