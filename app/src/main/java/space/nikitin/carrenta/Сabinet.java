package space.nikitin.carrenta;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;


import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.github.library.bubbleview.BubbleTextView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import android.text.format.DateFormat;


public class Сabinet extends AppCompatActivity {
    private FirebaseListAdapter<Wishes> adaption;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cabinet);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        displayallrenta();
    }
private void displayallrenta () {
    ListView listOfRenta =  findViewById(R.id.list_of_wishes);

    adaption = new FirebaseListAdapter<Wishes>(this,Wishes.class,R.layout.list_item_cabinet, FirebaseDatabase.getInstance().getReference().child("cars")) {
        @Override
        protected void populateView(View v, Wishes model, int position) {
            TextView user_renta,time_renta,car_renta,car_coast,interval_renta;
            BubbleTextView wishes_user;
            user_renta = v.findViewById(R.id.user_renta);
            time_renta = v.findViewById(R.id.time_renta);
            car_renta = v.findViewById(R.id.car_renta);
            car_coast = v.findViewById(R.id.car_coast);
            interval_renta = v.findViewById(R.id.interval_renta);
            wishes_user = v.findViewById(R.id.wishes_user);

            user_renta.setText(model.getNameUser());
            time_renta.setText(DateFormat.format("dd-MM-yyyy HH:mm:ss", model.getTimeMessage()));
            if (model.getStatus() == 0){
            car_renta.setText(model.getNameCar() + " Ожидайте");
            } else {
                car_renta.setText(model.getNameCar() + " Готово");
            }

            car_coast.setText(model.getCostCar() + "$");
            interval_renta.setText(model.getTimeInterval());
            wishes_user.setText(model.getMessageText());




        }
    };
    listOfRenta.setAdapter(adaption);
}





    @Override
    public void onBackPressed (){
        try {
            Intent intent = new Intent(Сabinet.this,NewActivity.class);
            startActivity(intent);
            finish();
        }catch (Exception e) {

        }

    }

    }
