package com.example.android.horizontalpaging;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.android.horizontalpaging.WiFiItemFragment.OnListFragmentInteractionListener;
import com.example.android.horizontalpaging.dummy.DummyContent.DummyItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class WiFiRecyclerViewAdapter extends RecyclerView.Adapter<WiFiRecyclerViewAdapter.ViewHolder> {

    private List<DummyItem> mValues;
    private final WiFiItemFragment.OnListFragmentInteractionListener mListener;

    public WiFiRecyclerViewAdapter(List<DummyItem> items, WiFiItemFragment.OnListFragmentInteractionListener mListener) {
        this.mValues = items;
        this.mListener = mListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_wifiitem, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final DummyItem dummyItem = mValues.get(position);
        holder.mItem = dummyItem;
        holder.mContentViewSsid.setText(dummyItem.ssid);
        holder.mContentViewCapabilities.setText(dummyItem.capabilities);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public void setItems(List<DummyItem> wiFiNetworks) {
        this.mValues = wiFiNetworks;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mContentViewSsid;
        public final TextView mContentViewCapabilities;
        public DummyItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mContentViewSsid = (TextView) view.findViewById(R.id.textViewSsid);
            mContentViewCapabilities = (TextView) view.findViewById(R.id.textViewCapabilities);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentViewSsid.getText() + "'";
        }
    }
}
