package com.example.cloudfirestore;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {

    private static final String NAME_KEY = "Name";
    private static final String EMAIL_KEY = "Email";
    TextView tv;
    EditText editText;
    // Access a Cloud Firestore instance from your Activity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv);
        editText = (EditText)findViewById(R.id.editText1);
//        save();
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

    public void fetch2(View view) {

        String roll_no = editText.getText().toString();
        DocumentReference mDocRef = FirebaseFirestore.getInstance().document("classList/B.Sc/First-Year/"+ roll_no);
        mDocRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {
                    String name = documentSnapshot.getString(NAME_KEY);
                    String email = documentSnapshot.getString(EMAIL_KEY);
                    tv.setText("Name: " + name + "\nEmail: " + email);
                }
            }
        });
    }
}