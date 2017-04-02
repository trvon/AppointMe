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
    EditText password;
    Button request;
    Button signup;
    EditText why;
    FirebaseDatabase database;
    EditText time;
    MainActivity mainActivity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.login_signup_fragment,container,false);
        // Write a message to the database
        database = FirebaseDatabase.getInstance();
time = (EditText) v.findViewById(R.id.timea);
        password = (EditText) v.findViewById(R.id.password);
        comp = (EditText) v.findViewById(R.id.companyNameET);
        id= (EditText) v.findViewById(R.id.idET);
        date = (EditText) v.findViewById(R.id.dateET);
        //why = (EditText) v.findViewById(R.id.why) ;
        request = (Button) v.findViewById(R.id.request);
        request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Send request for comp child for the persons id
                User u = new User(id.getText().toString(),comp.getText().toString(),"d");
                u.setDate(date.getText().toString());
               // u.setWhyImHere(why.getText().toString());
                DatabaseReference myRef = database.getReference("AnthemUser");
                //myRef.child(0+"").setValue(u);
                mainActivity.nameA = id.getText().toString();
                mainActivity.companyA = comp.getText().toString();
               // mainActivity.why = why.getText().toString();
                mainActivity.date = date.getText().toString();
                mainActivity.timeA = time.getText().toString();

                //Toast.makeText(getActivity(),"Who are you visiting?",Toast.LENGTH_LONG).show();
                mainActivity.company = comp.getText().toString();
               // Log.d("test",comp.getText().toString());
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
        Recipient h  = new Recipient("Rachel", "Thompson",true);
        h.setLocation("Rm 200");
        myRef2.child(0+"").setValue(h);

//        Recipient r  = new Recipient("Samuel", "Wart",true);
//        r.setLocation("Rm 103");
//        myRef2.child(1+"").setValue(r);
//
//        Recipient a  = new Recipient("Chris", "Fallow",true);
//        a.setLocation("Rm 138");
//        myRef2.child(2+"").setValue(a);
//
//        Recipient b  = new Recipient("Emily", "Stevens",true);
//        b.setLocation("Rm 338");
//        myRef2.child(3+"").setValue(b);
//
//        Recipient c  = new Recipient("Amy", "Marshall",true);
//        c.setLocation("Rm 320");
//        myRef2.child(4+"").setValue(c);
//
//        Recipient d  = new Recipient("David", "Erickson",true);
//        d.setLocation("Rm 011");
//        myRef2.child(5+"").setValue(d);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) context;
    }
}
