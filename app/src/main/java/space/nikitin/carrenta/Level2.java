package space.nikitin.carrenta;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class Level2 extends AppCompatActivity {
    String car_Nissan = " Nissan Xtrail";
    int coast_Nissan = 500;


    public int numCenter; //Переменная для картинки + текст
    Array array = new Array();//Новый обьект для класса Array
    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level2);

        //Создаем переменную text_levels
        TextView text_levels = findViewById(R.id.text_levels);
        text_levels.setText(R.string.Level1);

        final ImageView img_left = (ImageView)findViewById(R.id.img_left);
        //скруглим углы подлжки
        img_left.setClipToOutline(true);

        //Путь к средней TextView
        final TextView text_center = findViewById(R.id.text_center);

        Window w =getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Button button_back = (Button)findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Level2.this,Renta2.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e) {

                }
            }
        });




        //Подключаем анимацию
        final Animation a = AnimationUtils.loadAnimation(Level2.this,R.anim.alpha);


        numCenter = random.nextInt(4); //Генерируем число от 0 до 9
        img_left.setImageResource(array.images2[numCenter]); //Достаем из массива картинку
        text_center.setText(array.texts1[7]); //Достаем из массива текст

        img_left.setOnTouchListener(new View.OnTouchListener(){

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                //Условие касания картинки - начало
                if (motionEvent.getAction()==MotionEvent.ACTION_DOWN){
                    //если коснулся картинки -начало
                    img_left.setImageResource(array.images2[numCenter]); //Достаем из массива картинку
                    text_center.setText(array.texts1[7]);

                } else if (motionEvent.getAction()==MotionEvent.ACTION_UP){
                    //если отпустил палец начало
                    numCenter = random.nextInt(4);
                    img_left.setImageResource(array.images2[numCenter]); //Достаем из массива картинку
                    text_center.setText(array.texts1[7]);
                }
                //Условие касания картинки - конец
                return true;
            }
        });





    }
    @Override
    public void onBackPressed (){
        try {
            Intent intent = new Intent(Level2.this,Brand_cars.class);
            startActivity(intent);
            finish();
        }catch (Exception e) {

        }

    }
}

