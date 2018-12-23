package com.example.will.app_for_child_demo.ListAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.will.app_for_child_demo.Entity.Child;
import com.example.will.app_for_child_demo.R;

import java.util.List;

public class ChildListAdapter extends RecyclerView.Adapter<ChildListAdapter. ChildViewHolder> {

    class ChildViewHolder extends RecyclerView.ViewHolder {
        private final TextView childItemView;

        private ChildViewHolder(View itemView) {
            super(itemView);
            childItemView = itemView.findViewById(R.id.textView);
        }
    }

    private final LayoutInflater mInflater;
    private List<Child> mAllChild; // Cached copy of words

    public ChildListAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    @Override
    public ChildViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new ChildViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ChildViewHolder holder, int position) {
        if (mAllChild != null) {
            Child current = mAllChild.get(position);
            holder.childItemView.setText(current.getFirstName());
        } else {
            // Covers the case of data not being ready yet.
            holder.childItemView.setText("No First Name");
        }
    }

    public void setAllChild(List<Child> allChild){
        mAllChild = allChild;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mAllChild != null)
            return mAllChild.size();
        else return 0;
    }
}