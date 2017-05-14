package com.example.sandra.gcmemployee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TaskRequiredActivity extends AppCompatActivity {
    Button acceptButton;
    TextView resultTV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        acceptButton = (Button) findViewById(R.id.acceptButton);
        resultTV = (TextView) findViewById(R.id.resultTV);
        MainActivity.iAccepted = false;

        String title = getIntent().getStringExtra("title");
        if(title != null && title.equals("Task Required")){
            acceptButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    new MyAsync().execute("Task Taken", "Someone has accepted the task");
                    new MyAsync().execute("Task Taken Boss !", "I have accepted the task");
                    MainActivity.iAccepted = true;
                    resultTV.setText("Congratulations ! You got the job !");
                    acceptButton.setEnabled(false);
                }
            });
        } else if(MainActivity.iAccepted == false) {
            acceptButton.setEnabled(false);
            resultTV.setText("Sorry ! Someone else has taken the task !");
        }
    }
}
