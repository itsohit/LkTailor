package gridview.sample.test.lktailor;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener, ViewPager.OnPageChangeListener {
       ViewPager viewPager;
       TabLayout tab_layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.view_pager);
          tab_layout = (TabLayout) findViewById(R.id.tab_layout);
//        tab_layout.setupWithViewPager(viewPager);
         tab_layout.addTab(tab_layout.newTab().setText("Login"));
          tab_layout.addTab(tab_layout.newTab().setText("SignUp"));
          MyAdapter adapter = new MyAdapter(getSupportFragmentManager(),tab_layout.getTabCount());
          viewPager.setAdapter(adapter);

        tab_layout.setOnTabSelectedListener(this);
          viewPager.addOnPageChangeListener(this);

//        tab_layout.setupWithViewPager(viewPager);
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
            viewPager.setCurrentItem(tab.getPosition());    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        tab_layout.getTabAt(position).select();
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
