package gridview.sample.test.lktailor;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by IT sohit on 8/16/2017.
 */

class MyAdapter extends FragmentStatePagerAdapter{
      int total;
    public MyAdapter(FragmentManager supportFragmentManager, int tabCount) {
       super(supportFragmentManager);
     total= tabCount;}

    @Override
    public Fragment getItem(int position) {
          switch(position){
              case 0:
                   Login login = new Login();
                    return login;
              case 1:
                    SignUp signup = new SignUp();
                      return signup;
              default:
                   return null;
          }
    }

    @Override
    public int getCount() {
        return total;
    }
}
