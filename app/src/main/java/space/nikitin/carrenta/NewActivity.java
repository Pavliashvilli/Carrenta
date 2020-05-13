package space.nikitin.carrenta;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class NewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.carlevels);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);



        TextView textView4 = (TextView)findViewById(R.id.textView4);
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(NewActivity.this, User_Reviews.class);
                    startActivity(intent);
                    finish();

                }catch (Exception e){

                }

            }
        });


        //Perehod na legkovie
        TextView textView1 = (TextView)findViewById(R.id.textView1);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(NewActivity.this,Level1.class);
                    startActivity(intent);
                    finish();

                }catch (Exception e){

                }

            }
        });
        //konec
        //Perehod na legkovie
        TextView textView2 = (TextView)findViewById(R.id.textView2);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(NewActivity.this,Maps.class);
                    startActivity(intent);
                    finish();

                }catch (Exception e){

                }

            }
        });
        //konec
        //Perehod na kontackti
        TextView textView3 = (TextView)findViewById(R.id.textView3);
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(NewActivity.this,Contacts.class);
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
            Intent intent = new Intent(NewActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }catch (Exception e) {

        }

    }

}
