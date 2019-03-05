package com.example.will.app_for_child_demo.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.will.app_for_child_demo.Entity.Child;
import com.example.will.app_for_child_demo.Entity.HomeVisit;
import com.example.will.app_for_child_demo.R;

public class HomeVisitActivity extends AppCompatActivity {

    private static Child child;

    private Spinner mSpinnerLanguage;
    private Spinner mSpinnerPhysical;
    private Button submitResult;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_visit_main);

        getIncomingIntent();

        mSpinnerLanguage = findViewById(R.id.home_visit_language);
        mSpinnerPhysical = findViewById(R.id.home_visit_physical);
        submitResult = findViewById(R.id.home_visit_sumbit);

        ArrayAdapter<CharSequence> disabilityAdapter = ArrayAdapter.createFromResource(this, R.array.development, android.R.layout.simple_spinner_item);
        disabilityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mSpinnerLanguage.setAdapter(disabilityAdapter);
        mSpinnerLanguage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        child.setLanguageDev(false); // good
                        break;
                    case 1:
                        child.setLanguageDev(true);// delayed
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        mSpinnerPhysical.setAdapter(disabilityAdapter);
        mSpinnerPhysical.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        child.setPsysicalDev(false); // no
                        break;
                    case 1:
                        child.setPsysicalDev(true); // yes
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        submitResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.mChildViewModel.update(child);

                Intent intent = new Intent(HomeVisitActivity.this, FinishVisitActivity.class);
                intent.putExtra("visit_result_child", child);
                startActivity(intent);
            }
        });


    }

    private void getIncomingIntent() {
        if (getIntent().hasExtra("visit_child")) {
            child = (Child) getIntent().getSerializableExtra("visit_child");
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
            Intent intent = new Intent(HomeVisitActivity.this, MainActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
