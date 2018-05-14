package gridview.sample.test.lktailor;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

/**
 * Created by IT sohit on 8/24/2017.
 */

public class ImagesFullScreen extends AppCompatActivity {
            ViewPager imageView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.image_full_screen);

          imageView = (ViewPager) findViewById(R.id.image_view_full_screen);

//        Intent intent = getIntent();
//           int position = intent.getExtras().getInt("pos");
//             ImageAdapter adapter = new ImageAdapter(getApplicationContext());
//                imageView.setAdapter(adapter);
//          imageView.setCurrentItem(position);
    }
}
