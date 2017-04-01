package com.example.mohamed.timely4app;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by mohamed on 4/1/17.
 */

public class HomeFragment extends Fragment{

    EditText comp;
    EditText id;
    EditText date;
    Button request;
    Button signup;
    FirebaseDatabase database;
    MainActivity mainActivity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.login_signup_fragment,container,false);
        // Write a message to the database
        database = FirebaseDatabase.getInstance();

        comp = (EditText) v.findViewById(R.id.companyNameET);
        id= (EditText) v.findViewById(R.id.idET);
        date = (EditText) v.findViewById(R.id.dateET);
        request = (Button) v.findViewById(R.id.request);
        request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Send request for comp child for the persons id
                User u = new User("Sammy",id.getText().toString(),"Pinochet");
                u.setDate(date.getText().toString());
                DatabaseReference myRef = database.getReference(comp.getText().toString());
                myRef.setValue(u);
                Toast.makeText(getActivity(),"Who are you visiting?",Toast.LENGTH_LONG).show();
                mainActivity.company = comp.getText().toString();
                Log.d("test",comp.getText().toString());
                mainActivity.viewPager.setCurrentItem(1);
                mainActivity.company = comp.getText().toString();



            }
        });
        signup = (Button) v.findViewById(R.id.signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Go to register fragment
            }
        });
        //callAnthemPros();


        return v;
    }

    public void callAnthemPros(){
        DatabaseReference myRef2 = database.getReference("AnthemContacts");
        Recipient h  = new Recipient("John", "Erickson",true);
        h.setLocation("Rm 238");
        myRef2.child(0+"").setValue(h);

        Recipient r  = new Recipient("John", "Erickson",true);
        r.setLocation("Rm 238");
        myRef2.child(1+"").setValue(r);

        Recipient a  = new Recipient("John", "Erickson",true);
        a.setLocation("Rm 238");
        myRef2.child(2+"").setValue(a);

        Recipient b  = new Recipient("John", "Erickson",true);
        b.setLocation("Rm 238");
        myRef2.child(3+"").setValue(b);

        Recipient c  = new Recipient("John", "Erickson",true);
        c.setLocation("Rm 238");
        myRef2.child(4+"").setValue(c);

        Recipient d  = new Recipient("John", "Erickson",true);
        d.setLocation("Rm 238");
        myRef2.child(5+"").setValue(d);

        Recipient e  = new Recipient("John", "Erickson",true);
        e.setLocation("Rm 238");
        myRef2.child(6+"").setValue(e);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) context;
    }
}
