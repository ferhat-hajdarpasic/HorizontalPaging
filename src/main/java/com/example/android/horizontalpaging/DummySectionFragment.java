package com.example.android.horizontalpaging;

/**
 * Created by ferhat on 24/11/2015.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.horizontalpaging.dummy.DummyContent;

import java.util.ArrayList;
import java.util.List;

/**
 * A dummy fragment representing a section of the app, but that simply displays dummy text.
 * This would be replaced with your application's content.
 */
public class DummySectionFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    public static final String ARG_SECTION_NUMBER = "section_number";
    WiFiRecyclerViewAdapter wiFiRecyclerViewAdapter;

    public DummySectionFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main_dummy, container, false);
        RecyclerView recyclerView = (RecyclerView)rootView.findViewById(R.id.WiFiList);
        WiFiRecyclerViewAdapter adapter =  (WiFiRecyclerViewAdapter)recyclerView.getAdapter();
        final int sectionNumber = getArguments().getInt(ARG_SECTION_NUMBER);

        List<DummyContent.DummyItem> items = new ArrayList<DummyContent.DummyItem>();
        for(int i = 0; i < 15; i++) {
            items.add(new DummyContent.DummyItem("id" + i, "content"+i, "details"+i));
        }
        WiFiItemFragment.OnListFragmentInteractionListener mListener = new WiFiItemFragment.OnListFragmentInteractionListener() {
            @Override
            public void onListFragmentInteraction(DummyContent.DummyItem item) {
                Log.d("", "onListFragmentInteraction()");

            }
        };


        wiFiRecyclerViewAdapter = new WiFiRecyclerViewAdapter(items, mListener);
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.fragment_wifiitem_list, container, false);
        RecyclerView mRecyclerView =  (RecyclerView) view.findViewById(R.id.WiFiList);
//        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(wiFiRecyclerViewAdapter);

        Log.d("Section number", "" + sectionNumber);

        //dummyTextView.setText("HAJDARPASIC " + Integer.toString(sectionNumber));

        return view;
    }
}

