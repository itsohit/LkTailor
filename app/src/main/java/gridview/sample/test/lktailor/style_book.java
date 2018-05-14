package gridview.sample.test.lktailor;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;


public class style_book extends Fragment {
//      GridLayoutManager gridLayoutManager;
    GridView grid;
        GridAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
          View v = inflater.inflate(R.layout.fragment_style_book,container,false);
                grid = (GridView) v.findViewById(R.id.gridview);
//         gridLayoutManager = new GridLayoutManager(getContext(),GridLayoutManager.VERTICAL)
                adapter = new GridAdapter(this.getActivity());
                    grid.setAdapter(adapter);
        return v;
    }
}
