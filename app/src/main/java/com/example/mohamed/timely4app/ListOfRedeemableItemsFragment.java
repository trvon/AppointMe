package com.example.mohamed.timely4app;

/**
 * Created by mohamed on 4/1/17.
 */


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by msalad on 3/30/2017.
 */

public class ListOfRedeemableItemsFragment extends Fragment {

    RecyclerView mRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.redeem_items_fragment,container,false);
        mRecyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);
        ArrayList<String> f = new ArrayList<String>();
        f.add("Starbucks");
        f.add("Subways");
        f.add("Chick Fil A");
        f.add("McDonalds");
        f.add("Insomina Cookies");
        f.add("Papa Johns");
        MyAdapterGrid mAdapter = new MyAdapterGrid(f,getContext());
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity().getApplicationContext(), 2));

        return v;
    }

    public class MyAdapterGrid extends RecyclerView.Adapter<MyAdapterGrid.ViewHolder> {
        private ArrayList<String> mDataset;
        private Context mContext;

        // Provide a reference to the views for each data item
        // Complex data items may need more than one view per item, and
        // you provide access to all the views for a data item in a view holder
        public  class ViewHolder extends RecyclerView.ViewHolder {
            // each data item is just a string in this case
            public LinearLayout mLinearLayout;
            public TextView mPodcastTv, mPubDateTv;
            public ImageButton mPodcastIb;
            public ImageView mPodcastIv;
            public ViewHolder(View v) {
                super(v);
                mPodcastTv = (TextView) v.findViewById(R.id.textView22);
                mPodcastIv = (ImageView) v.findViewById(R.id.imageView);
            }
        }

        // Provide a suitable constructor (depends on the kind of dataset)
        public MyAdapterGrid(ArrayList<String> myDataset, Context context) {
            mDataset = myDataset;
            mContext = context;
        }

        // Create new views (invoked by the layout manager)
        @Override
        public MyAdapterGrid.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            // create a new view

            View v = (View) LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_redeemable_item, parent, false);



            ViewHolder vh = new ViewHolder(v);
            return vh;
        }

        // Replace the contents of a view (invoked by the layout manager)
        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {
            // - get element from your dataset at this position
            // - replace the contents of the view with that element
            //TextView tv = (TextView) holder.mLinearLayout.findViewById(R.id.podcast_tv);
            holder.mPodcastTv.setText(mDataset.get(position));
            //Log.d("IMAGE URL", mDataset.get(position).getUrlToImage());

            holder.mPodcastIv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Log.d("PLAY", "PLAY" + mDataset.get(position).getUrlToMp3());
                    // new PlayPodcastAsync(MyAdapterGrid.this).execute(mDataset.get(position).getUrlToMp3());
                    ((MainActivity) mContext).viewPager.setCurrentItem(5);
                    Log.d("STARBUCK","STARBUCK");


                }
            });


            // if (!mDataset.get(position).getUrlToImage().toString().equals("")) {
            // Picasso.with(mContext).load(mDataset.get(position).getUrlToImage()).into(holder.mPodcastIv);

            // }
            if(position == 1){
                holder.mPodcastIv.setImageResource(R.drawable.subways);
            } else if(position == 2){
                holder.mPodcastIv.setImageResource(R.drawable.chickfila);
            } else if(position == 5){
                holder.mPodcastIv.setImageResource(R.drawable.papa);
            }else if(position == 0){
                holder.mPodcastIv.setImageResource(R.drawable.starbucksg);
            }else if(position == 3){
                holder.mPodcastIv.setImageResource(R.drawable.mcdonalds);
            }else if(position == 4){
                holder.mPodcastIv.setImageResource(R.drawable.insomnia);
            }

        }

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return mDataset.size();
        }
    }


}
