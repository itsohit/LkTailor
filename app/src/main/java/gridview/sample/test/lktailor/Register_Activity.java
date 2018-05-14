package gridview.sample.test.lktailor;

import android.content.Intent;
import android.preference.EditTextPreference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Register_Activity extends AppCompatActivity {
        ImageView back,login;
      TextView registration;
    Spinner country;
    LkDatabaseClass dbclass;
    String []country_nm={"Select Country","India","Afghanistan","Albania","Algeria","Andorra","Angola","Antigua and Barbuda",
            "Argentina","Armenia"};
    String email_id ="[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
      EditText username,password,again_password,contactno,email,address;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_);
            back = (ImageView) findViewById(R.id.registration_back_btn);
          login = (ImageView) findViewById(R.id.registration_loginbtn);
        registration = (TextView) findViewById(R.id.registration_btn);
            country = (Spinner) findViewById(R.id.spinner_country);
         again_password = (EditText) findViewById(R.id.et_password_again_registration);
          email = (EditText) findViewById(R.id.et_email_id_registration);
          username = (EditText) findViewById(R.id.et_username_registration);
          password = (EditText) findViewById(R.id.et_password_registration);
          contactno = (EditText) findViewById(R.id.et_contact_no_registration);
        address = (EditText) findViewById(R.id.et_address_registration);
          dbclass = new LkDatabaseClass(this);
    }

    @Override
    protected void onStart() {
        super.onStart();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Register_Activity.this,Login_Activity.class));
                overridePendingTransition(R.anim.right_in,R.anim.left_out);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Register_Activity.this,Login_Activity.class));
                overridePendingTransition(R.anim.left_in,R.anim.right_out);
            }
        });

        ArrayAdapter adapter = new ArrayAdapter(this,R.layout.spinner_show_tv,country_nm);
        adapter.setDropDownViewResource(R.layout.drop_down_spinner);
        country.setAdapter(adapter);
//
//        MyCountryAdapter adapter = new MyCountryAdapter(this,country_nm);
//            country.setAdapter(adapter);

        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String em  = email.getText().toString().trim();
                String c = country_nm[country.getSelectedItemPosition()];
                if(username.getText().toString().length()==0) {
                    username.setError("Invalid User Name");
                    username.setFocusable(true);}
                else if (password.getText().toString().length()==0)
                {    password.setError("Invalid Password");
                    password.setFocusable(true);}
                else if (again_password.getText().toString().length()==0)
                {    again_password.setError("Invalid Password");
                    again_password.setFocusable(true);}
                else if (contactno.getText().toString().length()==0)
                {    contactno.setError("Invalid Password");
                    contactno.setFocusable(true);}
                else if (em.length()==0)
                { email.setError("Invalid Email id");
                    email.setFocusable(true);}
                else if (Register_Activity.this.checkValidation(em))
                { email.setError("Invalid Email id");
                    email.setFocusable(true);}
                else if (address.getText().toString().length()==0) {
                    address.setError("Invalid Email id");
                    address.setFocusable(true);}
                else if(country.getSelectedItemPosition()==0)
                    Toast.makeText(Register_Activity.this,"Select Country",Toast.LENGTH_SHORT).show();
                else if(dbclass.registration(email.getText().toString().trim(),password.getText().toString().trim(),username.getText().toString().trim(),contactno.getText().toString().trim(),address.getText().toString().trim(),c)){
                    Toast.makeText(Register_Activity.this,"Registration Fail",Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent  i = new Intent(Register_Activity.this,Login_Activity.class);
                    startActivity(i); }
            }
        });
    }
    private Boolean checkValidation(String e){
        Pattern p = Pattern.compile(email_id);
        Matcher m = p.matcher(e);
         if(!m.find())
             return true;
        return false;
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(Register_Activity.this,Login_Activity.class));
        overridePendingTransition(R.anim.right_in,R.anim.left_out);
        super.onBackPressed();
    }
}
