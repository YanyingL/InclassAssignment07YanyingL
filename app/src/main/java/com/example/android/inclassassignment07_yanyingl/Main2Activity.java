package com.example.android.inclassassignment07_yanyingl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import java.io.Serializable;

public class Main2Activity extends AppCompatActivity implements Serializable {

    public EditText name_text;
    public EditText legs_text;
    public EditText info_text;
    public Button submit_button;
    public CheckBox fur_check;

    String name;
    String legs;
    String info;
    Boolean fur;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        legs_text=(EditText)findViewById(R.id.leg_field);
        info_text=(EditText)findViewById(R.id.info_field);
        name_text=(EditText)findViewById(R.id.name_field);
        fur_check=(CheckBox)findViewById(R.id.fur_checkbox);
        submit_button=(Button) findViewById(R.id.launch_activity);

        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submit_activity();
            }
        });
    }

    public void submit_activity(){
        String name=name_text.getText().toString();
        String legs=legs_text.getText().toString();
        String info=info_text.getText().toString();
        boolean fur=fur_check.isChecked();

        Main2Activity animal=new Main2Activity(name,legs,info,fur);
        Intent data=new Intent();
        data.putExtra(Keys.animal, animal);
        setResult(RESULT_OK, data);
        finish();
    }

    public  Main2Activity (String aName, String aLegs, String aInfo, boolean aFur) {
        this.name = aName;
        this.legs = aLegs;
        this.info=aInfo;
        this.fur=aFur;
    }

    public Main2Activity(){
        super();
    }

    public String getName() {
        return name;
    }

    public String getlegs() {
        return legs;
    }

    public String getInfo() {
        return info;
    }

    public Boolean getfur() {
        return fur;
    }

    public void setName(String name){
        this.name=name;
    }

    public void setlegs(String legs){
        this.legs=legs;
    }

    public void setinfo(String info){
        this.info=info;
    }

    public void setfur(boolean fur){
        this.fur=fur;
    }

}
