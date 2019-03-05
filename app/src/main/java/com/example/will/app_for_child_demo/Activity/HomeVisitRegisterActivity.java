package com.example.will.app_for_child_demo.Activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.TextView;

import com.example.will.app_for_child_demo.Converter.Converters;
import com.example.will.app_for_child_demo.Entity.Child;
import com.example.will.app_for_child_demo.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class HomeVisitRegisterActivity extends AppCompatActivity {

    private static Child child;

    TextView height, weight, hemoLevel;
    TextView vacBcg, vacHvb, vacPenta1, vacVop1, vacTodpt, vacHib, vacVop2, vacPenta2, vacVop3, vacSpr, vacAma;
    TextView nextHomeVisit, nextCheckup, nextDeworming;
    CheckBox checkDia, checkMal, checkFlu, checkPne, checkTub;
    Button registerHomeVisit;

    Calendar calendar = Calendar.getInstance();
    final static String myFormat = "MM/dd/yyyy";
    final static SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
    DatePickerDialog.OnDateSetListener dateHomeVisit, dateCheckup, dateDewarm;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homevisit_register);

        height = findViewById(R.id.register_home_visit_height);
        weight = findViewById(R.id.register_home_visit_weight);
        hemoLevel = findViewById(R.id.register_home_visit_hemo_level);
        vacBcg = findViewById(R.id.register_home_visit_BCG);
        vacHvb = findViewById(R.id.register_home_visit_HvB);
        vacPenta1 = findViewById(R.id.register_home_visit_Penta1);
        vacVop1 = findViewById(R.id.register_home_visit_VOP1);
        vacTodpt = findViewById(R.id.register_home_visit_TetraoDPT);
        vacHib = findViewById(R.id.register_home_visit_HiB);
        vacVop2 = findViewById(R.id.register_home_visit_VOP2);
        vacPenta2 = findViewById(R.id.register_home_visit_Penta2);
        vacVop3 = findViewById(R.id.register_home_visit_VOP3);
        vacSpr = findViewById(R.id.register_home_visit_SPR);
        vacAma = findViewById(R.id.register_home_visit_AMA);
        nextHomeVisit = findViewById(R.id.register_home_visit_next_home_visit);
        nextCheckup = findViewById(R.id.register_home_visit_next_checkup);
        nextDeworming = findViewById(R.id.register_home_visit_next_deworming);
        checkDia = findViewById(R.id.register_home_visit_Diarrhea);
        checkMal = findViewById(R.id.register_home_visit_Malaria);
        checkFlu = findViewById(R.id.register_home_visit_Flu);
        checkPne = findViewById(R.id.register_home_visit_Pneumonia);
        checkTub = findViewById(R.id.register_home_visit_Tuberculosis);
        registerHomeVisit = findViewById(R.id.register_home_visit_submit);

        setOnclickListeners();

        getIncomingIntent();

    }

    private void setOnclickListeners() {
        vacBcg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (child.isBcg()) {
                    child.setBcg(false);
                } else {
                    child.setBcg(true);
                }
                calendar.setTime(child.getBirthday());
                calendar.add(Calendar.DATE, 0);
                vacBcg.setBackgroundColor(child.isBcg() ?
                        getResources().getColor(R.color.green) : Converters.ifPassedToday(calendar.getTime()) ?
                        getResources().getColor(R.color.red) : Converters.ifWithinThirtyDays(calendar.getTime()) ?
                        getResources().getColor(R.color.yellow) : getResources().getColor(R.color.green));
            }
        });
        vacHvb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (child.isHvb()) {
                    child.setHvb(false);
                } else {
                    child.setHvb(true);
                }
                calendar.setTime(child.getBirthday());
                calendar.add(Calendar.DATE, 0);
                vacHvb.setBackgroundColor(child.isHvb() ?
                        getResources().getColor(R.color.green) : Converters.ifPassedToday(calendar.getTime()) ?
                        getResources().getColor(R.color.red) : Converters.ifWithinThirtyDays(calendar.getTime()) ?
                        getResources().getColor(R.color.yellow) : getResources().getColor(R.color.green));
            }
        });
        vacPenta1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (child.isPenta1()) {
                    child.setPenta1(false);
                } else {
                    child.setPenta1(true);
                }
                calendar.setTime(child.getBirthday());
                calendar.add(Calendar.DATE, 60);
                vacPenta1.setBackgroundColor(child.isPenta1() ?
                        getResources().getColor(R.color.green) : Converters.ifPassedToday(calendar.getTime()) ?
                        getResources().getColor(R.color.red) : Converters.ifWithinThirtyDays(calendar.getTime()) ?
                        getResources().getColor(R.color.yellow) : getResources().getColor(R.color.green));
            }
        });
        vacVop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (child.isVop1()) {
                    child.setVop1(false);
                } else {
                    child.setVop1(true);
                }
                calendar.setTime(child.getBirthday());
                calendar.add(Calendar.DATE, 60);
                vacVop1.setBackgroundColor(child.isVop1() ?
                        getResources().getColor(R.color.green) : Converters.ifPassedToday(calendar.getTime()) ?
                        getResources().getColor(R.color.red) : Converters.ifWithinThirtyDays(calendar.getTime()) ?
                        getResources().getColor(R.color.yellow) : getResources().getColor(R.color.green));
            }
        });
        vacTodpt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (child.isTodpt()) {
                    child.setTodpt(false);
                } else {
                    child.setTodpt(true);
                }
                calendar.setTime(child.getBirthday());
                calendar.add(Calendar.DATE, 90);
                vacTodpt.setBackgroundColor(child.isTodpt() ?
                        getResources().getColor(R.color.green) : Converters.ifPassedToday(calendar.getTime()) ?
                        getResources().getColor(R.color.red) : Converters.ifWithinThirtyDays(calendar.getTime()) ?
                        getResources().getColor(R.color.yellow) : getResources().getColor(R.color.green));
            }
        });
        vacHib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (child.isHib()) {
                    child.setHib(false);
                } else {
                    child.setHib(true);
                }
                calendar.setTime(child.getBirthday());
                calendar.add(Calendar.DATE, 90);
                vacHib.setBackgroundColor(child.isHib() ?
                        getResources().getColor(R.color.green) : Converters.ifPassedToday(calendar.getTime()) ?
                        getResources().getColor(R.color.red) : Converters.ifWithinThirtyDays(calendar.getTime()) ?
                        getResources().getColor(R.color.yellow) : getResources().getColor(R.color.green));
            }
        });
        vacVop2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (child.isVop2()) {
                    child.setVop2(false);
                } else {
                    child.setVop2(true);
                }
                calendar.setTime(child.getBirthday());
                calendar.add(Calendar.DATE, 90);
                vacVop2.setBackgroundColor(child.isVop2() ?
                        getResources().getColor(R.color.green) : Converters.ifPassedToday(calendar.getTime()) ?
                        getResources().getColor(R.color.red) : Converters.ifWithinThirtyDays(calendar.getTime()) ?
                        getResources().getColor(R.color.yellow) : getResources().getColor(R.color.green));
            }
        });
        vacPenta2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (child.isPenta2()) {
                    child.setPenta2(false);
                } else {
                    child.setPenta2(true);
                }
                calendar.setTime(child.getBirthday());
                calendar.add(Calendar.DATE, 120);
                vacPenta2.setBackgroundColor(child.isPenta2() ?
                        getResources().getColor(R.color.green) : Converters.ifPassedToday(calendar.getTime()) ?
                        getResources().getColor(R.color.red) : Converters.ifWithinThirtyDays(calendar.getTime()) ?
                        getResources().getColor(R.color.yellow) : getResources().getColor(R.color.green));
            }
        });
        vacVop3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (child.isVop3()) {
                    child.setVop3(false);
                } else {
                    child.setVop3(true);
                }
                calendar.setTime(child.getBirthday());
                calendar.add(Calendar.DATE, 120);
                vacVop3.setBackgroundColor(child.isVop3() ?
                        getResources().getColor(R.color.green) : Converters.ifPassedToday(calendar.getTime()) ?
                        getResources().getColor(R.color.red) : Converters.ifWithinThirtyDays(calendar.getTime()) ?
                        getResources().getColor(R.color.yellow) : getResources().getColor(R.color.green));
            }
        });
        vacSpr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (child.isSpr()) {
                    child.setSpr(false);
                } else {
                    child.setSpr(true);
                }
                calendar.setTime(child.getBirthday());
                calendar.add(Calendar.DATE, 360);
                vacSpr.setBackgroundColor(child.isSpr() ?
                        getResources().getColor(R.color.green) : Converters.ifPassedToday(calendar.getTime()) ?
                        getResources().getColor(R.color.red) : Converters.ifWithinThirtyDays(calendar.getTime()) ?
                        getResources().getColor(R.color.yellow) : getResources().getColor(R.color.green));
            }
        });
        vacAma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (child.isAma()) {
                    child.setAma(false);
                } else {
                    child.setAma(true);
                }
                calendar.setTime(child.getBirthday());
                calendar.add(Calendar.DATE, 360);
                vacAma.setBackgroundColor(child.isAma() ?
                        getResources().getColor(R.color.green) : Converters.ifPassedToday(calendar.getTime()) ?
                        getResources().getColor(R.color.red) : Converters.ifWithinThirtyDays(calendar.getTime()) ?
                        getResources().getColor(R.color.yellow) : getResources().getColor(R.color.green));
            }
        });

        // date 1
        dateHomeVisit = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, monthOfYear);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                nextHomeVisit.setText(sdf.format(calendar.getTime()));
            }
        };
        nextHomeVisit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(HomeVisitRegisterActivity.this, dateHomeVisit, calendar
                        .get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        // date2
        dateCheckup = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, monthOfYear);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                nextCheckup.setText(sdf.format(calendar.getTime()));
            }
        };
        nextCheckup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(HomeVisitRegisterActivity.this, dateCheckup, calendar
                        .get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        // date3
        dateDewarm = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, monthOfYear);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                nextDeworming.setText(sdf.format(calendar.getTime()));
            }
        };
        nextDeworming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(HomeVisitRegisterActivity.this, dateDewarm, calendar
                        .get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        // illnesses
        checkDia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!((CheckBox) v).isChecked()) {
                    child.setDiarrhea(false);
                } else {
                    child.setDiarrhea(true);
                }
            }
        });
        checkMal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!((CheckBox) v).isChecked()) {
                    child.setMalaria(false);
                } else {
                    child.setMalaria(true);
                }
            }
        });
        checkFlu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!((CheckBox) v).isChecked()) {
                    child.setFlu(false);
                } else {
                    child.setFlu(true);
                }
            }
        });
        checkPne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!((CheckBox) v).isChecked()) {
                    child.setPneumonia(false);
                } else {
                    child.setPneumonia(true);
                }
            }
        });
        checkTub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!((CheckBox) v).isChecked()) {
                    child.setTuberculosis(false);
                } else {
                    child.setTuberculosis(true);
                }
            }
        });
        registerHomeVisit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                child.setHeight(Double.valueOf(height.getText().toString()));
                child.setWeight(Double.valueOf(weight.getText().toString()));
                child.setHemoLevel(Double.valueOf(hemoLevel.getText().toString()));
                try {
                    child.setDateVisit(sdf.parse(nextHomeVisit.getText().toString()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                try {
                    child.setDateCheck(sdf.parse(nextCheckup.getText().toString()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                try {
                    child.setDateDewarm(sdf.parse(nextDeworming.getText().toString()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                MainActivity.mChildViewModel.update(child);

                Intent intent = new Intent(HomeVisitRegisterActivity.this, ChildMainActivity.class);
                intent.putExtra("child_clicked", child);
                startActivity(intent);
            }
        });
    }

    private void getIncomingIntent() {
        if (getIntent().hasExtra("register_home_visit_child")) {
            child = (Child) getIntent().getSerializableExtra("register_home_visit_child");

            height.setText(String.valueOf(child.getHeight()));
            weight.setText(String.valueOf(child.getWeight()));
            hemoLevel.setText(String.valueOf(child.getHemoLevel()));

            calendar.setTime(child.getBirthday());
            calendar.add(Calendar.DATE, 0);
            vacBcg.setBackgroundColor(child.isBcg() ?
                    getResources().getColor(R.color.green) : Converters.ifPassedToday(calendar.getTime()) ?
                    getResources().getColor(R.color.red) : Converters.ifWithinThirtyDays(calendar.getTime()) ?
                    getResources().getColor(R.color.yellow) : getResources().getColor(R.color.green));
            vacHvb.setBackgroundColor(child.isHvb() ?
                    getResources().getColor(R.color.green) : Converters.ifPassedToday(calendar.getTime()) ?
                    getResources().getColor(R.color.red) : Converters.ifWithinThirtyDays(calendar.getTime()) ?
                    getResources().getColor(R.color.yellow) : getResources().getColor(R.color.green));

            calendar.setTime(child.getBirthday());
            calendar.add(Calendar.DATE, 60);
            vacPenta1.setBackgroundColor(child.isPenta1() ?
                    getResources().getColor(R.color.green) : Converters.ifPassedToday(calendar.getTime()) ?
                    getResources().getColor(R.color.red) : Converters.ifWithinThirtyDays(calendar.getTime()) ?
                    getResources().getColor(R.color.yellow) : getResources().getColor(R.color.green));
            vacVop1.setBackgroundColor(child.isVop1() ?
                    getResources().getColor(R.color.green) : Converters.ifPassedToday(calendar.getTime()) ?
                    getResources().getColor(R.color.red) : Converters.ifWithinThirtyDays(calendar.getTime()) ?
                    getResources().getColor(R.color.yellow) : getResources().getColor(R.color.green));

            calendar.setTime(child.getBirthday());
            calendar.add(Calendar.DATE, 90);
            vacTodpt.setBackgroundColor(child.isTodpt() ?
                    getResources().getColor(R.color.green) : Converters.ifPassedToday(calendar.getTime()) ?
                    getResources().getColor(R.color.red) : Converters.ifWithinThirtyDays(calendar.getTime()) ?
                    getResources().getColor(R.color.yellow) : getResources().getColor(R.color.green));
            vacHib.setBackgroundColor(child.isHib() ?
                    getResources().getColor(R.color.green) : Converters.ifPassedToday(calendar.getTime()) ?
                    getResources().getColor(R.color.red) : Converters.ifWithinThirtyDays(calendar.getTime()) ?
                    getResources().getColor(R.color.yellow) : getResources().getColor(R.color.green));
            vacVop2.setBackgroundColor(child.isVop2() ?
                    getResources().getColor(R.color.green) : Converters.ifPassedToday(calendar.getTime()) ?
                    getResources().getColor(R.color.red) : Converters.ifWithinThirtyDays(calendar.getTime()) ?
                    getResources().getColor(R.color.yellow) : getResources().getColor(R.color.green));

            calendar.setTime(child.getBirthday());
            calendar.add(Calendar.DATE, 120);
            vacPenta2.setBackgroundColor(child.isPenta2() ?
                    getResources().getColor(R.color.green) : Converters.ifPassedToday(calendar.getTime()) ?
                    getResources().getColor(R.color.red) : Converters.ifWithinThirtyDays(calendar.getTime()) ?
                    getResources().getColor(R.color.yellow) : getResources().getColor(R.color.green));
            vacVop3.setBackgroundColor(child.isVop3() ?
                    getResources().getColor(R.color.green) : Converters.ifPassedToday(calendar.getTime()) ?
                    getResources().getColor(R.color.red) : Converters.ifWithinThirtyDays(calendar.getTime()) ?
                    getResources().getColor(R.color.yellow) : getResources().getColor(R.color.green));

            calendar.setTime(child.getBirthday());
            calendar.add(Calendar.DATE, 360);
            vacSpr.setBackgroundColor(child.isSpr() ?
                    getResources().getColor(R.color.green) : Converters.ifPassedToday(calendar.getTime()) ?
                    getResources().getColor(R.color.red) : Converters.ifWithinThirtyDays(calendar.getTime()) ?
                    getResources().getColor(R.color.yellow) : getResources().getColor(R.color.green));
            vacAma.setBackgroundColor(child.isAma() ?
                    getResources().getColor(R.color.green) : Converters.ifPassedToday(calendar.getTime()) ?
                    getResources().getColor(R.color.red) : Converters.ifWithinThirtyDays(calendar.getTime()) ?
                    getResources().getColor(R.color.yellow) : getResources().getColor(R.color.green));

            calendar.setTime(child.getDateVisit());
            nextHomeVisit.setText(sdf.format(calendar.getTime()));
            calendar.setTime(child.getDateCheck());
            nextCheckup.setText(sdf.format(calendar.getTime()));
            calendar.setTime(child.getDateDewarm());
            nextDeworming.setText(sdf.format(calendar.getTime()));

            checkDia.setChecked(child.isDiarrhea());
            checkMal.setChecked(child.isMalaria());
            checkFlu.setChecked(child.isFlu());
            checkPne.setChecked(child.isPneumonia());
            checkTub.setChecked(child.isTuberculosis());
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
            Intent intent = new Intent(HomeVisitRegisterActivity.this, MainActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
