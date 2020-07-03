package me.crackn.aquascapemonitoring;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    TextView phText, suhuText, statusText;
    DatabaseReference mDatabase;
    modelData data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        phText = findViewById(R.id.ph);
        suhuText = findViewById(R.id.suhu);
        statusText = findViewById(R.id.status);
        mDatabase = FirebaseDatabase.getInstance().getReference("dataFuzzy");
        data= new modelData();
        ValueEventListener eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                modelData m = dataSnapshot.getValue(modelData.class);
                if(m!=null){
                    data = m;
                    updateUI();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        mDatabase.addValueEventListener(eventListener);
    }

    private void updateUI() {
        phText.setText(Float.toString(data.getPh()));
        suhuText.setText(Float.toString(data.getSuhu()));
        statusText.setText(data.getStatus());
        Toast.makeText(this, "data berubah", Toast.LENGTH_SHORT).show();
    }
}
