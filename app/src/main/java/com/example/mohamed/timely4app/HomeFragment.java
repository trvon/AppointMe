package com.example.mohamed.timely4app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by mohamed on 4/1/17.
 */

public class HomeFragment extends Fragment{

    EditText comp;
    EditText id;
    EditText date;
    Button request;
    Button signup;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.login_signup_fragment,container,false);
        comp = (EditText) v.findViewById(R.id.companyNameET);
        id= (EditText) v.findViewById(R.id.idET);
        date = (EditText) v.findViewById(R.id.dateET);
        request = (Button) v.findViewById(R.id.request);
        request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Send request for comp child for the persons id
            }
        });
        signup = (Button) v.findViewById(R.id.signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Go to register fragment
            }
        });
        return v;
    }
}
