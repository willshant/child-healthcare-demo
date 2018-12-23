package com.example.will.app_for_child_demo.Activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.will.app_for_child_demo.Entity.Child;
import com.example.will.app_for_child_demo.ListAdapter.ChildListAdapter;
import com.example.will.app_for_child_demo.R;
import com.example.will.app_for_child_demo.ViewModel.ChildViewModel;

import java.sql.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final int NEW_CHILD_ACTIVITY_REQUEST_CODE = 1;

    private ChildViewModel mChildViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final ChildListAdapter adapter = new ChildListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Get a new or existing ViewModel from the ViewModelProvider.
        mChildViewModel = ViewModelProviders.of(this).get(ChildViewModel.class);

        // Add an observer on the LiveData returned by getAllChild.
        // The onChanged() method fires when the observed data changes and the activity is
        // in the foreground.
        mChildViewModel.getAllChild().observe(this, new Observer<List<Child>>() {
            @Override
            public void onChanged(@Nullable final List<Child> children) {
                // Update the cached copy of the children in the adapter.
                adapter.setAllChild(children);
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NewChildActivity.class);
                startActivityForResult(intent, NEW_CHILD_ACTIVITY_REQUEST_CODE);
            }
        });

    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_CHILD_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            Child child = new Child(data.getStringExtra(NewChildActivity.FIRST_NAME),
                    data.getStringExtra(NewChildActivity.LAST_NAME), new Date(Long.valueOf(data.getStringExtra(NewChildActivity.BIRTHDAY))));
            mChildViewModel.insert(child);
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG).show();
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
