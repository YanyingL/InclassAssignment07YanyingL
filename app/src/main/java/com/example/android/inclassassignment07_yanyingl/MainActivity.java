package com.example.android.inclassassignment07_yanyingl;

import android.app.Person;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button add;
    public TextView result_view;
    String r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result_view = (TextView) findViewById(R.id.show_message);
        add = (Button) findViewById(R.id.add);
        result_view.setMovementMethod(new ScrollingMovementMethod());
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jump();
            }
        });

    }

    public void jump() {
        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        startActivityForResult(intent, RequestCodes.ADD);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RequestCodes.ADD && resultCode == RESULT_OK) {
            Main2Activity animal2 = (Main2Activity) data.getSerializableExtra(Keys.animal);
            String name=animal2.getName();
            String leg=animal2.getlegs();
            String info=animal2.getInfo();
            boolean fur=animal2.getfur();
            if (fur) {r="True";}
            else {r="False";}
            String result="Animal Type Name: "+ name+"\n"+"Number of Legs"+leg+"\n"+"Does it has fur?"+ r+"\n"+"Any Additional Information"+info;
            result_view.setText(result);

        }
    }


}
