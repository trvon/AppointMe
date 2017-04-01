package com.example.mohamed.timely4app;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mohamed on 4/1/17.
 */

public class AvailableProsFragment extends Fragment {

    RecyclerView mRecyclerView;
    FirebaseDatabase database;
    MainActivity mainActivity;
    List<Recipient> arrayList;
    RecyclerView.LayoutManager mLayoutManager;
    private DatabaseReference mConditionRef;
    DatabaseReference myRef;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.available_pros_fragment, container, false);
        mRecyclerView = (RecyclerView) v.findViewById(R.id.list);
        // ArrayAdapter<> drs = new ArrayList<String>();
        arrayList = new ArrayList<>();
        final MyAdapter myAdapter = new MyAdapter(arrayList, mainActivity.getApplication());
        database = FirebaseDatabase.getInstance();
//            try{
//            if(mainActivity.company.equals("Anthem")){
        //Log.d("ANTHEM","SUCCESS");
        myRef = database.getReference("AnthemContacts");
//        for (int i = 0; i < 6; i++) {
//            Recipient r = new Recipient();
//            r.setfName(myRef.child(i + "").);
//            r.setlName(myRef.child(i + "").child("lName").toString());
//            r.setLocation(myRef.child(i + "").child("location").toString());
//
//            arrayList.add(r);
//        }
        //mConditionRef = myRef.child("AnthemContacts");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int position = 0;//Integer.parseInt(dataSnapshot.getKey());

                for (int i = 0; i < 6; i++) {
                    //myAdapter.updateList(i, dataSnapshot.child(i + "").child("availability").getValue(Integer.class));

                    Recipient r = new Recipient();
                    r.setfName(dataSnapshot.child(i+"").child("fName").getValue(String.class));
                    r.setlName(dataSnapshot.child(i+"").child("lName").getValue(String.class));
                    r.setLocation(dataSnapshot.child(i+"").child("location").getValue(String.class));

                    arrayList.add(r);


myAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



        mRecyclerView = (RecyclerView) v.findViewById(R.id.list);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        // use a Relative layout manager
        mLayoutManager = new LinearLayoutManager(mainActivity.getApplicationContext());

        mRecyclerView.setLayoutManager(mLayoutManager);

        mRecyclerView.setAdapter(myAdapter);


        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) context;
    }

    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
        private List<Recipient> mDataset;
        private Context ctx;

        public List<Recipient> getDataset() {
            return mDataset;
        }

        private DatabaseReference mConditionRef;

        // Provide a reference to the views for each data item
        // Complex data items may need more than one view per item, and
        // you provide access to all the views for a data item in a view holder
        public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            // each data item is just a string in this case
            public TextView mTextPersonName;
            public TextView mTextPersonLocation;
            public Button mAvail;


            @Override
            public void onClick(View view) {

            }

            public ViewHolder(View v) {
                super(v);
                mTextPersonName = (TextView) v.findViewById(R.id.textPersonName);
                mTextPersonLocation = (TextView) v.findViewById(R.id.textPersonLocation);
                mAvail = (Button) v.findViewById(R.id.avail);

            }

        }


        // Provide a suitable constructor (depends on the kind of dataset)
        public MyAdapter(final List<Recipient> myDataset, Context ctx) {
            this.ctx = ctx;
            this.mDataset = myDataset;


        }

        public void updateList(int index, int val){
            //mDataset.clear();

            //mDataset.get(index).setAvailability(val);
            this.notifyDataSetChanged();
        }

        // Create new views (invoked by the layout manager)
        @Override
        public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                       int viewType) {

            Log.d("myadapter.vh", "myadapter.v");

            // create a new view
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.custom_doctors, parent, false);
            // set the view's size, margins, paddings and layout parameters

            ViewHolder vh = new ViewHolder(v);
            return vh;
        }


        // Replace the contents of a view (invoked by the layout manager)
        @Override
        public void onBindViewHolder(final ViewHolder holder, final int position) {
            Log.d("onbind", "onbind");
            // - get element from your dataset at this position
            // - replace the contents of the view with that element
            holder.mTextPersonName.setText("Name : " + mDataset.get(position).getfName());
            holder.mTextPersonLocation.setText("Building # : " + mDataset.get(position).location);
            holder.mAvail.setText("Request me!");
            if (!mDataset.get(position).isAvailable) {
                holder.mAvail.setClickable(false);
            }
            holder.mAvail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(mainActivity, holder.mTextPersonName.getText().toString()+" Has been notified! ", Toast.LENGTH_SHORT).show();
                    //Send to Timer Fragment
                    //Also notify firebase recipient here
                    mainActivity.viewPager.setCurrentItem(2);
                }
            });

            //Gets key value
            //mDataset.get(position).setAvailablity(Integer.parseInt(mDatabase.child("users").child(Integer.toString(position)).getKey()));

            //mDataset.get(position).setAvailablity(Integer.parseInt(mDatabase.child("users").child(Integer.toString(position)).getKey()));
            //holder.mRecipientAvail.setText(mDataset.get(position).getAvailablity()+"");
            //holder.mRating.setNumStars(mDataset.get(position).getName());

        }

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return mDataset.size();
        }


    }
}
