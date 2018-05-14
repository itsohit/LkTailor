package gridview.sample.test.lktailor;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class Aboutus extends Fragment {
        TextView header;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
          View v = inflater.inflate(R.layout.fragment_aboutus,container,false);
                header = (TextView) v.findViewById(R.id.text_view_aboutus_header);

          header.setText(Html.fromHtml("<font color=\"#000000\">ABOUT L&amp;K BESPOKE CUSTOM TAILORS </br> IN </font> <font color=\"#E01414\">Hong Kong</font>"));
        return v;
    }
}
