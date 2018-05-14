package gridview.sample.test.lktailor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Forget_page extends AppCompatActivity implements TextView.OnEditorActionListener{
        ImageView back;
    Button forgetbtn;
    LkDatabaseClass databaseClass;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    EditText forget_email,pass,again_pass;
    LinearLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_page);
            back = (ImageView) findViewById(R.id.forget_back_btn);
          forgetbtn = (Button) findViewById(R.id.forget_btn_new_password);
                forget_email = (EditText) findViewById(R.id.forget_email);
                layout = (LinearLayout) findViewById(R.id.password_layout);
                pass = (EditText) findViewById(R.id.forget_password);
                again_pass = (EditText) findViewById(R.id.forget_confim_password);
                databaseClass = new LkDatabaseClass(this);

    }
    private Boolean checkValidation(String e){
        Pattern p = Pattern.compile(emailPattern);
        Matcher m = p.matcher(e);
         if(!m.find())
             return true;
        return false;
    }

    @Override
    protected void onStart() {
        super.onStart();
        forget_email.setOnEditorActionListener(this);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Forget_page.this,Login_Activity.class));
                overridePendingTransition(R.anim.left_in,R.anim.right_out);
            }
        });
        forgetbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Forget_page.this.checkEmail();
            }
        });
    }
    private void checkEmail(){
        final String email = forget_email.getText().toString().trim();
        if (email.length()==0)
            forget_email.setError("Invalid Email id");
        else if(Forget_page.this.checkValidation(email))
            forget_email.setError("Invalid Email id");
        else if(databaseClass.getCheckEmail(email)) {
            forget_email.setFocusable(true);
            Toast.makeText(Forget_page.this,"Email not Found Try Again",Toast.LENGTH_SHORT).show();
        }
        else {
            layout.setVisibility(View.VISIBLE);
            if(pass.getText().length()==0){
                pass.setFocusable(true); }
            else if(again_pass.getText().length()==0)
                again_pass.setError("Invalid Password");
            else if(!pass.getText().toString().trim().equals(again_pass.getText().toString())){
                pass.setText("");
                again_pass.setText("");
                Toast.makeText(Forget_page.this,"Password not Same Try Again",Toast.LENGTH_SHORT).show();
            }
            else if(databaseClass.updatePassword(email,pass.getText().toString().trim()))
                Toast.makeText(Forget_page.this,"Failed Forget password",Toast.LENGTH_SHORT).show();
            else {
                Intent  i = new Intent(Forget_page.this,Login_Activity.class);
                startActivity(i);
            }
    }
}

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
         if(actionId== EditorInfo.IME_ACTION_GO || actionId == EditorInfo.IME_ACTION_DONE){
             checkEmail();
         }
        return false;
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(Forget_page.this,Login_Activity.class));
        overridePendingTransition(R.anim.right_in,R.anim.left_out);
        super.onBackPressed();
    }
}
