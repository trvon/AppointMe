package com.example.mohamed.timely4app;

import android.content.Context;
import android.graphics.Rect;
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
import android.widget.ImageView;
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
    DatabaseReference myRef2;
    String timeIn;
    String timeOut;



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
        myRef2 = database.getReference("AnthemUser");

        //myRef = database.getReference("AnthemUser");
        //myRef.child(0+"").setValue();
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

                for (int i = 0; i < dataSnapshot.getChildrenCount(); i++) {
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

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                timeIn = dataSnapshot.child(0+"").child("timeIn").getValue(String.class);
                timeOut = dataSnapshot.child(0+"").child("timeOut").getValue(String.class);

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
        SpacesItemDecoration dividerItemDecoration = new SpacesItemDecoration(30);
        mRecyclerView.addItemDecoration(dividerItemDecoration);

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
            public TextView mHours;
            public Button mAvail;
            public ImageView rachel;


            @Override
            public void onClick(View view) {

            }

            public ViewHolder(View v) {
                super(v);
                mTextPersonName = (TextView) v.findViewById(R.id.textPersonName);
                mTextPersonLocation = (TextView) v.findViewById(R.id.textPersonLocation);
                mAvail = (Button) v.findViewById(R.id.avail);
                mHours = (TextView) v.findViewById(R.id.hours);
                rachel = (ImageView) v.findViewById(R.id.rsz_rachel);

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
            holder.mTextPersonLocation.setText("Floor level : " + mDataset.get(position).location);
            holder.mAvail.setText("Request "+mDataset.get(position).getfName());
            holder.mHours.setText("Availability "+timeIn+"AM until "+timeOut+ " PM");
            Log.d("clickable",mDataset.get(position).getAvailable()+"");
            //holder.mAvail.setEnabled(mDataset.get(position).getAvailable());
            holder.mAvail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if(Integer.parseInt(mainActivity.timeA.substring(0,1)) > Integer.parseInt(timeOut)){
                        Toast.makeText(mainActivity,mDataset.get(position).getfName() +" Is not available at this time ",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Log.d("starboy", timeIn);
                        Toast.makeText(mainActivity, holder.mTextPersonName.getText().toString() + " Has been notified! ", Toast.LENGTH_SHORT).show();
                        //Send to Timer Fragment
                        //Also notify firebase recipient here
                        mainActivity.viewPager.setCurrentItem(3);

                        User u = new User(mainActivity.nameA, mainActivity.companyA, "d");
                        u.setWhyImHere(mainActivity.why);
                        u.setDate(mainActivity.date);
                        u.setTime(mainActivity.timeA);
                        myRef2.child(0 + "").setValue(u);
                    }
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

    public class SpacesItemDecoration extends RecyclerView.ItemDecoration {
        private int space;

        public SpacesItemDecoration(int space) {
            this.space = space;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            outRect.left = space;
            outRect.right = space;
            outRect.bottom = space;

            // Add top margin only for the first item to avoid double space between items
            if(parent.getChildAdapterPosition(view) == 0)
                outRect.top = space;
        }
    }

}
