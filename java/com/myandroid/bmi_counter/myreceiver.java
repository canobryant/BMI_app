package com.myandroid.bmi_counter;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class myreceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO Auto-generated method stub
        String sex=intent.getStringExtra("sex");
        double height = intent.getDoubleExtra("height", 0);
        double weight = intent.getDoubleExtra("weight", 0);
        String bmi="";
        bmi=format(weight/((height/100)*(height/100)));

        Toast.makeText(context, "Hello! your BMI is : "+ bmi, Toast.LENGTH_LONG).show();
        //Toast.makeText(context, bmi, Toast.LENGTH_LONG).show();
    }
    //四捨五入用
    private String format(double num) {
// TODO Auto-generated method stub
        NumberFormat formatter = new DecimalFormat("0.00");
        String s = formatter.format(num);
        return s;
    }
}

/*public class myreceiver extends Activity{
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.second);

        //取的intent中的bundle物件
        Bundle bundle0311 =this.getIntent().getExtras();

        String sex = bundle0311.getString("sex");
        double height = bundle0311.getDouble("height");
        double weight = bundle0311.getDouble("weight");

        String sexText="";
        if(sex.equals("M")){
            sexText="男性";
        }else{
            sexText="女性";
        }

        //取得標準體中
        String bmi = this.getbmi(height, weight);
        //設定輸出
        TextView tv1 = (TextView)findViewById(R.id.TextView11);
        if(sex.equals("M")){
            tv1.setText("\n\n\n你的身高是"+height+"cm\n\n" +
                    "你的體重是"+weight+"kg\n\n你的BMI是"+bmi+
                    "\n\n祝你身體健康!");
        }
        else{
            tv1.setText("\n\n\n妳的身高是"+height+"cm\n\n" +
                    "妳的體重是"+weight+"kg\n\n妳的BMI是"+bmi+
                    "\n\n祝妳身體健康!");
        }

    }

    private String getbmi(double height,double weight) {
        // TODO Auto-generated method stub
        String bmi="";

        bmi=format(weight/((height/100)*(height/100)));

        return bmi;
    }

    //四捨五入用
    private String format(double num) {
// TODO Auto-generated method stub
        NumberFormat formatter = new DecimalFormat("0.00");
        String s = formatter.format(num);
        return s;
    }


}*/
