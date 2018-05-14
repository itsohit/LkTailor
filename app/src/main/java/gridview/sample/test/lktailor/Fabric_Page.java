package gridview.sample.test.lktailor;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.transition.Visibility;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Spinner;


public class Fabric_Page extends Fragment    {
        Button filter_btn,suiting,shirting;
    FrameLayout frame_option;
    Spinner spinner1,spinner2;
    Button  search_btn;
    String []color={"Select All Colour","Red","Blue","Sky Blue","Yellow"};
    String []pattern={"Select All Pattern","Red","Blue","Sky Blue","Yellow"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vi= inflater.inflate(R.layout.fragment_fabric__page, container, false);
                filter_btn = (Button) vi.findViewById(R.id.filter_btn);
          frame_option = (FrameLayout) vi.findViewById(R.id.frame_filterbutton);
                suiting = (Button) vi.findViewById(R.id.suiting);
                shirting = (Button) vi.findViewById(R.id.shirting);
            search_btn = (Button) vi.findViewById(R.id.search_btn_filter);

        spinner1 = (Spinner) vi.findViewById(R.id.spinner1);
        spinner2 = (Spinner) vi.findViewById(R.id.spinner2);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item,color);
        adapter1.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner1.setAdapter(adapter1);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item,pattern);
        adapter2.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner2.setAdapter(adapter2);

        Suiting_fragment suiting_frag = new Suiting_fragment();
        FragmentManager manag = getFragmentManager();
        FragmentTransaction transa = manag.beginTransaction();
        transa.replace(R.id.frame_suiting,suiting_frag).commit();
            suiting.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    frame_option.setVisibility(View.INVISIBLE);
                    shirting.setBackground(getResources().getDrawable(R.drawable.disable_button));
                    shirting.setTextColor(getResources().getColor(R.color.Textcolor_black));
                    suiting.setBackground(getResources().getDrawable(R.drawable.red_background));
                    suiting.setTextColor(getResources().getColor(R.color.Textcolor_white));
                    Suiting_fragment suiting_fragment = new Suiting_fragment();
                    FragmentManager manager = getFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    transaction.replace(R.id.frame_suiting,suiting_fragment).commit();
                }
            });
              shirting.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                      frame_option.setVisibility(View.INVISIBLE);
                      suiting.setBackground(getResources().getDrawable(R.drawable.disable_button));
                      suiting.setTextColor(getResources().getColor(R.color.Textcolor_black));
                      shirting.setBackground(getResources().getDrawable(R.drawable.red_background));
                      shirting.setTextColor(getResources().getColor(R.color.Textcolor_white));
                      shirting_fragment shirting_fragment = new shirting_fragment();
                      FragmentManager manager = getFragmentManager();
                      FragmentTransaction trans = manager.beginTransaction();
                      trans.replace(R.id.frame_suiting,shirting_fragment).commit();
                  }
              });

           filter_btn.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   if(View.INVISIBLE==frame_option.getVisibility())
                   { frame_option.setVisibility(View.VISIBLE);
                   Filter_button_fragment filter = new Filter_button_fragment();
                   FragmentManager fm = getFragmentManager();
                   FragmentTransaction transaction = fm.beginTransaction();
                     transaction.replace(R.id.frame_filterbutton,filter).commit();}
                   else{
                       frame_option.setVisibility(View.INVISIBLE);
                   }
               }
           });
            search_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    frame_option.setVisibility(View.INVISIBLE);
                }
            });
          return vi;
    }
}
