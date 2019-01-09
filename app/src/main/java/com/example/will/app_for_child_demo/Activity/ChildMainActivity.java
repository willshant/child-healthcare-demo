package com.example.will.app_for_child_demo.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.will.app_for_child_demo.Entity.Child;
import com.example.will.app_for_child_demo.R;

public class ChildMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_main);

        getIncomingIntent();
    }

    private void getIncomingIntent() {
        if (getIntent().hasExtra("child_clicked")) {
            Child child = (Child) getIntent().getSerializableExtra("child_clicked");
            setChildPreview(child);
        }
    }

    private void setChildPreview(Child child) {
        TextView name = findViewById(R.id.child_name);
        name.setText(child.getFirstName() + " " + child.getLastName());

    }
}
