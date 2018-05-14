package gridview.sample.test.lktailor;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class ContactUs extends Fragment implements View.OnClickListener {
    Button mailing,contactus,feedback,submit;
      EditText firstname,lastname,address1,address2,country,company,email,phone,fax,comment;
    TextView customertype;
      RadioGroup radioGroup;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View views= inflater.inflate(R.layout.fragment_contact_us, container, false);
            mailing = (Button) views.findViewById(R.id.mailing_add);
          contactus = (Button) views.findViewById(R.id.contact_us);
            feedback = (Button) views.findViewById(R.id.feedback);
            firstname= (EditText)views.findViewById(R.id.contact_us_first_name);
            lastname= (EditText)views.findViewById(R.id.contact_us_lastname);
            address1= (EditText)views.findViewById(R.id.contact_us_address_1);
            address2= (EditText)views.findViewById(R.id.contact_us_address_2);
            country= (EditText)views.findViewById(R.id.contact_us_country);
            company= (EditText)views.findViewById(R.id.contact_us_company);
            email= (EditText)views.findViewById(R.id.contact_us_email);
            phone= (EditText)views.findViewById(R.id.contact_us_phone);
        comment = (EditText) views.findViewById(R.id.contact_us_comment_et);
         customertype = (TextView) views.findViewById(R.id.contact_us_tv);
         radioGroup = (RadioGroup) views.findViewById(R.id.contact_us_radio_grp);
            submit = (Button) views.findViewById(R.id.contact_us_submit);

          mailing.setOnClickListener(this);
            contactus.setOnClickListener(this);
          feedback.setOnClickListener(this);
        submit.setOnClickListener(this);
            return views;
    }

    @Override
    public void onClick(View v) {
        phone.setVisibility(View.VISIBLE);
        customertype.setVisibility(View.VISIBLE);
        comment.setVisibility(View.VISIBLE);
        radioGroup.setVisibility(View.VISIBLE);
        switch(v.getId()){
            case R.id.mailing_add:
                contactus.setBackground(getResources().getDrawable(R.drawable.disable_button));
                contactus.setTextColor(getResources().getColor(R.color.Textcolor_black));
                feedback.setBackground(getResources().getDrawable(R.drawable.disable_button));
                feedback.setTextColor(getResources().getColor(R.color.Textcolor_black));
                mailing.setBackground(getResources().getDrawable(R.drawable.red_background));
                mailing.setTextColor(getResources().getColor(R.color.Textcolor_white));
                phone.setVisibility(View.GONE);
                customertype.setVisibility(View.GONE);
                comment.setVisibility(View.GONE);
                radioGroup.setVisibility(View.GONE);
                break;
            case R.id.contact_us:
                mailing.setBackground(getResources().getDrawable(R.drawable.disable_button));
                mailing.setTextColor(getResources().getColor(R.color.Textcolor_black));
                feedback.setBackground(getResources().getDrawable(R.drawable.disable_button));
                feedback.setTextColor(getResources().getColor(R.color.Textcolor_black));
                contactus.setBackground(getResources().getDrawable(R.drawable.red_background));
                contactus.setTextColor(getResources().getColor(R.color.Textcolor_white));
                customertype.setVisibility(View.GONE);
                comment.setVisibility(View.GONE);
                radioGroup.setVisibility(View.GONE);
                break;
            case R.id.feedback:
                mailing.setBackground(getResources().getDrawable(R.drawable.disable_button));
                mailing.setTextColor(getResources().getColor(R.color.Textcolor_black));
                contactus.setBackground(getResources().getDrawable(R.drawable.disable_button));
                contactus.setTextColor(getResources().getColor(R.color.Textcolor_black));
                feedback.setBackground(getResources().getDrawable(R.drawable.red_background));
                feedback.setTextColor(getResources().getColor(R.color.Textcolor_white));
                break;
            case R.id.contact_us_submit:
                if(firstname.getText().toString().length()==0)
                    firstname.setError("Invalid Name");
                else if (lastname.getText().toString().length()==0)
                    lastname.setError("Invalid Name");
                else if(address1.getText().toString().length()==0)
                    address1.setError("Empty Address");
                else if (address2.getText().toString().length()==0)
                    address2.setError("Empty Address");
                else if(country.getText().toString().length()==0)
                    country.setError("Invalid Country");
                else if (company.getText().toString().length()==0)
                    company.setError("Invalid Company");
                else if(email.getText().toString().length()==0)
                    email.setError("Invalid Email");
                else if (phone.getText().toString().length()==0)
                    phone.setError("Invalid Phone");
                else if (fax.getText().toString().length()==0)
                    fax.setError("Invalid Fax");
                else if (comment.getText().toString().length()==0)
                    comment.setError("Empty Comment");
                else {
                    Toast.makeText(getContext(),"Successfull",Toast.LENGTH_SHORT).show();
                }
                break;
            default:
        }
    }
}
