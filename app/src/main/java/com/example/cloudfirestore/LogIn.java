package com.example.cloudfirestore;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class LogIn extends AppCompatActivity {

    TextView tv;
    EditText username, pass;
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    public void getCredentials(View view)
    {
        tv = (TextView) findViewById(R.id.tv);
        tv.setText(null);
        DocumentReference mDocRef = FirebaseFirestore.getInstance().document("username/society");
        mDocRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {

            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists())
                {
                    //Data myData = documentSnapshot.toObject(Data.class);
                    String username = documentSnapshot.getString(USERNAME);
                    String password = documentSnapshot.getString(PASSWORD);
                    logIn(username, password);
                }
            }
        });
    }

    public void logIn(String u, String p)
    {
        username = (EditText)findViewById(R.id.username);
        pass = (EditText) findViewById(R.id.pass);
        tv = (TextView) findViewById(R.id.tv);

        if (username.getText().toString().equals(u)&&pass.getText().toString().equals(p))
        {
            tv.setText("Log-In Success :)");
        }
    }

    public void change(View view){

        Intent intent = new Intent(this, Events.class);
        startActivity(intent);
        finish();
    }



//    public void save() {
//
//        Map<String, Object> dataToSave = new HashMap<>();
//        dataToSave.put(NAME_KEY, "ok");
//        dataToSave.put(EMAIL_KEY, "k@gmail.com");
//        DocumentReference mDocRef = FirebaseFirestore.getInstance().document("classList/B.Sc/First-Year/16527");
//        mDocRef.set(dataToSave);
//    }


//    public void fetch(View view) {
//        DocumentReference mDocRef = FirebaseFirestore.getInstance().document("sampleData/1");
//        mDocRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//            @Override
//            public void onSuccess(DocumentSnapshot documentSnapshot) {
//                if (documentSnapshot.exists()) {
//                    Data mydata = documentSnapshot.toObject(Data.class);
//                    String text = documentSnapshot.getString(QUOTE_KEY);
//                    String author = documentSnapshot.getString(AUTHOR_KEY);
//                    tv.setText("Your Text: " + text + "\n Author: " + author);
//                }
//            }
//        });
//    }

//    public void fetch2(View view) {
//
//        String roll_no = editText.getText().toString();
//        DocumentReference mDocRef = FirebaseFirestore.getInstance().document("classList/B.Sc/First-Year/"+ roll_no);
//        mDocRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//            @Override
//            public void onSuccess(DocumentSnapshot documentSnapshot) {
//                if (documentSnapshot.exists()) {
//                    String name = documentSnapshot.getString(NAME_KEY);
//                    String email = documentSnapshot.getString(EMAIL_KEY);
//                    tv.setText("Name: " + name + "\nEmail: " + email);
//                }
//            }
//        });
//    }
}