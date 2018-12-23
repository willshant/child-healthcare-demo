package com.example.will.app_for_child_demo.Activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.will.app_for_child_demo.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class NewChildActivity extends AppCompatActivity {

    public static final String FIRST_NAME = "child.first_name";
    public static final String LAST_NAME = "child.last_name";
    public static final String BIRTHDAY = "child.birthday";

    private EditText mEditFirstNameView;
    private EditText mEditLastNameView;
    private EditText mEditBirthday;

    Calendar myCalendar;
    DatePickerDialog.OnDateSetListener date;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_child);
        mEditFirstNameView = findViewById(R.id.edit_first_name);
        mEditLastNameView = findViewById(R.id.edit_last_name);
        mEditBirthday = findViewById(R.id.edit_birthday);

        myCalendar = Calendar.getInstance();
        date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };

        mEditBirthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(NewChildActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });


        // button submit
        final Button button = findViewById(R.id.button_save);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(mEditFirstNameView.getText()) || TextUtils.isEmpty(mEditLastNameView.getText()) || TextUtils.isEmpty(mEditBirthday.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    replyIntent.putExtra(FIRST_NAME, mEditFirstNameView.getText().toString());
                    replyIntent.putExtra(LAST_NAME, mEditLastNameView.getText().toString());
                    replyIntent.putExtra(BIRTHDAY, Long.toString(myCalendar.getTime().getTime()));
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });
    }

    private void updateLabel() {
        String myFormat = "MM/dd/yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        mEditBirthday.setText(sdf.format(myCalendar.getTime()));
//        Log.i("year", String.valueOf(myCalendar.get(Calendar.YEAR)));
//        Log.i("month", String.valueOf(myCalendar.get(Calendar.MONTH) + 1));
//        Log.i("day", String.valueOf(myCalendar.get(Calendar.DAY_OF_MONTH)));
    }
}