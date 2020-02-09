package com.example.mytestapplication;

import android.icu.util.Output;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import androidx.appcompat.app.AppCompatActivity;

import java.time.Instant;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Date[] starttime = new Date[1];
        final Date[] finishtime = new Date[1];
        final DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");


        final Button start = findViewById(R.id.StartButton);
        start.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                starttime[0] = Calendar.getInstance().getTime();

                String formattedstarttime = dateFormat.format(starttime[0]);
                //String formattedstarttime = "";
                start.setText("Session start time: " + formattedstarttime);

            }
        });

        final Button finish = findViewById(R.id.FinishButton);
        finish.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finishtime[0] = Calendar.getInstance().getTime();
                long difference = finishtime[0].getTime() - starttime[0].getTime();
                long minutes = (difference/1000)/60;
                long seconds = (difference/1000)%60;
                TextView Output = findViewById((R.id.output));

                String formattedfinishtime = dateFormat.format(finishtime[0]);
                //String formattedfinishtime = "";
                finish.setText("Session finish time: " + formattedfinishtime);

                Output.setText("Session length: " + minutes + " minutes " + seconds + " seconds");

            }
        });



    }
}
