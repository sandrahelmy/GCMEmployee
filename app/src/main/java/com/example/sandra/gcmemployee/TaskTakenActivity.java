package com.example.sandra.gcmemployee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TaskTakenActivity extends AppCompatActivity {
    TextView taskTakenTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_taken);
        taskTakenTv = (TextView) findViewById(R.id.taskTakenTv);
        if(MainActivity.iAccepted == true){
            taskTakenTv.setText("Congratulations ! You got the job");
        }
    }
}
