package gridview.sample.test.lktailor;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;


public class Testimonal_Fragment extends Fragment {
        RatingBar rate1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_testimonal_, container, false);
            rate1 = (RatingBar) view.findViewById(R.id.rating_1);

           rate1.setMax(5);
            return view;
    }
}
