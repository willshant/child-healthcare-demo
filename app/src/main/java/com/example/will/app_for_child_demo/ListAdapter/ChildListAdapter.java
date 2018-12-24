package com.example.will.app_for_child_demo.ListAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.will.app_for_child_demo.Entity.Child;
import com.example.will.app_for_child_demo.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

// adapter fill data into views
public class ChildListAdapter extends RecyclerView.Adapter<ChildListAdapter. ChildViewHolder> {

    private final LayoutInflater mInflater;
    private List<Child> mAllChild; // Cached copy of words

    public ChildListAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    @Override
    public ChildViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new ChildViewHolder(itemView);
    }

    class ChildViewHolder extends RecyclerView.ViewHolder {
        private final TextView firstNameItemView;
        private final TextView lastNameItemView;
        private final TextView birthdayItemView;

        // match a view holder to UI fields
        private ChildViewHolder(View itemView) {
            super(itemView);
            firstNameItemView = itemView.findViewById(R.id.view_first_name);
            lastNameItemView = itemView.findViewById(R.id.view_last_name);
            birthdayItemView = itemView.findViewById(R.id.view_birthday);
        }
    }

    @Override
    public void onBindViewHolder(ChildViewHolder holder, int position) {
        if (mAllChild != null) {
            Child current = mAllChild.get(position);
            holder.firstNameItemView.setText(current.getFirstName());
            holder.lastNameItemView.setText(current.getLastName());
//            String birthday = Integer.toString(current.getBirthday().getMonth() + 1)
//                    + '/' + Integer.toString(current.getBirthday().getDate())
//                    + '/' + Integer.toString(current.getBirthday().getYear() + 1900);
//            holder.birthdayItemView.setText(birthday);
            holder.birthdayItemView.setText(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(current.getBirthday()));
        } else {
            // Covers the case of data not being ready yet.
            holder.firstNameItemView.setText("Data not ready");
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