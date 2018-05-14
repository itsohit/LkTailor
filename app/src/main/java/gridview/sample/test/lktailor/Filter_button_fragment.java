package gridview.sample.test.lktailor;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class Filter_button_fragment extends Fragment {
    Spinner spinner1,spinner2;
        String []color={"Select All Colour","Red","Blue","Sky Blue","Yellow"};
        String []pattern={"Select All Pattern","Red","Blue","Sky Blue","Yellow"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_filter_button_fragment, container, false);
                spinner1 = (Spinner) v.findViewById(R.id.spinner1);
                spinner2 = (Spinner) v.findViewById(R.id.spinner2);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item,color);
            adapter1.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner1.setAdapter(adapter1);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item,pattern);
        adapter2.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner2.setAdapter(adapter2);
        return v;
    }
}
