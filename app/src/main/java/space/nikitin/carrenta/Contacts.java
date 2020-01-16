package space.nikitin.carrenta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class Contacts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Button button_back = (Button)findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Contacts.this,NewActivity.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e) {

                }
            }
        });

        ListView LvMain = (ListView)findViewById(R.id.lv);
        final TextView txt = (TextView)findViewById(R.id.txt);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.Contacs,
                android.R.layout.simple_list_item_1);
        LvMain.setAdapter(adapter);


    }
    @Override
    public void onBackPressed (){
        try {
            Intent intent = new Intent(Contacts.this,NewActivity.class);
            startActivity(intent);
            finish();
        }catch (Exception e) {

        }

    }
}
