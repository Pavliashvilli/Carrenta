package space.nikitin.carrenta;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Brand_cars extends AppCompatActivity {
    Dialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.car_brands);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //вызов диалогового окна
        dialog = new Dialog(this); //sozdaem ego
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);//scrili zagolovok
        dialog.setContentView(R.layout.previewdialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//prozrachniy fon
        dialog.setCancelable(false);//okno ne zakrit knopkoy nazad
        TextView btnclose = (TextView)dialog.findViewById(R.id.btnclose);
        btnclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Brand_cars.this,NewActivity.class);
                    startActivity(intent);
                    finish();

                }catch (Exception e){

                }
                dialog.dismiss();//zakrit dialog okno
            }
        });

        Button btncontinue = (Button)dialog.findViewById(R.id.btncontinue);
        btncontinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });





        dialog.show();//pokazat dialogovoe okno



        TextView textView1 = (TextView)findViewById(R.id.textViewBMW);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Brand_cars.this, Level1.class);
                    startActivity(intent);
                    finish();

                }catch (Exception e){

                }

            }
        });


        //Perehod na legkovie
        TextView textView2 = (TextView)findViewById(R.id.textViewNissan);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Brand_cars.this,Level2.class);
                    startActivity(intent);
                    finish();

                }catch (Exception e){

                }

            }
        });
        //konec
        //Perehod na legkovie
        TextView textView3 = (TextView)findViewById(R.id.textViewKia);
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Brand_cars.this,Level3.class);
                    startActivity(intent);
                    finish();

                }catch (Exception e){

                }

            }
        });
        //konec
        //Perehod na kontackti
        TextView textView4 = (TextView)findViewById(R.id.textViewAudi);
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Brand_cars.this,Level4.class);
                    startActivity(intent);
                    finish();

                }catch (Exception e){

                }

            }
        });
        //konec

    }
    @Override
    public void onBackPressed (){
        try {
            Intent intent = new Intent(Brand_cars.this,NewActivity.class);
            startActivity(intent);
            finish();
        }catch (Exception e) {

        }

    }

}

