package com.example.will.app_for_child_demo.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.will.app_for_child_demo.Converter.Converters;
import com.example.will.app_for_child_demo.Entity.Child;
import com.example.will.app_for_child_demo.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ChildMainActivity extends AppCompatActivity {

    private static Child child;

    public static final int EDIT_CHILD_ACTIVITY_REQUEST_CODE = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_main);
        getIncomingIntent();
    }

    private void getIncomingIntent() {
        if (getIntent().hasExtra("child_clicked")) {
            child = (Child) getIntent().getSerializableExtra("child_clicked");
            setChildPreview();
            setChildDetail();
        }
    }

    private void setChildPreview() {
        ImageView gender = findViewById(R.id.preview_gender);
        TextView name = findViewById(R.id.preview_name);
        TextView dni = findViewById(R.id.preview_dni);
        TextView age = findViewById(R.id.preview_age);
        Button editInfo = findViewById(R.id.preview_edit_child);
        gender.setImageResource(child.isGender() ? R.mipmap.female : R.mipmap.male);
        name.setText("Name: " + child.getName());
        dni.setText("DNI: " + child.getDni());
        age.setText("Age: " + Converters.getAge(child.getBirthday()));
        editInfo.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChildMainActivity.this, NewChildActivity.class);
                intent.putExtra("edit_child", child);
                startActivityForResult(intent, EDIT_CHILD_ACTIVITY_REQUEST_CODE);
            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == EDIT_CHILD_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            Child child = new Child(data.getStringExtra(NewChildActivity.NAME),
                    new java.sql.Date(Long.valueOf(data.getStringExtra(NewChildActivity.BIRTHDAY))),
                    Boolean.valueOf(data.getStringExtra(NewChildActivity.GENDER)),
                    data.getStringExtra(NewChildActivity.DNI),
                    Double.valueOf(data.getStringExtra(NewChildActivity.WEIGHT)),
                    data.getStringExtra(NewChildActivity.MOM_NAME),
                    data.getStringExtra(NewChildActivity.LOCATION),
                    data.getStringExtra(NewChildActivity.COMMUNITY),
                    Boolean.valueOf(data.getStringExtra(NewChildActivity.FACILITY)),
                    Boolean.valueOf(data.getStringExtra(NewChildActivity.DISABILITY))
            );
            int id = Integer.valueOf(data.getStringExtra(NewChildActivity.ID));
            if (id != -1) {
                child.setId(id);
            }
            MainActivity.mChildViewModel.update(child);
            Intent refresh = new Intent(this, ChildMainActivity.class);
            refresh.putExtra("child_clicked", child);
            startActivity(refresh);
            this.finish();
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG).show();
        }
    }

    private void setChildDetail() {
        ImageView nutriStatus = findViewById(R.id.detail_nutri_status);
        Button startHomeVisit = findViewById(R.id.detail_start_home_visit);
        Button registerIndicator = findViewById(R.id.detail_register_home_visit);
        TextView nextHomeVisit = findViewById(R.id.detail_next_home_visit);
        TextView nextCheckup = findViewById(R.id.detail_next_health_checkup);
        TextView nextVaccine = findViewById(R.id.detail_next_vaccine);
        TextView nextDeworm = findViewById(R.id.detail_next_deworming);
        TextView illDia = findViewById(R.id.detail_illness_dia);
        TextView illMal = findViewById(R.id.detail_illness_mal);
        TextView illFlu = findViewById(R.id.detail_illness_flu);
        TextView illPne = findViewById(R.id.detail_illness_pne);
        TextView illTub = findViewById(R.id.detail_illness_tub);
        TextView phyDev = findViewById(R.id.detail_physical_development);
        TextView lanDev = findViewById(R.id.detail_language_development);
        nextHomeVisit.setText(new SimpleDateFormat("MM-dd-yyyy").format(child.getDateVisit()));
        nextHomeVisit.setBackgroundColor(child.isFinished() ?
                getResources().getColor(R.color.green) : Converters.ifPassedToday(child.getDateVisit()) ?
                getResources().getColor(R.color.red) : Converters.ifWithinThirtyDays(child.getDateVisit()) ?
                getResources().getColor(R.color.yellow) : getResources().getColor(R.color.green));
        nextCheckup.setText(new SimpleDateFormat("MM-dd-yyyy").format(child.getDateCheck()));
        nextCheckup.setBackgroundColor(Converters.ifPassedToday(child.getDateCheck()) ? getResources().getColor(R.color.red) :
                Converters.ifWithinThirtyDays(child.getDateCheck()) ? getResources().getColor(R.color.yellow) : getResources().getColor(R.color.green));
        nextDeworm.setText(new SimpleDateFormat("MM-dd-yyyy").format(child.getDateDewarm()));
        nextDeworm.setBackgroundColor(Converters.ifPassedToday(child.getDateDewarm()) ? getResources().getColor(R.color.red) :
                Converters.ifWithinThirtyDays(child.getDateDewarm()) ? getResources().getColor(R.color.yellow) : getResources().getColor(R.color.green));
                                nextVaccine(nextVaccine, child);

        illDia.setAlpha(child.isDiarrhea() ? 1 : 0);
        illMal.setAlpha(child.isMalaria() ? 1 : 0);
        illFlu.setAlpha(child.isFlu() ? 1 : 0);
        illPne.setAlpha(child.isPneumonia() ? 1 : 0);
        illTub.setAlpha(child.isTuberculosis() ? 1 : 0);
        if (!child.isPsysicalDev()) {
            phyDev.setText("Physical Development: \nGood");
            phyDev.setBackgroundColor(getResources().getColor(R.color.green));
        } else {
            phyDev.setText("Physical Development: \nDelayed");
            phyDev.setBackgroundColor(getResources().getColor(R.color.red));
        }
        if (!child.isLanguageDev()) {
            lanDev.setText("Language Development: \nGood");
            lanDev.setBackgroundColor(getResources().getColor(R.color.green));
        } else {
            lanDev.setText("Language Development: \nDelayed");
            lanDev.setBackgroundColor(getResources().getColor(R.color.red));
        }

        startHomeVisit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChildMainActivity.this, HomeVisitActivity.class);
                intent.putExtra("visit_child", child);
                startActivity(intent);
            }
        });

        registerIndicator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChildMainActivity.this, HomeVisitRegisterActivity.class);
                intent.putExtra("register_home_visit_child", child);
                startActivity(intent);
            }
        });
    }

