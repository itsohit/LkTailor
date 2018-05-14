package gridview.sample.test.lktailor;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

class ImageAdapter extends PagerAdapter{
        int []img= {R.drawable.gallery_img1,R.drawable.gallery_img2,R.drawable.gallery_img3
                ,R.drawable.gallery_img4,R.drawable.gallery_img1,R.drawable.gallery_img2,
                R.drawable.gallery_img3,R.drawable.gallery_img4,R.drawable.gallery_img1,R.drawable.gallery_img2,
                R.drawable.gallery_img3,R.drawable.gallery_img4,};
      Context context;
//      LayoutInflater layoutInflater;
    ImageAdapter(Context context){
          this.context=context;
//          layoutInflater = LayoutInflater.from(context);
      }
    @Override
    public int getCount() {
        return img.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==((View)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
//         View view= layoutInflater.inflate(R.layout.pagerview_layout,container,false);
//        ImageView imageView = (ImageView) view.findViewById(R.id.pagerview_imageview);
//                imageView.setImageResource(img[position]);
//            container.addView(view);
          ImageView imageView = new ImageView(context);
            imageView.setImageResource(img[position]);
        ((ViewPager)container).addView(imageView,0);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }
}