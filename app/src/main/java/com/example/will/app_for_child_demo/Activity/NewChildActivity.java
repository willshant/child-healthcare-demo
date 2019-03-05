package com.example.will.app_for_child_demo.Activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.will.app_for_child_demo.Entity.Child;
import com.example.will.app_for_child_demo.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class NewChildActivity extends AppCompatActivity {

    private static Child child;

    public static final String NAME = "child.name";
    public static final String BIRTHDAY = "child.birthday";
    public static final String WEIGHT= "child.weight";
    public static final String GENDER = "child.gender";
    public static final String DNI = "child.dni";
    public static final String MOM_NAME = "child.mom_name";
    public static final String LOCATION = "child.location";
    public static final String FACILITY= "child.facility";
    public static final String COMMUNITY = "child.community";
    public static final String DISABILITY= "child.disability";
    public static final String ID= "child.id";

    private EditText mEditNameView;
    private EditText mEditBirthday;
    private EditText mEditWeight;
    private EditText mEditDNI;
    private EditText mEditMomName;
    private EditText mEditLocation;
    private EditText mEditCommunity;
    private Spinner mSpinnerFacility;
    private Spinner mSpinnerGender;
    private Spinner mSpinnerDisability;

    String gender;
    String facility;
    String disability;


    Calendar myCalendar;
    DatePickerDialog.OnDateSetListener date;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_child);

        mEditNameView = findViewById(R.id.edit_name);
        mEditBirthday = findViewById(R.id.edit_birthday);
        mEditWeight = findViewById(R.id.edit_weight);
        mEditDNI = findViewById(R.id.edit_dni);
        mEditMomName = findViewById(R.id.edit_mother_name);
        mEditLocation = findViewById(R.id.edit_location);
        mEditCommunity = findViewById(R.id.edit_community);
        mSpinnerFacility = findViewById(R.id.edit_facility);
        mSpinnerGender = findViewById(R.id.edit_gender);
        mSpinnerDisability = findViewById(R.id.edit_disability);

        // date
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

        // gender
        ArrayAdapter<CharSequence> genderAdapter = ArrayAdapter.createFromResource(this, R.array.gender, android.R.layout.simple_spinner_item);
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinnerGender.setAdapter(genderAdapter);
        mSpinnerGender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        gender = "false"; // male
                        break;
                    case 1:
                        gender = "true"; // female
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // facility
        ArrayAdapter<CharSequence> facilityAdapter = ArrayAdapter.createFromResource(this, R.array.facility, android.R.layout.simple_spinner_item);
        facilityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinnerFacility.setAdapter(facilityAdapter);
        mSpinnerFacility.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        facility = "false"; // home
                        break;
                    case 1:
                        facility = "true"; // health center
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // disability
        ArrayAdapter<CharSequence> disabilityAdapter = ArrayAdapter.createFromResource(this, R.array.disability, android.R.layout.simple_spinner_item);
        disabilityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinnerDisability.setAdapter(disabilityAdapter);
        mSpinnerDisability.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        disability = "false"; // no
                        break;
                    case 1:
                        disability = "true"; // yes
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // button submit
        final Button button = findViewById(R.id.button_save);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(mEditNameView.getText()) || TextUtils.isEmpty(mEditBirthday.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    replyIntent.putExtra(NAME, mEditNameView.getText().toString());
                    replyIntent.putExtra(BIRTHDAY, Long.toString(myCalendar.getTime().getTime()));
                    replyIntent.putExtra(WEIGHT, mEditWeight.getText().toString());
                    replyIntent.putExtra(DNI, mEditDNI.getText().toString());
                    replyIntent.putExtra(MOM_NAME, mEditMomName.getText().toString());
                    replyIntent.putExtra(LOCATION, mEditLocation.getText().toString());
                    replyIntent.putExtra(COMMUNITY, mEditCommunity.getText().toString());
                    replyIntent.putExtra(GENDER, gender);
                    replyIntent.putExtra(FACILITY, facility);
                    replyIntent.putExtra(DISABILITY, disability);
                    if (child != null) {
                        replyIntent.putExtra(ID, String.valueOf(child.getId()));
                    } else {
                        replyIntent.putExtra(ID, String.valueOf(-1));
                    }
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });

        getIncomingIntent();
    }

    private void getIncomingIntent() {
        if (getIntent().hasExtra("edit_child")) {
            child = (Child) getIntent().getSerializableExtra("edit_child");

            mEditNameView.setText(child.getName());
            myCalendar.setTime(child.getBirthday());
            updateLabel(); // set birthday
            mEditWeight.setText(String.valueOf(child.getBirthWeight()));
            mEditDNI.setText(child.getDni());
            mEditMomName.setText(child.getMotherName());
            mEditLocation.setText(child.getLocation());
            mEditCommunity.setText(child.getLocation());
            mSpinnerFacility.setSelection(child.isFacility() ? 1 : 0);
            mSpinnerGender.setSelection(child.isGender() ? 1 : 0);
            mSpinnerDisability.setSelection(child.isDisability() ? 1 : 0);
        }
    }


    private void updateLabel() {
        String myFormat = "MM/dd/yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        mEditBirthday.setText(sdf.format(myCalendar.getTime()));
//        Log.i("year", String.valueOf(myCalendar.get(Calendar.YEAR)));
//        Log.i("month", String.valueOf(myCalendar.get(Calendar.MONTH) + 1));
//        Log.i("day", String.valueOf(myCalendar.get(Calendar.DAY_OF_MONTH)));
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
            Intent intent = new Intent(NewChildActivity.this, MainActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}