package gridview.sample.test.lktailor;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Login_Activity extends AppCompatActivity implements TextView.OnEditorActionListener {
        Button login;
      TextView forget;
    LkDatabaseClass dbclass;
     ImageView registration;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    //      ImageView reg;
      String user;
    EditText username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);
        login = (Button) findViewById(R.id.login_btn_login_page);
         forget = (TextView) findViewById(R.id.forget_login_page_tv);
        registration = (ImageView) findViewById(R.id.registration_login_page);
            username= (EditText) findViewById(R.id.edit_username_login);
           password = (EditText) findViewById(R.id.edit_password_login);
         dbclass = new LkDatabaseClass(this);


    }

    @Override
    protected void onStart() {
        super.onStart();
            password.setOnEditorActionListener(this);
        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Login_Activity.this,Register_Activity.class);
                startActivity(i);
                overridePendingTransition(R.anim.right_in,R.anim.left_out);
            }
        });
        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login_Activity.this,Forget_page.class));
                overridePendingTransition(R.anim.left_in,R.anim.right_out);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login_Activity.this.loginOperation();
            }
        });
    }

    private Boolean checkValidation(String e){
        Pattern p = Pattern.compile(emailPattern);
        Matcher m = p.matcher(e);
         if(!m.find())
             return true;
        return false;
    }
    private void loginOperation(){
        user= username.getText().toString().trim();
        if(user.toString().length()==0 ){
            username.setError("Invalid Email id");
            username.setFocusable(true);}
        else if(Login_Activity.this.checkValidation(user)){
            username.setError("Invalid Email id");
            username.setFocusable(true); }
        else if (password.getText().toString().length()==0)
            password.setError("Invalid Password");
        else if(dbclass.Login(username.getText().toString().trim(),password.getText().toString().trim())){
            Toast.makeText(Login_Activity.this,"Wrong Email id, Password,Try Again",Toast.LENGTH_SHORT).show();
            username.setText("");
            password.setText("");
        }else{
            startActivity(new Intent(Login_Activity.this, Navigation_Activity.class));
            overridePendingTransition(R.anim.right_in,R.anim.left_out);
        }
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if(actionId == EditorInfo.IME_ACTION_GO)
                loginOperation();
        return false;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
