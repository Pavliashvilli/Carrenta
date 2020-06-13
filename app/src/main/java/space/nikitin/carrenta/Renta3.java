package space.nikitin.carrenta;

import android.content.Intent;
import android.icu.util.LocaleData;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;
import java.time.LocalDate;

import java.util.Calendar;
import java.util.Locale;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
public class Renta3 extends AppCompatActivity{
    CalendarView calendarView , calendarView2;
    TextView myDate, myDate2;
    String  car_naming;
    String date2;
    String date3;
    String res;
    String interval;
    int col_days ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_renta);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        increment();

    }
    public void increment (){
        calendarView = (CalendarView) findViewById(R.id.calendarView);
        myDate = (TextView) findViewById(R.id.myDate);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            public void onSelectedDayChange(@NonNull CalendarView calendarView, int  year, int month, int  dayOfMonth) {
                if (dayOfMonth >= 10){
                    date2 = year + "-" + ("0"+(month + 1)) + "-" +  dayOfMonth ;
                }
                else {
                    date2 = year + "-" + ("0"+(month + 1)) + "-" + ("0"+ dayOfMonth);
                }
                SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd");
                String date1 = sdf.format(Calendar.getInstance().getTime());
                if (date1.compareTo(date2) < 0 && date1.length()==date2.length()) {
                    myDate.setText(date2);



                } else {
                    Toast toast = Toast.makeText(Renta3.this, "Выберите другую дату",Toast.LENGTH_LONG);
                    toast.show();
                    myDate.setText("Select date");
                }



            }
        });
    }





    public void onMyClick(View view) {
        Toast toast = Toast.makeText(Renta3.this, "Complete", Toast.LENGTH_LONG);
        toast.show();
        calendarView2 = (CalendarView) findViewById(R.id.calendarView);
        calendarView2.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayOfMonth) {
                date3 = year + "-" + ("0" + (month + 1)) + "-" + dayOfMonth;
                // myDate2.setText(date2);

                if (date2.compareTo(date3) < 0) {
                    myDate.setText(date2 + " до " +date3);

                    parse();

                } else {
                    Toast toast = Toast.makeText(Renta3.this, "Выберите другую дату", Toast.LENGTH_LONG);
                    toast.show();
                    myDate2.setText("Select date");
                }
            }
        });



    }

    public void parse () {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

            Date date22 = formatter.parse(date2);
            Date date33 = formatter.parse(date3);
            Date dateOne = null;
            Date dateTwo = null;

            try {
                dateOne = date33;
                dateTwo = date22;
            } catch (Exception e) {
                e.printStackTrace();
            }

            // Количество дней между датами в миллисекундах
            long difference = dateOne.getTime() - dateTwo.getTime();
            // Перевод количества дней между датами из миллисекунд в дни
            int days =  (int)(difference / (24 * 60 * 60 * 1000)); // миллисекунды / (24ч * 60мин * 60сек * 1000мс)
            days = days +1 ;
            // Вывод разницы между датами в днях на экран

            //myDate.setText(date2 + "-" +date3+days + " дн.");
            //myDate3.setText(days + " дн.");
            col_days = days;

            if (col_days != 0) {
                constract ();
            }else {
                Toast toast = Toast.makeText(Renta3.this, "col_days problem", Toast.LENGTH_LONG);
                toast.show();

            }

        } catch (ParseException ex) {
            ex.printStackTrace(); // or log it using a logging framework
        }


    }
    public void constract (){
        Level3 name = new Level3();
        Level3 coast = new Level3();
        int car_coast = coast.coast_Kia;
        int result = car_coast * col_days;
        res = String.valueOf(result) ;
        car_naming = name.car_Kia;
        myDate2 = (TextView)findViewById(R.id.myDate2);
        myDate2.setText(car_naming);
        myDate.setText(date2 + " до " +date3+ "\n"+col_days + " дн." + " "+res+"$");
        interval = date2 + " до " +date3;

        Button btnwishes = findViewById(R.id.btnSend_wishes);
        btnwishes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText textwishes = findViewById(R.id.messagewishes);
                if (textwishes.getText().toString() == " ")
                    return;

                System.out.println("ИНТЕРВАЛ"+interval);
                System.out.println("ИМЯ АВТО"+car_naming);
                System.out.println("СУММА"+res);
                int status = 0 ;

                FirebaseDatabase.getInstance().getReference().child("cars").push().setValue(new Wishes(FirebaseAuth.getInstance().getCurrentUser().getEmail(),
                        textwishes.getText().toString(),interval,car_naming,res,status )
                );
                textwishes.setText("");
            }
        });




    }


    @Override
    public void onBackPressed (){
        try {
            Intent intent = new Intent(Renta3.this,Level2.class);
            startActivity(intent);
            finish();
        }catch (Exception e) {

        }

    }
}