//    private final String[] vaccines = {"bcg", "hvb", "penta1", "vop1", "todpt", "hib", "vop2", "penta2", "vop3", "spr", "ama"};
    private void nextVaccine(TextView nextVaccine, Child child) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(child.getBirthday());
        if (!child.isBcg() || !child.isHvb()) {
            c.add(Calendar.DATE, 0);
        } else if (!child.isPenta1() || !child.isVop1()) {
            c.add(Calendar.DATE, 60);
            nextVaccine.setText(sdf.format(c.getTime()));
        } else if (!child.isTodpt() || !child.isHib() || !child.isVop2()) {
            c.add(Calendar.DATE, 90);
        } else if (!child.isPenta2() || !child.isVop3()) {
            c.add(Calendar.DATE, 120);
        } else if (!child.isSpr() || !child.isAma()) {
            c.add(Calendar.DATE, 360);
        } else {
            c.add(Calendar.DATE, 360);
            nextVaccine.setText(sdf.format(c.getTime()));
            nextVaccine.setBackgroundColor(getResources().getColor(R.color.green));
            return;
        }
        nextVaccine.setText(sdf.format(c.getTime()));
        nextVaccine.setBackgroundColor(Converters.ifWithinThirtyDays(c.getTime()) ?
                getResources().getColor(R.color.yellow) : Converters.ifPassedToday(c.getTime()) ?
                getResources().getColor(R.color.green) : getResources().getColor(R.color.red));
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
            Intent intent = new Intent(ChildMainActivity.this, MainActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
