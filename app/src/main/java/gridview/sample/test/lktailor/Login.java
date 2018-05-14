package gridview.sample.test.lktailor;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class Login extends Fragment {
        Button login_btn;
       EditText username,password;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
          View view = inflater.inflate(R.layout.fragment_login,container,false);
                    username = (EditText) view.findViewById(R.id.et_username);
                    password = (EditText) view.findViewById(R.id.et_password);
                    login_btn = (Button) view.findViewById(R.id.login_btn);

              login_btn.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                      Intent i = new Intent(getActivity(),Navigation_Activity.class);
                         startActivity(i);
                  }
              });
        return view;
    }
}
