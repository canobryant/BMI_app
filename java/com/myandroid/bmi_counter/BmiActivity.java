package com.myandroid.bmi_counter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;


public class BmiActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(com.myandroid.bmi_counter.R.layout.activity_main);

        Button CalculateButton = (Button)findViewById(com.myandroid.bmi_counter.R.id.Button01);
        CalculateButton.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                EditText HeightEditText = (EditText)findViewById(com.myandroid.bmi_counter.R.id.EditText01);
                double height = Double.parseDouble(HeightEditText.getText().toString());
                EditText WeightEditText = (EditText)findViewById(com.myandroid.bmi_counter.R.id.EditText02);
                double weight = Double.parseDouble(WeightEditText.getText().toString());

                String sex;
                RadioButton SexMale = (RadioButton)findViewById(com.myandroid.bmi_counter.R.id.RadioButton01);
                if(SexMale.isChecked()){
                    sex="M";
                }
                else{
                    sex="F";
                }
                Intent intent = new Intent();
                intent.setAction("com.myandroid.bmi_counter");
                intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
                //new一個Bundle物件，並將要傳遞的資料傳入
                Bundle bundle = new Bundle();
                bundle.putDouble("height", height);
                bundle.putDouble("weight", weight);
                bundle.putString("sex", sex);
                //將Bundle物件assign給intent
                intent.putExtras(bundle);
                sendBroadcast(intent);

               /* //new一個intent物件，並指定Activity切換的class
                Intent intent = new Intent();
                intent.setClass(BmiActivity.this, myreceiver.class);

                //new一個Bundle物件，並將要傳遞的資料傳入
                Bundle bundle = new Bundle();
                bundle.putDouble("height",height );
                bundle.putDouble("weight",weight );
                bundle.putString("sex", sex);

                //將Bundle物件assign給intent
                intent.putExtras(bundle);

                //切換Activity
                startActivity(intent);*/
            }

        });
    }
}