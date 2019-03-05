package com.example.will.app_for_child_demo.ListAdapter;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.will.app_for_child_demo.Activity.ChildMainActivity;
import com.example.will.app_for_child_demo.Converter.Converters;
import com.example.will.app_for_child_demo.Converter.MyApplication;
import com.example.will.app_for_child_demo.Entity.Child;
import com.example.will.app_for_child_demo.R;
import com.example.will.app_for_child_demo.Repository.HomeVisitRepository;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

// adapter fill data into views
public class ChildListAdapter extends RecyclerView.Adapter<ChildListAdapter. ChildViewHolder> {

    private final LayoutInflater mInflater;
    private List<Child> mAllChild; // Cached copy of words
    private Context mcontext;

    public ChildListAdapter(Context context) {
        mcontext = context;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public ChildViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new ChildViewHolder(itemView);
    }

    class ChildViewHolder extends RecyclerView.ViewHolder {
        private final ConstraintLayout parentLayout;

        private final ImageView genderImageView;
        private final TextView nameItemView;
        private final TextView ageItemView;
        private final TextView visitDayItemView;
        private final ImageView anemiaImageView;
        private final ImageView malnutriImageView;
        private final ImageView checkupImageView;

        // match a view holder to UI fields
        private ChildViewHolder(View itemView) {
            super(itemView);
            parentLayout = itemView.findViewById(R.id.parent_layout);

            genderImageView = itemView.findViewById(R.id.view_gender);
            ageItemView = itemView.findViewById(R.id.view_age);
            nameItemView = itemView.findViewById(R.id.view_name);
            visitDayItemView = itemView.findViewById(R.id.view_visit_date);
            anemiaImageView = itemView.findViewById(R.id.view_anemia);
            malnutriImageView = itemView.findViewById(R.id.view_malnutri);
            checkupImageView = itemView.findViewById(R.id.view_checkup);
        }
    }

    @Override
    public void onBindViewHolder(ChildViewHolder holder, int position) {
        if (mAllChild != null) {
            // load data to holder
            final Child current = mAllChild.get(position);
            holder.genderImageView.setImageResource(current.isGender() ? R.mipmap.female : R.mipmap.male);
            // get age
            holder.ageItemView.setText(Converters.getAge(current.getBirthday()));
            holder.nameItemView.setText(current.getName());
            // get visit date
//            String visitDateString = Integer.toString(visitDate.getMonth() + 1)
//                    + '/' + Integer.toString(visitDate.getDate())
//                    + '/' + Integer.toString(visitDate.getYear() + 1900);
//            holder.visitDayItemView.setText(visitDateString);
            holder.visitDayItemView.setText(new SimpleDateFormat("MM-dd-yyyy").format(current.getDateVisit()));
            holder.anemiaImageView.setImageResource(current.getHemoLevel() < 110 && current.getHemoLevel() != 0 ? R.mipmap.red_radio : R.mipmap.blue_radio);
            holder.malnutriImageView.setImageResource(current.getWeight() < 20 && current.getWeight() != 0 ? R.mipmap.red_radio : R.mipmap.blue_radio);
            holder.checkupImageView.setImageResource(Converters.ifPassedToday(current.getDateCheck()) ? R.mipmap.red_radio : R.mipmap.blue_radio);
            // onClick
            holder.parentLayout.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mcontext, ChildMainActivity.class);
                    intent.putExtra("child_clicked", current);
                    mcontext.startActivity(intent);
                }
            });
        } else {
            // Covers the case of data not being ready yet.
            holder.nameItemView.setText("Data not ready");
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