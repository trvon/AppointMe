package com.example.mohamed.timely4app;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by mohamed on 4/1/17.
 */

public class Form extends Fragment {
    TextView name;
    TextView email;
    TextView address;
    Button submitform;
    RadioGroup radioGroup;
    RadioButton rb;
    MainActivity mainActivity;
    EditText purpose;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_form,container,false);
        name = (TextView) v.findViewById(R.id.name);
        email = (TextView) v.findViewById(R.id.email);
        address = (TextView) v.findViewById(R.id.address);
        submitform = (Button) v.findViewById(R.id.submitform);

        purpose = (EditText) v.findViewById(R.id.purpose);
        rb = (RadioButton) v.findViewById(R.id.radioButton);
        rb.setChecked(true);

        name.setText("Cody Hill");
        email.setText("codyjhill99@uncc.edu");
        address.setText("5207 Sun River Rd. Charlotte, NC");
        submitform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Form stored please select who you want to set the Appt. with!",Toast.LENGTH_SHORT).show();
                mainActivity.viewPager.setCurrentItem(2);
                mainActivity.why = purpose.getText().toString();
            }
        });
        return v;


    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) context;
    }
}
