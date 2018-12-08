package com.example.admin.tasks;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class TaskActivity extends Activity {
    private FirebaseDatabase mdatabase;
    private DatabaseReference mDBRef;
    Button Insert;
    Button Cancel;
    EditText Title,Subject,Text,Date,Rate,Status;
    Tasks task;

@Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.tasks);

    mdatabase = FirebaseDatabase.getInstance();
    mDBRef = mdatabase.getReference("Task");
    task = new Tasks();
    Title = (EditText) findViewById(R.id.Title);
    Subject = (EditText) findViewById(R.id.Subject);
    Text = (EditText) findViewById(R.id.Text);
    Date = (EditText) findViewById(R.id.Date);
    Rate = (EditText) findViewById(R.id.Rate);
    Status = (EditText) findViewById(R.id.Status);
    Cancel = (Button) findViewById(R.id.btnCancel);
    Insert = (Button) findViewById(R.id.btnInsert);
}
private void getValues() {
    task.setTitle(Title.getText().toString());
    task.setSubject(Subject.getText().toString());
    task.setText(Text.getText().toString());
    task.setDate(Date.getText().toString());
    task.setRate(Integer.parseInt(Rate.getText().toString()));
    task.setStatus(Status.getText().toString());
}
public void btnInsert(View view){
    mDBRef.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            getValues();
            mDBRef.child("Task").setValue(task);
            Toast.makeText(TaskActivity.this,"Data Insetr",Toast.LENGTH_LONG).show();

        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    });
}
}
