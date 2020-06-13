package space.nikitin.carrenta;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.format.DateFormat;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.firebase.ui.database.FirebaseListAdapter;
//import com.firebase.ui.database.FirebaseListOptions;
import com.github.library.bubbleview.BubbleTextView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;


import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class User_Reviews extends AppCompatActivity {
    String Firebase_user;



    private RelativeLayout activity_reviews;
    private FirebaseListAdapter<Message> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reviews);
        activity_reviews = findViewById(R.id.activity_reviews);
        displayAllMessages();
        Button sendBtn = findViewById(R.id.btnSend);
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText textField = findViewById(R.id.messageField);
                if (textField.getText().toString() == " ")
                    return;

                FirebaseDatabase.getInstance().getReference().child("reviews").push().setValue(new Message(FirebaseAuth.getInstance().getCurrentUser().getEmail(),
                        textField.getText().toString())
                );
                textField.setText("");
            }
        });


        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


    }

    private void displayAllMessages(){
        //


        Firebase_user = FirebaseAuth.getInstance().getCurrentUser().getEmail();



        ListView listOfMessages = findViewById(R.id.list_of_messages);//id list_view
        adapter =  new FirebaseListAdapter<Message>(this,Message.class,R.layout.list_item,FirebaseDatabase.getInstance().getReference().child("reviews")) {
            @Override
            protected void populateView(@NonNull View v, @NonNull Message model, int position) {
                TextView mess_user,mess_time;
                BubbleTextView mess_text;
                mess_user = v.findViewById(R.id.message_user); //id polya list_item
                mess_time = v.findViewById(R.id.message_time); //id polya list_item
                mess_text = v.findViewById(R.id.message_text); //id polya list_item
                String user = model.getUserName();  //model.get(peremennaya Message)
                    mess_user.setText(user);
                    mess_text.setText(model.getTextMessge());
                    mess_time.setText(DateFormat.format("dd-MM-yyyy HH:mm:ss", model.getMessageTime()));
                    System.out.println("Отправляющий" + user);
                    System.out.println("Текущий" + Firebase_user);


            }
        };
        listOfMessages.setAdapter(adapter);

    }
    @Override
    public void onBackPressed (){
        try {
            Intent intent = new Intent(User_Reviews.this,NewActivity.class);
            startActivity(intent);
            finish();
        }catch (Exception e) {

        }

    }

}
