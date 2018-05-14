package gridview.sample.test.lktailor;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;


public class ArrayOfImage extends Fragment{

    GridView gridview;
    int[] img = {R.drawable.gallery_img1, R.drawable.gallery_img2, R.drawable.gallery_img3
            , R.drawable.gallery_img4, R.drawable.gallery_img1, R.drawable.gallery_img2,
            R.drawable.gallery_img3, R.drawable.gallery_img4, R.drawable.gallery_img1, R.drawable.gallery_img2,
            R.drawable.gallery_img3, R.drawable.gallery_img4,};
    ViewPager viewPager;
    //            MyPagerView imageAdapter;
    MyAdapterGridView adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_array_of_image, container, false);
        viewPager = (ViewPager) v.findViewById(R.id.view_imager);
        gridview = (GridView) v.findViewById(R.id.gridview_array_of);

        adapter = new MyAdapterGridView(v.getContext(), img);
        gridview.setAdapter(adapter);
//        v.setOnKeyListener(pressed);
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                  viewPager.setVisibility(View.VISIBLE);
                ImageAdapter adapter = new ImageAdapter(getContext());
                viewPager.setAdapter(adapter);
                 viewPager.setCurrentItem(position);
//                            Intent i = new Intent(getActivity(),ImagesFullScreen.class);
//                               i.putExtra("pos",img[position]);
//                              getContext().startActivity(i);
            }
        });
        return v;
    }
    @Override
    public void onResume() {
        super.onResume();

        if(getView() == null){
            return;
        }

        getView().setFocusableInTouchMode(true);
        getView().requestFocus();
        getView().setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK){
                    // handle back button's click listener
                      viewPager.setVisibility(View.INVISIBLE);
                    return true;
                }
                return false;
            }
        });
    }
//    View.OnKeyListener pressed = new View.OnKeyListener() {
//        @Override
//        public boolean onKey(View v, int keyCode, KeyEvent event) {
//            if( keyCode == KeyEvent.KEYCODE_BACK ){
//                // back to previous fragment by tag
//                viewPager.setVisibility(View.INVISIBLE);
//                return true;
//            }
//            return false;
//        }
//    };
}
