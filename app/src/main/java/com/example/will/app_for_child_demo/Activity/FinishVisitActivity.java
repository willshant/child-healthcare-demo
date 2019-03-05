package com.example.will.app_for_child_demo.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.will.app_for_child_demo.Entity.Child;
import com.example.will.app_for_child_demo.Entity.HomeVisit;
import com.example.will.app_for_child_demo.R;

public class FinishVisitActivity extends AppCompatActivity {

    private static Child child;

    private Button goBack;
    private Button goNext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_visit_finish);

        getIncomingIntent();

        goBack = findViewById(R.id.finish_backto_childmain);
        goNext = findViewById(R.id.finish_continue);

        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FinishVisitActivity.this, ChildMainActivity.class);
                intent.putExtra("child_clicked", child);
                startActivity(intent);
            }
        });

        goNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FinishVisitActivity.this, HomeVisitRegisterActivity.class);
                intent.putExtra("register_home_visit_child", child);
                startActivity(intent);
            }
        });

    }

    private void getIncomingIntent() {
        if (getIntent().hasExtra("visit_result_child")) {
            child = (Child) getIntent().getSerializableExtra("visit_result_child");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.item_home) {
            Intent intent = new Intent(FinishVisitActivity.this, MainActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
