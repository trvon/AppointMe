package com.example.mohamed.timely4app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mohamed on 4/1/17.
 */

public class AvailableProsFragment extends Fragment{

    ListView list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.available_pros_fragment,container,false);
        list = (ListView) v.findViewById(R.id.list);
        ArrayList<String> drs = new ArrayList<String>();
        drs.add("Dr.Palto");
        drs.add("Dr.Amin");
        drs.add("Dr.Saufree");
        drs.add("Dr.Vission");
        drs.add("Dr.Johnson");
        drs.add("Dr.Amir");
        ArrayAdapter<String> p = new ArrayAdapter<String>(getActivity().getApplicationContext(),android.R.layout.simple_list_item_1,drs);
        list.setAdapter(p);
        return v;
    }
}
