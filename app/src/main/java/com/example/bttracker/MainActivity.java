package com.example.bttracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView mainButton1 = findViewById(R.id.Mainbutton1);
        mainButton1.setOnClickListener(this);

        TextView mainButton2 = findViewById(R.id.Mainbutton2);
        mainButton2.setOnClickListener(this);

        TextView mainButton3 = findViewById(R.id.Mainbutton3);
        mainButton3.setOnClickListener(this);

        TextView mainButton4 = findViewById(R.id.Mainbutton4);
        mainButton4.setOnClickListener(this);

    @Override
    public void onClick (View view)  {
         switch (view.getId()) {
             case R.id.Mainbutton1:
                    // If Mainbutton1 is clicked, do something
                    Intent toLog = new Intent(this, Logacvtivity.class);
                    startActivity(toLog);
                    break;
                case R.id.Mainbutton2:
                    Intent toNormal = new Intent(this, NormalActivity.class);
                    startActivity(toNormal);
                    break;
                case R.id.Mainbutton3:
                    Intent toMechanism = new Intent(this, MechanismActivity.class);
                    startActivity(toMechanism);
                    break;
                case R.id.Mainbutton4:
                    Intent openFeverLink = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.healthline.com/health/how-to-break-a-fever"));
                    if (openFeverLink.resolveActivity(getPackageManager()) != null) {
                        startActivity(openFeverLink);
                    }
                    break;


            }


        }

    }
}