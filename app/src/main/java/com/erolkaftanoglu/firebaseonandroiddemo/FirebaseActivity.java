package com.erolkaftanoglu.firebaseonandroiddemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FirebaseActivity extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase);
        textView = (TextView) findViewById(R.id.textView);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("kisiler").child("1"); //
2        databaseReference.child("name").setValue("ahmet");
        databaseReference.child("surname").setValue("cengiz");
        databaseReference.child("age").setValue("25");
        databaseReference.child("deparment").setValue("CS");
        DatabaseReference itemsReference = databaseReference.child("yapilcaklar");

        itemsReference.child("0").setValue("hello");
        itemsReference.child("1").setValue("world - 2");
        itemsReference.child("2").setValue("tutorial");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                textView.setText(dataSnapshot.child("yapilcaklar").toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }

    // TODO: 2.09.2016 object göndemek için aşamalar.
    class Item{
        String merhaba;

        public Item(String merhaba) {
            this.merhaba = merhaba;
        }
    }
}
