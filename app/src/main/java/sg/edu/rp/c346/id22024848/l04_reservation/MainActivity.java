package sg.edu.rp.c346.id22024848.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TimePicker tp ;
    DatePicker dp;
    EditText etName, etNum, etPax;
    RadioGroup rgTable;
    Button btnReserve, btnReset;
    RadioButton rbtnSmoke, rbtnUnsmoke;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tp=findViewById(R.id.timePicker);
        dp=findViewById(R.id.datePicker);
        etName=findViewById(R.id.editTextName);
        etNum=findViewById(R.id.editTextNum);
        etPax=findViewById(R.id.editTextPax);
        rgTable=findViewById(R.id.radioGroupTable);
        btnReserve=findViewById(R.id.buttonReserve);
        btnReset=findViewById(R.id.buttonReset);
        rbtnSmoke=findViewById(R.id.radioButtonSmoke);
        rbtnUnsmoke=findViewById(R.id.radioButtonUnsmoke);

        tp.setCurrentHour(7);
        tp.setCurrentMinute(30);
        dp.updateDate(2020, 5, 1);

        btnReserve.setOnClickListener(new View.OnClickListener() {
            String time=String.format("%02d:%02d", tp.getCurrentHour(), tp.getCurrentMinute());

            @Override


            public void onClick(View v) {
                String area="";
                if (rbtnSmoke.isChecked()==true){
                    area="Smoking Area";
                }
                else{
                    area="Non-Smoking Area";
                }
                Toast.makeText(MainActivity.this, "Name: "+etName.getText().toString()+"Phone Number: "+etNum.getText().toString()+"Pax:"+etPax.getText().toString()+"Booking Date: "+dp.getDayOfMonth()+"/"+dp.getMonth()+"/"+dp.getYear()+" Booking Time: "+time+" Table Area: "+area, Toast.LENGTH_SHORT).show();
            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                etName.setText("");
                etNum.setText("");
                etPax.setText("");
                tp.setCurrentHour(7);
                tp.setCurrentMinute(30);
                dp.updateDate(2020, 5, 1);
                rbtnSmoke.setChecked(false);
                rbtnUnsmoke.setChecked(false);


            }

        });
}}